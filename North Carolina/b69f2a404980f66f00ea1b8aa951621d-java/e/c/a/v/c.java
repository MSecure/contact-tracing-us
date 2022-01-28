package e.c.a.v;

import e.c.a.w.a;
import e.c.a.w.e;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.n;
import e.c.a.w.o;

public abstract class c implements e {
    @Override // e.c.a.w.e
    public o b(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.n(this);
        }
        if (i(jVar)) {
            return jVar.k();
        }
        throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.w.e
    public int d(j jVar) {
        return b(jVar).a(l(jVar), jVar);
    }

    @Override // e.c.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f5177a || lVar == k.f5178b || lVar == k.f5179c) {
            return null;
        }
        return lVar.a(this);
    }
}
