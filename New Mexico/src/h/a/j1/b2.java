package h.a.j1;

import h.a.b;
import h.a.c;
import h.a.c1;
import h.a.n0;
import h.a.o0;
import h.a.q;
/* loaded from: classes.dex */
public final class b2 extends b.a {
    public final w a;
    public final o0<?, ?> b;
    public final n0 c;

    /* renamed from: d  reason: collision with root package name */
    public final c f4147d;

    /* renamed from: g  reason: collision with root package name */
    public u f4150g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4151h;

    /* renamed from: i  reason: collision with root package name */
    public e0 f4152i;

    /* renamed from: f  reason: collision with root package name */
    public final Object f4149f = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final q f4148e = q.L();

    public b2(w wVar, o0<?, ?> o0Var, n0 n0Var, c cVar) {
        this.a = wVar;
        this.b = o0Var;
        this.c = n0Var;
        this.f4147d = cVar;
    }

    /* JADX WARN: Finally extract failed */
    @Override // h.a.b.a
    public void a(n0 n0Var) {
        f.b.a.c.b.o.b.G(!this.f4151h, "apply() or fail() already called");
        f.b.a.c.b.o.b.A(n0Var, "headers");
        this.c.f(n0Var);
        q d2 = this.f4148e.d();
        try {
            u g2 = this.a.g(this.b, this.c, this.f4147d);
            this.f4148e.Q(d2);
            c(g2);
        } catch (Throwable th) {
            this.f4148e.Q(d2);
            throw th;
        }
    }

    @Override // h.a.b.a
    public void b(c1 c1Var) {
        f.b.a.c.b.o.b.p(!c1Var.e(), "Cannot fail with OK status");
        f.b.a.c.b.o.b.G(!this.f4151h, "apply() or fail() already called");
        c(new i0(c1Var));
    }

    public final void c(u uVar) {
        boolean z = true;
        f.b.a.c.b.o.b.G(!this.f4151h, "already finalized");
        this.f4151h = true;
        synchronized (this.f4149f) {
            if (this.f4150g == null) {
                this.f4150g = uVar;
                return;
            }
            if (this.f4152i == null) {
                z = false;
            }
            f.b.a.c.b.o.b.G(z, "delayedStream is null");
            this.f4152i.q(uVar);
        }
    }
}
