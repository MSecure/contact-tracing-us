package g.b.a;

import c.a.a.a.a;
import g.b.a.t.m;
import g.b.a.w.b;
import g.b.a.w.d;
import g.b.a.w.e;
import g.b.a.w.f;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.n;
import g.b.a.w.o;

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

    public static h D(int i) {
        if (i >= 1 && i <= 12) {
            return n[i - 1];
        }
        throw new a(a.n("Invalid value for MonthOfYear: ", i));
    }

    public int A(boolean z) {
        int ordinal = ordinal();
        return ordinal != 1 ? (ordinal == 3 || ordinal == 5 || ordinal == 8 || ordinal == 10) ? 30 : 31 : z ? 29 : 28;
    }

    public int B() {
        int ordinal = ordinal();
        if (ordinal != 1) {
            return (ordinal == 3 || ordinal == 5 || ordinal == 8 || ordinal == 10) ? 30 : 31;
        }
        return 29;
    }

    @Override // g.b.a.w.e
    public o b(j jVar) {
        if (jVar == g.b.a.w.a.MONTH_OF_YEAR) {
            return jVar.m();
        }
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.p(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    @Override // g.b.a.w.e
    public int d(j jVar) {
        return jVar == g.b.a.w.a.MONTH_OF_YEAR ? x() : b(jVar).a(n(jVar), jVar);
    }

    @Override // g.b.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f6657b) {
            return (R) m.f6476d;
        }
        if (lVar == k.f6658c) {
            return (R) b.MONTHS;
        }
        if (lVar == k.f6661f || lVar == k.f6662g || lVar == k.f6659d || lVar == k.f6656a || lVar == k.f6660e) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar == g.b.a.w.a.MONTH_OF_YEAR : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        if (jVar == g.b.a.w.a.MONTH_OF_YEAR) {
            return (long) x();
        }
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.k(this);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int p(boolean z) {
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

    @Override // g.b.a.w.f
    public d t(d dVar) {
        if (g.b.a.t.h.p(dVar).equals(m.f6476d)) {
            return dVar.r(g.b.a.w.a.MONTH_OF_YEAR, (long) x());
        }
        throw new a("Adjustment only supported on ISO date-time");
    }

    public int x() {
        return ordinal() + 1;
    }
}
