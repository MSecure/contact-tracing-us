package f.b.b.f.a;

import f.b.b.f.a.b;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public class s<V> implements u<V> {
    public static final u<?> c = new s(null);

    /* renamed from: d */
    public static final Logger f3458d = Logger.getLogger(s.class.getName());
    public final V b;

    /* loaded from: classes.dex */
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
        f.b.a.c.b.o.b.A(runnable, "Runnable was null.");
        f.b.a.c.b.o.b.A(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f3458d;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    @Override // java.util.concurrent.Future
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

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    @Override // java.lang.Object
    public String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + this.b + "]]";
    }
}
