package h.a.j1;

import h.a.c1;
import h.a.e1;
import h.a.f1;
import h.a.j;
import h.a.j1.a2;
import h.a.j1.d;
import h.a.j1.v;
import h.a.k;
import h.a.k1.f;
import h.a.l;
import h.a.n0;
import h.a.r;
import h.a.s;
import h.a.t;
import h.a.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import k.e;

public abstract class a extends d implements u, a2.d {

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f3546f = Logger.getLogger(a.class.getName());
    public final c3 a;
    public final o0 b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3547d;

    /* renamed from: e  reason: collision with root package name */
    public n0 f3548e;

    /* renamed from: h.a.j1.a$a  reason: collision with other inner class name */
    public class C0139a implements o0 {
        public n0 a;
        public boolean b;
        public final w2 c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f3549d;

        public C0139a(n0 n0Var, w2 w2Var) {
            f.b.a.c.b.o.b.A(n0Var, "headers");
            this.a = n0Var;
            f.b.a.c.b.o.b.A(w2Var, "statsTraceCtx");
            this.c = w2Var;
        }

        @Override // h.a.j1.o0
        public void a(int i2) {
        }

        @Override // h.a.j1.o0
        public o0 b(l lVar) {
            return this;
        }

        @Override // h.a.j1.o0
        public boolean c() {
            return this.b;
        }

        @Override // h.a.j1.o0
        public void close() {
            boolean z = true;
            this.b = true;
            if (this.f3549d == null) {
                z = false;
            }
            f.b.a.c.b.o.b.G(z, "Lack of request message. GET request is only supported for unary requests");
            ((f.a) a.this.o()).a(this.a, this.f3549d);
            this.f3549d = null;
            this.a = null;
        }

        @Override // h.a.j1.o0
        public void d(InputStream inputStream) {
            f.b.a.c.b.o.b.G(this.f3549d == null, "writePayload should not be called multiple times");
            try {
                this.f3549d = f.b.b.c.b.b(inputStream);
                for (f1 f1Var : this.c.a) {
                    Objects.requireNonNull(f1Var);
                }
                w2 w2Var = this.c;
                int length = this.f3549d.length;
                for (f1 f1Var2 : w2Var.a) {
                    Objects.requireNonNull(f1Var2);
                }
                w2 w2Var2 = this.c;
                int length2 = this.f3549d.length;
                for (f1 f1Var3 : w2Var2.a) {
                    Objects.requireNonNull(f1Var3);
                }
                w2 w2Var3 = this.c;
                long length3 = (long) this.f3549d.length;
                for (f1 f1Var4 : w2Var3.a) {
                    f1Var4.a(length3);
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // h.a.j1.o0
        public void flush() {
        }
    }

    public interface b {
    }

    public static abstract class c extends d.a {

        /* renamed from: h  reason: collision with root package name */
        public final w2 f3551h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f3552i;

        /* renamed from: j  reason: collision with root package name */
        public v f3553j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f3554k;

        /* renamed from: l  reason: collision with root package name */
        public t f3555l = t.f3986d;
        public boolean m = false;
        public Runnable n;
        public volatile boolean o;
        public boolean p;
        public boolean q;

        /* renamed from: h.a.j1.a$c$a  reason: collision with other inner class name */
        public class RunnableC0140a implements Runnable {
            public final /* synthetic */ c1 b;
            public final /* synthetic */ v.a c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ n0 f3556d;

            public RunnableC0140a(c1 c1Var, v.a aVar, n0 n0Var) {
                this.b = c1Var;
                this.c = aVar;
                this.f3556d = n0Var;
            }

            public void run() {
                c.this.g(this.b, this.c, this.f3556d);
            }
        }

        public c(int i2, w2 w2Var, c3 c3Var) {
            super(i2, w2Var, c3Var);
            f.b.a.c.b.o.b.A(w2Var, "statsTraceCtx");
            this.f3551h = w2Var;
        }

        @Override // h.a.j1.z1.b
        public void e(boolean z) {
            f.b.a.c.b.o.b.G(this.p, "status should have been reported on deframer closed");
            this.m = true;
            if (this.q && z) {
                i(c1.m.g("Encountered end-of-stream mid-frame"), v.a.PROCESSED, true, new n0());
            }
            Runnable runnable = this.n;
            if (runnable != null) {
                runnable.run();
                this.n = null;
            }
        }

        public final void g(c1 c1Var, v.a aVar, n0 n0Var) {
            if (!this.f3552i) {
                this.f3552i = true;
                w2 w2Var = this.f3551h;
                if (w2Var.b.compareAndSet(false, true)) {
                    for (f1 f1Var : w2Var.a) {
                        Objects.requireNonNull(f1Var);
                    }
                }
                this.f3553j.d(c1Var, aVar, n0Var);
                c3 c3Var = this.f3588d;
                if (c3Var == null) {
                    return;
                }
                if (c1Var.e()) {
                    c3Var.c++;
                } else {
                    c3Var.f3584d++;
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0072  */
        public void h(n0 n0Var) {
            e1 e1Var;
            boolean z;
            String str;
            f.b.a.c.b.o.b.G(!this.p, "Received headers on closed stream");
            for (f1 f1Var : this.f3551h.a) {
                Objects.requireNonNull((j) f1Var);
            }
            String str2 = (String) n0Var.d(q0.f3718e);
            if (this.f3554k && str2 != null) {
                if (str2.equalsIgnoreCase("gzip")) {
                    this.b.N(new r0());
                    this.b = new f(this, this, (z1) this.b);
                    z = true;
                    str = (String) n0Var.d(q0.c);
                    if (str != null) {
                        t.a aVar = this.f3555l.a.get(str);
                        s sVar = aVar != null ? aVar.a : null;
                        if (sVar == null) {
                            e1Var = new e1(c1.m.g(String.format("Can't find decompressor for %s", str)));
                        } else if (sVar != k.b.a) {
                            if (z) {
                                e1Var = new e1(c1.m.g(String.format("Full stream and gRPC message encoding cannot both be set", new Object[0])));
                            } else {
                                this.b.A(sVar);
                            }
                        }
                        ((f.b) this).b(e1Var);
                        return;
                    }
                    this.f3553j.e(n0Var);
                } else if (!str2.equalsIgnoreCase("identity")) {
                    e1Var = new e1(c1.m.g(String.format("Can't find full stream decompressor for %s", str2)));
                    ((f.b) this).b(e1Var);
                    return;
                }
            }
            z = false;
            str = (String) n0Var.d(q0.c);
            if (str != null) {
            }
            this.f3553j.e(n0Var);
        }

        public final void i(c1 c1Var, v.a aVar, boolean z, n0 n0Var) {
            f.b.a.c.b.o.b.A(c1Var, "status");
            f.b.a.c.b.o.b.A(n0Var, "trailers");
            if (!this.p || z) {
                this.p = true;
                this.q = c1Var.e();
                synchronized (this.c) {
                    this.f3591g = true;
                }
                if (this.m) {
                    this.n = null;
                    g(c1Var, aVar, n0Var);
                    return;
                }
                this.n = new RunnableC0140a(c1Var, aVar, n0Var);
                c0 c0Var = this.b;
                if (z) {
                    c0Var.close();
                } else {
                    c0Var.v();
                }
            }
        }
    }

    public a(e3 e3Var, w2 w2Var, c3 c3Var, n0 n0Var, h.a.c cVar, boolean z) {
        f.b.a.c.b.o.b.A(n0Var, "headers");
        f.b.a.c.b.o.b.A(c3Var, "transportTracer");
        this.a = c3Var;
        this.c = !Boolean.TRUE.equals(cVar.a(q0.f3725l));
        this.f3547d = z;
        if (!z) {
            this.b = new a2(this, e3Var, w2Var);
            this.f3548e = n0Var;
            return;
        }
        this.b = new C0139a(n0Var, w2Var);
    }

    @Override // h.a.j1.u
    public void a(int i2) {
        this.b.a(i2);
    }

    @Override // h.a.j1.x2
    public final void c(int i2) {
        f.a aVar = (f.a) o();
        Objects.requireNonNull(aVar);
        Objects.requireNonNull(h.b.c.a);
        try {
            synchronized (f.this.m.y) {
                f.b bVar = f.this.m;
                Objects.requireNonNull(bVar);
                try {
                    bVar.b.c(i2);
                } catch (Throwable th) {
                    bVar.b(th);
                }
            }
        } finally {
            Objects.requireNonNull(h.b.c.a);
        }
    }

    @Override // h.a.j1.u
    public void d(int i2) {
        p().b.d(i2);
    }

    @Override // h.a.j1.u
    public void e(r rVar) {
        n0 n0Var = this.f3548e;
        n0.f<Long> fVar = q0.b;
        n0Var.b(fVar);
        this.f3548e.h(fVar, Long.valueOf(Math.max(0L, rVar.e(TimeUnit.NANOSECONDS))));
    }

    @Override // h.a.j1.u
    public final void f(t tVar) {
        c p = p();
        f.b.a.c.b.o.b.G(p.f3553j == null, "Already called start");
        f.b.a.c.b.o.b.A(tVar, "decompressorRegistry");
        p.f3555l = tVar;
    }

    @Override // h.a.j1.u
    public final void g(c1 c1Var) {
        f.b.a.c.b.o.b.o(!c1Var.e(), "Should not cancel with OK status");
        f.a aVar = (f.a) o();
        Objects.requireNonNull(aVar);
        Objects.requireNonNull(h.b.c.a);
        try {
            synchronized (f.this.m.y) {
                f.this.m.n(c1Var, true, null);
            }
        } catch (Throwable th) {
            Objects.requireNonNull(h.b.c.a);
            throw th;
        }
    }

    @Override // h.a.j1.u
    public final void i(v vVar) {
        c p = p();
        f.b.a.c.b.o.b.G(p.f3553j == null, "Already called setListener");
        f.b.a.c.b.o.b.A(vVar, "listener");
        p.f3553j = vVar;
        if (!this.f3547d) {
            ((f.a) o()).a(this.f3548e, null);
            this.f3548e = null;
        }
    }

    @Override // h.a.j1.u
    public final void k(y0 y0Var) {
        h.a.a aVar = ((f) this).o;
        y0Var.b("remote_addr", aVar.a.get(y.a));
    }

    @Override // h.a.j1.u
    public final void l() {
        if (!p().o) {
            p().o = true;
            this.b.close();
        }
    }

    @Override // h.a.j1.a2.d
    public final void m(d3 d3Var, boolean z, boolean z2, int i2) {
        e eVar;
        f.b.a.c.b.o.b.o(d3Var != null || z, "null frame before EOS");
        f.a aVar = (f.a) o();
        Objects.requireNonNull(aVar);
        Objects.requireNonNull(h.b.c.a);
        if (d3Var == null) {
            eVar = f.q;
        } else {
            eVar = ((h.a.k1.l) d3Var).a;
            int i3 = (int) eVar.c;
            if (i3 > 0) {
                d.a q = f.this.q();
                synchronized (q.c) {
                    q.f3589e += i3;
                }
            }
        }
        try {
            synchronized (f.this.m.y) {
                f.b.m(f.this.m, eVar, z, z2);
                c3 c3Var = f.this.a;
                Objects.requireNonNull(c3Var);
                if (i2 != 0) {
                    c3Var.f3586f += (long) i2;
                    c3Var.a.a();
                }
            }
        } catch (Throwable th) {
            Objects.requireNonNull(h.b.c.a);
            throw th;
        }
    }

    @Override // h.a.j1.u
    public final void n(boolean z) {
        p().f3554k = z;
    }

    public abstract b o();

    public abstract c p();
}
