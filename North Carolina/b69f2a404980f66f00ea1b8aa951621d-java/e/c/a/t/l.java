package e.c.a.t;

import e.c.a.a;
import e.c.a.w.b;
import e.c.a.w.d;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.n;
import e.c.a.w.o;

public enum l implements i {
    BEFORE_AH,
    AH;

    public static l s(int i) {
        if (i == 0) {
            return BEFORE_AH;
        }
        if (i == 1) {
            return AH;
        }
        throw new a("HijrahEra not valid");
    }

    private Object writeReplace() {
        return new u((byte) 4, this);
    }

    @Override // e.c.a.w.e
    public o b(j jVar) {
        if (jVar == e.c.a.w.a.ERA) {
            return o.d(1, 1);
        }
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.n(this);
        }
        throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.w.e
    public int d(j jVar) {
        if (jVar == e.c.a.w.a.ERA) {
            return ordinal();
        }
        return b(jVar).a(l(jVar), jVar);
    }

    @Override // e.c.a.w.e
    public <R> R f(e.c.a.w.l<R> lVar) {
        if (lVar == k.f5179c) {
            return (R) b.ERAS;
        }
        if (lVar == k.f5178b || lVar == k.f5180d || lVar == k.f5177a || lVar == k.f5181e || lVar == k.f || lVar == k.g) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof e.c.a.w.a ? jVar == e.c.a.w.a.ERA : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        if (jVar == e.c.a.w.a.ERA) {
            return (long) ordinal();
        }
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.i(this);
        }
        throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        return dVar.n(e.c.a.w.a.ERA, (long) ordinal());
    }
}
