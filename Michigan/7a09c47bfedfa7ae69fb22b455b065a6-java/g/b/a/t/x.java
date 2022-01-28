package g.b.a.t;

import g.b.a.a;
import g.b.a.w.b;
import g.b.a.w.d;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.n;
import g.b.a.w.o;

public enum x implements i {
    BEFORE_BE,
    BE;

    public static x p(int i) {
        if (i == 0) {
            return BEFORE_BE;
        }
        if (i == 1) {
            return BE;
        }
        throw new a("Era is not valid for ThaiBuddhistEra");
    }

    private Object writeReplace() {
        return new u((byte) 8, this);
    }

    @Override // g.b.a.w.e
    public o b(j jVar) {
        if (jVar == g.b.a.w.a.ERA) {
            return jVar.m();
        }
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.p(this);
        }
        throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // g.b.a.w.e
    public int d(j jVar) {
        if (jVar == g.b.a.w.a.ERA) {
            return ordinal();
        }
        return b(jVar).a(n(jVar), jVar);
    }

    @Override // g.b.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f6658c) {
            return (R) b.ERAS;
        }
        if (lVar == k.f6657b || lVar == k.f6659d || lVar == k.f6656a || lVar == k.f6660e || lVar == k.f6661f || lVar == k.f6662g) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar == g.b.a.w.a.ERA : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        if (jVar == g.b.a.w.a.ERA) {
            return (long) ordinal();
        }
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.k(this);
        }
        throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // g.b.a.w.f
    public d t(d dVar) {
        return dVar.r(g.b.a.w.a.ERA, (long) ordinal());
    }
}
