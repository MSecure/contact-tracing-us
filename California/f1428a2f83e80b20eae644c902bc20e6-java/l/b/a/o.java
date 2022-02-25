package l.b.a;

import java.io.InvalidObjectException;
import java.io.Serializable;
import l.b.a.t.h;
import l.b.a.u.m;
import l.b.a.v.c;
import l.b.a.w.a;
import l.b.a.w.b;
import l.b.a.w.d;
import l.b.a.w.e;
import l.b.a.w.f;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.n;

public final class o extends c implements d, f, Comparable<o>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f4059d = 0;
    public final int b;
    public final int c;

    static {
        l.b.a.u.d n = new l.b.a.u.d().n(a.YEAR, 4, 10, m.EXCEEDS_PAD);
        n.d('-');
        n.m(a.MONTH_OF_YEAR, 2);
        n.q();
    }

    public o(int i2, int i3) {
        this.b = i2;
        this.c = i3;
    }

    public static o q(e eVar) {
        if (eVar instanceof o) {
            return (o) eVar;
        }
        try {
            if (!l.b.a.t.m.f4084d.equals(h.l(eVar))) {
                eVar = e.E(eVar);
            }
            return s(eVar.b(a.YEAR), eVar.b(a.MONTH_OF_YEAR));
        } catch (a unused) {
            throw new a(f.a.a.a.a.f(eVar, f.a.a.a.a.k("Unable to obtain YearMonth from TemporalAccessor: ", eVar, ", type ")));
        }
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static o s(int i2, int i3) {
        a aVar = a.YEAR;
        aVar.f4182e.b((long) i2, aVar);
        a aVar2 = a.MONTH_OF_YEAR;
        aVar2.f4182e.b((long) i3, aVar2);
        return new o(i2, i3);
    }

    private Object writeReplace() {
        return new m((byte) 68, this);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public l.b.a.w.o a(j jVar) {
        if (jVar != a.YEAR_OF_ERA) {
            return super.a(jVar);
        }
        return l.b.a.w.o.d(1, this.b <= 0 ? 1000000000 : 999999999);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public int b(j jVar) {
        return a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.b) {
            return (R) l.b.a.t.m.f4084d;
        }
        if (lVar == k.c) {
            return (R) b.MONTHS;
        }
        if (lVar == k.f4200f || lVar == k.f4201g || lVar == k.f4198d || lVar == k.a || lVar == k.f4199e) {
            return null;
        }
        return (R) super.c(lVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(o oVar) {
        o oVar2 = oVar;
        int i2 = this.b - oVar2.b;
        return i2 == 0 ? this.c - oVar2.c : i2;
    }

    @Override // l.b.a.w.d
    public d e(f fVar) {
        return (o) fVar.n(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.b == oVar.b && this.c == oVar.c;
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof a ? jVar == a.YEAR || jVar == a.MONTH_OF_YEAR || jVar == a.PROLEPTIC_MONTH || jVar == a.YEAR_OF_ERA || jVar == a.ERA : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.w.d
    public d h(long j2, l.b.a.w.m mVar) {
        return j2 == Long.MIN_VALUE ? m(Long.MAX_VALUE, mVar).m(1, mVar) : m(-j2, mVar);
    }

    public int hashCode() {
        return this.b ^ (this.c << 27);
    }

    @Override // l.b.a.w.e
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

    @Override // l.b.a.w.f
    public d n(d dVar) {
        if (h.l(dVar).equals(l.b.a.t.m.f4084d)) {
            return dVar.l(a.PROLEPTIC_MONTH, r());
        }
        throw new a("Adjustment only supported on ISO date-time");
    }

    @Override // l.b.a.w.d
    public long o(d dVar, l.b.a.w.m mVar) {
        o q = q(dVar);
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
    public o m(long j2, l.b.a.w.m mVar) {
        if (!(mVar instanceof b)) {
            return (o) mVar.c(this, j2);
        }
        switch (((b) mVar).ordinal()) {
            case 9:
                return u(j2);
            case 10:
                return v(j2);
            case 11:
                return v(f.b.a.c.b.o.b.I1(j2, 10));
            case 12:
                return v(f.b.a.c.b.o.b.I1(j2, 100));
            case 13:
                return v(f.b.a.c.b.o.b.I1(j2, 1000));
            case 14:
                a aVar = a.ERA;
                return l(aVar, f.b.a.c.b.o.b.H1(i(aVar), j2));
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

    public o u(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (((long) this.b) * 12) + ((long) (this.c - 1)) + j2;
        return w(a.YEAR.m(f.b.a.c.b.o.b.B0(j3, 12)), f.b.a.c.b.o.b.C0(j3, 12) + 1);
    }

    public o v(long j2) {
        return j2 == 0 ? this : w(a.YEAR.m(((long) this.b) + j2), this.c);
    }

    public final o w(int i2, int i3) {
        return (this.b == i2 && this.c == i3) ? this : new o(i2, i3);
    }

    /* renamed from: x */
    public o l(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return (o) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        aVar.f4182e.b(j2, aVar);
        switch (aVar.ordinal()) {
            case 23:
                int i2 = (int) j2;
                a aVar2 = a.MONTH_OF_YEAR;
                aVar2.f4182e.b((long) i2, aVar2);
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

    public o y(int i2) {
        a aVar = a.YEAR;
        aVar.f4182e.b((long) i2, aVar);
        return w(i2, this.c);
    }
}
