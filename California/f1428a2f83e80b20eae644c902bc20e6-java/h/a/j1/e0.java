package h.a.j1;

import h.a.c1;
import h.a.j1.v;
import h.a.j1.y2;
import h.a.n0;
import h.a.r;
import h.a.t;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class e0 implements u {
    public volatile boolean a;
    public v b;
    public u c;

    /* renamed from: d  reason: collision with root package name */
    public c1 f3596d;

    /* renamed from: e  reason: collision with root package name */
    public List<Runnable> f3597e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public n f3598f;

    /* renamed from: g  reason: collision with root package name */
    public long f3599g;

    /* renamed from: h  reason: collision with root package name */
    public long f3600h;

    public class a implements Runnable {
        public final /* synthetic */ int b;

        public a(int i2) {
            this.b = i2;
        }

        public void run() {
            e0.this.c.c(this.b);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ h.a.l b;

        public b(h.a.l lVar) {
            this.b = lVar;
        }

        public void run() {
            e0.this.c.b(this.b);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ boolean b;

        public c(boolean z) {
            this.b = z;
        }

        public void run() {
            e0.this.c.n(this.b);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ t b;

        public d(t tVar) {
            this.b = tVar;
        }

        public void run() {
            e0.this.c.f(this.b);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ int b;

        public e(int i2) {
            this.b = i2;
        }

        public void run() {
            e0.this.c.d(this.b);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ int b;

        public f(int i2) {
            this.b = i2;
        }

        public void run() {
            e0.this.c.a(this.b);
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ r b;

        public g(r rVar) {
            this.b = rVar;
        }

        public void run() {
            e0.this.c.e(this.b);
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ String b;

        public h(String str) {
            this.b = str;
        }

        public void run() {
            e0.this.c.j(this.b);
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ v b;

        public i(v vVar) {
            this.b = vVar;
        }

        public void run() {
            e0.this.c.i(this.b);
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ InputStream b;

        public j(InputStream inputStream) {
            this.b = inputStream;
        }

        public void run() {
            e0.this.c.h(this.b);
        }
    }

    public class k implements Runnable {
        public k() {
        }

        public void run() {
            e0.this.c.flush();
        }
    }

    public class l implements Runnable {
        public final /* synthetic */ c1 b;

        public l(c1 c1Var) {
            this.b = c1Var;
        }

        public void run() {
            e0.this.c.g(this.b);
        }
    }

    public class m implements Runnable {
        public m() {
        }

        public void run() {
            e0.this.c.l();
        }
    }

    public static class n implements v {
        public final v a;
        public volatile boolean b;
        public List<Runnable> c = new ArrayList();

        public class a implements Runnable {
            public final /* synthetic */ y2.a b;

            public a(y2.a aVar) {
                this.b = aVar;
            }

            public void run() {
                n.this.a.a(this.b);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                n.this.a.c();
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ n0 b;

            public c(n0 n0Var) {
                this.b = n0Var;
            }

            public void run() {
                n.this.a.e(this.b);
            }
        }

        public class d implements Runnable {
            public final /* synthetic */ c1 b;
            public final /* synthetic */ n0 c;

            public d(c1 c1Var, n0 n0Var) {
                this.b = c1Var;
                this.c = n0Var;
            }

            public void run() {
                n.this.a.b(this.b, this.c);
            }
        }

        public class e implements Runnable {
            public final /* synthetic */ c1 b;
            public final /* synthetic */ v.a c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ n0 f3602d;

            public e(c1 c1Var, v.a aVar, n0 n0Var) {
                this.b = c1Var;
                this.c = aVar;
                this.f3602d = n0Var;
            }

            public void run() {
                n.this.a.d(this.b, this.c, this.f3602d);
            }
        }

        public n(v vVar) {
            this.a = vVar;
        }

        @Override // h.a.j1.y2
        public void a(y2.a aVar) {
            if (this.b) {
                this.a.a(aVar);
            } else {
                f(new a(aVar));
            }
        }

        @Override // h.a.j1.v
        public void b(c1 c1Var, n0 n0Var) {
            f(new d(c1Var, n0Var));
        }

        @Override // h.a.j1.y2
        public void c() {
            if (this.b) {
                this.a.c();
            } else {
                f(new b());
            }
        }

        @Override // h.a.j1.v
        public void d(c1 c1Var, v.a aVar, n0 n0Var) {
            f(new e(c1Var, aVar, n0Var));
        }

        @Override // h.a.j1.v
        public void e(n0 n0Var) {
            f(new c(n0Var));
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                if (!this.b) {
                    this.c.add(runnable);
                } else {
                    runnable.run();
                }
            }
        }
    }

    @Override // h.a.j1.u
    public void a(int i2) {
        if (this.a) {
            this.c.a(i2);
        } else {
            m(new f(i2));
        }
    }

    @Override // h.a.j1.x2
    public void b(h.a.l lVar) {
        f.b.a.c.b.o.b.A(lVar, "compressor");
        m(new b(lVar));
    }

    @Override // h.a.j1.x2
    public void c(int i2) {
        if (this.a) {
            this.c.c(i2);
        } else {
            m(new a(i2));
        }
    }

    @Override // h.a.j1.u
    public void d(int i2) {
        if (this.a) {
            this.c.d(i2);
        } else {
            m(new e(i2));
        }
    }

    @Override // h.a.j1.u
    public void e(r rVar) {
        m(new g(rVar));
    }

    @Override // h.a.j1.u
    public void f(t tVar) {
        f.b.a.c.b.o.b.A(tVar, "decompressorRegistry");
        m(new d(tVar));
    }

    @Override // h.a.j1.x2
    public void flush() {
        if (this.a) {
            this.c.flush();
        } else {
            m(new k());
        }
    }

    @Override // h.a.j1.u
    public void g(c1 c1Var) {
        v vVar;
        boolean z;
        f.b.a.c.b.o.b.A(c1Var, "reason");
        synchronized (this) {
            if (this.c == null) {
                p(c2.a);
                z = false;
                vVar = this.b;
                this.f3596d = c1Var;
            } else {
                z = true;
                vVar = null;
            }
        }
        if (z) {
            m(new l(c1Var));
            return;
        }
        if (vVar != null) {
            vVar.b(c1Var, new n0());
        }
        o();
    }

    @Override // h.a.j1.x2
    public void h(InputStream inputStream) {
        f.b.a.c.b.o.b.A(inputStream, "message");
        if (this.a) {
            this.c.h(inputStream);
        } else {
            m(new j(inputStream));
        }
    }

    @Override // h.a.j1.u
    public void i(v vVar) {
        c1 c1Var;
        boolean z;
        f.b.a.c.b.o.b.G(this.b == null, "already started");
        synchronized (this) {
            f.b.a.c.b.o.b.A(vVar, "listener");
            this.b = vVar;
            c1Var = this.f3596d;
            z = this.a;
            if (!z) {
                n nVar = new n(vVar);
                this.f3598f = nVar;
                vVar = nVar;
            }
            this.f3599g = System.nanoTime();
        }
        if (c1Var != null) {
            vVar.b(c1Var, new n0());
        } else if (z) {
            this.c.i(vVar);
        } else {
            m(new i(vVar));
        }
    }

    @Override // h.a.j1.u
    public void j(String str) {
        f.b.a.c.b.o.b.G(this.b == null, "May only be called before start");
        f.b.a.c.b.o.b.A(str, "authority");
        m(new h(str));
    }

    @Override // h.a.j1.u
    public void k(y0 y0Var) {
        synchronized (this) {
            if (this.b != null) {
                if (this.c != null) {
                    y0Var.b("buffered_nanos", Long.valueOf(this.f3600h - this.f3599g));
                    this.c.k(y0Var);
                } else {
                    y0Var.b("buffered_nanos", Long.valueOf(System.nanoTime() - this.f3599g));
                    y0Var.a.add("waiting_for_connection");
                }
            }
        }
    }

    @Override // h.a.j1.u
    public void l() {
        m(new m());
    }

    public final void m(Runnable runnable) {
        synchronized (this) {
            if (!this.a) {
                this.f3597e.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    @Override // h.a.j1.u
    public void n(boolean z) {
        m(new c(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r4v2. Raw type applied. Possible types: java.util.List<java.lang.Runnable>, java.util.List */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: java.util.List<java.lang.Runnable>, java.util.List */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        if (r2.c.isEmpty() == false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        r2.c = null;
        r2.b = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        r4 = r2.c;
        r2.c = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        r3 = r4.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r3.hasNext() == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        ((java.lang.Runnable) r3.next()).run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        r4.clear();
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0054, code lost:
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r0.hasNext() == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005e, code lost:
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r3 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        monitor-enter(r2);
     */
    public final void o() {
        List list;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                if (this.f3597e.isEmpty()) {
                    this.f3597e = null;
                    this.a = true;
                    n nVar = this.f3598f;
                } else {
                    list = this.f3597e;
                    this.f3597e = arrayList;
                }
            }
            list.clear();
            arrayList = list;
        }
    }

    public final void p(u uVar) {
        u uVar2 = this.c;
        f.b.a.c.b.o.b.H(uVar2 == null, "realStream already set to %s", uVar2);
        this.c = uVar;
        this.f3600h = System.nanoTime();
    }

    public final void q(u uVar) {
        synchronized (this) {
            if (this.c == null) {
                f.b.a.c.b.o.b.A(uVar, "stream");
                p(uVar);
                o();
            }
        }
    }
}
