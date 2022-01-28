package e.c.a.t;

import e.c.a.w.a;
import e.c.a.w.b;
import e.c.a.w.d;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.o;

public enum n implements i {
    BCE,
    CE;

    @Override // e.c.a.w.e
    public o b(j jVar) {
        if (jVar == a.ERA) {
            return jVar.k();
        }
        if (!(jVar instanceof a)) {
            return jVar.n(this);
        }
        throw new e.c.a.w.n(c.a.a.a.a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.w.e
    public int d(j jVar) {
        if (jVar == a.ERA) {
            return ordinal();
        }
        return b(jVar).a(l(jVar), jVar);
    }

    @Override // e.c.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f5179c) {
            return (R) b.ERAS;
        }
        if (lVar == k.f5178b || lVar == k.f5180d || lVar == k.f5177a || lVar == k.f5181e || lVar == k.f || lVar == k.g) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof a ? jVar == a.ERA : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        if (jVar == a.ERA) {
            return (long) ordinal();
        }
        if (!(jVar instanceof a)) {
            return jVar.i(this);
        }
        throw new e.c.a.w.n(c.a.a.a.a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        return dVar.n(a.ERA, (long) ordinal());
    }
}
