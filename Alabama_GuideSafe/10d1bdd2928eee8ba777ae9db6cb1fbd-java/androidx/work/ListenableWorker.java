package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ForegroundInfo;
import androidx.work.WorkInfo$State;
import androidx.work.impl.Processor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public abstract class ListenableWorker {
    public Context mAppContext;
    public boolean mRunInForeground;
    public boolean mUsed;
    public WorkerParameters mWorkerParams;

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.mAppContext = context;
            this.mWorkerParams = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public boolean isRunInForeground() {
        return this.mRunInForeground;
    }

    public void onStopped() {
    }

    public final ListenableFuture<Void> setForegroundAsync(ForegroundInfo foregroundInfo) {
        this.mRunInForeground = true;
        WorkerParameters workerParameters = this.mWorkerParams;
        ForegroundUpdater foregroundUpdater = workerParameters.mForegroundUpdater;
        Context context = this.mAppContext;
        UUID uuid = workerParameters.mId;
        WorkForegroundUpdater workForegroundUpdater = (WorkForegroundUpdater) foregroundUpdater;
        if (workForegroundUpdater != null) {
            SettableFuture settableFuture = new SettableFuture();
            TaskExecutor taskExecutor = workForegroundUpdater.mTaskExecutor;
            ((WorkManagerTaskExecutor) taskExecutor).mBackgroundExecutor.execute(new Runnable(settableFuture, uuid, foregroundInfo, context) {
                /* class androidx.work.impl.utils.WorkForegroundUpdater.AnonymousClass1 */
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ ForegroundInfo val$foregroundInfo;
                public final /* synthetic */ SettableFuture val$future;
                public final /* synthetic */ UUID val$id;

                {
                    this.val$future = r2;
                    this.val$id = r3;
                    this.val$foregroundInfo = r4;
                    this.val$context = r5;
                }

                public void run() {
                    try {
                        if (!(this.val$future.value instanceof AbstractFuture.Cancellation)) {
                            String uuid = this.val$id.toString();
                            WorkInfo$State state = ((WorkSpecDao_Impl) WorkForegroundUpdater.this.mWorkSpecDao).getState(uuid);
                            if (state == null || state.isFinished()) {
                                throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                            }
                            ((Processor) WorkForegroundUpdater.this.mForegroundProcessor).startForeground(uuid, this.val$foregroundInfo);
                            this.val$context.startService(SystemForegroundDispatcher.createNotifyIntent(this.val$context, uuid, this.val$foregroundInfo));
                        }
                        this.val$future.set(null);
                    } catch (Throwable th) {
                        this.val$future.setException(th);
                    }
                }
            });
            return settableFuture;
        }
        throw null;
    }

    public abstract ListenableFuture<Result> startWork();

    public final void stop() {
        onStopped();
    }

    public static abstract class Result {

        public static final class Failure extends Result {
            public final Data mOutputData = Data.EMPTY;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Failure.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Failure) obj).mOutputData);
            }

            public int hashCode() {
                return this.mOutputData.hashCode() + 846803280;
            }

            public String toString() {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Failure {mOutputData=");
                outline17.append(this.mOutputData);
                outline17.append('}');
                return outline17.toString();
            }
        }

        public static final class Retry extends Result {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && Retry.class == obj.getClass();
            }

            public int hashCode() {
                return 25945934;
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class Success extends Result {
            public final Data mOutputData;

            public Success() {
                this.mOutputData = Data.EMPTY;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Success.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Success) obj).mOutputData);
            }

            public int hashCode() {
                return this.mOutputData.hashCode() - 1876823561;
            }

            public String toString() {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Success {mOutputData=");
                outline17.append(this.mOutputData);
                outline17.append('}');
                return outline17.toString();
            }

            public Success(Data data) {
                this.mOutputData = data;
            }
        }
    }
}
