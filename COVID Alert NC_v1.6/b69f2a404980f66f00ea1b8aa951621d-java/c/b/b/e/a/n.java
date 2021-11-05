package c.b.b.e.a;

import c.b.b.e.a.o;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Incorrect class signature, class is equals to this class: <V:Ljava/lang/Object;>Lc/b/b/e/a/n;Ljava/util/concurrent/Future<TV;>; */
public abstract class n<V> implements Future<V> {
    public boolean cancel(boolean z) {
        return ((o.a) this).f3408b.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return ((o.a) this).f3408b.get();
    }

    public boolean isCancelled() {
        return ((o.a) this).f3408b.isCancelled();
    }

    public boolean isDone() {
        return ((o.a) this).f3408b.isDone();
    }

    public String toString() {
        return ((o.a) this).f3408b.toString();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) {
        return ((o.a) this).f3408b.get(j, timeUnit);
    }
}
