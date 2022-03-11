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
/* loaded from: classes.dex */
public abstract class a extends d implements u, a2.d {

    /* renamed from: f */
    public static final Logger f4116f = Logger.getLogger(a.class.getName());
    public final c3 a;
    public final o0 b;
    public boolean c;

    /* renamed from: d */
    public boolean f4117d;

    /* renamed from: e */
    public n0 f4118e;

    /* renamed from: h.a.j1.a$a */
    /* loaded from: classes.dex */
    public class C0146a implements o0 {
        public n0 a;
        public boolean b;
        public final w2 c;

        /* renamed from: d */
        public byte[] f4119d;

        public C0146a(n0 n0Var, w2 w2Var) {
            a.this = r1;
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
            if (this.f4119d == null) {
                z = false;
            }
            f.b.a.c.b.o.b.G(z, "Lack of request message. GET request is only supported for unary requests");
            ((f.a) a.this.o()).a(this.a, this.f4119d);
            this.f4119d = null;
            this.a = null;
        }

        @Override // h.a.j1.o0
        public void d(InputStream inputStream) {
            f.b.a.c.b.o.b.G(this.f4119d == null, "writePayload should not be called multiple times");
            try {
                this.f4119d = f.b.b.c.b.b(inputStream);
                for (f1 f1Var : this.c.a) {
                    Objects.requireNonNull(f1Var);
                }
                w2 w2Var = this.c;
                int length = this.f4119d.length;
                for (f1 f1Var2 : w2Var.a) {
                    Objects.requireNonNull(f1Var2);
                }
                w2 w2Var2 = this.c;
                int length2 = this.f4119d.length;
                for (f1 f1Var3 : w2Var2.a) {
                    Objects.requireNonNull(f1Var3);
                }
                w2 w2Var3 = this.c;
                long length3 = (long) this.f4119d.length;
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

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    public static abstract class c extends d.a {

        /* renamed from: h */
        public final w2 f4121h;

        /* renamed from: i */
        public boolean f4122i;

        /* renamed from: j */
        public v f4123j;

        /* renamed from: k */
        public boolean f4124k;

        /* renamed from: l */
        public t f4125l = t.f4556d;
        public boolean m = false;
        public Runnable n;
        public volatile boolean o;
        public boolean p;
        public boolean q;

        /* renamed from: h.a.j1.a$c$a */
        /* loaded from: classes.dex */
        public class RunnableC0147a implements Runnable {
            public final /* synthetic */ c1 b;
            public final /* synthetic */ v.a c;

            /* renamed from: d */
            public final /* synthetic */ n0 f4126d;

            public RunnableC0147a(c1 c1Var, v.a aVar, n0 n0Var) {
                c.this = r1;
                this.b = c1Var;
                this.c = aVar;
                this.f4126d = n0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.g(this.b, this.c, this.f4126d);
            }
        }

        public c(int i2, w2 w2Var, c3 c3Var) {
            super(i2, w2Var, c3Var);
            f.b.a.c.b.o.b.A(w2Var, "statsTraceCtx");
            this.f4121h = w2Var;
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
            if (!this.f4122i) {
                this.f4122i = true;
                w2 w2Var = this.f4121h;
                if (w2Var.b.compareAndSet(false, true)) {
                    for (f1 f1Var : w2Var.a) {
                        Objects.requireNonNull(f1Var);
                    }
                }
                this.f4123j.d(c1Var, aVar, n0Var);
                c3 c3Var = this.f4158d;
                if (c3Var == null) {
                    return;
                }
                if (c1Var.e()) {
                    c3Var.c++;
                } else {
                    c3Var.f4154d++;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void h(n0 n0Var) {
            e1 e1Var;
            boolean z;
            String str;
            f.b.a.c.b.o.b.G(!this.p, "Received headers on closed stream");
            for (f1 f1Var : this.f4121h.a) {
                Objects.requireNonNull((j) f1Var);
            }
            String str2 = (String) n0Var.d(q0.f4288e);
            if (this.f4124k && str2 != null) {
                if (str2.equalsIgnoreCase("gzip")) {
                    this.b.J(new r0());
                    this.b = new f(this, this, (z1) this.b);
                    z = true;
                    str = (String) n0Var.d(q0.c);
                    if (str != null) {
                        t.a aVar = this.f4125l.a.get(str);
                        s sVar = aVar != null ? aVar.a : null;
                        if (sVar == null) {
                            e1Var = new e1(c1.m.g(String.format("Can't find decompressor for %s", str)));
                        } else if (sVar != k.b.a) {
                            if (z) {
                                e1Var = new e1(c1.m.g(String.format("Full stream and gRPC message encoding cannot both be set", new Object[0])));
                            } else {
                                this.b.x(sVar);
                            }
                        }
                        ((f.b) this).b(e1Var);
                        return;
                    }
                    this.f4123j.e(n0Var);
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
            this.f4123j.e(n0Var);
        }

        public final void i(c1 c1Var, v.a aVar, boolean z, n0 n0Var) {
            f.b.a.c.b.o.b.A(c1Var, "status");
            f.b.a.c.b.o.b.A(n0Var, "trailers");
            if (!this.p || z) {
                this.p = true;
                this.q = c1Var.e();
                synchronized (this.c) {
                    this.f4161g = true;
                }
                if (this.m) {
                    this.n = null;
                    g(c1Var, aVar, n0Var);
                    return;
                }
                this.n = new RunnableC0147a(c1Var, aVar, n0Var);
                c0 c0Var = this.b;
                if (z) {
                    c0Var.close();
                } else {
                    c0Var.t();
                }
            }
        }
    }

    public a(e3 e3Var, w2 w2Var, c3 c3Var, n0 n0Var, h.a.c cVar, boolean z) {
        f.b.a.c.b.o.b.A(n0Var, "headers");
        f.b.a.c.b.o.b.A(c3Var, "transportTracer");
        this.a = c3Var;
        this.c = !Boolean.TRUE.equals(cVar.a(q0.f4295l));
        this.f4117d = z;
        if (!z) {
            this.b = new a2(this, e3Var, w2Var);
            this.f4118e = n0Var;
            return;
        }
        this.b = new C0146a(n0Var, w2Var);
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
        n0 n0Var = this.f4118e;
        n0.f<Long> fVar = q0.b;
        n0Var.b(fVar);
        this.f4118e.h(fVar, Long.valueOf(Math.max(0L, rVar.e(TimeUnit.NANOSECONDS))));
    }

    @Override // h.a.j1.u
    public final void f(t tVar) {
        c p = p();
        f.b.a.c.b.o.b.G(p.f4123j == null, "Already called start");
        f.b.a.c.b.o.b.A(tVar, "decompressorRegistry");
        p.f4125l = tVar;
    }

    @Override // h.a.j1.u
    public final void g(c1 c1Var) {
        f.b.a.c.b.o.b.p(!c1Var.e(), "Should not cancel with OK status");
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
        f.b.a.c.b.o.b.G(p.f4123j == null, "Already called setListener");
        f.b.a.c.b.o.b.A(vVar, "listener");
        p.f4123j = vVar;
        if (!this.f4117d) {
            ((f.a) o()).a(this.f4118e, null);
            this.f4118e = null;
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
        f.b.a.c.b.o.b.p(d3Var != null || z, "null frame before EOS");
        f.a aVar = (f.a) o();
        Objects.requireNonNull(aVar);
        if (d3Var == null) {
            eVar = f.q;
        } else {
            eVar = ((h.a.k1.l) d3Var).a;
            int i3 = (int) eVar.c;
            if (i3 > 0) {
                d.a q = f.this.q();
                synchronized (q.c) {
                    q.f4159e += i3;
                }
            }
        }
        try {
            synchronized (f.this.m.y) {
                f.b.m(f.this.m, eVar, z, z2);
                c3 c3Var = f.this.a;
                Objects.requireNonNull(c3Var);
                if (i2 != 0) {
                    c3Var.f4156f += (long) i2;
                    c3Var.a.a();
                }
            }
        } finally {
            Objects.requireNonNull(h.b.c.a);
        }
    }

    @Override // h.a.j1.u
    public final void n(boolean z) {
        p().f4124k = z;
    }

    public abstract b o();

    public abstract c p();
}
