package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class MoreExecutors$5 implements Executor {
    public boolean thrownFromDelegate = true;
    public final /* synthetic */ Executor val$delegate;
    public final /* synthetic */ AbstractFuture val$future;

    public MoreExecutors$5(Executor executor, AbstractFuture abstractFuture) {
        this.val$delegate = executor;
        this.val$future = abstractFuture;
    }

    public void execute(final Runnable runnable) {
        try {
            this.val$delegate.execute(new Runnable() {
                /* class com.google.common.util.concurrent.MoreExecutors$5.AnonymousClass1 */

                public void run() {
                    MoreExecutors$5.this.thrownFromDelegate = false;
                    runnable.run();
                }

                public String toString() {
                    return runnable.toString();
                }
            });
        } catch (RejectedExecutionException e) {
            if (this.thrownFromDelegate) {
                this.val$future.setException(e);
            }
        }
    }
}
