package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.InputMergerFactory;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo$State;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class WorkerWrapper implements Runnable {
    public static final String TAG = Logger.tagWithPrefix("WorkerWrapper");
    public Context mAppContext;
    public Configuration mConfiguration;
    public DependencyDao mDependencyDao;
    public ForegroundProcessor mForegroundProcessor;
    public SettableFuture<Boolean> mFuture = new SettableFuture<>();
    public ListenableFuture<ListenableWorker.Result> mInnerFuture = null;
    public volatile boolean mInterrupted;
    public ListenableWorker.Result mResult = new ListenableWorker.Result.Failure();
    public WorkerParameters.RuntimeExtras mRuntimeExtras;
    public List<Scheduler> mSchedulers;
    public List<String> mTags;
    public WorkDatabase mWorkDatabase;
    public String mWorkDescription;
    public WorkSpec mWorkSpec;
    public WorkSpecDao mWorkSpecDao;
    public String mWorkSpecId;
    public WorkTagDao mWorkTagDao;
    public TaskExecutor mWorkTaskExecutor;
    public ListenableWorker mWorker;

    public static class Builder {
        public Context mAppContext;
        public Configuration mConfiguration;
        public ForegroundProcessor mForegroundProcessor;
        public WorkerParameters.RuntimeExtras mRuntimeExtras = new WorkerParameters.RuntimeExtras();
        public List<Scheduler> mSchedulers;
        public WorkDatabase mWorkDatabase;
        public String mWorkSpecId;
        public TaskExecutor mWorkTaskExecutor;

        public Builder(Context context, Configuration configuration, TaskExecutor taskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase workDatabase, String str) {
            this.mAppContext = context.getApplicationContext();
            this.mWorkTaskExecutor = taskExecutor;
            this.mForegroundProcessor = foregroundProcessor;
            this.mConfiguration = configuration;
            this.mWorkDatabase = workDatabase;
            this.mWorkSpecId = str;
        }
    }

    public WorkerWrapper(Builder builder) {
        this.mAppContext = builder.mAppContext;
        this.mWorkTaskExecutor = builder.mWorkTaskExecutor;
        this.mForegroundProcessor = builder.mForegroundProcessor;
        this.mWorkSpecId = builder.mWorkSpecId;
        this.mSchedulers = builder.mSchedulers;
        this.mRuntimeExtras = builder.mRuntimeExtras;
        this.mWorker = null;
        this.mConfiguration = builder.mConfiguration;
        WorkDatabase workDatabase = builder.mWorkDatabase;
        this.mWorkDatabase = workDatabase;
        this.mWorkSpecDao = workDatabase.workSpecDao();
        this.mDependencyDao = this.mWorkDatabase.dependencyDao();
        this.mWorkTagDao = this.mWorkDatabase.workTagDao();
    }

    public final void handleResult(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            Logger.get().info(TAG, String.format("Worker result SUCCESS for %s", this.mWorkDescription), new Throwable[0]);
            if (this.mWorkSpec.isPeriodic()) {
                resetPeriodicAndResolve();
                return;
            }
            this.mWorkDatabase.beginTransaction();
            try {
                WorkSpecDao workSpecDao = this.mWorkSpecDao;
                ((WorkSpecDao_Impl) workSpecDao).setState(WorkInfo$State.SUCCEEDED, this.mWorkSpecId);
                Data data = ((ListenableWorker.Result.Success) this.mResult).mOutputData;
                ((WorkSpecDao_Impl) this.mWorkSpecDao).setOutput(this.mWorkSpecId, data);
                long currentTimeMillis = System.currentTimeMillis();
                Iterator it = ((ArrayList) ((DependencyDao_Impl) this.mDependencyDao).getDependentWorkIds(this.mWorkSpecId)).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (((WorkSpecDao_Impl) this.mWorkSpecDao).getState(str) == WorkInfo$State.BLOCKED && ((DependencyDao_Impl) this.mDependencyDao).hasCompletedAllPrerequisites(str)) {
                        Logger.get().info(TAG, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                        WorkSpecDao workSpecDao2 = this.mWorkSpecDao;
                        ((WorkSpecDao_Impl) workSpecDao2).setState(WorkInfo$State.ENQUEUED, str);
                        ((WorkSpecDao_Impl) this.mWorkSpecDao).setPeriodStartTime(str, currentTimeMillis);
                    }
                }
                this.mWorkDatabase.setTransactionSuccessful();
            } finally {
                this.mWorkDatabase.endTransaction();
                resolve(false);
            }
        } else if (result instanceof ListenableWorker.Result.Retry) {
            Logger.get().info(TAG, String.format("Worker result RETRY for %s", this.mWorkDescription), new Throwable[0]);
            rescheduleAndResolve();
        } else {
            Logger.get().info(TAG, String.format("Worker result FAILURE for %s", this.mWorkDescription), new Throwable[0]);
            if (this.mWorkSpec.isPeriodic()) {
                resetPeriodicAndResolve();
            } else {
                setFailedAndResolve();
            }
        }
    }

    public final void iterativelyFailWorkAndDependents(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (((WorkSpecDao_Impl) this.mWorkSpecDao).getState(str2) != WorkInfo$State.CANCELLED) {
                WorkSpecDao workSpecDao = this.mWorkSpecDao;
                ((WorkSpecDao_Impl) workSpecDao).setState(WorkInfo$State.FAILED, str2);
            }
            linkedList.addAll(((DependencyDao_Impl) this.mDependencyDao).getDependentWorkIds(str2));
        }
    }

    public void onWorkFinished() {
        if (!tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.beginTransaction();
            try {
                WorkInfo$State state = ((WorkSpecDao_Impl) this.mWorkSpecDao).getState(this.mWorkSpecId);
                ((WorkProgressDao_Impl) this.mWorkDatabase.workProgressDao()).delete(this.mWorkSpecId);
                if (state == null) {
                    resolve(false);
                } else if (state == WorkInfo$State.RUNNING) {
                    handleResult(this.mResult);
                } else if (!state.isFinished()) {
                    rescheduleAndResolve();
                }
                this.mWorkDatabase.setTransactionSuccessful();
            } finally {
                this.mWorkDatabase.endTransaction();
            }
        }
        List<Scheduler> list = this.mSchedulers;
        if (list != null) {
            for (Scheduler scheduler : list) {
                scheduler.cancel(this.mWorkSpecId);
            }
            Schedulers.schedule(this.mConfiguration, this.mWorkDatabase, this.mSchedulers);
        }
    }

    public final void rescheduleAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            WorkSpecDao workSpecDao = this.mWorkSpecDao;
            ((WorkSpecDao_Impl) workSpecDao).setState(WorkInfo$State.ENQUEUED, this.mWorkSpecId);
            ((WorkSpecDao_Impl) this.mWorkSpecDao).setPeriodStartTime(this.mWorkSpecId, System.currentTimeMillis());
            ((WorkSpecDao_Impl) this.mWorkSpecDao).markWorkSpecScheduled(this.mWorkSpecId, -1);
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(true);
        }
    }

    public final void resetPeriodicAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            ((WorkSpecDao_Impl) this.mWorkSpecDao).setPeriodStartTime(this.mWorkSpecId, System.currentTimeMillis());
            WorkSpecDao workSpecDao = this.mWorkSpecDao;
            ((WorkSpecDao_Impl) workSpecDao).setState(WorkInfo$State.ENQUEUED, this.mWorkSpecId);
            ((WorkSpecDao_Impl) this.mWorkSpecDao).resetWorkSpecRunAttemptCount(this.mWorkSpecId);
            ((WorkSpecDao_Impl) this.mWorkSpecDao).markWorkSpecScheduled(this.mWorkSpecId, -1);
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(false);
        }
    }

    /* JADX INFO: finally extract failed */
    public final void resolve(boolean z) {
        this.mWorkDatabase.beginTransaction();
        try {
            if (((ArrayList) ((WorkSpecDao_Impl) this.mWorkDatabase.workSpecDao()).getAllUnfinishedWork()).isEmpty()) {
                PackageManagerHelper.setComponentEnabled(this.mAppContext, RescheduleReceiver.class, false);
            }
            if (z) {
                ((WorkSpecDao_Impl) this.mWorkSpecDao).setState(WorkInfo$State.ENQUEUED, this.mWorkSpecId);
                ((WorkSpecDao_Impl) this.mWorkSpecDao).markWorkSpecScheduled(this.mWorkSpecId, -1);
            }
            if (!(this.mWorkSpec == null || this.mWorker == null || !this.mWorker.isRunInForeground())) {
                ForegroundProcessor foregroundProcessor = this.mForegroundProcessor;
                String str = this.mWorkSpecId;
                Processor processor = (Processor) foregroundProcessor;
                synchronized (processor.mLock) {
                    processor.mForegroundWorkMap.remove(str);
                    processor.stopForegroundService();
                }
            }
            this.mWorkDatabase.setTransactionSuccessful();
            this.mWorkDatabase.endTransaction();
            this.mFuture.set(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.mWorkDatabase.endTransaction();
            throw th;
        }
    }

    public final void resolveIncorrectStatus() {
        WorkInfo$State state = ((WorkSpecDao_Impl) this.mWorkSpecDao).getState(this.mWorkSpecId);
        if (state == WorkInfo$State.RUNNING) {
            Logger.get().debug(TAG, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.mWorkSpecId), new Throwable[0]);
            resolve(true);
            return;
        }
        Logger.get().debug(TAG, String.format("Status for %s is %s; not doing any work", this.mWorkSpecId, state), new Throwable[0]);
        resolve(false);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c1, code lost:
        if ((r2.state == r0 && r2.runAttemptCount > 0) != false) goto L_0x00c3;
     */
    public void run() {
        Data merge;
        boolean z;
        List<String> tagsForWorkSpecId = ((WorkTagDao_Impl) this.mWorkTagDao).getTagsForWorkSpecId(this.mWorkSpecId);
        this.mTags = tagsForWorkSpecId;
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.mWorkSpecId);
        sb.append(", tags={ ");
        boolean z2 = true;
        for (String str : tagsForWorkSpecId) {
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        this.mWorkDescription = sb.toString();
        WorkInfo$State workInfo$State = WorkInfo$State.ENQUEUED;
        if (!tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.beginTransaction();
            try {
                WorkSpec workSpec = ((WorkSpecDao_Impl) this.mWorkSpecDao).getWorkSpec(this.mWorkSpecId);
                this.mWorkSpec = workSpec;
                if (workSpec == null) {
                    Logger.get().error(TAG, String.format("Didn't find WorkSpec for id %s", this.mWorkSpecId), new Throwable[0]);
                    resolve(false);
                } else if (workSpec.state != workInfo$State) {
                    resolveIncorrectStatus();
                    this.mWorkDatabase.setTransactionSuccessful();
                    Logger.get().debug(TAG, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.mWorkSpec.workerClassName), new Throwable[0]);
                } else {
                    if (!workSpec.isPeriodic()) {
                        WorkSpec workSpec2 = this.mWorkSpec;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!(this.mWorkSpec.periodStartTime == 0) && currentTimeMillis < this.mWorkSpec.calculateNextRunTime()) {
                        Logger.get().debug(TAG, String.format("Delaying execution for %s because it is being executed before schedule.", this.mWorkSpec.workerClassName), new Throwable[0]);
                        resolve(true);
                    }
                    this.mWorkDatabase.setTransactionSuccessful();
                    this.mWorkDatabase.endTransaction();
                    if (this.mWorkSpec.isPeriodic()) {
                        merge = this.mWorkSpec.input;
                    } else {
                        InputMergerFactory inputMergerFactory = this.mConfiguration.mInputMergerFactory;
                        String str2 = this.mWorkSpec.inputMergerClassName;
                        if (inputMergerFactory != null) {
                            InputMerger fromClassName = InputMerger.fromClassName(str2);
                            if (fromClassName == null) {
                                Logger.get().error(TAG, String.format("Could not create Input Merger %s", this.mWorkSpec.inputMergerClassName), new Throwable[0]);
                                setFailedAndResolve();
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(this.mWorkSpec.input);
                            WorkSpecDao workSpecDao = this.mWorkSpecDao;
                            String str3 = this.mWorkSpecId;
                            WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) workSpecDao;
                            if (workSpecDao_Impl != null) {
                                RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
                                if (str3 == null) {
                                    acquire.bindNull(1);
                                } else {
                                    acquire.bindString(1, str3);
                                }
                                workSpecDao_Impl.__db.assertNotSuspendingTransaction();
                                Cursor query = DBUtil.query(workSpecDao_Impl.__db, acquire, false, null);
                                try {
                                    ArrayList arrayList2 = new ArrayList(query.getCount());
                                    while (query.moveToNext()) {
                                        arrayList2.add(Data.fromByteArray(query.getBlob(0)));
                                    }
                                    query.close();
                                    acquire.release();
                                    arrayList.addAll(arrayList2);
                                    merge = fromClassName.merge(arrayList);
                                } catch (Throwable th) {
                                    query.close();
                                    acquire.release();
                                    throw th;
                                }
                            } else {
                                throw null;
                            }
                        } else {
                            throw null;
                        }
                    }
                    UUID fromString = UUID.fromString(this.mWorkSpecId);
                    List<String> list = this.mTags;
                    WorkerParameters.RuntimeExtras runtimeExtras = this.mRuntimeExtras;
                    int i = this.mWorkSpec.runAttemptCount;
                    Configuration configuration = this.mConfiguration;
                    WorkerParameters workerParameters = new WorkerParameters(fromString, merge, list, runtimeExtras, i, configuration.mExecutor, this.mWorkTaskExecutor, configuration.mWorkerFactory, new WorkProgressUpdater(this.mWorkDatabase, this.mWorkTaskExecutor), new WorkForegroundUpdater(this.mWorkDatabase, this.mForegroundProcessor, this.mWorkTaskExecutor));
                    if (this.mWorker == null) {
                        this.mWorker = this.mConfiguration.mWorkerFactory.createWorkerWithDefaultFallback(this.mAppContext, this.mWorkSpec.workerClassName, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.mWorker;
                    if (listenableWorker == null) {
                        Logger.get().error(TAG, String.format("Could not create Worker %s", this.mWorkSpec.workerClassName), new Throwable[0]);
                        setFailedAndResolve();
                    } else if (listenableWorker.mUsed) {
                        Logger.get().error(TAG, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.mWorkSpec.workerClassName), new Throwable[0]);
                        setFailedAndResolve();
                    } else {
                        listenableWorker.mUsed = true;
                        this.mWorkDatabase.beginTransaction();
                        try {
                            if (((WorkSpecDao_Impl) this.mWorkSpecDao).getState(this.mWorkSpecId) == workInfo$State) {
                                z = true;
                                ((WorkSpecDao_Impl) this.mWorkSpecDao).setState(WorkInfo$State.RUNNING, this.mWorkSpecId);
                                ((WorkSpecDao_Impl) this.mWorkSpecDao).incrementWorkSpecRunAttemptCount(this.mWorkSpecId);
                            } else {
                                z = false;
                            }
                            this.mWorkDatabase.setTransactionSuccessful();
                            if (!z) {
                                resolveIncorrectStatus();
                            } else if (!tryCheckForInterruptionAndResolve()) {
                                final SettableFuture settableFuture = new SettableFuture();
                                ((WorkManagerTaskExecutor) this.mWorkTaskExecutor).mMainThreadExecutor.execute(new Runnable() {
                                    /* class androidx.work.impl.WorkerWrapper.AnonymousClass1 */

                                    public void run() {
                                        try {
                                            Logger.get().debug(WorkerWrapper.TAG, String.format("Starting work for %s", WorkerWrapper.this.mWorkSpec.workerClassName), new Throwable[0]);
                                            WorkerWrapper.this.mInnerFuture = WorkerWrapper.this.mWorker.startWork();
                                            settableFuture.setFuture(WorkerWrapper.this.mInnerFuture);
                                        } catch (Throwable th) {
                                            settableFuture.setException(th);
                                        }
                                    }
                                });
                                final String str4 = this.mWorkDescription;
                                settableFuture.addListener(new Runnable() {
                                    /* class androidx.work.impl.WorkerWrapper.AnonymousClass2 */

                                    @SuppressLint({"SyntheticAccessor"})
                                    public void run() {
                                        try {
                                            ListenableWorker.Result result = (ListenableWorker.Result) settableFuture.get();
                                            if (result == null) {
                                                Logger.get().error(WorkerWrapper.TAG, String.format("%s returned a null result. Treating it as a failure.", WorkerWrapper.this.mWorkSpec.workerClassName), new Throwable[0]);
                                            } else {
                                                Logger.get().debug(WorkerWrapper.TAG, String.format("%s returned a %s result.", WorkerWrapper.this.mWorkSpec.workerClassName, result), new Throwable[0]);
                                                WorkerWrapper.this.mResult = result;
                                            }
                                        } catch (CancellationException e) {
                                            Logger.get().info(WorkerWrapper.TAG, String.format("%s was cancelled", str4), e);
                                        } catch (InterruptedException | ExecutionException e2) {
                                            Logger.get().error(WorkerWrapper.TAG, String.format("%s failed because it threw an exception/error", str4), e2);
                                        } catch (Throwable th) {
                                            WorkerWrapper.this.onWorkFinished();
                                            throw th;
                                        }
                                        WorkerWrapper.this.onWorkFinished();
                                    }
                                }, ((WorkManagerTaskExecutor) this.mWorkTaskExecutor).mBackgroundExecutor);
                            }
                        } finally {
                            this.mWorkDatabase.endTransaction();
                        }
                    }
                }
            } finally {
                this.mWorkDatabase.endTransaction();
            }
        }
    }

    public void setFailedAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            iterativelyFailWorkAndDependents(this.mWorkSpecId);
            ((WorkSpecDao_Impl) this.mWorkSpecDao).setOutput(this.mWorkSpecId, ((ListenableWorker.Result.Failure) this.mResult).mOutputData);
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(false);
        }
    }

    public final boolean tryCheckForInterruptionAndResolve() {
        if (!this.mInterrupted) {
            return false;
        }
        Logger.get().debug(TAG, String.format("Work interrupted for %s", this.mWorkDescription), new Throwable[0]);
        WorkInfo$State state = ((WorkSpecDao_Impl) this.mWorkSpecDao).getState(this.mWorkSpecId);
        if (state == null) {
            resolve(false);
        } else {
            resolve(!state.isFinished());
        }
        return true;
    }
}
