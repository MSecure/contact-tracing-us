package l.b.a.t;

import l.b.a.w.a;
import l.b.a.w.b;
import l.b.a.w.d;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.o;

public enum n implements i {
    BCE,
    CE;

    @Override // l.b.a.w.e
    public o a(j jVar) {
        if (jVar == a.ERA) {
            return jVar.h();
        }
        if (!(jVar instanceof a)) {
            return jVar.l(this);
        }
        throw new l.b.a.w.n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.e
    public int b(j jVar) {
        if (jVar == a.ERA) {
            return ordinal();
        }
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.c) {
            return (R) b.ERAS;
        }
        if (lVar == k.b || lVar == k.f4198d || lVar == k.a || lVar == k.f4199e || lVar == k.f4200f || lVar == k.f4201g) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof a ? jVar == a.ERA : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        if (jVar == a.ERA) {
            return (long) ordinal();
        }
        if (!(jVar instanceof a)) {
            return jVar.f(this);
        }
        throw new l.b.a.w.n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.f
    public d n(d dVar) {
        return dVar.l(a.ERA, (long) ordinal());
    }
}
