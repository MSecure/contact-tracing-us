package f.b.b.f.a;

import f.b.b.f.a.o;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public abstract class n<V> implements Future<V> {
    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return ((o.a) this).b.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return ((o.a) this).b.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return ((o.a) this).b.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return ((o.a) this).b.isDone();
    }

    @Override // java.lang.Object
    public String toString() {
        return ((o.a) this).b.toString();
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) {
        return ((o.a) this).b.get(j2, timeUnit);
    }
}
