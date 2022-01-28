package g.b.a;

import c.a.a.a.a;
import g.b.a.w.d;
import g.b.a.w.e;
import g.b.a.w.f;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.n;
import g.b.a.w.o;

public enum b implements e, f {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    
    public static final b[] i = values();

    public static b x(int i2) {
        if (i2 >= 1 && i2 <= 7) {
            return i[i2 - 1];
        }
        throw new a(a.n("Invalid value for DayOfWeek: ", i2));
    }

    @Override // g.b.a.w.e
    public o b(j jVar) {
        if (jVar == g.b.a.w.a.DAY_OF_WEEK) {
            return jVar.m();
        }
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.p(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    @Override // g.b.a.w.e
    public int d(j jVar) {
        return jVar == g.b.a.w.a.DAY_OF_WEEK ? p() : b(jVar).a(n(jVar), jVar);
    }

    @Override // g.b.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f6658c) {
            return (R) g.b.a.w.b.DAYS;
        }
        if (lVar == k.f6661f || lVar == k.f6662g || lVar == k.f6657b || lVar == k.f6659d || lVar == k.f6656a || lVar == k.f6660e) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar == g.b.a.w.a.DAY_OF_WEEK : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        if (jVar == g.b.a.w.a.DAY_OF_WEEK) {
            return (long) p();
        }
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.k(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    public int p() {
        return ordinal() + 1;
    }

    @Override // g.b.a.w.f
    public d t(d dVar) {
        return dVar.r(g.b.a.w.a.DAY_OF_WEEK, (long) p());
    }
}
