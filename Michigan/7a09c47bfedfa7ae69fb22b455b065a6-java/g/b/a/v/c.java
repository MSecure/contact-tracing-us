package g.b.a.v;

import g.b.a.w.a;
import g.b.a.w.e;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.n;
import g.b.a.w.o;

public abstract class c implements e {
    @Override // g.b.a.w.e
    public o b(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.p(this);
        }
        if (k(jVar)) {
            return jVar.m();
        }
        throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // g.b.a.w.e
    public int d(j jVar) {
        return b(jVar).a(n(jVar), jVar);
    }

    @Override // g.b.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f6656a || lVar == k.f6657b || lVar == k.f6658c) {
            return null;
        }
        return lVar.a(this);
    }
}
