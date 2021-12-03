package l.b.a.w;

import l.b.a.x.a;
import l.b.a.x.e;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.n;
import l.b.a.x.o;

public abstract class c implements e {
    @Override // l.b.a.x.e
    public o a(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.l(this);
        }
        if (f(jVar)) {
            return jVar.h();
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.e
    public int b(j jVar) {
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.x.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.a || lVar == k.b || lVar == k.c) {
            return null;
        }
        return lVar.a(this);
    }
}
