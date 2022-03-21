package l.b.a;

import f.a.a.a.a;
import l.b.a.w.d;
import l.b.a.w.e;
import l.b.a.w.f;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.n;
import l.b.a.w.o;

public enum b implements e, f {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    

    /* renamed from: i  reason: collision with root package name */
    public static final b[] f4037i = values();

    public static b r(int i2) {
        if (i2 >= 1 && i2 <= 7) {
            return f4037i[i2 - 1];
        }
        throw new a(a.q("Invalid value for DayOfWeek: ", i2));
    }

    @Override // l.b.a.w.e
    public o a(j jVar) {
        if (jVar == l.b.a.w.a.DAY_OF_WEEK) {
            return jVar.h();
        }
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.l(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.e
    public int b(j jVar) {
        return jVar == l.b.a.w.a.DAY_OF_WEEK ? q() : a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.c) {
            return (R) l.b.a.w.b.DAYS;
        }
        if (lVar == k.f4208f || lVar == k.f4209g || lVar == k.b || lVar == k.f4206d || lVar == k.a || lVar == k.f4207e) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof l.b.a.w.a ? jVar == l.b.a.w.a.DAY_OF_WEEK : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        if (jVar == l.b.a.w.a.DAY_OF_WEEK) {
            return (long) q();
        }
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.f(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.f
    public d n(d dVar) {
        return dVar.l(l.b.a.w.a.DAY_OF_WEEK, (long) q());
    }

    public int q() {
        return ordinal() + 1;
    }
}
