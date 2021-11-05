package e.c.a;

import c.a.a.a.a;
import e.c.a.w.d;
import e.c.a.w.e;
import e.c.a.w.f;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.n;
import e.c.a.w.o;

public enum b implements e, f {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    
    public static final b[] i = values();

    public static b t(int i2) {
        if (i2 >= 1 && i2 <= 7) {
            return i[i2 - 1];
        }
        throw new a(a.l("Invalid value for DayOfWeek: ", i2));
    }

    @Override // e.c.a.w.e
    public o b(j jVar) {
        if (jVar == e.c.a.w.a.DAY_OF_WEEK) {
            return jVar.k();
        }
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.n(this);
        }
        throw new n(a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.w.e
    public int d(j jVar) {
        return jVar == e.c.a.w.a.DAY_OF_WEEK ? s() : b(jVar).a(l(jVar), jVar);
    }

    @Override // e.c.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f5179c) {
            return (R) e.c.a.w.b.DAYS;
        }
        if (lVar == k.f || lVar == k.g || lVar == k.f5178b || lVar == k.f5180d || lVar == k.f5177a || lVar == k.f5181e) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof e.c.a.w.a ? jVar == e.c.a.w.a.DAY_OF_WEEK : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        if (jVar == e.c.a.w.a.DAY_OF_WEEK) {
            return (long) s();
        }
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.i(this);
        }
        throw new n(a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        return dVar.n(e.c.a.w.a.DAY_OF_WEEK, (long) s());
    }

    public int s() {
        return ordinal() + 1;
    }
}
