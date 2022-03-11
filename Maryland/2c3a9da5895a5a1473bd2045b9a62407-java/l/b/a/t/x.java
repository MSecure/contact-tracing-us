package l.b.a.t;

import l.b.a.a;
import l.b.a.w.b;
import l.b.a.w.d;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.n;
import l.b.a.w.o;

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
        throw new a("Era is not valid for ThaiBuddhistEra");
    }

    private Object writeReplace() {
        return new u((byte) 8, this);
    }

    @Override // l.b.a.w.e
    public o a(j jVar) {
        if (jVar == l.b.a.w.a.ERA) {
            return jVar.h();
        }
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.l(this);
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.e
    public int b(j jVar) {
        if (jVar == l.b.a.w.a.ERA) {
            return ordinal();
        }
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.c) {
            return (R) b.ERAS;
        }
        if (lVar == k.b || lVar == k.f4302d || lVar == k.a || lVar == k.f4303e || lVar == k.f4304f || lVar == k.f4305g) {
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
            return (long) ordinal();
        }
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.f(this);
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.f
    public d n(d dVar) {
        return dVar.l(l.b.a.w.a.ERA, (long) ordinal());
    }
}
