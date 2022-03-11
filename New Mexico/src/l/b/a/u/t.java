package l.b.a.u;

import f.a.a.a.a;
import l.b.a.b;
import l.b.a.x.d;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.n;
import l.b.a.x.o;
/* loaded from: classes.dex */
public enum t implements i {
    BEFORE_ROC,
    ROC;

    public static t q(int i2) {
        if (i2 == 0) {
            return BEFORE_ROC;
        }
        if (i2 == 1) {
            return ROC;
        }
        throw new b(a.u("Invalid era: ", i2));
    }

    private Object writeReplace() {
        return new u((byte) 6, this);
    }

    @Override // l.b.a.x.e
    public o a(j jVar) {
        if (jVar == l.b.a.x.a.ERA) {
            return jVar.h();
        }
        if (!(jVar instanceof l.b.a.x.a)) {
            return jVar.l(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.e
    public int b(j jVar) {
        if (jVar == l.b.a.x.a.ERA) {
            return ordinal();
        }
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.x.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.c) {
            return (R) l.b.a.x.b.ERAS;
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
            return (long) ordinal();
        }
        if (!(jVar instanceof l.b.a.x.a)) {
            return jVar.f(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        return dVar.l(l.b.a.x.a.ERA, (long) ordinal());
    }
}
