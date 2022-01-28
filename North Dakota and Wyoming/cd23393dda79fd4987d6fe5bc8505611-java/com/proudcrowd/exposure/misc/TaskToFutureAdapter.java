package com.proudcrowd.exposure.misc;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskToFutureAdapter {
    private static final String TAG = "TaskToFutureAdapter";

    public static <T> ListenableFuture<T> getFutureWithTimeout(Task<T> task, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return FluentFuture.from(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(scheduledExecutorService) {
            /* class com.proudcrowd.exposure.misc.$$Lambda$TaskToFutureAdapter$zuar5JBOReh49WE0K7TfLK4IFE */
            public final /* synthetic */ ScheduledExecutorService f$1;

            {
                this.f$1 = r2;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return Task.this.addOnCompleteListener((Task) this.f$1, (ScheduledExecutorService) new OnCompleteListener() {
                    /* class com.proudcrowd.exposure.misc.$$Lambda$TaskToFutureAdapter$P3J8k03vwRsVNchO1aklWSHgA3U */

                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        TaskToFutureAdapter.lambda$null$0(CallbackToFutureAdapter.Completer.this, task);
                    }
                });
            }
        })).withTimeout(j, timeUnit, scheduledExecutorService);
    }

    static /* synthetic */ void lambda$null$0(CallbackToFutureAdapter.Completer completer, Task task) {
        try {
            if (task.isCanceled()) {
                completer.setCancelled();
            } else if (task.getException() != null) {
                completer.setException(task.getException());
            } else {
                completer.set(task.getResult());
            }
        } catch (Exception e) {
            completer.setException(e);
        }
    }
}
