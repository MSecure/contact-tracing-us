package l.b.a;

import f.a.a.a.a;
import l.b.a.x.b;
import l.b.a.x.d;
import l.b.a.x.e;
import l.b.a.x.f;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.n;
import l.b.a.x.o;

public enum c implements e, f {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    

    /* renamed from: i  reason: collision with root package name */
    public static final c[] f4353i = values();

    public static c r(int i2) {
        if (i2 >= 1 && i2 <= 7) {
            return f4353i[i2 - 1];
        }
        throw new b(a.t("Invalid value for DayOfWeek: ", i2));
    }

    @Override // l.b.a.x.e
    public o a(j jVar) {
        if (jVar == l.b.a.x.a.DAY_OF_WEEK) {
            return jVar.h();
        }
        if (!(jVar instanceof l.b.a.x.a)) {
            return jVar.l(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.e
    public int b(j jVar) {
        return jVar == l.b.a.x.a.DAY_OF_WEEK ? q() : a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.x.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.c) {
            return (R) b.DAYS;
        }
        if (lVar == k.f4524f || lVar == k.f4525g || lVar == k.b || lVar == k.f4522d || lVar == k.a || lVar == k.f4523e) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return jVar instanceof l.b.a.x.a ? jVar == l.b.a.x.a.DAY_OF_WEEK : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.x.e
    public long i(j jVar) {
        if (jVar == l.b.a.x.a.DAY_OF_WEEK) {
            return (long) q();
        }
        if (!(jVar instanceof l.b.a.x.a)) {
            return jVar.f(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        return dVar.l(l.b.a.x.a.DAY_OF_WEEK, (long) q());
    }

    public int q() {
        return ordinal() + 1;
    }
}
