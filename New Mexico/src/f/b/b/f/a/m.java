package f.b.b.f.a;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class m<V> extends l<V> {

    /* renamed from: i  reason: collision with root package name */
    public final u<V> f3457i;

    public m(u<V> uVar) {
        Objects.requireNonNull(uVar);
        this.f3457i = uVar;
    }

    @Override // f.b.b.f.a.b, f.b.b.f.a.u
    public void a(Runnable runnable, Executor executor) {
        this.f3457i.a(runnable, executor);
    }

    @Override // f.b.b.f.a.b, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.f3457i.cancel(z);
    }

    @Override // f.b.b.f.a.b, java.util.concurrent.Future
    public V get() {
        return this.f3457i.get();
    }

    @Override // f.b.b.f.a.b, java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) {
        return this.f3457i.get(j2, timeUnit);
    }

    @Override // f.b.b.f.a.b, java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f3457i.isCancelled();
    }

    @Override // f.b.b.f.a.b, java.util.concurrent.Future
    public boolean isDone() {
        return this.f3457i.isDone();
    }

    @Override // f.b.b.f.a.b, java.lang.Object
    public String toString() {
        return this.f3457i.toString();
    }
}
