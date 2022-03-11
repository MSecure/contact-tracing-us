package f.b.c.k.w;

import f.b.a.c.i.h;
import f.b.c.k.w.n0;
import f.b.c.k.x.c;
import f.b.c.k.x.k;
import f.b.c.k.x.l;
import f.b.c.k.x.m;
import h.a.c1;
import h.a.f;
import h.a.o0;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;

public abstract class b<ReqT, RespT, CallbackT extends n0> {

    /* renamed from: l  reason: collision with root package name */
    public static final long f3224l;
    public static final long m;
    public static final long n;
    public static final long o;
    public c.b a;
    public final t b;
    public final o0<ReqT, RespT> c;

    /* renamed from: d  reason: collision with root package name */
    public final b<ReqT, RespT, CallbackT>.RunnableC0120b f3225d;

    /* renamed from: e  reason: collision with root package name */
    public final f.b.c.k.x.c f3226e;

    /* renamed from: f  reason: collision with root package name */
    public final c.d f3227f;

    /* renamed from: g  reason: collision with root package name */
    public m0 f3228g = m0.Initial;

    /* renamed from: h  reason: collision with root package name */
    public long f3229h = 0;

    /* renamed from: i  reason: collision with root package name */
    public f<ReqT, RespT> f3230i;

    /* renamed from: j  reason: collision with root package name */
    public final l f3231j;

    /* renamed from: k  reason: collision with root package name */
    public final CallbackT f3232k;

    public class a {
        public final long a;

        public a(long j2) {
            this.a = j2;
        }

        public void a(Runnable runnable) {
            b.this.f3226e.d();
            b bVar = b.this;
            if (bVar.f3229h == this.a) {
                runnable.run();
                return;
            }
            m.a(m.a.DEBUG, bVar.getClass().getSimpleName(), "stream callback skipped by CloseGuardedRunner.", new Object[0]);
        }
    }

    /* renamed from: f.b.c.k.w.b$b  reason: collision with other inner class name */
    public class RunnableC0120b implements Runnable {
        public RunnableC0120b() {
        }

        public void run() {
            b bVar = b.this;
            if (bVar.c()) {
                bVar.a(m0.Initial, c1.f3613f);
            }
        }
    }

    public class c implements d0<RespT> {
        public final b<ReqT, RespT, CallbackT>.a a;

        public c(b<ReqT, RespT, CallbackT>.a aVar) {
            this.a = aVar;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f3224l = timeUnit.toMillis(1);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        m = timeUnit2.toMillis(1);
        n = timeUnit2.toMillis(1);
        o = timeUnit.toMillis(10);
    }

    public b(t tVar, o0<ReqT, RespT> o0Var, f.b.c.k.x.c cVar, c.d dVar, c.d dVar2, CallbackT callbackt) {
        this.b = tVar;
        this.c = o0Var;
        this.f3226e = cVar;
        this.f3227f = dVar2;
        this.f3232k = callbackt;
        this.f3225d = new RunnableC0120b();
        this.f3231j = new l(cVar, dVar, f3224l, 1.5d, m);
    }

    public final void a(m0 m0Var, c1 c1Var) {
        m.a aVar = m.a.DEBUG;
        f.b.a.c.b.o.b.b1(d(), "Only started streams should be closed.", new Object[0]);
        m0 m0Var2 = m0.Error;
        f.b.a.c.b.o.b.b1(m0Var == m0Var2 || c1Var.equals(c1.f3613f), "Can't provide an error when not in an error state.", new Object[0]);
        this.f3226e.d();
        Set<String> set = j.f3243d;
        c1.b bVar = c1Var.a;
        Throwable th = c1Var.c;
        if (th instanceof SSLHandshakeException) {
            th.getMessage().contains("no ciphers available");
        }
        c.b bVar2 = this.a;
        if (bVar2 != null) {
            bVar2.a();
            this.a = null;
        }
        l lVar = this.f3231j;
        c.b bVar3 = lVar.f3290h;
        if (bVar3 != null) {
            bVar3.a();
            lVar.f3290h = null;
        }
        this.f3229h++;
        c1.b bVar4 = c1Var.a;
        if (bVar4 == c1.b.OK) {
            this.f3231j.f3288f = 0;
        } else if (bVar4 == c1.b.RESOURCE_EXHAUSTED) {
            m.a(aVar, getClass().getSimpleName(), "(%x) Using maximum backoff delay to prevent overloading the backend.", Integer.valueOf(System.identityHashCode(this)));
            l lVar2 = this.f3231j;
            lVar2.f3288f = lVar2.f3287e;
        } else if (bVar4 == c1.b.UNAUTHENTICATED) {
            this.b.b.b();
        } else if (bVar4 == c1.b.UNAVAILABLE) {
            Throwable th2 = c1Var.c;
            if ((th2 instanceof UnknownHostException) || (th2 instanceof ConnectException)) {
                this.f3231j.f3287e = o;
            }
        }
        if (m0Var != m0Var2) {
            m.a(aVar, getClass().getSimpleName(), "(%x) Performing stream teardown", Integer.valueOf(System.identityHashCode(this)));
            h();
        }
        if (this.f3230i != null) {
            if (c1Var.e()) {
                m.a(aVar, getClass().getSimpleName(), "(%x) Closing stream client-side", Integer.valueOf(System.identityHashCode(this)));
                this.f3230i.a();
            }
            this.f3230i = null;
        }
        this.f3228g = m0Var;
        this.f3232k.e(c1Var);
    }

    public void b() {
        f.b.a.c.b.o.b.b1(!d(), "Can only inhibit backoff after in a stopped state", new Object[0]);
        this.f3226e.d();
        this.f3228g = m0.Initial;
        this.f3231j.f3288f = 0;
    }

    public boolean c() {
        this.f3226e.d();
        return this.f3228g == m0.Open;
    }

    public boolean d() {
        this.f3226e.d();
        m0 m0Var = this.f3228g;
        return m0Var == m0.Starting || m0Var == m0.Open || m0Var == m0.Backoff;
    }

    public void e() {
        if (c() && this.a == null) {
            this.a = this.f3226e.a(this.f3227f, n, this.f3225d);
        }
    }

    public abstract void f(RespT respt);

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c8, code lost:
        if (r1 > r3) goto L_0x00ca;
     */
    public void g() {
        this.f3226e.d();
        f.b.a.c.b.o.b.b1(this.f3230i == null, "Last call still set", new Object[0]);
        f.b.a.c.b.o.b.b1(this.a == null, "Idle timer still set", new Object[0]);
        m0 m0Var = this.f3228g;
        m0 m0Var2 = m0.Error;
        if (m0Var == m0Var2) {
            f.b.a.c.b.o.b.b1(m0Var == m0Var2, "Should only perform backoff in an error state", new Object[0]);
            this.f3228g = m0.Backoff;
            l lVar = this.f3231j;
            a aVar = new a(this);
            c.b bVar = lVar.f3290h;
            if (bVar != null) {
                bVar.a();
                lVar.f3290h = null;
            }
            long random = lVar.f3288f + ((long) ((Math.random() - 0.5d) * ((double) lVar.f3288f)));
            long max = Math.max(0L, new Date().getTime() - lVar.f3289g);
            long max2 = Math.max(0L, random - max);
            if (lVar.f3288f > 0) {
                m.a(m.a.DEBUG, l.class.getSimpleName(), "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)", Long.valueOf(max2), Long.valueOf(lVar.f3288f), Long.valueOf(random), Long.valueOf(max));
            }
            lVar.f3290h = lVar.a.a(lVar.b, max2, new k(lVar, aVar));
            long j2 = (long) (((double) lVar.f3288f) * 1.5d);
            lVar.f3288f = j2;
            long j3 = lVar.c;
            if (j2 >= j3) {
                j3 = lVar.f3287e;
            }
            lVar.f3288f = j3;
            lVar.f3287e = lVar.f3286d;
            return;
        }
        f.b.a.c.b.o.b.b1(m0Var == m0.Initial, "Already started", new Object[0]);
        c cVar = new c(new a(this.f3229h));
        t tVar = this.b;
        o0<ReqT, RespT> o0Var = this.c;
        Objects.requireNonNull(tVar);
        f[] fVarArr = {null};
        b0 b0Var = tVar.c;
        h<TContinuationResult> i2 = b0Var.a.i(b0Var.b.a, new u(b0Var, o0Var));
        i2.c(tVar.a.a, new p(tVar, fVarArr, cVar));
        this.f3230i = new s(tVar, fVarArr, i2);
        this.f3228g = m0.Starting;
    }

    public void h() {
    }

    public void i(ReqT reqt) {
        this.f3226e.d();
        m.a(m.a.DEBUG, getClass().getSimpleName(), "(%x) Stream sending: %s", Integer.valueOf(System.identityHashCode(this)), reqt);
        c.b bVar = this.a;
        if (bVar != null) {
            bVar.a();
            this.a = null;
        }
        this.f3230i.c(reqt);
    }
}
