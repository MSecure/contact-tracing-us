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
/* loaded from: classes.dex */
public class e0 implements u {
    public volatile boolean a;
    public v b;
    public u c;

    /* renamed from: d */
    public c1 f4174d;

    /* renamed from: e */
    public List<Runnable> f4175e = new ArrayList();

    /* renamed from: f */
    public n f4176f;

    /* renamed from: g */
    public long f4177g;

    /* renamed from: h */
    public long f4178h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ int b;

        public a(int i2) {
            e0.this = r1;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.c.c(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ h.a.l b;

        public b(h.a.l lVar) {
            e0.this = r1;
            this.b = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.c.b(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ boolean b;

        public c(boolean z) {
            e0.this = r1;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.c.n(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public final /* synthetic */ t b;

        public d(t tVar) {
            e0.this = r1;
            this.b = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.c.f(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public final /* synthetic */ int b;

        public e(int i2) {
            e0.this = r1;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.c.d(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public final /* synthetic */ int b;

        public f(int i2) {
            e0.this = r1;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.c.a(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public final /* synthetic */ r b;

        public g(r rVar) {
            e0.this = r1;
            this.b = rVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.c.e(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public final /* synthetic */ String b;

        public h(String str) {
            e0.this = r1;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.c.j(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public final /* synthetic */ v b;

        public i(v vVar) {
            e0.this = r1;
            this.b = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.c.i(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public final /* synthetic */ InputStream b;

        public j(InputStream inputStream) {
            e0.this = r1;
            this.b = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.c.h(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public k() {
            e0.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.c.flush();
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public final /* synthetic */ c1 b;

        public l(c1 c1Var) {
            e0.this = r1;
            this.b = c1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.c.g(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public m() {
            e0.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.c.l();
        }
    }

    /* loaded from: classes.dex */
    public static class n implements v {
        public final v a;
        public volatile boolean b;
        public List<Runnable> c = new ArrayList();

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public final /* synthetic */ y2.a b;

            public a(y2.a aVar) {
                n.this = r1;
                this.b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                n.this.a.a(this.b);
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public b() {
                n.this = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                n.this.a.c();
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public final /* synthetic */ n0 b;

            public c(n0 n0Var) {
                n.this = r1;
                this.b = n0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                n.this.a.e(this.b);
            }
        }

        /* loaded from: classes.dex */
        public class d implements Runnable {
            public final /* synthetic */ c1 b;
            public final /* synthetic */ n0 c;

            public d(c1 c1Var, n0 n0Var) {
                n.this = r1;
                this.b = c1Var;
                this.c = n0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                n.this.a.b(this.b, this.c);
            }
        }

        /* loaded from: classes.dex */
        public class e implements Runnable {
            public final /* synthetic */ c1 b;
            public final /* synthetic */ v.a c;

            /* renamed from: d */
            public final /* synthetic */ n0 f4180d;

            public e(c1 c1Var, v.a aVar, n0 n0Var) {
                n.this = r1;
                this.b = c1Var;
                this.c = aVar;
                this.f4180d = n0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                n.this.a.d(this.b, this.c, this.f4180d);
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
                this.f4174d = c1Var;
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
            c1Var = this.f4174d;
            z = this.a;
            if (!z) {
                n nVar = new n(vVar);
                this.f4176f = nVar;
                vVar = nVar;
            }
            this.f4177g = System.nanoTime();
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
                    y0Var.b("buffered_nanos", Long.valueOf(this.f4178h - this.f4177g));
                    this.c.k(y0Var);
                } else {
                    y0Var.b("buffered_nanos", Long.valueOf(System.nanoTime() - this.f4177g));
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
                this.f4175e.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    @Override // h.a.j1.u
    public void n(boolean z) {
        m(new c(z));
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
        if (r0.hasNext() == false) goto L_0x0068;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void o() {
        n nVar;
        List<Runnable> list;
        List list2;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                if (this.f4175e.isEmpty()) {
                    break;
                }
                list2 = this.f4175e;
                this.f4175e = arrayList;
            }
            if (nVar == null) {
                List arrayList2 = new ArrayList();
                while (true) {
                    synchronized (nVar) {
                        if (nVar.c.isEmpty()) {
                            nVar.c = null;
                            nVar.b = true;
                            return;
                        }
                        list = nVar.c;
                        nVar.c = arrayList2;
                    }
                    for (Runnable runnable : list) {
                        runnable.run();
                    }
                    list.clear();
                    arrayList2 = list;
                }
            } else {
                return;
            }
            list2.clear();
            arrayList = list2;
        }
        this.f4175e = null;
        this.a = true;
        nVar = this.f4176f;
        if (nVar == null) {
        }
    }

    public final void p(u uVar) {
        u uVar2 = this.c;
        f.b.a.c.b.o.b.H(uVar2 == null, "realStream already set to %s", uVar2);
        this.c = uVar;
        this.f4178h = System.nanoTime();
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
