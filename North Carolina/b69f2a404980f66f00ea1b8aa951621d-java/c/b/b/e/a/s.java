package c.b.b.e.a;

import c.b.a.a.c.n.c;
import c.b.b.e.a.b;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class s<V> implements u<V> {

    /* renamed from: c  reason: collision with root package name */
    public static final u<?> f3411c = new s(null);

    /* renamed from: d  reason: collision with root package name */
    public static final Logger f3412d = Logger.getLogger(s.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public final V f3413b;

    public static final class a<V> extends b.j<V> {
        public a(Throwable th) {
            n(th);
        }
    }

    public s(V v) {
        this.f3413b = v;
    }

    @Override // c.b.b.e.a.u
    public void b(Runnable runnable, Executor executor) {
        c.t(runnable, "Runnable was null.");
        c.t(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f3412d;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.f3413b;
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) {
        if (timeUnit != null) {
            return this.f3413b;
        }
        throw null;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + ((Object) this.f3413b) + "]]";
    }
}
