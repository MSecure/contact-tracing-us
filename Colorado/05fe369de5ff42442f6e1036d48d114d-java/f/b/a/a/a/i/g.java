package f.b.a.a.a.i;

import e.p.t;

public final /* synthetic */ class g implements t {
    public final /* synthetic */ a0 a;
    public final /* synthetic */ t b;

    public /* synthetic */ g(a0 a0Var, t tVar) {
        this.a = a0Var;
        this.b = tVar;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        a0 a0Var = this.a;
        t tVar = this.b;
        if (a0Var.f2148l.compareAndSet(true, false)) {
            tVar.a(obj);
        }
    }
}
