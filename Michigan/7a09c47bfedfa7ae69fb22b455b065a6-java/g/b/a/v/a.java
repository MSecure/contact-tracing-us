package g.b.a.v;

import g.b.a.t.i;
import g.b.a.t.q;
import g.b.a.w.b;
import g.b.a.w.d;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.n;

public abstract class a extends c implements i {
    @Override // g.b.a.w.e, g.b.a.v.c
    public int d(j jVar) {
        if (jVar == g.b.a.w.a.ERA) {
            return ((q) this).f6491b;
        }
        return b(jVar).a(n(jVar), jVar);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        if (lVar == k.f6658c) {
            return (R) b.ERAS;
        }
        if (lVar == k.f6657b || lVar == k.f6659d || lVar == k.f6656a || lVar == k.f6660e || lVar == k.f6661f || lVar == k.f6662g) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar == g.b.a.w.a.ERA : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        if (jVar == g.b.a.w.a.ERA) {
            return (long) ((q) this).f6491b;
        }
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.k(this);
        }
        throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // g.b.a.w.f
    public d t(d dVar) {
        return dVar.r(g.b.a.w.a.ERA, (long) ((q) this).f6491b);
    }
}
