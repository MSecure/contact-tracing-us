package h.a.j1;

import f.b.b.a.s;
import f.b.b.f.a.k;
import h.a.c1;
import h.a.j1.w;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class j1 {

    /* renamed from: l  reason: collision with root package name */
    public static final long f3625l = TimeUnit.SECONDS.toNanos(10);
    public final ScheduledExecutorService a;
    public final s b;
    public final d c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3626d;

    /* renamed from: e  reason: collision with root package name */
    public e f3627e = e.IDLE;

    /* renamed from: f  reason: collision with root package name */
    public ScheduledFuture<?> f3628f;

    /* renamed from: g  reason: collision with root package name */
    public ScheduledFuture<?> f3629g;

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f3630h = new k1(new a());

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f3631i = new k1(new b());

    /* renamed from: j  reason: collision with root package name */
    public final long f3632j;

    /* renamed from: k  reason: collision with root package name */
    public final long f3633k;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            j1 j1Var;
            boolean z;
            synchronized (j1.this) {
                j1Var = j1.this;
                e eVar = j1Var.f3627e;
                e eVar2 = e.DISCONNECTED;
                if (eVar != eVar2) {
                    j1Var.f3627e = eVar2;
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                j1Var.c.a();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            boolean z;
            synchronized (j1.this) {
                j1 j1Var = j1.this;
                j1Var.f3629g = null;
                e eVar = j1Var.f3627e;
                e eVar2 = e.PING_SCHEDULED;
                if (eVar == eVar2) {
                    z = true;
                    j1Var.f3627e = e.PING_SENT;
                    j1Var.f3628f = j1Var.a.schedule(j1Var.f3630h, j1Var.f3633k, TimeUnit.NANOSECONDS);
                } else {
                    if (eVar == e.PING_DELAYED) {
                        ScheduledExecutorService scheduledExecutorService = j1Var.a;
                        Runnable runnable = j1Var.f3631i;
                        long j2 = j1Var.f3632j;
                        s sVar = j1Var.b;
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        j1Var.f3629g = scheduledExecutorService.schedule(runnable, j2 - sVar.a(timeUnit), timeUnit);
                        j1.this.f3627e = eVar2;
                    }
                    z = false;
                }
            }
            if (z) {
                j1.this.c.b();
            }
        }
    }

    public static final class c implements d {
        public final z a;

        public class a implements w.a {
            public a() {
            }

            @Override // h.a.j1.w.a
            public void a(Throwable th) {
                c.this.a.a(c1.n.g("Keepalive failed. The connection is likely gone"));
            }

            @Override // h.a.j1.w.a
            public void b(long j2) {
            }
        }

        public c(z zVar) {
            this.a = zVar;
        }

        @Override // h.a.j1.j1.d
        public void a() {
            this.a.a(c1.n.g("Keepalive failed. The connection is likely gone"));
        }

        @Override // h.a.j1.j1.d
        public void b() {
            this.a.f(new a(), k.INSTANCE);
        }
    }

    public interface d {
        void a();

        void b();
    }

    public enum e {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    static {
        TimeUnit.MILLISECONDS.toNanos(10);
    }

    public j1(d dVar, ScheduledExecutorService scheduledExecutorService, long j2, long j3, boolean z) {
        s sVar = new s();
        f.b.a.c.b.o.b.A(dVar, "keepAlivePinger");
        this.c = dVar;
        f.b.a.c.b.o.b.A(scheduledExecutorService, "scheduler");
        this.a = scheduledExecutorService;
        f.b.a.c.b.o.b.A(sVar, "stopwatch");
        this.b = sVar;
        this.f3632j = j2;
        this.f3633k = j3;
        this.f3626d = z;
        sVar.b();
        sVar.c();
    }

    public synchronized void a() {
        e eVar = e.IDLE_AND_PING_SENT;
        synchronized (this) {
            s sVar = this.b;
            sVar.b();
            sVar.c();
            e eVar2 = this.f3627e;
            e eVar3 = e.PING_SCHEDULED;
            if (eVar2 == eVar3) {
                this.f3627e = e.PING_DELAYED;
            } else if (eVar2 == e.PING_SENT || eVar2 == eVar) {
                ScheduledFuture<?> scheduledFuture = this.f3628f;
                boolean z = false;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                if (this.f3627e == eVar) {
                    this.f3627e = e.IDLE;
                    return;
                }
                this.f3627e = eVar3;
                if (this.f3629g == null) {
                    z = true;
                }
                f.b.a.c.b.o.b.G(z, "There should be no outstanding pingFuture");
                this.f3629g = this.a.schedule(this.f3631i, this.f3632j, TimeUnit.NANOSECONDS);
            }
        }
    }

    public synchronized void b() {
        e eVar = this.f3627e;
        if (eVar == e.IDLE) {
            this.f3627e = e.PING_SCHEDULED;
            if (this.f3629g == null) {
                ScheduledExecutorService scheduledExecutorService = this.a;
                Runnable runnable = this.f3631i;
                long j2 = this.f3632j;
                s sVar = this.b;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                this.f3629g = scheduledExecutorService.schedule(runnable, j2 - sVar.a(timeUnit), timeUnit);
            }
        } else if (eVar == e.IDLE_AND_PING_SENT) {
            this.f3627e = e.PING_SENT;
        }
    }
}
