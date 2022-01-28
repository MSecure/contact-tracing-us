package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ForwardingListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class ForwardingFuture<V> extends Future<V> implements Future {
    public boolean cancel(boolean z) {
        return ((ForwardingListenableFuture.SimpleForwardingListenableFuture) this).delegate.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return ((ForwardingListenableFuture.SimpleForwardingListenableFuture) this).delegate.get();
    }

    public boolean isCancelled() {
        return ((ForwardingListenableFuture.SimpleForwardingListenableFuture) this).delegate.isCancelled();
    }

    public boolean isDone() {
        return ((ForwardingListenableFuture.SimpleForwardingListenableFuture) this).delegate.isDone();
    }

    public String toString() {
        return ((ForwardingListenableFuture.SimpleForwardingListenableFuture) this).delegate.toString();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return ((ForwardingListenableFuture.SimpleForwardingListenableFuture) this).delegate.get(j, timeUnit);
    }
}
