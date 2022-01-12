package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.LockSupport;

public class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {
    public volatile InterruptibleTask<?> task;

    public final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        public final Callable<V> callable;

        public TrustedFutureInterruptibleTask(Callable<V> callable2) {
            if (callable2 != null) {
                this.callable = callable2;
                return;
            }
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptibly(V v, Throwable th) {
            if (th == null) {
                TrustedListenableFutureTask.this.set(v);
            } else {
                TrustedListenableFutureTask.this.setException(th);
            }
        }
    }

    public TrustedListenableFutureTask(Callable<V> callable) {
        this.task = new TrustedFutureInterruptibleTask(callable);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        InterruptibleTask<?> interruptibleTask;
        if (wasInterrupted() && (interruptibleTask = this.task) != null) {
            Runnable runnable = (Runnable) interruptibleTask.get();
            if ((runnable instanceof Thread) && interruptibleTask.compareAndSet(runnable, InterruptibleTask.INTERRUPTING)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (((Runnable) interruptibleTask.getAndSet(InterruptibleTask.DONE)) == InterruptibleTask.PARKED) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
        this.task = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask == null) {
            return super.pendingToString();
        }
        return "task=[" + interruptibleTask + "]";
    }

    public void run() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.task = null;
    }
}
