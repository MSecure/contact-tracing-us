package l.b.a.v;

import l.b.a.w.a;
import l.b.a.w.e;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.n;
import l.b.a.w.o;

public abstract class c implements e {
    @Override // l.b.a.w.e
    public o a(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.l(this);
        }
        if (f(jVar)) {
            return jVar.h();
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.e
    public int b(j jVar) {
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.a || lVar == k.b || lVar == k.c) {
            return null;
        }
        return lVar.a(this);
    }
}
