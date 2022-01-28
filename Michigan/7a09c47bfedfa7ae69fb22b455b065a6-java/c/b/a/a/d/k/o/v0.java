package c.b.a.a.d.k.o;

import c.b.a.a.d.c;
import c.b.a.a.d.k.o.g;
import c.b.a.a.d.k.o.k;
import c.b.a.a.j.j;

public final class v0 extends t0<Void> {

    /* renamed from: c  reason: collision with root package name */
    public final e0 f3055c;

    public v0(e0 e0Var, j<Void> jVar) {
        super(3, jVar);
        this.f3055c = e0Var;
    }

    @Override // c.b.a.a.d.k.o.g0
    public final /* bridge */ /* synthetic */ void c(e1 e1Var, boolean z) {
    }

    @Override // c.b.a.a.d.k.o.u
    public final c[] f(g.a<?> aVar) {
        return this.f3055c.f2970a.getRequiredFeatures();
    }

    @Override // c.b.a.a.d.k.o.u
    public final boolean g(g.a<?> aVar) {
        return this.f3055c.f2970a.zaa();
    }

    @Override // c.b.a.a.d.k.o.t0
    public final void h(g.a<?> aVar) {
        this.f3055c.f2970a.registerListener(aVar.f2984b, this.f3050b);
        k.a<?> listenerKey = this.f3055c.f2970a.getListenerKey();
        if (listenerKey != null) {
            aVar.f2988f.put(listenerKey, this.f3055c);
        }
    }
}
