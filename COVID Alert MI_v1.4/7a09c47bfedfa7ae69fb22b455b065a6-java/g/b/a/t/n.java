package g.b.a.t;

import g.b.a.w.a;
import g.b.a.w.b;
import g.b.a.w.d;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.o;

public enum n implements i {
    BCE,
    CE;

    @Override // g.b.a.w.e
    public o b(j jVar) {
        if (jVar == a.ERA) {
            return jVar.m();
        }
        if (!(jVar instanceof a)) {
            return jVar.p(this);
        }
        throw new g.b.a.w.n(c.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // g.b.a.w.e
    public int d(j jVar) {
        if (jVar == a.ERA) {
            return ordinal();
        }
        return b(jVar).a(n(jVar), jVar);
    }

    @Override // g.b.a.w.e
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
        return jVar instanceof a ? jVar == a.ERA : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        if (jVar == a.ERA) {
            return (long) ordinal();
        }
        if (!(jVar instanceof a)) {
            return jVar.k(this);
        }
        throw new g.b.a.w.n(c.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // g.b.a.w.f
    public d t(d dVar) {
        return dVar.r(a.ERA, (long) ordinal());
    }
}
