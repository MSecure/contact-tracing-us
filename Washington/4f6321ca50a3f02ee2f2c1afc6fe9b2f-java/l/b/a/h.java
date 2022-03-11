package l.b.a;

import f.a.a.a.a;
import l.b.a.t.m;
import l.b.a.w.b;
import l.b.a.w.d;
import l.b.a.w.e;
import l.b.a.w.f;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.n;
import l.b.a.w.o;

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

    public static h u(int i2) {
        if (i2 >= 1 && i2 <= 12) {
            return n[i2 - 1];
        }
        throw new a(a.q("Invalid value for MonthOfYear: ", i2));
    }

    @Override // l.b.a.w.e
    public o a(j jVar) {
        if (jVar == l.b.a.w.a.MONTH_OF_YEAR) {
            return jVar.h();
        }
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.l(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.e
    public int b(j jVar) {
        return jVar == l.b.a.w.a.MONTH_OF_YEAR ? r() : a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.b) {
            return (R) m.f4092d;
        }
        if (lVar == k.c) {
            return (R) b.MONTHS;
        }
        if (lVar == k.f4208f || lVar == k.f4209g || lVar == k.f4206d || lVar == k.a || lVar == k.f4207e) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof l.b.a.w.a ? jVar == l.b.a.w.a.MONTH_OF_YEAR : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        if (jVar == l.b.a.w.a.MONTH_OF_YEAR) {
            return (long) r();
        }
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.f(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.f
    public d n(d dVar) {
        if (l.b.a.t.h.l(dVar).equals(m.f4092d)) {
            return dVar.l(l.b.a.w.a.MONTH_OF_YEAR, (long) r());
        }
        throw new a("Adjustment only supported on ISO date-time");
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
