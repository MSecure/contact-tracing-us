package f.b.b.f.a;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

public abstract class c extends AbstractExecutorService implements w {
    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new d0(Executors.callable(runnable, t));
    }

    @Override // java.util.concurrent.AbstractExecutorService, f.b.b.f.a.w, java.util.concurrent.ExecutorService
    public u<?> submit(Runnable runnable) {
        return (u) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, f.b.b.f.a.w, java.util.concurrent.ExecutorService
    /* renamed from: submit  reason: collision with other method in class */
    public Future m18submit(Runnable runnable) {
        return (u) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new d0(callable);
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
