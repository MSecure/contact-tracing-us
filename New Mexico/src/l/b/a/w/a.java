package l.b.a.w;

import l.b.a.u.i;
import l.b.a.u.q;
import l.b.a.x.b;
import l.b.a.x.d;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.n;
/* loaded from: classes.dex */
public abstract class a extends c implements i {
    @Override // l.b.a.w.c, l.b.a.x.e
    public int b(j jVar) {
        if (jVar == l.b.a.x.a.ERA) {
            return ((q) this).b;
        }
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.w.c, l.b.a.x.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.c) {
            return (R) b.ERAS;
        }
        if (lVar == k.b || lVar == k.f4777d || lVar == k.a || lVar == k.f4778e || lVar == k.f4779f || lVar == k.f4780g) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return jVar instanceof l.b.a.x.a ? jVar == l.b.a.x.a.ERA : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.x.e
    public long i(j jVar) {
        if (jVar == l.b.a.x.a.ERA) {
            return (long) ((q) this).b;
        }
        if (!(jVar instanceof l.b.a.x.a)) {
            return jVar.f(this);
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        return dVar.l(l.b.a.x.a.ERA, (long) ((q) this).b);
    }
}
