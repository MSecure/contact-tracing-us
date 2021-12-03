package h.a.j1;

import h.a.b;
import h.a.c;
import h.a.c1;
import h.a.n0;
import h.a.o0;
import h.a.q;

public final class b2 extends b.a {
    public final w a;
    public final o0<?, ?> b;
    public final n0 c;

    /* renamed from: d  reason: collision with root package name */
    public final c f3892d;

    /* renamed from: e  reason: collision with root package name */
    public final q f3893e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f3894f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public u f3895g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3896h;

    /* renamed from: i  reason: collision with root package name */
    public e0 f3897i;

    public b2(w wVar, o0<?, ?> o0Var, n0 n0Var, c cVar) {
        this.a = wVar;
        this.b = o0Var;
        this.c = n0Var;
        this.f3892d = cVar;
        this.f3893e = q.L();
    }

    /* JADX INFO: finally extract failed */
    @Override // h.a.b.a
    public void a(n0 n0Var) {
        f.b.a.c.b.o.b.F(!this.f3896h, "apply() or fail() already called");
        f.b.a.c.b.o.b.z(n0Var, "headers");
        this.c.f(n0Var);
        q d2 = this.f3893e.d();
        try {
            u g2 = this.a.g(this.b, this.c, this.f3892d);
            this.f3893e.Q(d2);
            c(g2);
        } catch (Throwable th) {
            this.f3893e.Q(d2);
            throw th;
        }
    }

    @Override // h.a.b.a
    public void b(c1 c1Var) {
        f.b.a.c.b.o.b.o(!c1Var.e(), "Cannot fail with OK status");
        f.b.a.c.b.o.b.F(!this.f3896h, "apply() or fail() already called");
        c(new i0(c1Var));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r3.f3897i == null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        f.b.a.c.b.o.b.F(r1, "delayedStream is null");
        r3.f3897i.q(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        return;
     */
    public final void c(u uVar) {
        boolean z = true;
        f.b.a.c.b.o.b.F(!this.f3896h, "already finalized");
        this.f3896h = true;
        synchronized (this.f3894f) {
            if (this.f3895g == null) {
                this.f3895g = uVar;
            }
        }
    }
}
