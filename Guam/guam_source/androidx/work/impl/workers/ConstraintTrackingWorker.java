package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {
    public static final String TAG = Logger.tagWithPrefix("ConstraintTrkngWrkr");
    public volatile boolean mAreConstraintsUnmet = false;
    public ListenableWorker mDelegate;
    public SettableFuture<ListenableWorker.Result> mFuture = new SettableFuture<>();
    public final Object mLock = new Object();
    public WorkerParameters mWorkerParameters;

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.mWorkerParameters = workerParameters;
    }

    @Override // androidx.work.ListenableWorker
    public boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.mDelegate;
        return listenableWorker != null && listenableWorker.isRunInForeground();
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List<String> list) {
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List<String> list) {
        Logger.get().debug(TAG, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.mLock) {
            this.mAreConstraintsUnmet = true;
        }
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        ListenableWorker listenableWorker = this.mDelegate;
        if (listenableWorker != null) {
            listenableWorker.stop();
        }
    }

    public void setFutureFailed() {
        this.mFuture.set(new ListenableWorker.Result.Failure());
    }

    public void setFutureRetry() {
        this.mFuture.set(new ListenableWorker.Result.Retry());
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        this.mWorkerParams.mBackgroundExecutor.execute(new Runnable() {
            /* class androidx.work.impl.workers.ConstraintTrackingWorker.AnonymousClass1 */

            public void run() {
                ConstraintTrackingWorker constraintTrackingWorker = ConstraintTrackingWorker.this;
                Object obj = constraintTrackingWorker.mWorkerParams.mInputData.mValues.get("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
                String str = obj instanceof String ? (String) obj : null;
                if (TextUtils.isEmpty(str)) {
                    Logger.get().error(ConstraintTrackingWorker.TAG, "No worker to delegate to.", new Throwable[0]);
                    constraintTrackingWorker.setFutureFailed();
                    return;
                }
                ListenableWorker createWorkerWithDefaultFallback = constraintTrackingWorker.mWorkerParams.mWorkerFactory.createWorkerWithDefaultFallback(constraintTrackingWorker.mAppContext, str, constraintTrackingWorker.mWorkerParameters);
                constraintTrackingWorker.mDelegate = createWorkerWithDefaultFallback;
                if (createWorkerWithDefaultFallback == null) {
                    Logger.get().debug(ConstraintTrackingWorker.TAG, "No worker to delegate to.", new Throwable[0]);
                    constraintTrackingWorker.setFutureFailed();
                    return;
                }
                WorkSpec workSpec = ((WorkSpecDao_Impl) WorkManagerImpl.getInstance(constraintTrackingWorker.mAppContext).mWorkDatabase.workSpecDao()).getWorkSpec(constraintTrackingWorker.mWorkerParams.mId.toString());
                if (workSpec == null) {
                    constraintTrackingWorker.setFutureFailed();
                    return;
                }
                Context context = constraintTrackingWorker.mAppContext;
                WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(context, WorkManagerImpl.getInstance(context).mWorkTaskExecutor, constraintTrackingWorker);
                workConstraintsTracker.replace(Collections.singletonList(workSpec));
                if (workConstraintsTracker.areAllConstraintsMet(constraintTrackingWorker.mWorkerParams.mId.toString())) {
                    Logger.get().debug(ConstraintTrackingWorker.TAG, String.format("Constraints met for delegate %s", str), new Throwable[0]);
                    try {
                        ListenableFuture<ListenableWorker.Result> startWork = constraintTrackingWorker.mDelegate.startWork();
                        startWork.addListener(new Runnable(startWork) {
                            /* class androidx.work.impl.workers.ConstraintTrackingWorker.AnonymousClass2 */
                            public final /* synthetic */ ListenableFuture val$innerFuture;

                            {
                                this.val$innerFuture = r2;
                            }

                            public void run() {
                                synchronized (ConstraintTrackingWorker.this.mLock) {
                                    if (ConstraintTrackingWorker.this.mAreConstraintsUnmet) {
                                        ConstraintTrackingWorker.this.setFutureRetry();
                                    } else {
                                        ConstraintTrackingWorker.this.mFuture.setFuture(this.val$innerFuture);
                                    }
                                }
                            }
                        }, constraintTrackingWorker.mWorkerParams.mBackgroundExecutor);
                    } catch (Throwable th) {
                        Logger.get().debug(ConstraintTrackingWorker.TAG, String.format("Delegated worker %s threw exception in startWork.", str), th);
                        synchronized (constraintTrackingWorker.mLock) {
                            if (constraintTrackingWorker.mAreConstraintsUnmet) {
                                Logger.get().debug(ConstraintTrackingWorker.TAG, "Constraints were unmet, Retrying.", new Throwable[0]);
                                constraintTrackingWorker.setFutureRetry();
                            } else {
                                constraintTrackingWorker.setFutureFailed();
                            }
                        }
                    }
                } else {
                    Logger.get().debug(ConstraintTrackingWorker.TAG, String.format("Constraints not met for delegate %s. Requesting retry.", str), new Throwable[0]);
                    constraintTrackingWorker.setFutureRetry();
                }
            }
        });
        return this.mFuture;
    }
}
