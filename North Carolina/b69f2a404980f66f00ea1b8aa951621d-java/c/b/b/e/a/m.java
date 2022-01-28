package c.b.b.e.a;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class m<V> extends l<V> {
    public final u<V> i;

    public m(u<V> uVar) {
        if (uVar != null) {
            this.i = uVar;
            return;
        }
        throw null;
    }

    @Override // c.b.b.e.a.b, c.b.b.e.a.u
    public void b(Runnable runnable, Executor executor) {
        this.i.b(runnable, executor);
    }

    @Override // c.b.b.e.a.b
    public boolean cancel(boolean z) {
        return this.i.cancel(z);
    }

    @Override // java.util.concurrent.Future, c.b.b.e.a.b
    public V get() {
        return this.i.get();
    }

    @Override // java.util.concurrent.Future, c.b.b.e.a.b
    public V get(long j, TimeUnit timeUnit) {
        return this.i.get(j, timeUnit);
    }

    @Override // c.b.b.e.a.b
    public boolean isCancelled() {
        return this.i.isCancelled();
    }

    @Override // c.b.b.e.a.b
    public boolean isDone() {
        return this.i.isDone();
    }

    @Override // c.b.b.e.a.b
    public String toString() {
        return this.i.toString();
    }
}
