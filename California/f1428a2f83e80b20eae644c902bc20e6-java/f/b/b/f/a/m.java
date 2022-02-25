package f.b.b.f.a;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class m<V> extends l<V> {

    /* renamed from: i  reason: collision with root package name */
    public final u<V> f2939i;

    public m(u<V> uVar) {
        Objects.requireNonNull(uVar);
        this.f2939i = uVar;
    }

    @Override // f.b.b.f.a.b, f.b.b.f.a.u
    public void a(Runnable runnable, Executor executor) {
        this.f2939i.a(runnable, executor);
    }

    @Override // f.b.b.f.a.b
    public boolean cancel(boolean z) {
        return this.f2939i.cancel(z);
    }

    @Override // f.b.b.f.a.b, java.util.concurrent.Future
    public V get() {
        return this.f2939i.get();
    }

    @Override // f.b.b.f.a.b, java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) {
        return this.f2939i.get(j2, timeUnit);
    }

    @Override // f.b.b.f.a.b
    public boolean isCancelled() {
        return this.f2939i.isCancelled();
    }

    @Override // f.b.b.f.a.b
    public boolean isDone() {
        return this.f2939i.isDone();
    }

    @Override // f.b.b.f.a.b
    public String toString() {
        return this.f2939i.toString();
    }
}
