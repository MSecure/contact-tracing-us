package h.a.j1;

import f.b.b.f.a.k;
import h.a.c1;
import h.a.f;
import h.a.j1.m1;
import h.a.j1.v;
import h.a.j1.y2;
import h.a.k;
import h.a.l;
import h.a.m;
import h.a.n0;
import h.a.o0;
import h.a.q;
import h.a.r;
import h.a.t;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class p<ReqT, RespT> extends f<ReqT, RespT> {
    public static final Logger u = Logger.getLogger(p.class.getName());
    public static final byte[] v = "gzip".getBytes(Charset.forName("US-ASCII"));
    public static final long w = TimeUnit.SECONDS.toNanos(1);
    public final o0<ReqT, RespT> a;
    public final h.b.d b;
    public final Executor c;

    /* renamed from: d  reason: collision with root package name */
    public final m f3797d;

    /* renamed from: e  reason: collision with root package name */
    public final q f3798e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3799f;

    /* renamed from: g  reason: collision with root package name */
    public final h.a.c f3800g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f3801h;

    /* renamed from: i  reason: collision with root package name */
    public u f3802i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f3803j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3804k;

    /* renamed from: l  reason: collision with root package name */
    public final c f3805l;
    public p<ReqT, RespT>.d m;
    public final ScheduledExecutorService n;
    public boolean o;
    public t p = t.f4082d;
    public m q = m.b;
    public volatile ScheduledFuture<?> r;
    public volatile ScheduledFuture<?> s;
    public boolean t;

    public class b implements v {
        public final f.a<RespT> a;
        public boolean b;

        public final class a extends b0 {
            public final /* synthetic */ n0 c;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(h.b.b bVar, n0 n0Var) {
                super(p.this.f3798e);
                this.c = n0Var;
            }

            @Override // h.a.j1.b0
            public void a() {
                h.b.d dVar = p.this.b;
                h.b.a aVar = h.b.c.a;
                Objects.requireNonNull(aVar);
                Objects.requireNonNull(aVar);
                try {
                    b();
                    h.b.d dVar2 = p.this.b;
                    Objects.requireNonNull(aVar);
                } catch (Throwable th) {
                    h.b.d dVar3 = p.this.b;
                    Objects.requireNonNull(h.b.c.a);
                    throw th;
                }
            }

            public final void b() {
                b bVar = b.this;
                if (!bVar.b) {
                    try {
                        bVar.a.b(this.c);
                    } catch (Throwable th) {
                        c1 g2 = c1.f3614g.f(th).g("Failed to read headers");
                        p.this.f3802i.g(g2);
                        b.f(b.this, g2, new n0());
                    }
                }
            }
        }

        /* renamed from: h.a.j1.p$b$b  reason: collision with other inner class name */
        public final class C0147b extends b0 {
            public final /* synthetic */ y2.a c;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0147b(h.b.b bVar, y2.a aVar) {
                super(p.this.f3798e);
                this.c = aVar;
            }

            @Override // h.a.j1.b0
            public void a() {
                h.b.d dVar = p.this.b;
                h.b.a aVar = h.b.c.a;
                Objects.requireNonNull(aVar);
                Objects.requireNonNull(aVar);
                try {
                    b();
                    h.b.d dVar2 = p.this.b;
                    Objects.requireNonNull(aVar);
                } catch (Throwable th) {
                    h.b.d dVar3 = p.this.b;
                    Objects.requireNonNull(h.b.c.a);
                    throw th;
                }
            }

            public final void b() {
                if (b.this.b) {
                    y2.a aVar = this.c;
                    Logger logger = q0.a;
                    while (true) {
                        InputStream next = aVar.next();
                        if (next != null) {
                            q0.b(next);
                        } else {
                            return;
                        }
                    }
                } else {
                    while (true) {
                        try {
                            InputStream next2 = this.c.next();
                            if (next2 != null) {
                                try {
                                    b bVar = b.this;
                                    bVar.a.c(p.this.a.f4055e.a(next2));
                                    next2.close();
                                } catch (Throwable th) {
                                    q0.b(next2);
                                    throw th;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            y2.a aVar2 = this.c;
                            Logger logger2 = q0.a;
                            while (true) {
                                InputStream next3 = aVar2.next();
                                if (next3 != null) {
                                    q0.b(next3);
                                } else {
                                    c1 g2 = c1.f3614g.f(th2).g("Failed to read message.");
                                    p.this.f3802i.g(g2);
                                    b.f(b.this, g2, new n0());
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        public final class c extends b0 {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public c(h.b.b bVar) {
                super(p.this.f3798e);
            }

            @Override // h.a.j1.b0
            public void a() {
                h.b.d dVar = p.this.b;
                h.b.a aVar = h.b.c.a;
                Objects.requireNonNull(aVar);
                Objects.requireNonNull(aVar);
                try {
                    b();
                    h.b.d dVar2 = p.this.b;
                    Objects.requireNonNull(aVar);
                } catch (Throwable th) {
                    h.b.d dVar3 = p.this.b;
                    Objects.requireNonNull(h.b.c.a);
                    throw th;
                }
            }

            public final void b() {
                try {
                    b.this.a.d();
                } catch (Throwable th) {
                    c1 g2 = c1.f3614g.f(th).g("Failed to call onReady.");
                    p.this.f3802i.g(g2);
                    b.f(b.this, g2, new n0());
                }
            }
        }

        public b(f.a<RespT> aVar) {
            f.b.a.c.b.o.b.A(aVar, "observer");
            this.a = aVar;
        }

        public static void f(b bVar, c1 c1Var, n0 n0Var) {
            bVar.b = true;
            p.this.f3803j = true;
            try {
                p pVar = p.this;
                f.a<RespT> aVar = bVar.a;
                if (!pVar.t) {
                    pVar.t = true;
                    aVar.a(c1Var, n0Var);
                }
            } finally {
                p.this.g();
                p.this.f3797d.a(c1Var.e());
            }
        }

        @Override // h.a.j1.y2
        public void a(y2.a aVar) {
            h.b.d dVar = p.this.b;
            h.b.a aVar2 = h.b.c.a;
            Objects.requireNonNull(aVar2);
            h.b.c.a();
            try {
                p.this.c.execute(new C0147b(h.b.a.b, aVar));
                h.b.d dVar2 = p.this.b;
                Objects.requireNonNull(aVar2);
            } catch (Throwable th) {
                h.b.d dVar3 = p.this.b;
                Objects.requireNonNull(h.b.c.a);
                throw th;
            }
        }

        @Override // h.a.j1.v
        public void b(c1 c1Var, n0 n0Var) {
            h.b.d dVar = p.this.b;
            h.b.a aVar = h.b.c.a;
            Objects.requireNonNull(aVar);
            try {
                g(c1Var, n0Var);
                h.b.d dVar2 = p.this.b;
                Objects.requireNonNull(aVar);
            } catch (Throwable th) {
                h.b.d dVar3 = p.this.b;
                Objects.requireNonNull(h.b.c.a);
                throw th;
            }
        }

        @Override // h.a.j1.y2
        public void c() {
            o0.c cVar = p.this.a.a;
            Objects.requireNonNull(cVar);
            if (!(cVar == o0.c.UNARY || cVar == o0.c.SERVER_STREAMING)) {
                h.b.d dVar = p.this.b;
                Objects.requireNonNull(h.b.c.a);
                h.b.c.a();
                try {
                    p.this.c.execute(new c(h.b.a.b));
                    h.b.d dVar2 = p.this.b;
                } catch (Throwable th) {
                    h.b.d dVar3 = p.this.b;
                    Objects.requireNonNull(h.b.c.a);
                    throw th;
                }
            }
        }

        @Override // h.a.j1.v
        public void d(c1 c1Var, v.a aVar, n0 n0Var) {
            h.b.d dVar = p.this.b;
            h.b.a aVar2 = h.b.c.a;
            Objects.requireNonNull(aVar2);
            try {
                g(c1Var, n0Var);
                h.b.d dVar2 = p.this.b;
                Objects.requireNonNull(aVar2);
            } catch (Throwable th) {
                h.b.d dVar3 = p.this.b;
                Objects.requireNonNull(h.b.c.a);
                throw th;
            }
        }

        @Override // h.a.j1.v
        public void e(n0 n0Var) {
            h.b.d dVar = p.this.b;
            h.b.a aVar = h.b.c.a;
            Objects.requireNonNull(aVar);
            h.b.c.a();
            try {
                p.this.c.execute(new a(h.b.a.b, n0Var));
                h.b.d dVar2 = p.this.b;
                Objects.requireNonNull(aVar);
            } catch (Throwable th) {
                h.b.d dVar3 = p.this.b;
                Objects.requireNonNull(h.b.c.a);
                throw th;
            }
        }

        public final void g(c1 c1Var, n0 n0Var) {
            r f2 = p.this.f();
            if (c1Var.a == c1.b.CANCELLED && f2 != null && f2.c()) {
                y0 y0Var = new y0();
                p.this.f3802i.k(y0Var);
                c1 c1Var2 = c1.f3616i;
                c1Var = c1Var2.a("ClientCall was cancelled at or after deadline. " + y0Var);
                n0Var = new n0();
            }
            h.b.c.a();
            p.this.c.execute(new t(this, h.b.a.b, c1Var, n0Var));
        }
    }

    public interface c {
    }

    public final class d implements q.b {
        public f.a<RespT> a;

        public d(f.a aVar, a aVar2) {
            this.a = aVar;
        }

        @Override // h.a.q.b
        public void a(q qVar) {
            if (qVar.W() == null || !qVar.W().c()) {
                p.this.f3802i.g(f.b.a.c.b.o.b.R1(qVar));
                return;
            }
            p.e(p.this, f.b.a.c.b.o.b.R1(qVar), this.a);
        }
    }

    public p(o0<ReqT, RespT> o0Var, Executor executor, h.a.c cVar, c cVar2, ScheduledExecutorService scheduledExecutorService, m mVar, boolean z) {
        boolean z2 = false;
        this.t = false;
        this.a = o0Var;
        String str = o0Var.b;
        System.identityHashCode(this);
        Objects.requireNonNull(h.b.c.a);
        this.b = h.b.a.a;
        this.c = executor == k.INSTANCE ? new p2() : new q2(executor);
        this.f3797d = mVar;
        this.f3798e = q.P();
        o0.c cVar3 = o0Var.a;
        this.f3799f = (cVar3 == o0.c.UNARY || cVar3 == o0.c.SERVER_STREAMING) ? true : z2;
        this.f3800g = cVar;
        this.f3805l = cVar2;
        this.n = scheduledExecutorService;
        this.f3801h = z;
    }

    public static void e(p pVar, c1 c1Var, f.a aVar) {
        if (pVar.s == null) {
            pVar.s = pVar.n.schedule(new k1(new s(pVar, c1Var)), w, TimeUnit.NANOSECONDS);
            pVar.c.execute(new q(pVar, aVar, c1Var));
        }
    }

    @Override // h.a.f
    public void a() {
        h.b.a aVar = h.b.c.a;
        Objects.requireNonNull(aVar);
        try {
            f.b.a.c.b.o.b.G(this.f3802i != null, "Not started");
            f.b.a.c.b.o.b.G(true, "call was cancelled");
            f.b.a.c.b.o.b.G(!this.f3804k, "call already half-closed");
            this.f3804k = true;
            this.f3802i.l();
            Objects.requireNonNull(aVar);
        } catch (Throwable th) {
            Objects.requireNonNull(h.b.c.a);
            throw th;
        }
    }

    @Override // h.a.f
    public void b(int i2) {
        h.b.a aVar = h.b.c.a;
        Objects.requireNonNull(aVar);
        try {
            boolean z = true;
            f.b.a.c.b.o.b.G(this.f3802i != null, "Not started");
            if (i2 < 0) {
                z = false;
            }
            f.b.a.c.b.o.b.o(z, "Number requested must be non-negative");
            this.f3802i.c(i2);
            Objects.requireNonNull(aVar);
        } catch (Throwable th) {
            Objects.requireNonNull(h.b.c.a);
            throw th;
        }
    }

    @Override // h.a.f
    public void c(ReqT reqt) {
        h.b.a aVar = h.b.c.a;
        Objects.requireNonNull(aVar);
        try {
            h(reqt);
            Objects.requireNonNull(aVar);
        } catch (Throwable th) {
            Objects.requireNonNull(h.b.c.a);
            throw th;
        }
    }

    @Override // h.a.f
    public void d(f.a<RespT> aVar, n0 n0Var) {
        h.b.a aVar2 = h.b.c.a;
        Objects.requireNonNull(aVar2);
        try {
            i(aVar, n0Var);
            Objects.requireNonNull(aVar2);
        } catch (Throwable th) {
            Objects.requireNonNull(h.b.c.a);
            throw th;
        }
    }

    public final r f() {
        r rVar = this.f3800g.a;
        r W = this.f3798e.W();
        if (rVar != null) {
            if (W == null) {
                return rVar;
            }
            rVar.a(W);
            rVar.a(W);
            if (rVar.c - W.c < 0) {
                return rVar;
            }
        }
        return W;
    }

    public final void g() {
        this.f3798e.Z(this.m);
        ScheduledFuture<?> scheduledFuture = this.s;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        ScheduledFuture<?> scheduledFuture2 = this.r;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(false);
        }
    }

    public final void h(ReqT reqt) {
        f.b.a.c.b.o.b.G(this.f3802i != null, "Not started");
        f.b.a.c.b.o.b.G(true, "call was cancelled");
        f.b.a.c.b.o.b.G(!this.f3804k, "call was half-closed");
        try {
            u uVar = this.f3802i;
            if (uVar instanceof n2) {
                ((n2) uVar).y(reqt);
            } else {
                uVar.h(this.a.f4054d.b(reqt));
            }
            if (!this.f3799f) {
                this.f3802i.flush();
            }
        } catch (RuntimeException e2) {
            this.f3802i.g(c1.f3614g.f(e2).g("Failed to stream message"));
        } catch (Error e3) {
            this.f3802i.g(c1.f3614g.g("Client sendMessage() failed with Error"));
            throw e3;
        }
    }

    public final void i(f.a<RespT> aVar, n0 n0Var) {
        l lVar;
        Executor executor;
        q qVar;
        h.a.k kVar = k.b.a;
        c2 c2Var = c2.a;
        f.b.a.c.b.o.b.G(this.f3802i == null, "Already started");
        f.b.a.c.b.o.b.G(true, "call was cancelled");
        f.b.a.c.b.o.b.A(aVar, "observer");
        f.b.a.c.b.o.b.A(n0Var, "headers");
        if (this.f3798e.X()) {
            this.f3802i = c2Var;
            c1 R1 = f.b.a.c.b.o.b.R1(this.f3798e);
            executor = this.c;
            qVar = new q(this, aVar, R1);
        } else {
            String str = this.f3800g.f3605e;
            if (str != null) {
                lVar = this.q.a.get(str);
                if (lVar == null) {
                    this.f3802i = c2Var;
                    c1 g2 = c1.m.g(String.format("Unable to find compressor by name %s", str));
                    executor = this.c;
                    qVar = new q(this, aVar, g2);
                }
            } else {
                lVar = kVar;
            }
            t tVar = this.p;
            boolean z = this.o;
            n0.f<String> fVar = q0.c;
            n0Var.b(fVar);
            if (lVar != kVar) {
                n0Var.h(fVar, lVar.a());
            }
            n0.f<byte[]> fVar2 = q0.f3813d;
            n0Var.b(fVar2);
            byte[] bArr = tVar.b;
            if (bArr.length != 0) {
                n0Var.h(fVar2, bArr);
            }
            n0Var.b(q0.f3814e);
            n0.f<byte[]> fVar3 = q0.f3815f;
            n0Var.b(fVar3);
            if (z) {
                n0Var.h(fVar3, v);
            }
            r f2 = f();
            if (!(f2 != null && f2.c())) {
                r W = this.f3798e.W();
                r rVar = this.f3800g.a;
                Logger logger = u;
                if (logger.isLoggable(Level.FINE) && f2 != null && f2.equals(W)) {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    StringBuilder sb = new StringBuilder(String.format("Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(Math.max(0L, f2.e(timeUnit)))));
                    sb.append(rVar == null ? " Explicit call timeout was not set." : String.format(" Explicit call timeout was '%d' ns.", Long.valueOf(rVar.e(timeUnit))));
                    logger.fine(sb.toString());
                }
                if (this.f3801h) {
                    c cVar = this.f3805l;
                    o0<ReqT, RespT> o0Var = this.a;
                    h.a.c cVar2 = this.f3800g;
                    q qVar2 = this.f3798e;
                    m1.h hVar = (m1.h) cVar;
                    Objects.requireNonNull(m1.this);
                    f.b.a.c.b.o.b.G(false, "retry should be enabled");
                    this.f3802i = new r1(hVar, o0Var, n0Var, cVar2, m1.this.Q.b.c, qVar2);
                } else {
                    w a2 = ((m1.h) this.f3805l).a(new h2(this.a, n0Var, this.f3800g));
                    q d2 = this.f3798e.d();
                    try {
                        this.f3802i = a2.g(this.a, n0Var, this.f3800g);
                    } finally {
                        this.f3798e.V(d2);
                    }
                }
            } else {
                c1 c1Var = c1.f3616i;
                this.f3802i = new i0(c1Var.g("ClientCall started after deadline exceeded: " + f2));
            }
            String str2 = this.f3800g.c;
            if (str2 != null) {
                this.f3802i.j(str2);
            }
            Integer num = this.f3800g.f3609i;
            if (num != null) {
                this.f3802i.d(num.intValue());
            }
            Integer num2 = this.f3800g.f3610j;
            if (num2 != null) {
                this.f3802i.a(num2.intValue());
            }
            if (f2 != null) {
                this.f3802i.e(f2);
            }
            this.f3802i.b(lVar);
            boolean z2 = this.o;
            if (z2) {
                this.f3802i.n(z2);
            }
            this.f3802i.f(this.p);
            m mVar = this.f3797d;
            mVar.b.a(1);
            mVar.a.a();
            this.m = new d(aVar, null);
            this.f3802i.i(new b(aVar));
            this.f3798e.c(this.m, f.b.b.f.a.k.INSTANCE);
            if (f2 != null && !f2.equals(this.f3798e.W()) && this.n != null && !(this.f3802i instanceof i0)) {
                TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                long e2 = f2.e(timeUnit2);
                this.r = this.n.schedule(new k1(new r(this, e2, aVar)), e2, timeUnit2);
            }
            if (this.f3803j) {
                g();
                return;
            }
            return;
        }
        executor.execute(qVar);
    }

    public String toString() {
        f.b.b.a.k T1 = f.b.a.c.b.o.b.T1(this);
        T1.d("method", this.a);
        return T1.toString();
    }
}
