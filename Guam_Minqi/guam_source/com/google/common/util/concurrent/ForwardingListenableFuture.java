package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {

    public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {
        public final ListenableFuture<V> delegate;

        public SimpleForwardingListenableFuture(ListenableFuture<V> listenableFuture) {
            if (listenableFuture != null) {
                this.delegate = listenableFuture;
                return;
            }
            throw null;
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        ((SimpleForwardingListenableFuture) this).delegate.addListener(runnable, executor);
    }
}
