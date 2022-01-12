package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class ForwardingFluentFuture<V> extends FluentFuture<V> {
    public final ListenableFuture<V> delegate;

    public ForwardingFluentFuture(ListenableFuture<V> listenableFuture) {
        if (listenableFuture != null) {
            this.delegate = listenableFuture;
            return;
        }
        throw null;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture, com.google.common.util.concurrent.AbstractFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.delegate.addListener(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean cancel(boolean z) {
        return this.delegate.cancel(z);
    }

    @Override // java.util.concurrent.Future, com.google.common.util.concurrent.AbstractFuture
    public V get() throws InterruptedException, ExecutionException {
        return this.delegate.get();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean isDone() {
        return this.delegate.isDone();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String toString() {
        return this.delegate.toString();
    }

    @Override // java.util.concurrent.Future, com.google.common.util.concurrent.AbstractFuture
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.delegate.get(j, timeUnit);
    }
}
