package g.b.a;

import b.x.t;
import g.b.a.t.h;
import g.b.a.u.m;
import g.b.a.v.c;
import g.b.a.w.a;
import g.b.a.w.b;
import g.b.a.w.d;
import g.b.a.w.e;
import g.b.a.w.f;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.n;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class o extends c implements d, f, Comparable<o>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final int f6441b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6442c;

    static {
        g.b.a.u.d n = new g.b.a.u.d().n(a.YEAR, 4, 10, m.EXCEEDS_PAD);
        n.d('-');
        n.m(a.MONTH_OF_YEAR, 2);
        n.q();
    }

    public o(int i, int i2) {
        this.f6441b = i;
        this.f6442c = i2;
    }

    public static o A(e eVar) {
        if (eVar instanceof o) {
            return (o) eVar;
        }
        try {
            if (!g.b.a.t.m.f6476d.equals(h.p(eVar))) {
                eVar = e.V(eVar);
            }
            return D(eVar.d(a.YEAR), eVar.d(a.MONTH_OF_YEAR));
        } catch (a unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain YearMonth from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(c.a.a.a.a.e(eVar, sb));
        }
    }

    public static o D(int i, int i2) {
        a aVar = a.YEAR;
        aVar.f6633c.b((long) i, aVar);
        a aVar2 = a.MONTH_OF_YEAR;
        aVar2.f6633c.b((long) i2, aVar2);
        return new o(i, i2);
    }

    public static o L(DataInput dataInput) {
        return D(dataInput.readInt(), dataInput.readByte());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 68, this);
    }

    public final long B() {
        return (((long) this.f6441b) * 12) + ((long) (this.f6442c - 1));
    }

    /* renamed from: F */
    public o s(long j, g.b.a.w.m mVar) {
        if (!(mVar instanceof b)) {
            return (o) mVar.f(this, j);
        }
        switch (((b) mVar).ordinal()) {
            case 9:
                return G(j);
            case 10:
                return H(j);
            case 11:
                return H(t.E2(j, 10));
            case 12:
                return H(t.E2(j, 100));
            case 13:
                return H(t.E2(j, 1000));
            case 14:
                a aVar = a.ERA;
                return r(aVar, t.D2(n(aVar), j));
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public o G(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.f6441b) * 12) + ((long) (this.f6442c - 1)) + j;
        return P(a.YEAR.r(t.t1(j2, 12)), t.v1(j2, 12) + 1);
    }

    public o H(long j) {
        return j == 0 ? this : P(a.YEAR.r(((long) this.f6441b) + j), this.f6442c);
    }

    public final o P(int i, int i2) {
        return (this.f6441b == i && this.f6442c == i2) ? this : new o(i, i2);
    }

    /* renamed from: Q */
    public o r(j jVar, long j) {
        if (!(jVar instanceof a)) {
            return (o) jVar.f(this, j);
        }
        a aVar = (a) jVar;
        aVar.f6633c.b(j, aVar);
        switch (aVar.ordinal()) {
            case 23:
                int i = (int) j;
                a aVar2 = a.MONTH_OF_YEAR;
                aVar2.f6633c.b((long) i, aVar2);
                return P(this.f6441b, i);
            case 24:
                return G(j - n(a.PROLEPTIC_MONTH));
            case 25:
                if (this.f6441b < 1) {
                    j = 1 - j;
                }
                return R((int) j);
            case 26:
                return R((int) j);
            case 27:
                return n(a.ERA) == j ? this : R(1 - this.f6441b);
            default:
                throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
        }
    }

    public o R(int i) {
        a aVar = a.YEAR;
        aVar.f6633c.b((long) i, aVar);
        return P(i, this.f6442c);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public g.b.a.w.o b(j jVar) {
        if (jVar != a.YEAR_OF_ERA) {
            return super.b(jVar);
        }
        return g.b.a.w.o.d(1, this.f6441b <= 0 ? 1000000000 : 999999999);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(o oVar) {
        o oVar2 = oVar;
        int i = this.f6441b - oVar2.f6441b;
        return i == 0 ? this.f6442c - oVar2.f6442c : i;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public int d(j jVar) {
        return b(jVar).a(n(jVar), jVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f6441b == oVar.f6441b && this.f6442c == oVar.f6442c;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        if (lVar == k.f6657b) {
            return (R) g.b.a.t.m.f6476d;
        }
        if (lVar == k.f6658c) {
            return (R) b.MONTHS;
        }
        if (lVar == k.f6661f || lVar == k.f6662g || lVar == k.f6659d || lVar == k.f6656a || lVar == k.f6660e) {
            return null;
        }
        return (R) super.f(lVar);
    }

    public int hashCode() {
        return this.f6441b ^ (this.f6442c << 27);
    }

    @Override // g.b.a.w.d
    public d i(f fVar) {
        return (o) ((e) fVar).t(this);
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof a ? jVar == a.YEAR || jVar == a.MONTH_OF_YEAR || jVar == a.PROLEPTIC_MONTH || jVar == a.YEAR_OF_ERA || jVar == a.ERA : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.d
    public d m(long j, g.b.a.w.m mVar) {
        return j == Long.MIN_VALUE ? s(Long.MAX_VALUE, mVar).s(1, mVar) : s(-j, mVar);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        int i;
        if (!(jVar instanceof a)) {
            return jVar.k(this);
        }
        int i2 = 1;
        switch (((a) jVar).ordinal()) {
            case 23:
                i = this.f6442c;
                break;
            case 24:
                return B();
            case 25:
                int i3 = this.f6441b;
                if (i3 < 1) {
                    i3 = 1 - i3;
                }
                return (long) i3;
            case 26:
                i = this.f6441b;
                break;
            case 27:
                if (this.f6441b < 1) {
                    i2 = 0;
                }
                return (long) i2;
            default:
                throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
        }
        return (long) i;
    }

    @Override // g.b.a.w.f
    public d t(d dVar) {
        if (h.p(dVar).equals(g.b.a.t.m.f6476d)) {
            return dVar.r(a.PROLEPTIC_MONTH, B());
        }
        throw new a("Adjustment only supported on ISO date-time");
    }

    public String toString() {
        int i;
        int abs = Math.abs(this.f6441b);
        StringBuilder sb = new StringBuilder(9);
        if (abs < 1000) {
            int i2 = this.f6441b;
            if (i2 < 0) {
                sb.append(i2 - 10000);
                i = 1;
            } else {
                sb.append(i2 + 10000);
                i = 0;
            }
            sb.deleteCharAt(i);
        } else {
            sb.append(this.f6441b);
        }
        sb.append(this.f6442c < 10 ? "-0" : "-");
        sb.append(this.f6442c);
        return sb.toString();
    }

    @Override // g.b.a.w.d
    public long y(d dVar, g.b.a.w.m mVar) {
        long j;
        o A = A(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, A);
        }
        long B = A.B() - B();
        switch (((b) mVar).ordinal()) {
            case 9:
                return B;
            case 10:
                j = 12;
                break;
            case 11:
                j = 120;
                break;
            case 12:
                j = 1200;
                break;
            case 13:
                j = 12000;
                break;
            case 14:
                return A.n(a.ERA) - n(a.ERA);
            default:
                throw new n("Unsupported unit: " + mVar);
        }
        return B / j;
    }
}
