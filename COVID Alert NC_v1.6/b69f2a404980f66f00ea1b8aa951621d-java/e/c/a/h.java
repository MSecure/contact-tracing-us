package e.c.a;

import c.a.a.a.a;
import e.c.a.t.m;
import e.c.a.w.b;
import e.c.a.w.d;
import e.c.a.w.e;
import e.c.a.w.f;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.n;
import e.c.a.w.o;

public enum h implements e, f {
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
    
    public static final h[] n = values();

    public static h w(int i) {
        if (i >= 1 && i <= 12) {
            return n[i - 1];
        }
        throw new a(a.l("Invalid value for MonthOfYear: ", i));
    }

    @Override // e.c.a.w.e
    public o b(j jVar) {
        if (jVar == e.c.a.w.a.MONTH_OF_YEAR) {
            return jVar.k();
        }
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.n(this);
        }
        throw new n(a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.w.e
    public int d(j jVar) {
        return jVar == e.c.a.w.a.MONTH_OF_YEAR ? t() : b(jVar).a(l(jVar), jVar);
    }

    @Override // e.c.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f5178b) {
            return (R) m.f5027d;
        }
        if (lVar == k.f5179c) {
            return (R) b.MONTHS;
        }
        if (lVar == k.f || lVar == k.g || lVar == k.f5180d || lVar == k.f5177a || lVar == k.f5181e) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof e.c.a.w.a ? jVar == e.c.a.w.a.MONTH_OF_YEAR : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        if (jVar == e.c.a.w.a.MONTH_OF_YEAR) {
            return (long) t();
        }
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.i(this);
        }
        throw new n(a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        if (e.c.a.t.h.n(dVar).equals(m.f5027d)) {
            return dVar.n(e.c.a.w.a.MONTH_OF_YEAR, (long) t());
        }
        throw new a("Adjustment only supported on ISO date-time");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int s(boolean z) {
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

    public int t() {
        return ordinal() + 1;
    }

    public int u(boolean z) {
        int ordinal = ordinal();
        return ordinal != 1 ? (ordinal == 3 || ordinal == 5 || ordinal == 8 || ordinal == 10) ? 30 : 31 : z ? 29 : 28;
    }

    public int v() {
        int ordinal = ordinal();
        if (ordinal != 1) {
            return (ordinal == 3 || ordinal == 5 || ordinal == 8 || ordinal == 10) ? 30 : 31;
        }
        return 29;
    }
}
