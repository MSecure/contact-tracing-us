package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class Worker extends ListenableWorker {
    public SettableFuture<ListenableWorker.Result> mFuture;

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract ListenableWorker.Result doWork();

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        this.mFuture = new SettableFuture<>();
        this.mWorkerParams.mBackgroundExecutor.execute(new Runnable() {
            /* class androidx.work.Worker.AnonymousClass1 */

            public void run() {
                try {
                    Worker.this.mFuture.set(Worker.this.doWork());
                } catch (Throwable th) {
                    Worker.this.mFuture.setException(th);
                }
            }
        });
        return this.mFuture;
    }
}
