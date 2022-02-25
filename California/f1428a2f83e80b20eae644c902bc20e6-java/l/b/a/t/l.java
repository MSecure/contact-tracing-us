package l.b.a.t;

import l.b.a.a;
import l.b.a.w.b;
import l.b.a.w.d;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.n;
import l.b.a.w.o;

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
        throw new a("HijrahEra not valid");
    }

    private Object writeReplace() {
        return new u((byte) 4, this);
    }

    @Override // l.b.a.w.e
    public o a(j jVar) {
        if (jVar == l.b.a.w.a.ERA) {
            return o.d(1, 1);
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
    public <R> R c(l.b.a.w.l<R> lVar) {
        if (lVar == k.c) {
            return (R) b.ERAS;
        }
        if (lVar == k.b || lVar == k.f4198d || lVar == k.a || lVar == k.f4199e || lVar == k.f4200f || lVar == k.f4201g) {
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
