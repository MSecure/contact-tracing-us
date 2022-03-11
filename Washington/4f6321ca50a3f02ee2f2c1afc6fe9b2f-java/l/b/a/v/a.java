package l.b.a.v;

import l.b.a.t.i;
import l.b.a.t.q;
import l.b.a.w.b;
import l.b.a.w.d;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.n;

public abstract class a extends c implements i {
    @Override // l.b.a.v.c, l.b.a.w.e
    public int b(j jVar) {
        if (jVar == l.b.a.w.a.ERA) {
            return ((q) this).b;
        }
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.c) {
            return (R) b.ERAS;
        }
        if (lVar == k.b || lVar == k.f4206d || lVar == k.a || lVar == k.f4207e || lVar == k.f4208f || lVar == k.f4209g) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof l.b.a.w.a ? jVar == l.b.a.w.a.ERA : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        if (jVar == l.b.a.w.a.ERA) {
            return (long) ((q) this).b;
        }
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.f(this);
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.f
    public d n(d dVar) {
        return dVar.l(l.b.a.w.a.ERA, (long) ((q) this).b);
    }
}
