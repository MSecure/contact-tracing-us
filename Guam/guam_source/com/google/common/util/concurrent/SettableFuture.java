package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;

public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean set(V v) {
        return super.set(v);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}
