package e.c.a.v;

import e.c.a.t.i;
import e.c.a.t.q;
import e.c.a.w.b;
import e.c.a.w.d;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.n;

public abstract class a extends c implements i {
    @Override // e.c.a.v.c, e.c.a.w.e
    public int d(j jVar) {
        if (jVar == e.c.a.w.a.ERA) {
            return ((q) this).f5038b;
        }
        return b(jVar).a(l(jVar), jVar);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
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
        return jVar instanceof e.c.a.w.a ? jVar == e.c.a.w.a.ERA : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        if (jVar == e.c.a.w.a.ERA) {
            return (long) ((q) this).f5038b;
        }
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.i(this);
        }
        throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        return dVar.n(e.c.a.w.a.ERA, (long) ((q) this).f5038b);
    }
}
