package c.b.a.a.c.k.o;

import c.b.a.a.c.c;
import c.b.a.a.c.k.o.g;
import c.b.a.a.c.k.o.k;
import c.b.a.a.g.a0;
import c.b.a.a.g.i;

public final class y0 extends j0<Boolean> {

    /* renamed from: c  reason: collision with root package name */
    public final k.a<?> f2411c;

    public y0(k.a<?> aVar, i<Boolean> iVar) {
        super(4, iVar);
        this.f2411c = aVar;
    }

    @Override // c.b.a.a.c.k.o.y
    public final /* bridge */ /* synthetic */ void c(t tVar, boolean z) {
    }

    @Override // c.b.a.a.c.k.o.v0
    public final c[] f(g.a<?> aVar) {
        i0 i0Var = aVar.g.get(this.f2411c);
        if (i0Var == null) {
            return null;
        }
        return i0Var.f2364a.getRequiredFeatures();
    }

    @Override // c.b.a.a.c.k.o.v0
    public final boolean g(g.a<?> aVar) {
        i0 i0Var = aVar.g.get(this.f2411c);
        return i0Var != null && i0Var.f2364a.shouldAutoResolveMissingFeatures();
    }

    @Override // c.b.a.a.c.k.o.j0
    public final void h(g.a<?> aVar) {
        i0 remove = aVar.g.remove(this.f2411c);
        if (remove != null) {
            remove.f2365b.unregisterListener(aVar.f2342b, this.f2371b);
            remove.f2364a.clearListener();
            return;
        }
        i<T> iVar = this.f2371b;
        TResult tresult = (TResult) Boolean.FALSE;
        a0<TResult> a0Var = iVar.f2856a;
        synchronized (a0Var.f2849a) {
            if (!a0Var.f2851c) {
                a0Var.f2851c = true;
                a0Var.f2853e = tresult;
                a0Var.f2850b.a(a0Var);
            }
        }
    }
}
