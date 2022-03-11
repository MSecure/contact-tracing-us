package f.b.b.f.a;

import f.b.b.f.a.o;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Incorrect class signature, class is equals to this class: <V:Ljava/lang/Object;>Lf/b/b/f/a/n;Ljava/util/concurrent/Future<TV;>; */
public abstract class n<V> implements Future<V> {
    public boolean cancel(boolean z) {
        return ((o.a) this).b.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return ((o.a) this).b.get();
    }

    public boolean isCancelled() {
        return ((o.a) this).b.isCancelled();
    }

    public boolean isDone() {
        return ((o.a) this).b.isDone();
    }

    public String toString() {
        return ((o.a) this).b.toString();
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) {
        return ((o.a) this).b.get(j2, timeUnit);
    }
}
