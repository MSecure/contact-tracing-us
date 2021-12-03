package f.b.b.f.a;

import f.b.b.f.a.b;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class s<V> implements u<V> {
    public static final u<?> c = new s(null);

    /* renamed from: d  reason: collision with root package name */
    public static final Logger f3203d = Logger.getLogger(s.class.getName());
    public final V b;

    public static final class a<V> extends b.j<V> {
        public a(Throwable th) {
            u(th);
        }
    }

    public s(V v) {
        this.b = v;
    }

    @Override // f.b.b.f.a.u
    public void a(Runnable runnable, Executor executor) {
        f.b.a.c.b.o.b.z(runnable, "Runnable was null.");
        f.b.a.c.b.o.b.z(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f3203d;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.b;
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit);
        return this.b;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + ((Object) this.b) + "]]";
    }
}
