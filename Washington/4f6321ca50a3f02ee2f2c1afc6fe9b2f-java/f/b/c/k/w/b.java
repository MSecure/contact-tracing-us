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
    public static final long f3128l;
    public static final long m;
    public static final long n;
    public static final long o;
    public c.b a;
    public final t b;
    public final o0<ReqT, RespT> c;

    /* renamed from: d  reason: collision with root package name */
    public final b<ReqT, RespT, CallbackT>.RunnableC0116b f3129d;

    /* renamed from: e  reason: collision with root package name */
    public final f.b.c.k.x.c f3130e;

    /* renamed from: f  reason: collision with root package name */
    public final c.d f3131f;

    /* renamed from: g  reason: collision with root package name */
    public m0 f3132g = m0.Initial;

    /* renamed from: h  reason: collision with root package name */
    public long f3133h = 0;

    /* renamed from: i  reason: collision with root package name */
    public f<ReqT, RespT> f3134i;

    /* renamed from: j  reason: collision with root package name */
    public final l f3135j;

    /* renamed from: k  reason: collision with root package name */
    public final CallbackT f3136k;

    public class a {
        public final long a;

        public a(long j2) {
            this.a = j2;
        }

        public void a(Runnable runnable) {
            b.this.f3130e.d();
            b bVar = b.this;
            if (bVar.f3133h == this.a) {
                runnable.run();
                return;
            }
            m.a(m.a.DEBUG, bVar.getClass().getSimpleName(), "stream callback skipped by CloseGuardedRunner.", new Object[0]);
        }
    }

    /* renamed from: f.b.c.k.w.b$b  reason: collision with other inner class name */
    public class RunnableC0116b implements Runnable {
        public RunnableC0116b() {
        }

        public void run() {
            b bVar = b.this;
            if (bVar.c()) {
                bVar.a(m0.Initial, c1.f3517f);
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
        f3128l = timeUnit.toMillis(1);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        m = timeUnit2.toMillis(1);
        n = timeUnit2.toMillis(1);
        o = timeUnit.toMillis(10);
    }

    public b(t tVar, o0<ReqT, RespT> o0Var, f.b.c.k.x.c cVar, c.d dVar, c.d dVar2, CallbackT callbackt) {
        this.b = tVar;
        this.c = o0Var;
        this.f3130e = cVar;
        this.f3131f = dVar2;
        this.f3136k = callbackt;
        this.f3129d = new RunnableC0116b();
        this.f3135j = new l(cVar, dVar, f3128l, 1.5d, m);
    }

    public final void a(m0 m0Var, c1 c1Var) {
        m.a aVar = m.a.DEBUG;
        f.b.a.c.b.o.b.a1(d(), "Only started streams should be closed.", new Object[0]);
        m0 m0Var2 = m0.Error;
        f.b.a.c.b.o.b.a1(m0Var == m0Var2 || c1Var.equals(c1.f3517f), "Can't provide an error when not in an error state.", new Object[0]);
        this.f3130e.d();
        Set<String> set = j.f3147d;
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
        l lVar = this.f3135j;
        c.b bVar3 = lVar.f3194h;
        if (bVar3 != null) {
            bVar3.a();
            lVar.f3194h = null;
        }
        this.f3133h++;
        c1.b bVar4 = c1Var.a;
        if (bVar4 == c1.b.OK) {
            this.f3135j.f3192f = 0;
        } else if (bVar4 == c1.b.RESOURCE_EXHAUSTED) {
            m.a(aVar, getClass().getSimpleName(), "(%x) Using maximum backoff delay to prevent overloading the backend.", Integer.valueOf(System.identityHashCode(this)));
            l lVar2 = this.f3135j;
            lVar2.f3192f = lVar2.f3191e;
        } else if (bVar4 == c1.b.UNAUTHENTICATED) {
            this.b.b.b();
        } else if (bVar4 == c1.b.UNAVAILABLE) {
            Throwable th2 = c1Var.c;
            if ((th2 instanceof UnknownHostException) || (th2 instanceof ConnectException)) {
                this.f3135j.f3191e = o;
            }
        }
        if (m0Var != m0Var2) {
            m.a(aVar, getClass().getSimpleName(), "(%x) Performing stream teardown", Integer.valueOf(System.identityHashCode(this)));
            h();
        }
        if (this.f3134i != null) {
            if (c1Var.e()) {
                m.a(aVar, getClass().getSimpleName(), "(%x) Closing stream client-side", Integer.valueOf(System.identityHashCode(this)));
                this.f3134i.a();
            }
            this.f3134i = null;
        }
        this.f3132g = m0Var;
        this.f3136k.e(c1Var);
    }

    public void b() {
        f.b.a.c.b.o.b.a1(!d(), "Can only inhibit backoff after in a stopped state", new Object[0]);
        this.f3130e.d();
        this.f3132g = m0.Initial;
        this.f3135j.f3192f = 0;
    }

    public boolean c() {
        this.f3130e.d();
        return this.f3132g == m0.Open;
    }

    public boolean d() {
        this.f3130e.d();
        m0 m0Var = this.f3132g;
        return m0Var == m0.Starting || m0Var == m0.Open || m0Var == m0.Backoff;
    }

    public void e() {
        if (c() && this.a == null) {
            this.a = this.f3130e.a(this.f3131f, n, this.f3129d);
        }
    }

    public abstract void f(RespT respt);

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c8, code lost:
        if (r1 > r3) goto L_0x00ca;
     */
    public void g() {
        this.f3130e.d();
        f.b.a.c.b.o.b.a1(this.f3134i == null, "Last call still set", new Object[0]);
        f.b.a.c.b.o.b.a1(this.a == null, "Idle timer still set", new Object[0]);
        m0 m0Var = this.f3132g;
        m0 m0Var2 = m0.Error;
        if (m0Var == m0Var2) {
            f.b.a.c.b.o.b.a1(m0Var == m0Var2, "Should only perform backoff in an error state", new Object[0]);
            this.f3132g = m0.Backoff;
            l lVar = this.f3135j;
            a aVar = new a(this);
            c.b bVar = lVar.f3194h;
            if (bVar != null) {
                bVar.a();
                lVar.f3194h = null;
            }
            long random = lVar.f3192f + ((long) ((Math.random() - 0.5d) * ((double) lVar.f3192f)));
            long max = Math.max(0L, new Date().getTime() - lVar.f3193g);
            long max2 = Math.max(0L, random - max);
            if (lVar.f3192f > 0) {
                m.a(m.a.DEBUG, l.class.getSimpleName(), "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)", Long.valueOf(max2), Long.valueOf(lVar.f3192f), Long.valueOf(random), Long.valueOf(max));
            }
            lVar.f3194h = lVar.a.a(lVar.b, max2, new k(lVar, aVar));
            long j2 = (long) (((double) lVar.f3192f) * 1.5d);
            lVar.f3192f = j2;
            long j3 = lVar.c;
            if (j2 >= j3) {
                j3 = lVar.f3191e;
            }
            lVar.f3192f = j3;
            lVar.f3191e = lVar.f3190d;
            return;
        }
        f.b.a.c.b.o.b.a1(m0Var == m0.Initial, "Already started", new Object[0]);
        c cVar = new c(new a(this.f3133h));
        t tVar = this.b;
        o0<ReqT, RespT> o0Var = this.c;
        Objects.requireNonNull(tVar);
        f[] fVarArr = {null};
        b0 b0Var = tVar.c;
        h<TContinuationResult> i2 = b0Var.a.i(b0Var.b.a, new u(b0Var, o0Var));
        i2.c(tVar.a.a, new p(tVar, fVarArr, cVar));
        this.f3134i = new s(tVar, fVarArr, i2);
        this.f3132g = m0.Starting;
    }

    public void h() {
    }

    public void i(ReqT reqt) {
        this.f3130e.d();
        m.a(m.a.DEBUG, getClass().getSimpleName(), "(%x) Stream sending: %s", Integer.valueOf(System.identityHashCode(this)), reqt);
        c.b bVar = this.a;
        if (bVar != null) {
            bVar.a();
            this.a = null;
        }
        this.f3134i.c(reqt);
    }
}
