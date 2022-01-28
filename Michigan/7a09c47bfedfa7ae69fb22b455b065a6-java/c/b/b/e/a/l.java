package c.b.b.e.a;

import c.b.b.a.e;
import c.b.b.e.a.b;
import c.b.b.e.a.b0;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class l<V> extends r<V> {

    public static abstract class a<V> extends l<V> implements b.i<V> {
        @Override // c.b.b.e.a.b, c.b.b.e.a.u
        public final void b(Runnable runnable, Executor executor) {
            super.b(runnable, executor);
        }

        @Override // c.b.b.e.a.b
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // java.util.concurrent.Future, c.b.b.e.a.b
        public final V get() {
            return (V) super.get();
        }

        @Override // java.util.concurrent.Future, c.b.b.e.a.b
        public final V get(long j, TimeUnit timeUnit) {
            return (V) super.get(j, timeUnit);
        }

        @Override // c.b.b.e.a.b
        public final boolean isCancelled() {
            return this.f4716b instanceof b.c;
        }

        @Override // c.b.b.e.a.b
        public final boolean isDone() {
            return super.isDone();
        }
    }

    @Deprecated
    public static <V> l<V> r(l<V> lVar) {
        if (lVar != null) {
            return lVar;
        }
        throw null;
    }

    public static <V> l<V> s(u<V> uVar) {
        return uVar instanceof l ? (l) uVar : new m(uVar);
    }

    public final <X extends Throwable> l<V> q(Class<X> cls, e<? super X, ? extends V> eVar, Executor executor) {
        return (l) a.w(this, cls, eVar, executor);
    }

    public final <T> l<T> t(e<? super V, T> eVar, Executor executor) {
        return (l) d.w(this, eVar, executor);
    }

    public final <T> l<T> u(i<? super V, T> iVar, Executor executor) {
        return (l) d.x(this, iVar, executor);
    }

    public final l<V> v(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (isDone()) {
            return this;
        }
        b0 b0Var = new b0(this);
        b0.b bVar = new b0.b(b0Var);
        b0Var.j = scheduledExecutorService.schedule(bVar, j, timeUnit);
        b(bVar, k.INSTANCE);
        return b0Var;
    }
}
