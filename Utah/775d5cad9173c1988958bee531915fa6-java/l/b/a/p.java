package l.b.a;

import java.io.InvalidObjectException;
import java.io.Serializable;
import l.b.a.u.h;
import l.b.a.v.m;
import l.b.a.w.c;
import l.b.a.x.a;
import l.b.a.x.b;
import l.b.a.x.d;
import l.b.a.x.e;
import l.b.a.x.f;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.n;
import l.b.a.x.o;

public final class p extends c implements d, f, Comparable<p>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f4383d = 0;
    public final int b;
    public final int c;

    static {
        l.b.a.v.d n = new l.b.a.v.d().n(a.YEAR, 4, 10, m.EXCEEDS_PAD);
        n.d('-');
        n.m(a.MONTH_OF_YEAR, 2);
        n.q();
    }

    public p(int i2, int i3) {
        this.b = i2;
        this.c = i3;
    }

    public static p q(e eVar) {
        if (eVar instanceof p) {
            return (p) eVar;
        }
        try {
            if (!l.b.a.u.m.f4408d.equals(h.l(eVar))) {
                eVar = f.E(eVar);
            }
            return s(eVar.b(a.YEAR), eVar.b(a.MONTH_OF_YEAR));
        } catch (b unused) {
            throw new b(f.a.a.a.a.f(eVar, f.a.a.a.a.k("Unable to obtain YearMonth from TemporalAccessor: ", eVar, ", type ")));
        }
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static p s(int i2, int i3) {
        a aVar = a.YEAR;
        aVar.f4506e.b((long) i2, aVar);
        a aVar2 = a.MONTH_OF_YEAR;
        aVar2.f4506e.b((long) i3, aVar2);
        return new p(i2, i3);
    }

    private Object writeReplace() {
        return new n((byte) 68, this);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public o a(j jVar) {
        if (jVar != a.YEAR_OF_ERA) {
            return super.a(jVar);
        }
        return o.d(1, this.b <= 0 ? 1000000000 : 999999999);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public int b(j jVar) {
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public <R> R c(l<R> lVar) {
        if (lVar == k.b) {
            return (R) l.b.a.u.m.f4408d;
        }
        if (lVar == k.c) {
            return (R) b.MONTHS;
        }
        if (lVar == k.f4524f || lVar == k.f4525g || lVar == k.f4522d || lVar == k.a || lVar == k.f4523e) {
            return null;
        }
        return (R) super.c(lVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(p pVar) {
        p pVar2 = pVar;
        int i2 = this.b - pVar2.b;
        return i2 == 0 ? this.c - pVar2.c : i2;
    }

    @Override // l.b.a.x.d
    public d e(f fVar) {
        return (p) fVar.n(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.b == pVar.b && this.c == pVar.c;
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return jVar instanceof a ? jVar == a.YEAR || jVar == a.MONTH_OF_YEAR || jVar == a.PROLEPTIC_MONTH || jVar == a.YEAR_OF_ERA || jVar == a.ERA : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.x.d
    public d h(long j2, l.b.a.x.m mVar) {
        return j2 == Long.MIN_VALUE ? m(Long.MAX_VALUE, mVar).m(1, mVar) : m(-j2, mVar);
    }

    public int hashCode() {
        return this.b ^ (this.c << 27);
    }

    @Override // l.b.a.x.e
    public long i(j jVar) {
        int i2;
        if (!(jVar instanceof a)) {
            return jVar.f(this);
        }
        int i3 = 1;
        switch (((a) jVar).ordinal()) {
            case 23:
                i2 = this.c;
                break;
            case 24:
                return r();
            case 25:
                int i4 = this.b;
                if (i4 < 1) {
                    i4 = 1 - i4;
                }
                return (long) i4;
            case 26:
                i2 = this.b;
                break;
            case 27:
                if (this.b < 1) {
                    i3 = 0;
                }
                return (long) i3;
            default:
                throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }
        return (long) i2;
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        if (h.l(dVar).equals(l.b.a.u.m.f4408d)) {
            return dVar.l(a.PROLEPTIC_MONTH, r());
        }
        throw new b("Adjustment only supported on ISO date-time");
    }

    @Override // l.b.a.x.d
    public long o(d dVar, l.b.a.x.m mVar) {
        p q = q(dVar);
        if (!(mVar instanceof b)) {
            return mVar.b(this, q);
        }
        long r = q.r() - r();
        switch (((b) mVar).ordinal()) {
            case 9:
                return r;
            case 10:
                return r / 12;
            case 11:
                return r / 120;
            case 12:
                return r / 1200;
            case 13:
                return r / 12000;
            case 14:
                a aVar = a.ERA;
                return q.i(aVar) - i(aVar);
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public final long r() {
        return (((long) this.b) * 12) + ((long) (this.c - 1));
    }

    /* renamed from: t */
    public p m(long j2, l.b.a.x.m mVar) {
        if (!(mVar instanceof b)) {
            return (p) mVar.c(this, j2);
        }
        switch (((b) mVar).ordinal()) {
            case 9:
                return u(j2);
            case 10:
                return v(j2);
            case 11:
                return v(g.b.a.c.c.d.x(j2, 10));
            case 12:
                return v(g.b.a.c.c.d.x(j2, 100));
            case 13:
                return v(g.b.a.c.c.d.x(j2, 1000));
            case 14:
                a aVar = a.ERA;
                return l(aVar, g.b.a.c.c.d.w(i(aVar), j2));
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public String toString() {
        int i2;
        int abs = Math.abs(this.b);
        StringBuilder sb = new StringBuilder(9);
        if (abs < 1000) {
            int i3 = this.b;
            if (i3 < 0) {
                sb.append(i3 - 10000);
                i2 = 1;
            } else {
                sb.append(i3 + 10000);
                i2 = 0;
            }
            sb.deleteCharAt(i2);
        } else {
            sb.append(this.b);
        }
        sb.append(this.c < 10 ? "-0" : "-");
        sb.append(this.c);
        return sb.toString();
    }

    public p u(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (((long) this.b) * 12) + ((long) (this.c - 1)) + j2;
        return w(a.YEAR.m(g.b.a.c.c.d.i(j3, 12)), g.b.a.c.c.d.k(j3, 12) + 1);
    }

    public p v(long j2) {
        return j2 == 0 ? this : w(a.YEAR.m(((long) this.b) + j2), this.c);
    }

    public final p w(int i2, int i3) {
        return (this.b == i2 && this.c == i3) ? this : new p(i2, i3);
    }

    /* renamed from: x */
    public p l(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return (p) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        aVar.f4506e.b(j2, aVar);
        switch (aVar.ordinal()) {
            case 23:
                int i2 = (int) j2;
                a aVar2 = a.MONTH_OF_YEAR;
                aVar2.f4506e.b((long) i2, aVar2);
                return w(this.b, i2);
            case 24:
                return u(j2 - i(a.PROLEPTIC_MONTH));
            case 25:
                if (this.b < 1) {
                    j2 = 1 - j2;
                }
                return y((int) j2);
            case 26:
                return y((int) j2);
            case 27:
                return i(a.ERA) == j2 ? this : y(1 - this.b);
            default:
                throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }
    }

    public p y(int i2) {
        a aVar = a.YEAR;
        aVar.f4506e.b((long) i2, aVar);
        return w(i2, this.c);
    }
}
