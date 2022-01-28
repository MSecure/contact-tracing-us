package h.a.j1;

import f.b.a.c.b.o.b;
import h.a.c1;
import h.a.j1.v;
import h.a.n0;

public final class i0 extends c2 {
    public boolean b;
    public final c1 c;

    /* renamed from: d  reason: collision with root package name */
    public final v.a f3879d;

    public i0(c1 c1Var) {
        v.a aVar = v.a.PROCESSED;
        b.o(!c1Var.e(), "error must not be OK");
        this.c = c1Var;
        this.f3879d = aVar;
    }

    public i0(c1 c1Var, v.a aVar) {
        b.o(!c1Var.e(), "error must not be OK");
        this.c = c1Var;
        this.f3879d = aVar;
    }

    @Override // h.a.j1.c2, h.a.j1.u
    public void i(v vVar) {
        b.F(!this.b, "already started");
        this.b = true;
        vVar.d(this.c, this.f3879d, new n0());
    }

    @Override // h.a.j1.c2, h.a.j1.u
    public void k(y0 y0Var) {
        y0Var.b("error", this.c);
        y0Var.b("progress", this.f3879d);
    }
}
