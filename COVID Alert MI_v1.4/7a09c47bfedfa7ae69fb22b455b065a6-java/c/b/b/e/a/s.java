package c.b.b.e.a;

import b.x.t;
import c.b.b.e.a.b;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class s<V> implements u<V> {

    /* renamed from: c  reason: collision with root package name */
    public static final u<?> f4761c = new s(null);

    /* renamed from: d  reason: collision with root package name */
    public static final Logger f4762d = Logger.getLogger(s.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public final V f4763b;

    public static final class a<V> extends b.j<V> {
        public a(Throwable th) {
            n(th);
        }
    }

    public s(V v) {
        this.f4763b = v;
    }

    @Override // c.b.b.e.a.u
    public void b(Runnable runnable, Executor executor) {
        t.F(runnable, "Runnable was null.");
        t.F(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f4762d;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.f4763b;
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) {
        if (timeUnit != null) {
            return this.f4763b;
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
        return super.toString() + "[status=SUCCESS, result=[" + ((Object) this.f4763b) + "]]";
    }
}
