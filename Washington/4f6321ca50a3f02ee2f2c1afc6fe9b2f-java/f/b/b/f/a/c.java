package f.b.b.f.a;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

public abstract class c extends AbstractExecutorService implements v {
    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new c0(Executors.callable(runnable, t));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, f.b.b.f.a.v
    public u<?> submit(Runnable runnable) {
        return (u) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, f.b.b.f.a.v
    /* renamed from: submit  reason: collision with other method in class */
    public Future m6submit(Runnable runnable) {
        return (u) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new c0(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return (u) super.submit(runnable, obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return (u) super.submit(callable);
    }
}
