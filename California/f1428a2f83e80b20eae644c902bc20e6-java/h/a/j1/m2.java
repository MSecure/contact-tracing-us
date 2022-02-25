package h.a.j1;

import f.b.b.a.s;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class m2 {
    public final ScheduledExecutorService a;
    public final Executor b;
    public final Runnable c;

    /* renamed from: d  reason: collision with root package name */
    public final s f3664d;

    /* renamed from: e  reason: collision with root package name */
    public long f3665e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3666f;

    /* renamed from: g  reason: collision with root package name */
    public ScheduledFuture<?> f3667g;

    public final class b implements Runnable {
        public b(a aVar) {
        }

        public void run() {
            m2 m2Var = m2.this;
            if (!m2Var.f3666f) {
                m2Var.f3667g = null;
                return;
            }
            s sVar = m2Var.f3664d;
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long a = sVar.a(timeUnit);
            m2 m2Var2 = m2.this;
            long j2 = m2Var2.f3665e - a;
            if (j2 > 0) {
                m2Var2.f3667g = m2Var2.a.schedule(new c(null), j2, timeUnit);
                return;
            }
            m2Var2.f3666f = false;
            m2Var2.f3667g = null;
            m2Var2.c.run();
        }
    }

    public final class c implements Runnable {
        public c(a aVar) {
        }

        public void run() {
            m2 m2Var = m2.this;
            m2Var.b.execute(new b(null));
        }
    }

    public m2(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, s sVar) {
        this.c = runnable;
        this.b = executor;
        this.a = scheduledExecutorService;
        this.f3664d = sVar;
        sVar.c();
    }
}
