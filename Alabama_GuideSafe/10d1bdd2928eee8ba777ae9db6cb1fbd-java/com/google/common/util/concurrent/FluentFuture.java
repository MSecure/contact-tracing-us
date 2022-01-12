package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.TimeoutFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class FluentFuture<V> extends GwtFluentFutureCatchingSpecialization<V> {

    public static abstract class TrustedFuture<V> extends FluentFuture<V> implements AbstractFuture.Trusted<V> {
        @Override // com.google.common.util.concurrent.ListenableFuture, com.google.common.util.concurrent.AbstractFuture
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // java.util.concurrent.Future, com.google.common.util.concurrent.AbstractFuture
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public final boolean isCancelled() {
            return this.value instanceof AbstractFuture.Cancellation;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // java.util.concurrent.Future, com.google.common.util.concurrent.AbstractFuture
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }
    }

    public static <V> FluentFuture<V> from(ListenableFuture<V> listenableFuture) {
        return listenableFuture instanceof FluentFuture ? (FluentFuture) listenableFuture : new ForwardingFluentFuture(listenableFuture);
    }

    public final <X extends Throwable> FluentFuture<V> catching(Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return (FluentFuture) AbstractCatchingFuture.create(this, cls, function, executor);
    }

    public final <T> FluentFuture<T> transform(Function<? super V, T> function, Executor executor) {
        return (FluentFuture) AbstractTransformFuture.create(this, function, executor);
    }

    public final <T> FluentFuture<T> transformAsync(AsyncFunction<? super V, T> asyncFunction, Executor executor) {
        return (FluentFuture) AbstractTransformFuture.create(this, asyncFunction, executor);
    }

    public final FluentFuture<V> withTimeout(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (isDone()) {
            return this;
        }
        TimeoutFuture timeoutFuture = new TimeoutFuture(this);
        TimeoutFuture.Fire fire = new TimeoutFuture.Fire(timeoutFuture);
        timeoutFuture.timer = scheduledExecutorService.schedule(fire, j, timeUnit);
        addListener(fire, DirectExecutor.INSTANCE);
        return timeoutFuture;
    }
}
