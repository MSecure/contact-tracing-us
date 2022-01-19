package com.google.common.util.concurrent;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class MoreExecutors$ListeningDecorator extends AbstractListeningExecutorService {
    public final ExecutorService delegate;

    public MoreExecutors$ListeningDecorator(ExecutorService executorService) {
        if (executorService != null) {
            this.delegate = executorService;
            return;
        }
        throw null;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    public final void execute(Runnable runnable) {
        this.delegate.execute(runnable);
    }

    public final boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public final boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public final void shutdown() {
        this.delegate.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }
}
