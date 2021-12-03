package l.b.a.u;

import l.b.a.b;
import l.b.a.x.a;
import l.b.a.x.d;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.n;
import l.b.a.x.o;

public enum l implements i {
    BEFORE_AH,
    AH;

    public static l q(int i2) {
        if (i2 == 0) {
            return BEFORE_AH;
        }
        if (i2 == 1) {
            return AH;
        }
        throw new b("HijrahEra not valid");
    }

    private Object writeReplace() {
        return new u((byte) 4, this);
    }

    @Override // l.b.a.x.e
    public o a(j jVar) {
        if (jVar == a.ERA) {
            return o.d(1, 1);
        }
        if (!(jVar instanceof a)) {
            return jVar.l(this);
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.e
    public int b(j jVar) {
        if (jVar == a.ERA) {
            return ordinal();
        }
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.x.e
    public <R> R c(l.b.a.x.l<R> lVar) {
        if (lVar == k.c) {
            return (R) l.b.a.x.b.ERAS;
        }
        if (lVar == k.b || lVar == k.f4522d || lVar == k.a || lVar == k.f4523e || lVar == k.f4524f || lVar == k.f4525g) {
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
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        return dVar.l(a.ERA, (long) ordinal());
    }
}
