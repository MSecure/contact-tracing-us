package f.b.b.f.a;

import f.b.b.a.g;
import f.b.b.f.a.b;
import f.b.b.f.a.b0;
import f.b.b.f.a.d;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class l<V> extends r<V> {

    public static abstract class a<V> extends l<V> implements b.i<V> {
        @Override // f.b.b.f.a.b, f.b.b.f.a.u
        public final void a(Runnable runnable, Executor executor) {
            super.a(runnable, executor);
        }

        @Override // f.b.b.f.a.b
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // f.b.b.f.a.b, java.util.concurrent.Future
        public final V get() {
            return (V) super.get();
        }

        @Override // f.b.b.f.a.b, java.util.concurrent.Future
        public final V get(long j2, TimeUnit timeUnit) {
            return (V) super.get(j2, timeUnit);
        }

        @Override // f.b.b.f.a.b
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // f.b.b.f.a.b
        public final boolean isDone() {
            return super.isDone();
        }
    }

    public static <V> l<V> x(u<V> uVar) {
        return uVar instanceof l ? (l) uVar : new m(uVar);
    }

    public final l<V> A(long j2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (isDone()) {
            return this;
        }
        b0 b0Var = new b0(this);
        b0.b bVar = new b0.b(b0Var);
        b0Var.f2935j = scheduledExecutorService.schedule(bVar, j2, timeUnit);
        a(bVar, k.INSTANCE);
        return b0Var;
    }

    public final <T> l<T> y(g<? super V, T> gVar, Executor executor) {
        d.b bVar = new d.b(this, gVar);
        a(bVar, f.b.a.c.b.o.b.A1(executor, bVar));
        return bVar;
    }

    public final <T> l<T> z(i<? super V, T> iVar, Executor executor) {
        Objects.requireNonNull(executor);
        d.a aVar = new d.a(this, iVar);
        a(aVar, f.b.a.c.b.o.b.A1(executor, aVar));
        return aVar;
    }
}
