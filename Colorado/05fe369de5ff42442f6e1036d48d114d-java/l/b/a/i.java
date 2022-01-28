package l.b.a;

import f.a.a.a.a;
import l.b.a.u.h;
import l.b.a.u.m;
import l.b.a.x.b;
import l.b.a.x.d;
import l.b.a.x.e;
import l.b.a.x.f;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.n;
import l.b.a.x.o;

public enum i implements e, f {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
    
    public static final i[] n = values();

    public static i u(int i2) {
        if (i2 >= 1 && i2 <= 12) {
            return n[i2 - 1];
        }
        throw new b(a.v("Invalid value for MonthOfYear: ", i2));
    }

    @Override // l.b.a.x.e
    public o a(j jVar) {
        if (jVar == l.b.a.x.a.MONTH_OF_YEAR) {
            return jVar.h();
        }
        if (!(jVar instanceof l.b.a.x.a)) {
            return jVar.l(this);
        }
        throw new n(a.e("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.e
    public int b(j jVar) {
        return jVar == l.b.a.x.a.MONTH_OF_YEAR ? r() : a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.x.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.b) {
            return (R) m.f4343d;
        }
        if (lVar == k.c) {
            return (R) b.MONTHS;
        }
        if (lVar == k.f4459f || lVar == k.f4460g || lVar == k.f4457d || lVar == k.a || lVar == k.f4458e) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return jVar instanceof l.b.a.x.a ? jVar == l.b.a.x.a.MONTH_OF_YEAR : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.x.e
    public long i(j jVar) {
        if (jVar == l.b.a.x.a.MONTH_OF_YEAR) {
            return (long) r();
        }
        if (!(jVar instanceof l.b.a.x.a)) {
            return jVar.f(this);
        }
        throw new n(a.e("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        if (h.l(dVar).equals(m.f4343d)) {
            return dVar.l(l.b.a.x.a.MONTH_OF_YEAR, (long) r());
        }
        throw new b("Adjustment only supported on ISO date-time");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int q(boolean z) {
        switch (ordinal()) {
            case 0:
                return 1;
            case 1:
                return 32;
            case 2:
                return z + 60;
            case 3:
                return (z ? 1 : 0) + 91;
            case 4:
                return z + 121;
            case 5:
                return z + 152;
            case 6:
                return z + 182;
            case 7:
                return z + 213;
            case 8:
                return z + 244;
            case 9:
                return z + 274;
            case 10:
                return z + 305;
            default:
                return z + 335;
        }
    }

    public int r() {
        return ordinal() + 1;
    }

    public int s(boolean z) {
        int ordinal = ordinal();
        return ordinal != 1 ? (ordinal == 3 || ordinal == 5 || ordinal == 8 || ordinal == 10) ? 30 : 31 : z ? 29 : 28;
    }

    public int t() {
        int ordinal = ordinal();
        if (ordinal != 1) {
            return (ordinal == 3 || ordinal == 5 || ordinal == 8 || ordinal == 10) ? 30 : 31;
        }
        return 29;
    }
}
