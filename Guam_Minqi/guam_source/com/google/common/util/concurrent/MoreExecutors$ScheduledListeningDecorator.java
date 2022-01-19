package com.google.common.util.concurrent;

import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class MoreExecutors$ScheduledListeningDecorator extends MoreExecutors$ListeningDecorator implements ListeningScheduledExecutorService {
    public final ScheduledExecutorService delegate;

    public static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements Object<V>, ListenableFuture {
        public final ScheduledFuture<?> scheduledDelegate;

        public ListenableScheduledTask(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
            super(listenableFuture);
            this.scheduledDelegate = scheduledFuture;
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture
        public boolean cancel(boolean z) {
            boolean cancel = super.cancel(z);
            if (cancel) {
                this.scheduledDelegate.cancel(z);
            }
            return cancel;
        }

        public int compareTo(Object obj) {
            return this.scheduledDelegate.compareTo((Delayed) obj);
        }

        public long getDelay(TimeUnit timeUnit) {
            return this.scheduledDelegate.getDelay(timeUnit);
        }
    }

    public static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {
        public final Runnable delegate;

        public NeverSuccessfulListenableFutureTask(Runnable runnable) {
            if (runnable != null) {
                this.delegate = runnable;
                return;
            }
            throw null;
        }

        public void run() {
            try {
                this.delegate.run();
            } catch (Throwable th) {
                setException(th);
                Throwables.throwIfUnchecked(th);
                throw new RuntimeException(th);
            }
        }
    }

    public MoreExecutors$ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.delegate = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        TrustedListenableFutureTask trustedListenableFutureTask = new TrustedListenableFutureTask(callable);
        return new ListenableScheduledTask(trustedListenableFutureTask, this.delegate.schedule(trustedListenableFutureTask, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
        return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
        return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        TrustedListenableFutureTask trustedListenableFutureTask = new TrustedListenableFutureTask(Executors.callable(runnable, null));
        return new ListenableScheduledTask(trustedListenableFutureTask, this.delegate.schedule(trustedListenableFutureTask, j, timeUnit));
    }
}
