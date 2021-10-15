package c.b.a.a.d.k.o;

import c.b.a.a.d.c;
import c.b.a.a.d.k.o.g;
import c.b.a.a.d.k.o.k;
import c.b.a.a.j.b0;
import c.b.a.a.j.j;

public final class w0 extends t0<Boolean> {

    /* renamed from: c  reason: collision with root package name */
    public final k.a<?> f3058c;

    public w0(k.a<?> aVar, j<Boolean> jVar) {
        super(4, jVar);
        this.f3058c = aVar;
    }

    @Override // c.b.a.a.d.k.o.g0
    public final /* bridge */ /* synthetic */ void c(e1 e1Var, boolean z) {
    }

    @Override // c.b.a.a.d.k.o.u
    public final c[] f(g.a<?> aVar) {
        e0 e0Var = aVar.f2988f.get(this.f3058c);
        if (e0Var == null) {
            return null;
        }
        return e0Var.f2970a.getRequiredFeatures();
    }

    @Override // c.b.a.a.d.k.o.u
    public final boolean g(g.a<?> aVar) {
        e0 e0Var = aVar.f2988f.get(this.f3058c);
        return e0Var != null && e0Var.f2970a.zaa();
    }

    @Override // c.b.a.a.d.k.o.t0
    public final void h(g.a<?> aVar) {
        e0 remove = aVar.f2988f.remove(this.f3058c);
        if (remove != null) {
            remove.f2971b.unregisterListener(aVar.f2984b, this.f3050b);
            remove.f2970a.clearListener();
            return;
        }
        j<T> jVar = this.f3050b;
        TResult tresult = (TResult) Boolean.FALSE;
        b0<TResult> b0Var = jVar.f4109a;
        synchronized (b0Var.f4101a) {
            if (!b0Var.f4103c) {
                b0Var.f4103c = true;
                b0Var.f4105e = tresult;
                b0Var.f4102b.a(b0Var);
            }
        }
    }
}
