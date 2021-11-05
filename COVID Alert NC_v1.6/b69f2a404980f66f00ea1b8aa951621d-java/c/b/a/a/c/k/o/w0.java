package c.b.a.a.c.k.o;

import c.b.a.a.c.c;
import c.b.a.a.c.k.o.g;
import c.b.a.a.g.i;

public final class w0 extends j0<Void> {

    /* renamed from: c  reason: collision with root package name */
    public final i0 f2406c;

    public w0(i0 i0Var, i<Void> iVar) {
        super(3, iVar);
        this.f2406c = i0Var;
    }

    @Override // c.b.a.a.c.k.o.y
    public final /* bridge */ /* synthetic */ void c(t tVar, boolean z) {
    }

    @Override // c.b.a.a.c.k.o.v0
    public final c[] f(g.a<?> aVar) {
        return this.f2406c.f2364a.getRequiredFeatures();
    }

    @Override // c.b.a.a.c.k.o.v0
    public final boolean g(g.a<?> aVar) {
        return this.f2406c.f2364a.shouldAutoResolveMissingFeatures();
    }

    @Override // c.b.a.a.c.k.o.j0
    public final void h(g.a<?> aVar) {
        this.f2406c.f2364a.registerListener(aVar.f2342b, this.f2371b);
        if (this.f2406c.f2364a.getListenerKey() != null) {
            aVar.g.put(this.f2406c.f2364a.getListenerKey(), this.f2406c);
        }
    }
}
