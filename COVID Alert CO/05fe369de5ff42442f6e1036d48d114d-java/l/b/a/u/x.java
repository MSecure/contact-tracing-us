package l.b.a.u;

import l.b.a.b;
import l.b.a.x.a;
import l.b.a.x.d;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.n;
import l.b.a.x.o;

public enum x implements i {
    BEFORE_BE,
    BE;

    public static x q(int i2) {
        if (i2 == 0) {
            return BEFORE_BE;
        }
        if (i2 == 1) {
            return BE;
        }
        throw new b("Era is not valid for ThaiBuddhistEra");
    }

    private Object writeReplace() {
        return new u((byte) 8, this);
    }

    @Override // l.b.a.x.e
    public o a(j jVar) {
        if (jVar == a.ERA) {
            return jVar.h();
        }
        if (!(jVar instanceof a)) {
            return jVar.l(this);
        }
        throw new n(f.a.a.a.a.e("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.e
    public int b(j jVar) {
        if (jVar == a.ERA) {
            return ordinal();
        }
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.x.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.c) {
            return (R) l.b.a.x.b.ERAS;
        }
        if (lVar == k.b || lVar == k.f4457d || lVar == k.a || lVar == k.f4458e || lVar == k.f4459f || lVar == k.f4460g) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return jVar instanceof a ? jVar == a.ERA : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.x.e
    public long i(j jVar) {
        if (jVar == a.ERA) {
            return (long) ordinal();
        }
        if (!(jVar instanceof a)) {
            return jVar.f(this);
        }
        throw new n(f.a.a.a.a.e("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        return dVar.l(a.ERA, (long) ordinal());
    }
}
