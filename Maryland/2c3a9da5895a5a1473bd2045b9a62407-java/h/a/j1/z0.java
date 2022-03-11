package h.a.j1;

import f.b.b.a.k;
import f.b.b.a.s;
import f.b.b.a.u;
import h.a.a0;
import h.a.c0;
import h.a.c1;
import h.a.d0;
import h.a.e;
import h.a.g1;
import h.a.j1.h0;
import h.a.j1.j;
import h.a.j1.v;
import h.a.j1.x;
import h.a.j1.y1;
import h.a.n;
import h.a.n0;
import h.a.o;
import h.a.o0;
import h.a.v;
import h.a.z;
import java.net.SocketAddress;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class z0 implements c0<Object>, b3 {
    public final d0 a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final j.a f3880d;

    /* renamed from: e  reason: collision with root package name */
    public final e f3881e;

    /* renamed from: f  reason: collision with root package name */
    public final x f3882f;

    /* renamed from: g  reason: collision with root package name */
    public final ScheduledExecutorService f3883g;

    /* renamed from: h  reason: collision with root package name */
    public final a0 f3884h;

    /* renamed from: i  reason: collision with root package name */
    public final m f3885i;

    /* renamed from: j  reason: collision with root package name */
    public final h.a.e f3886j;

    /* renamed from: k  reason: collision with root package name */
    public final g1 f3887k;

    /* renamed from: l  reason: collision with root package name */
    public final f f3888l;
    public volatile List<v> m;
    public j n;
    public final s o;
    public g1.c p;
    public final Collection<z> q = new ArrayList();
    public final x0<z> r = new a();
    public z s;
    public volatile y1 t;
    public volatile o u = o.a(n.IDLE);
    public c1 v;

    public class a extends x0<z> {
        public a() {
        }

        @Override // h.a.j1.x0
        public void a() {
            z0 z0Var = z0.this;
            m1.this.X.c(z0Var, true);
        }

        @Override // h.a.j1.x0
        public void b() {
            z0 z0Var = z0.this;
            m1.this.X.c(z0Var, false);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            if (z0.this.u.a == n.IDLE) {
                z0.this.f3886j.a(e.a.INFO, "CONNECTING as requested");
                z0.h(z0.this, n.CONNECTING);
                z0.i(z0.this);
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ c1 b;

        public c(c1 c1Var) {
            this.b = c1Var;
        }

        public void run() {
            n nVar = z0.this.u.a;
            n nVar2 = n.SHUTDOWN;
            if (nVar != nVar2) {
                z0 z0Var = z0.this;
                z0Var.v = this.b;
                y1 y1Var = z0Var.t;
                z0 z0Var2 = z0.this;
                z zVar = z0Var2.s;
                z0Var2.t = null;
                z0 z0Var3 = z0.this;
                z0Var3.s = null;
                z0Var3.f3887k.d();
                z0Var3.j(o.a(nVar2));
                z0.this.f3888l.b();
                if (z0.this.q.isEmpty()) {
                    z0 z0Var4 = z0.this;
                    g1 g1Var = z0Var4.f3887k;
                    d1 d1Var = new d1(z0Var4);
                    Queue<Runnable> queue = g1Var.c;
                    f.b.a.c.b.o.b.A(d1Var, "runnable is null");
                    queue.add(d1Var);
                    g1Var.a();
                }
                z0 z0Var5 = z0.this;
                z0Var5.f3887k.d();
                g1.c cVar = z0Var5.p;
                if (cVar != null) {
                    cVar.a();
                    z0Var5.p = null;
                    z0Var5.n = null;
                }
                if (y1Var != null) {
                    y1Var.d(this.b);
                }
                if (zVar != null) {
                    zVar.d(this.b);
                }
            }
        }
    }

    public static final class d extends m0 {
        public final z a;
        public final m b;

        public class a extends k0 {
            public final /* synthetic */ u a;

            /* renamed from: h.a.j1.z0$d$a$a  reason: collision with other inner class name */
            public class C0148a extends l0 {
                public final /* synthetic */ v a;

                public C0148a(v vVar) {
                    this.a = vVar;
                }

                @Override // h.a.j1.v
                public void b(c1 c1Var, n0 n0Var) {
                    d.this.b.a(c1Var.e());
                    this.a.b(c1Var, n0Var);
                }

                @Override // h.a.j1.v
                public void d(c1 c1Var, v.a aVar, n0 n0Var) {
                    d.this.b.a(c1Var.e());
                    this.a.d(c1Var, aVar, n0Var);
                }
            }

            public a(u uVar) {
                this.a = uVar;
            }

            @Override // h.a.j1.u
            public void i(v vVar) {
                m mVar = d.this.b;
                mVar.b.a(1);
                mVar.a.a();
                this.a.i(new C0148a(vVar));
            }
        }

        public d(z zVar, m mVar, a aVar) {
            this.a = zVar;
            this.b = mVar;
        }

        @Override // h.a.j1.m0
        public z b() {
            return this.a;
        }

        @Override // h.a.j1.w
        public u g(o0<?, ?> o0Var, n0 n0Var, h.a.c cVar) {
            return new a(b().g(o0Var, n0Var, cVar));
        }
    }

    public static abstract class e {
    }

    public static final class f {
        public List<h.a.v> a;
        public int b;
        public int c;

        public f(List<h.a.v> list) {
            this.a = list;
        }

        public SocketAddress a() {
            return this.a.get(this.b).a.get(this.c);
        }

        public void b() {
            this.b = 0;
            this.c = 0;
        }
    }

    public class g implements y1.a {
        public final z a;
        public boolean b = false;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                g gVar = g.this;
                z0 z0Var = z0.this;
                z0Var.n = null;
                if (z0Var.v != null) {
                    f.b.a.c.b.o.b.G(z0Var.t == null, "Unexpected non-null activeTransport");
                    g gVar2 = g.this;
                    gVar2.a.d(z0.this.v);
                    return;
                }
                z zVar = z0Var.s;
                z zVar2 = gVar.a;
                if (zVar == zVar2) {
                    z0Var.t = zVar2;
                    z0 z0Var2 = z0.this;
                    z0Var2.s = null;
                    n nVar = n.READY;
                    z0Var2.f3887k.d();
                    z0Var2.j(o.a(nVar));
                }
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ c1 b;

            public b(c1 c1Var) {
                this.b = c1Var;
            }

            public void run() {
                if (z0.this.u.a != n.SHUTDOWN) {
                    y1 y1Var = z0.this.t;
                    g gVar = g.this;
                    z zVar = gVar.a;
                    if (y1Var == zVar) {
                        z0.this.t = null;
                        z0.this.f3888l.b();
                        z0.h(z0.this, n.IDLE);
                        return;
                    }
                    z0 z0Var = z0.this;
                    if (z0Var.s == zVar) {
                        boolean z = true;
                        f.b.a.c.b.o.b.H(z0Var.u.a == n.CONNECTING, "Expected state is CONNECTING, actual state is %s", z0.this.u.a);
                        f fVar = z0.this.f3888l;
                        int i2 = fVar.c + 1;
                        fVar.c = i2;
                        if (i2 >= fVar.a.get(fVar.b).a.size()) {
                            fVar.b++;
                            fVar.c = 0;
                        }
                        f fVar2 = z0.this.f3888l;
                        if (!(fVar2.b < fVar2.a.size())) {
                            z0 z0Var2 = z0.this;
                            z0Var2.s = null;
                            z0Var2.f3888l.b();
                            z0 z0Var3 = z0.this;
                            c1 c1Var = this.b;
                            z0Var3.f3887k.d();
                            f.b.a.c.b.o.b.o(!c1Var.e(), "The error status must not be OK");
                            z0Var3.j(new o(n.TRANSIENT_FAILURE, c1Var));
                            if (z0Var3.n == null) {
                                Objects.requireNonNull((h0.a) z0Var3.f3880d);
                                z0Var3.n = new h0();
                            }
                            long a = ((h0) z0Var3.n).a();
                            s sVar = z0Var3.o;
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            long a2 = a - sVar.a(timeUnit);
                            z0Var3.f3886j.b(e.a.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", z0Var3.k(c1Var), Long.valueOf(a2));
                            if (z0Var3.p != null) {
                                z = false;
                            }
                            f.b.a.c.b.o.b.G(z, "previous reconnectTask is not done");
                            z0Var3.p = z0Var3.f3887k.c(new a1(z0Var3), a2, timeUnit, z0Var3.f3883g);
                            return;
                        }
                        z0.i(z0.this);
                    }
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            public void run() {
                g gVar = g.this;
                z0.this.q.remove(gVar.a);
                if (z0.this.u.a == n.SHUTDOWN && z0.this.q.isEmpty()) {
                    z0 z0Var = z0.this;
                    g1 g1Var = z0Var.f3887k;
                    d1 d1Var = new d1(z0Var);
                    Queue<Runnable> queue = g1Var.c;
                    f.b.a.c.b.o.b.A(d1Var, "runnable is null");
                    queue.add(d1Var);
                    g1Var.a();
                }
            }
        }

        public g(z zVar, SocketAddress socketAddress) {
            this.a = zVar;
        }

        @Override // h.a.j1.y1.a
        public void a() {
            f.b.a.c.b.o.b.G(this.b, "transportShutdown() must be called before transportTerminated().");
            z0.this.f3886j.b(e.a.INFO, "{0} Terminated", this.a.c());
            a0 a0Var = z0.this.f3884h;
            a0.b(a0Var.c, this.a);
            z0 z0Var = z0.this;
            z zVar = this.a;
            g1 g1Var = z0Var.f3887k;
            e1 e1Var = new e1(z0Var, zVar, false);
            Queue<Runnable> queue = g1Var.c;
            f.b.a.c.b.o.b.A(e1Var, "runnable is null");
            queue.add(e1Var);
            g1Var.a();
            g1 g1Var2 = z0.this.f3887k;
            c cVar = new c();
            Queue<Runnable> queue2 = g1Var2.c;
            f.b.a.c.b.o.b.A(cVar, "runnable is null");
            queue2.add(cVar);
            g1Var2.a();
        }

        @Override // h.a.j1.y1.a
        public void b() {
            z0.this.f3886j.a(e.a.INFO, "READY");
            g1 g1Var = z0.this.f3887k;
            a aVar = new a();
            Queue<Runnable> queue = g1Var.c;
            f.b.a.c.b.o.b.A(aVar, "runnable is null");
            queue.add(aVar);
            g1Var.a();
        }

        @Override // h.a.j1.y1.a
        public void c(boolean z) {
            z0 z0Var = z0.this;
            z zVar = this.a;
            g1 g1Var = z0Var.f3887k;
            e1 e1Var = new e1(z0Var, zVar, z);
            Queue<Runnable> queue = g1Var.c;
            f.b.a.c.b.o.b.A(e1Var, "runnable is null");
            queue.add(e1Var);
            g1Var.a();
        }

        @Override // h.a.j1.y1.a
        public void d(c1 c1Var) {
            z0.this.f3886j.b(e.a.INFO, "{0} SHUTDOWN with {1}", this.a.c(), z0.this.k(c1Var));
            this.b = true;
            g1 g1Var = z0.this.f3887k;
            b bVar = new b(c1Var);
            Queue<Runnable> queue = g1Var.c;
            f.b.a.c.b.o.b.A(bVar, "runnable is null");
            queue.add(bVar);
            g1Var.a();
        }
    }

    public static final class h extends h.a.e {
        public d0 a;

        @Override // h.a.e
        public void a(e.a aVar, String str) {
            d0 d0Var = this.a;
            Level d2 = n.d(aVar);
            if (o.f3792e.isLoggable(d2)) {
                o.a(d0Var, d2, str);
            }
        }

        @Override // h.a.e
        public void b(e.a aVar, String str, Object... objArr) {
            d0 d0Var = this.a;
            Level d2 = n.d(aVar);
            if (o.f3792e.isLoggable(d2)) {
                o.a(d0Var, d2, MessageFormat.format(str, objArr));
            }
        }
    }

    public z0(List<h.a.v> list, String str, String str2, j.a aVar, x xVar, ScheduledExecutorService scheduledExecutorService, u<s> uVar, g1 g1Var, e eVar, a0 a0Var, m mVar, o oVar, d0 d0Var, h.a.e eVar2) {
        f.b.a.c.b.o.b.A(list, "addressGroups");
        f.b.a.c.b.o.b.o(!list.isEmpty(), "addressGroups is empty");
        for (h.a.v vVar : list) {
            f.b.a.c.b.o.b.A(vVar, "addressGroups contains null entry");
        }
        List<h.a.v> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.m = unmodifiableList;
        this.f3888l = new f(unmodifiableList);
        this.b = str;
        this.c = str2;
        this.f3880d = aVar;
        this.f3882f = xVar;
        this.f3883g = scheduledExecutorService;
        this.o = uVar.get();
        this.f3887k = g1Var;
        this.f3881e = eVar;
        this.f3884h = a0Var;
        this.f3885i = mVar;
        f.b.a.c.b.o.b.A(oVar, "channelTracer");
        f.b.a.c.b.o.b.A(d0Var, "logId");
        this.a = d0Var;
        f.b.a.c.b.o.b.A(eVar2, "channelLogger");
        this.f3886j = eVar2;
    }

    public static void h(z0 z0Var, n nVar) {
        z0Var.f3887k.d();
        z0Var.j(o.a(nVar));
    }

    public static void i(z0 z0Var) {
        SocketAddress socketAddress;
        z zVar;
        z0Var.f3887k.d();
        f.b.a.c.b.o.b.G(z0Var.p == null, "Should have no reconnectTask scheduled");
        f fVar = z0Var.f3888l;
        if (fVar.b == 0 && fVar.c == 0) {
            s sVar = z0Var.o;
            sVar.b();
            sVar.c();
        }
        SocketAddress a2 = z0Var.f3888l.a();
        if (a2 instanceof z) {
            zVar = (z) a2;
            socketAddress = zVar.c;
        } else {
            socketAddress = a2;
            zVar = null;
        }
        f fVar2 = z0Var.f3888l;
        h.a.a aVar = fVar2.a.get(fVar2.b).b;
        String str = (String) aVar.a.get(h.a.v.f4086d);
        x.a aVar2 = new x.a();
        if (str == null) {
            str = z0Var.b;
        }
        f.b.a.c.b.o.b.A(str, "authority");
        aVar2.a = str;
        f.b.a.c.b.o.b.A(aVar, "eagAttributes");
        aVar2.b = aVar;
        aVar2.c = z0Var.c;
        aVar2.f3873d = zVar;
        h hVar = new h();
        hVar.a = z0Var.a;
        d dVar = new d(z0Var.f3882f.f(socketAddress, aVar2, hVar), z0Var.f3885i, null);
        hVar.a = dVar.c();
        a0.a(z0Var.f3884h.c, dVar);
        z0Var.s = dVar;
        z0Var.q.add(dVar);
        Runnable e2 = dVar.b().e(new g(dVar, socketAddress));
        if (e2 != null) {
            Queue<Runnable> queue = z0Var.f3887k.c;
            f.b.a.c.b.o.b.A(e2, "runnable is null");
            queue.add(e2);
        }
        z0Var.f3886j.b(e.a.INFO, "Started transport {0}", hVar.a);
    }

    @Override // h.a.j1.b3
    public w b() {
        y1 y1Var = this.t;
        if (y1Var != null) {
            return y1Var;
        }
        g1 g1Var = this.f3887k;
        b bVar = new b();
        Queue<Runnable> queue = g1Var.c;
        f.b.a.c.b.o.b.A(bVar, "runnable is null");
        queue.add(bVar);
        g1Var.a();
        return null;
    }

    @Override // h.a.c0
    public d0 c() {
        return this.a;
    }

    public void d(c1 c1Var) {
        g1 g1Var = this.f3887k;
        c cVar = new c(c1Var);
        Queue<Runnable> queue = g1Var.c;
        f.b.a.c.b.o.b.A(cVar, "runnable is null");
        queue.add(cVar);
        g1Var.a();
    }

    public final void j(o oVar) {
        this.f3887k.d();
        if (this.u.a != oVar.a) {
            boolean z = false;
            boolean z2 = this.u.a != n.SHUTDOWN;
            f.b.a.c.b.o.b.G(z2, "Cannot transition out of SHUTDOWN to " + oVar);
            this.u = oVar;
            t1 t1Var = (t1) this.f3881e;
            m1 m1Var = m1.this;
            Logger logger = m1.c0;
            Objects.requireNonNull(m1Var);
            n nVar = oVar.a;
            if (nVar == n.TRANSIENT_FAILURE || nVar == n.IDLE) {
                m1Var.u();
            }
            if (t1Var.a != null) {
                z = true;
            }
            f.b.a.c.b.o.b.G(z, "listener is null");
            t1Var.a.a(oVar);
        }
    }

    public final String k(c1 c1Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(c1Var.a);
        if (c1Var.b != null) {
            sb.append("(");
            sb.append(c1Var.b);
            sb.append(")");
        }
        return sb.toString();
    }

    public String toString() {
        k T1 = f.b.a.c.b.o.b.T1(this);
        T1.b("logId", this.a.c);
        T1.d("addressGroups", this.m);
        return T1.toString();
    }
}
