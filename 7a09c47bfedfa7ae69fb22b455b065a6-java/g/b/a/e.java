package g.b.a;

import b.x.t;
import g.b.a.t.b;
import g.b.a.t.h;
import g.b.a.t.i;
import g.b.a.t.m;
import g.b.a.u.c;
import g.b.a.w.d;
import g.b.a.w.f;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.n;
import g.b.a.w.o;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class e extends b implements d, f, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final e f6406e = f0(-999999999, 1, 1);

    /* renamed from: f  reason: collision with root package name */
    public static final e f6407f = f0(999999999, 12, 31);

    /* renamed from: g  reason: collision with root package name */
    public static final l<e> f6408g = new a();

    /* renamed from: b  reason: collision with root package name */
    public final int f6409b;

    /* renamed from: c  reason: collision with root package name */
    public final short f6410c;

    /* renamed from: d  reason: collision with root package name */
    public final short f6411d;

    public class a implements l<e> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // g.b.a.w.l
        public e a(g.b.a.w.e eVar) {
            return e.V(eVar);
        }
    }

    public e(int i, int i2, int i3) {
        this.f6409b = i;
        this.f6410c = (short) i2;
        this.f6411d = (short) i3;
    }

    public static e T(int i, h hVar, int i2) {
        if (i2 <= 28 || i2 <= hVar.A(m.f6476d.F((long) i))) {
            return new e(i, hVar.x(), i2);
        }
        if (i2 == 29) {
            throw new a(c.a.a.a.a.o("Invalid date 'February 29' as '", i, "' is not a leap year"));
        }
        StringBuilder h = c.a.a.a.a.h("Invalid date '");
        h.append(hVar.name());
        h.append(" ");
        h.append(i2);
        h.append("'");
        throw new a(h.toString());
    }

    public static e V(g.b.a.w.e eVar) {
        e eVar2 = (e) eVar.f(k.f6661f);
        if (eVar2 != null) {
            return eVar2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to obtain LocalDate from TemporalAccessor: ");
        sb.append(eVar);
        sb.append(", type ");
        throw new a(c.a.a.a.a.e(eVar, sb));
    }

    public static e f0(int i, int i2, int i3) {
        g.b.a.w.a aVar = g.b.a.w.a.YEAR;
        aVar.f6633c.b((long) i, aVar);
        g.b.a.w.a aVar2 = g.b.a.w.a.MONTH_OF_YEAR;
        aVar2.f6633c.b((long) i2, aVar2);
        g.b.a.w.a aVar3 = g.b.a.w.a.DAY_OF_MONTH;
        aVar3.f6633c.b((long) i3, aVar3);
        return T(i, h.D(i2), i3);
    }

    public static e g0(int i, h hVar, int i2) {
        g.b.a.w.a aVar = g.b.a.w.a.YEAR;
        aVar.f6633c.b((long) i, aVar);
        t.y2(hVar, "month");
        g.b.a.w.a aVar2 = g.b.a.w.a.DAY_OF_MONTH;
        aVar2.f6633c.b((long) i2, aVar2);
        return T(i, hVar, i2);
    }

    public static e h0(long j) {
        long j2;
        g.b.a.w.a aVar = g.b.a.w.a.EPOCH_DAY;
        aVar.f6633c.b(j, aVar);
        long j3 = (j + 719528) - 60;
        if (j3 < 0) {
            long j4 = ((j3 + 1) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((j5 / 400) + (((j5 / 4) + (j5 * 365)) - (j5 / 100)));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((j5 / 400) + (((j5 / 4) + (365 * j5)) - (j5 / 100)));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / 153;
        return new e(g.b.a.w.a.YEAR.r(j5 + j2 + ((long) (i2 / 10))), ((i2 + 2) % 12) + 1, (i - (((i2 * 306) + 5) / 10)) + 1);
    }

    public static e i0(int i, int i2) {
        g.b.a.w.a aVar = g.b.a.w.a.YEAR;
        long j = (long) i;
        aVar.f6633c.b(j, aVar);
        g.b.a.w.a aVar2 = g.b.a.w.a.DAY_OF_YEAR;
        aVar2.f6633c.b((long) i2, aVar2);
        boolean F = m.f6476d.F(j);
        if (i2 != 366 || F) {
            h D = h.D(((i2 - 1) / 31) + 1);
            if (i2 > (D.A(F) + D.p(F)) - 1) {
                D = h.n[((((int) 1) + 12) + D.ordinal()) % 12];
            }
            return T(i, D, (i2 - D.p(F)) + 1);
        }
        throw new a(c.a.a.a.a.o("Invalid date 'DayOfYear 366' as '", i, "' is not a leap year"));
    }

    public static e j0(CharSequence charSequence, c cVar) {
        t.y2(cVar, "formatter");
        return (e) cVar.c(charSequence, f6408g);
    }

    public static e p0(DataInput dataInput) {
        return f0(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    public static e q0(int i, int i2, int i3) {
        int i4;
        if (i2 != 2) {
            if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
                i4 = 30;
            }
            return f0(i, i2, i3);
        }
        i4 = m.f6476d.F((long) i) ? 29 : 28;
        i3 = Math.min(i3, i4);
        return f0(i, i2, i3);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 3, this);
    }

    @Override // g.b.a.t.b
    public g.b.a.t.c A(g gVar) {
        return f.Y(this, gVar);
    }

    @Override // g.b.a.t.b
    /* renamed from: B */
    public int compareTo(b bVar) {
        return bVar instanceof e ? S((e) bVar) : super.compareTo(bVar);
    }

    @Override // g.b.a.t.b
    public h D() {
        return m.f6476d;
    }

    @Override // g.b.a.t.b
    public i F() {
        return super.F();
    }

    @Override // g.b.a.t.b
    public b L(g.b.a.w.i iVar) {
        return (e) ((l) iVar).a(this);
    }

    @Override // g.b.a.t.b
    public long P() {
        long j;
        long j2 = (long) this.f6409b;
        long j3 = (long) this.f6410c;
        long j4 = (365 * j2) + 0;
        if (j2 >= 0) {
            j = ((j2 + 399) / 400) + (((3 + j2) / 4) - ((99 + j2) / 100)) + j4;
        } else {
            j = j4 - ((j2 / -400) + ((j2 / -4) - (j2 / -100)));
        }
        long j5 = (((367 * j3) - 362) / 12) + j + ((long) (this.f6411d - 1));
        if (j3 > 2) {
            j5--;
            if (!b0()) {
                j5--;
            }
        }
        return j5 - 719528;
    }

    public int S(e eVar) {
        int i = this.f6409b - eVar.f6409b;
        if (i != 0) {
            return i;
        }
        int i2 = this.f6410c - eVar.f6410c;
        return i2 == 0 ? this.f6411d - eVar.f6411d : i2;
    }

    public long U(e eVar) {
        return eVar.P() - P();
    }

    public final int W(j jVar) {
        switch (((g.b.a.w.a) jVar).ordinal()) {
            case 15:
                return X().p();
            case 16:
                return ((this.f6411d - 1) % 7) + 1;
            case 17:
                return ((Y() - 1) % 7) + 1;
            case 18:
                return this.f6411d;
            case 19:
                return Y();
            case 20:
                throw new a(c.a.a.a.a.d("Field too large for an int: ", jVar));
            case 21:
                return ((this.f6411d - 1) / 7) + 1;
            case 22:
                return ((Y() - 1) / 7) + 1;
            case 23:
                return this.f6410c;
            case 24:
                throw new a(c.a.a.a.a.d("Field too large for an int: ", jVar));
            case 25:
                int i = this.f6409b;
                return i >= 1 ? i : 1 - i;
            case 26:
                return this.f6409b;
            case 27:
                return this.f6409b >= 1 ? 1 : 0;
            default:
                throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
        }
    }

    public b X() {
        return b.x(t.v1(P() + 3, 7) + 1);
    }

    public int Y() {
        return (h.D(this.f6410c).p(b0()) + this.f6411d) - 1;
    }

    public final long Z() {
        return (((long) this.f6409b) * 12) + ((long) (this.f6410c - 1));
    }

    public boolean a0(b bVar) {
        return bVar instanceof e ? S((e) bVar) < 0 : P() < bVar.P();
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        int i;
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.p(this);
        }
        g.b.a.w.a aVar = (g.b.a.w.a) jVar;
        if (aVar.b()) {
            int ordinal = aVar.ordinal();
            if (ordinal == 18) {
                short s = this.f6410c;
                i = s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : b0() ? 29 : 28;
            } else if (ordinal == 19) {
                i = b0() ? 366 : 365;
            } else if (ordinal == 21) {
                return o.d(1, (h.D(this.f6410c) != h.FEBRUARY || b0()) ? 5 : 4);
            } else if (ordinal != 25) {
                return jVar.m();
            } else {
                return o.d(1, this.f6409b <= 0 ? 1000000000 : 999999999);
            }
            return o.d(1, (long) i);
        }
        throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
    }

    public boolean b0() {
        return m.f6476d.F((long) this.f6409b);
    }

    /* renamed from: c0 */
    public e m(long j, g.b.a.w.m mVar) {
        return j == Long.MIN_VALUE ? s(Long.MAX_VALUE, mVar).s(1, mVar) : s(-j, mVar);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public int d(j jVar) {
        return jVar instanceof g.b.a.w.a ? W(jVar) : b(jVar).a(n(jVar), jVar);
    }

    public e d0(long j) {
        return j == Long.MIN_VALUE ? l0(Long.MAX_VALUE).l0(1) : l0(-j);
    }

    public final long e0(e eVar) {
        return (((eVar.Z() * 32) + ((long) eVar.f6411d)) - ((Z() * 32) + ((long) this.f6411d))) / 32;
    }

    @Override // g.b.a.t.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return S((e) obj) == 0;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: g.b.a.e */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.b.a.w.e, g.b.a.t.b, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        return lVar == k.f6661f ? this : (R) super.f(lVar);
    }

    @Override // g.b.a.t.b
    public int hashCode() {
        int i = this.f6409b;
        return (((i << 11) + (this.f6410c << 6)) + this.f6411d) ^ (i & -2048);
    }

    @Override // g.b.a.w.e, g.b.a.t.b
    public boolean k(j jVar) {
        return super.k(jVar);
    }

    /* renamed from: k0 */
    public e s(long j, g.b.a.w.m mVar) {
        if (!(mVar instanceof g.b.a.w.b)) {
            return (e) mVar.f(this, j);
        }
        switch (((g.b.a.w.b) mVar).ordinal()) {
            case 7:
                return l0(j);
            case 8:
                return n0(j);
            case 9:
                return m0(j);
            case 10:
                return o0(j);
            case 11:
                return o0(t.E2(j, 10));
            case 12:
                return o0(t.E2(j, 100));
            case 13:
                return o0(t.E2(j, 1000));
            case 14:
                g.b.a.w.a aVar = g.b.a.w.a.ERA;
                return r(aVar, t.D2(n(aVar), j));
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public e l0(long j) {
        return j == 0 ? this : h0(t.D2(P(), j));
    }

    public e m0(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.f6409b) * 12) + ((long) (this.f6410c - 1)) + j;
        return q0(g.b.a.w.a.YEAR.r(t.t1(j2, 12)), t.v1(j2, 12) + 1, this.f6411d);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar == g.b.a.w.a.EPOCH_DAY ? P() : jVar == g.b.a.w.a.PROLEPTIC_MONTH ? Z() : (long) W(jVar) : jVar.k(this);
    }

    public e n0(long j) {
        return l0(t.E2(j, 7));
    }

    public e o0(long j) {
        return j == 0 ? this : q0(g.b.a.w.a.YEAR.r(((long) this.f6409b) + j), this.f6410c, this.f6411d);
    }

    /* renamed from: r0 */
    public e i(f fVar) {
        return fVar instanceof e ? (e) fVar : (e) fVar.t(this);
    }

    /* renamed from: s0 */
    public e r(j jVar, long j) {
        if (!(jVar instanceof g.b.a.w.a)) {
            return (e) jVar.f(this, j);
        }
        g.b.a.w.a aVar = (g.b.a.w.a) jVar;
        aVar.f6633c.b(j, aVar);
        switch (aVar.ordinal()) {
            case 15:
                return l0(j - ((long) X().p()));
            case 16:
                return l0(j - n(g.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 17:
                return l0(j - n(g.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 18:
                int i = (int) j;
                return this.f6411d == i ? this : f0(this.f6409b, this.f6410c, i);
            case 19:
                int i2 = (int) j;
                return Y() == i2 ? this : i0(this.f6409b, i2);
            case 20:
                return h0(j);
            case 21:
                return n0(j - n(g.b.a.w.a.ALIGNED_WEEK_OF_MONTH));
            case 22:
                return n0(j - n(g.b.a.w.a.ALIGNED_WEEK_OF_YEAR));
            case 23:
                int i3 = (int) j;
                if (this.f6410c == i3) {
                    return this;
                }
                g.b.a.w.a aVar2 = g.b.a.w.a.MONTH_OF_YEAR;
                aVar2.f6633c.b((long) i3, aVar2);
                return q0(this.f6409b, i3, this.f6411d);
            case 24:
                return m0(j - n(g.b.a.w.a.PROLEPTIC_MONTH));
            case 25:
                if (this.f6409b < 1) {
                    j = 1 - j;
                }
                return t0((int) j);
            case 26:
                return t0((int) j);
            case 27:
                return n(g.b.a.w.a.ERA) == j ? this : t0(1 - this.f6409b);
            default:
                throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
        }
    }

    @Override // g.b.a.w.f, g.b.a.t.b
    public d t(d dVar) {
        return super.t(dVar);
    }

    public e t0(int i) {
        if (this.f6409b == i) {
            return this;
        }
        g.b.a.w.a aVar = g.b.a.w.a.YEAR;
        aVar.f6633c.b((long) i, aVar);
        return q0(i, this.f6410c, this.f6411d);
    }

    @Override // g.b.a.t.b
    public String toString() {
        int i;
        int i2 = this.f6409b;
        short s = this.f6410c;
        short s2 = this.f6411d;
        int abs = Math.abs(i2);
        StringBuilder sb = new StringBuilder(10);
        if (abs < 1000) {
            if (i2 < 0) {
                sb.append(i2 - 10000);
                i = 1;
            } else {
                sb.append(i2 + 10000);
                i = 0;
            }
            sb.deleteCharAt(i);
        } else {
            if (i2 > 9999) {
                sb.append('+');
            }
            sb.append(i2);
        }
        String str = "-0";
        sb.append(s < 10 ? str : "-");
        sb.append((int) s);
        if (s2 >= 10) {
            str = "-";
        }
        sb.append(str);
        sb.append((int) s2);
        return sb.toString();
    }

    @Override // g.b.a.w.d
    public long y(d dVar, g.b.a.w.m mVar) {
        e V = V(dVar);
        if (!(mVar instanceof g.b.a.w.b)) {
            return mVar.d(this, V);
        }
        switch (((g.b.a.w.b) mVar).ordinal()) {
            case 7:
                return U(V);
            case 8:
                return U(V) / 7;
            case 9:
                return e0(V);
            case 10:
                return e0(V) / 12;
            case 11:
                return e0(V) / 120;
            case 12:
                return e0(V) / 1200;
            case 13:
                return e0(V) / 12000;
            case 14:
                return V.n(g.b.a.w.a.ERA) - n(g.b.a.w.a.ERA);
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }
}
