package l.b.a;

import java.io.InvalidObjectException;
import java.io.Serializable;
import l.b.a.t.b;
import l.b.a.t.h;
import l.b.a.t.i;
import l.b.a.t.m;
import l.b.a.u.c;
import l.b.a.w.d;
import l.b.a.w.f;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.n;
import l.b.a.w.o;
import l.b.a.x.f;

public final class e extends b implements d, f, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final e f4137e = P(-999999999, 1, 1);

    /* renamed from: f  reason: collision with root package name */
    public static final e f4138f = P(999999999, 12, 31);

    /* renamed from: g  reason: collision with root package name */
    public static final l<e> f4139g = new a();
    public final int b;
    public final short c;

    /* renamed from: d  reason: collision with root package name */
    public final short f4140d;

    public class a implements l<e> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // l.b.a.w.l
        public e a(l.b.a.w.e eVar) {
            return e.E(eVar);
        }
    }

    public e(int i2, int i3, int i4) {
        this.b = i2;
        this.c = (short) i3;
        this.f4140d = (short) i4;
    }

    public static e C(int i2, h hVar, int i3) {
        if (i3 <= 28 || i3 <= hVar.s(m.f4188d.u((long) i2))) {
            return new e(i2, hVar.r(), i3);
        }
        if (i3 == 29) {
            throw new a(f.a.a.a.a.r("Invalid date 'February 29' as '", i2, "' is not a leap year"));
        }
        StringBuilder h2 = f.a.a.a.a.h("Invalid date '");
        h2.append(hVar.name());
        h2.append(" ");
        h2.append(i3);
        h2.append("'");
        throw new a(h2.toString());
    }

    public static e E(l.b.a.w.e eVar) {
        e eVar2 = (e) eVar.c(k.f4304f);
        if (eVar2 != null) {
            return eVar2;
        }
        throw new a(f.a.a.a.a.f(eVar, f.a.a.a.a.k("Unable to obtain LocalDate from TemporalAccessor: ", eVar, ", type ")));
    }

    public static e O(p pVar) {
        f.b.a.c.b.o.b.A1(pVar, "zone");
        return R(f.b.a.c.b.o.b.B0(d.y(System.currentTimeMillis()).b + ((long) ((f.a) pVar.s()).b.c), 86400));
    }

    public static e P(int i2, int i3, int i4) {
        l.b.a.w.a aVar = l.b.a.w.a.YEAR;
        aVar.f4286e.b((long) i2, aVar);
        l.b.a.w.a aVar2 = l.b.a.w.a.MONTH_OF_YEAR;
        aVar2.f4286e.b((long) i3, aVar2);
        l.b.a.w.a aVar3 = l.b.a.w.a.DAY_OF_MONTH;
        aVar3.f4286e.b((long) i4, aVar3);
        return C(i2, h.u(i3), i4);
    }

    public static e Q(int i2, h hVar, int i3) {
        l.b.a.w.a aVar = l.b.a.w.a.YEAR;
        aVar.f4286e.b((long) i2, aVar);
        f.b.a.c.b.o.b.A1(hVar, "month");
        l.b.a.w.a aVar2 = l.b.a.w.a.DAY_OF_MONTH;
        aVar2.f4286e.b((long) i3, aVar2);
        return C(i2, hVar, i3);
    }

    public static e R(long j2) {
        long j3;
        l.b.a.w.a aVar = l.b.a.w.a.EPOCH_DAY;
        aVar.f4286e.b(j2, aVar);
        long j4 = (j2 + 719528) - 60;
        if (j4 < 0) {
            long j5 = ((j4 + 1) / 146097) - 1;
            j3 = j5 * 400;
            j4 += (-j5) * 146097;
        } else {
            j3 = 0;
        }
        long j6 = ((j4 * 400) + 591) / 146097;
        long j7 = j4 - ((j6 / 400) + (((j6 / 4) + (j6 * 365)) - (j6 / 100)));
        if (j7 < 0) {
            j6--;
            j7 = j4 - ((j6 / 400) + (((j6 / 4) + (365 * j6)) - (j6 / 100)));
        }
        int i2 = (int) j7;
        int i3 = ((i2 * 5) + 2) / 153;
        return new e(l.b.a.w.a.YEAR.m(j6 + j3 + ((long) (i3 / 10))), ((i3 + 2) % 12) + 1, (i2 - (((i3 * 306) + 5) / 10)) + 1);
    }

    public static e S(int i2, int i3) {
        l.b.a.w.a aVar = l.b.a.w.a.YEAR;
        long j2 = (long) i2;
        aVar.f4286e.b(j2, aVar);
        l.b.a.w.a aVar2 = l.b.a.w.a.DAY_OF_YEAR;
        aVar2.f4286e.b((long) i3, aVar2);
        boolean u = m.f4188d.u(j2);
        if (i3 != 366 || u) {
            h u2 = h.u(((i3 - 1) / 31) + 1);
            if (i3 > (u2.s(u) + u2.q(u)) - 1) {
                u2 = h.n[((((int) 1) + 12) + u2.ordinal()) % 12];
            }
            return C(i2, u2, (i3 - u2.q(u)) + 1);
        }
        throw new a(f.a.a.a.a.r("Invalid date 'DayOfYear 366' as '", i2, "' is not a leap year"));
    }

    public static e T(CharSequence charSequence, c cVar) {
        f.b.a.c.b.o.b.A1(cVar, "formatter");
        l<e> lVar = f4139g;
        f.b.a.c.b.o.b.A1(charSequence, "text");
        f.b.a.c.b.o.b.A1(lVar, "type");
        try {
            l.b.a.u.a d2 = cVar.d(charSequence, null);
            d2.x(cVar.f4221d, cVar.f4222e);
            return lVar.a(d2);
        } catch (l.b.a.u.f e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw cVar.a(charSequence, e3);
        }
    }

    public static e Z(int i2, int i3, int i4) {
        int i5;
        if (i3 != 2) {
            if (i3 == 4 || i3 == 6 || i3 == 9 || i3 == 11) {
                i5 = 30;
            }
            return P(i2, i3, i4);
        }
        i5 = m.f4188d.u((long) i2) ? 29 : 28;
        i4 = Math.min(i4, i5);
        return P(i2, i3, i4);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 3, this);
    }

    public s A(p pVar) {
        f.b.a.c.b.o.b.A1(pVar, "zone");
        f F = f.F(this, g.f4145h);
        if (!(pVar instanceof q)) {
            pVar.s();
        }
        return s.H(F, pVar);
    }

    public int B(e eVar) {
        int i2 = this.b - eVar.b;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.c - eVar.c;
        return i3 == 0 ? this.f4140d - eVar.f4140d : i3;
    }

    public long D(e eVar) {
        return eVar.x() - x();
    }

    public final int F(j jVar) {
        switch (((l.b.a.w.a) jVar).ordinal()) {
            case 15:
                return G().q();
            case 16:
                return ((this.f4140d - 1) % 7) + 1;
            case 17:
                return ((H() - 1) % 7) + 1;
            case 18:
                return this.f4140d;
            case 19:
                return H();
            case 20:
                throw new a(f.a.a.a.a.d("Field too large for an int: ", jVar));
            case 21:
                return ((this.f4140d - 1) / 7) + 1;
            case 22:
                return ((H() - 1) / 7) + 1;
            case 23:
                return this.c;
            case 24:
                throw new a(f.a.a.a.a.d("Field too large for an int: ", jVar));
            case 25:
                int i2 = this.b;
                return i2 >= 1 ? i2 : 1 - i2;
            case 26:
                return this.b;
            case 27:
                return this.b >= 1 ? 1 : 0;
            default:
                throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }
    }

    public b G() {
        return b.r(f.b.a.c.b.o.b.D0(x() + 3, 7) + 1);
    }

    public int H() {
        return (h.u(this.c).q(K()) + this.f4140d) - 1;
    }

    public final long I() {
        return (((long) this.b) * 12) + ((long) (this.c - 1));
    }

    public boolean J(b bVar) {
        return bVar instanceof e ? B((e) bVar) < 0 : x() < bVar.x();
    }

    public boolean K() {
        return m.f4188d.u((long) this.b);
    }

    /* renamed from: L */
    public e u(long j2, l.b.a.w.m mVar) {
        return j2 == Long.MIN_VALUE ? v(Long.MAX_VALUE, mVar).v(1, mVar) : v(-j2, mVar);
    }

    public e M(long j2) {
        return j2 == Long.MIN_VALUE ? V(Long.MAX_VALUE).V(1) : V(-j2);
    }

    public final long N(e eVar) {
        return (((eVar.I() * 32) + ((long) eVar.f4140d)) - ((I() * 32) + ((long) this.f4140d))) / 32;
    }

    /* renamed from: U */
    public e v(long j2, l.b.a.w.m mVar) {
        if (!(mVar instanceof l.b.a.w.b)) {
            return (e) mVar.c(this, j2);
        }
        switch (((l.b.a.w.b) mVar).ordinal()) {
            case 7:
                return V(j2);
            case 8:
                return X(j2);
            case 9:
                return W(j2);
            case 10:
                return Y(j2);
            case 11:
                return Y(f.b.a.c.b.o.b.H1(j2, 10));
            case 12:
                return Y(f.b.a.c.b.o.b.H1(j2, 100));
            case 13:
                return Y(f.b.a.c.b.o.b.H1(j2, 1000));
            case 14:
                l.b.a.w.a aVar = l.b.a.w.a.ERA;
                return z(aVar, f.b.a.c.b.o.b.G1(i(aVar), j2));
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public e V(long j2) {
        return j2 == 0 ? this : R(f.b.a.c.b.o.b.G1(x(), j2));
    }

    public e W(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (((long) this.b) * 12) + ((long) (this.c - 1)) + j2;
        return Z(l.b.a.w.a.YEAR.m(f.b.a.c.b.o.b.B0(j3, 12)), f.b.a.c.b.o.b.D0(j3, 12) + 1, this.f4140d);
    }

    public e X(long j2) {
        return V(f.b.a.c.b.o.b.H1(j2, 7));
    }

    public e Y(long j2) {
        return j2 == 0 ? this : Z(l.b.a.w.a.YEAR.m(((long) this.b) + j2), this.c, this.f4140d);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        int i2;
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.l(this);
        }
        l.b.a.w.a aVar = (l.b.a.w.a) jVar;
        if (aVar.a()) {
            int ordinal = aVar.ordinal();
            if (ordinal == 18) {
                short s = this.c;
                i2 = s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : K() ? 29 : 28;
            } else if (ordinal == 19) {
                i2 = K() ? 366 : 365;
            } else if (ordinal == 21) {
                return o.d(1, (h.u(this.c) != h.FEBRUARY || K()) ? 5 : 4);
            } else if (ordinal != 25) {
                return jVar.h();
            } else {
                return o.d(1, this.b <= 0 ? 1000000000 : 999999999);
            }
            return o.d(1, (long) i2);
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    /* renamed from: a0 */
    public e y(l.b.a.w.f fVar) {
        return fVar instanceof e ? (e) fVar : (e) fVar.n(this);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public int b(j jVar) {
        return jVar instanceof l.b.a.w.a ? F(jVar) : a(jVar).a(i(jVar), jVar);
    }

    /* renamed from: b0 */
    public e z(j jVar, long j2) {
        if (!(jVar instanceof l.b.a.w.a)) {
            return (e) jVar.c(this, j2);
        }
        l.b.a.w.a aVar = (l.b.a.w.a) jVar;
        aVar.f4286e.b(j2, aVar);
        switch (aVar.ordinal()) {
            case 15:
                return V(j2 - ((long) G().q()));
            case 16:
                return V(j2 - i(l.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 17:
                return V(j2 - i(l.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 18:
                int i2 = (int) j2;
                return this.f4140d == i2 ? this : P(this.b, this.c, i2);
            case 19:
                int i3 = (int) j2;
                return H() == i3 ? this : S(this.b, i3);
            case 20:
                return R(j2);
            case 21:
                return X(j2 - i(l.b.a.w.a.ALIGNED_WEEK_OF_MONTH));
            case 22:
                return X(j2 - i(l.b.a.w.a.ALIGNED_WEEK_OF_YEAR));
            case 23:
                int i4 = (int) j2;
                if (this.c == i4) {
                    return this;
                }
                l.b.a.w.a aVar2 = l.b.a.w.a.MONTH_OF_YEAR;
                aVar2.f4286e.b((long) i4, aVar2);
                return Z(this.b, i4, this.f4140d);
            case 24:
                return W(j2 - i(l.b.a.w.a.PROLEPTIC_MONTH));
            case 25:
                if (this.b < 1) {
                    j2 = 1 - j2;
                }
                return c0((int) j2);
            case 26:
                return c0((int) j2);
            case 27:
                return i(l.b.a.w.a.ERA) == j2 ? this : c0(1 - this.b);
            default:
                throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: l.b.a.e */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.b.a.v.c, l.b.a.w.e, l.b.a.t.b
    public <R> R c(l<R> lVar) {
        return lVar == k.f4304f ? this : (R) super.c(lVar);
    }

    public e c0(int i2) {
        if (this.b == i2) {
            return this;
        }
        l.b.a.w.a aVar = l.b.a.w.a.YEAR;
        aVar.f4286e.b((long) i2, aVar);
        return Z(i2, this.c, this.f4140d);
    }

    @Override // l.b.a.t.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && B((e) obj) == 0;
    }

    @Override // l.b.a.w.e, l.b.a.t.b
    public boolean f(j jVar) {
        return super.f(jVar);
    }

    @Override // l.b.a.t.b
    public int hashCode() {
        int i2 = this.b;
        return (((i2 << 11) + (this.c << 6)) + this.f4140d) ^ (i2 & -2048);
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        return jVar instanceof l.b.a.w.a ? jVar == l.b.a.w.a.EPOCH_DAY ? x() : jVar == l.b.a.w.a.PROLEPTIC_MONTH ? I() : (long) F(jVar) : jVar.f(this);
    }

    @Override // l.b.a.w.f, l.b.a.t.b
    public d n(d dVar) {
        return super.n(dVar);
    }

    @Override // l.b.a.w.d
    public long o(d dVar, l.b.a.w.m mVar) {
        long D;
        long j2;
        e E = E(dVar);
        if (!(mVar instanceof l.b.a.w.b)) {
            return mVar.b(this, E);
        }
        switch (((l.b.a.w.b) mVar).ordinal()) {
            case 7:
                return D(E);
            case 8:
                D = D(E);
                j2 = 7;
                break;
            case 9:
                return N(E);
            case 10:
                D = N(E);
                j2 = 12;
                break;
            case 11:
                D = N(E);
                j2 = 120;
                break;
            case 12:
                D = N(E);
                j2 = 1200;
                break;
            case 13:
                D = N(E);
                j2 = 12000;
                break;
            case 14:
                l.b.a.w.a aVar = l.b.a.w.a.ERA;
                return E.i(aVar) - i(aVar);
            default:
                throw new n("Unsupported unit: " + mVar);
        }
        return D / j2;
    }

    @Override // l.b.a.t.b
    public l.b.a.t.c q(g gVar) {
        return f.F(this, gVar);
    }

    @Override // l.b.a.t.b
    /* renamed from: r */
    public int compareTo(b bVar) {
        return bVar instanceof e ? B((e) bVar) : super.compareTo(bVar);
    }

    @Override // l.b.a.t.b
    public h s() {
        return m.f4188d;
    }

    @Override // l.b.a.t.b
    public i t() {
        return super.t();
    }

    @Override // l.b.a.t.b
    public String toString() {
        int i2;
        int i3 = this.b;
        short s = this.c;
        short s2 = this.f4140d;
        int abs = Math.abs(i3);
        StringBuilder sb = new StringBuilder(10);
        if (abs < 1000) {
            if (i3 < 0) {
                sb.append(i3 - 10000);
                i2 = 1;
            } else {
                sb.append(i3 + 10000);
                i2 = 0;
            }
            sb.deleteCharAt(i2);
        } else {
            if (i3 > 9999) {
                sb.append('+');
            }
            sb.append(i3);
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

    @Override // l.b.a.t.b
    public b w(l.b.a.w.i iVar) {
        return (e) ((l) iVar).b(this);
    }

    @Override // l.b.a.t.b
    public long x() {
        long j2;
        long j3 = (long) this.b;
        long j4 = (long) this.c;
        long j5 = (365 * j3) + 0;
        if (j3 >= 0) {
            j2 = ((j3 + 399) / 400) + (((3 + j3) / 4) - ((99 + j3) / 100)) + j5;
        } else {
            j2 = j5 - ((j3 / -400) + ((j3 / -4) - (j3 / -100)));
        }
        long j6 = (((367 * j4) - 362) / 12) + j2 + ((long) (this.f4140d - 1));
        if (j4 > 2) {
            j6--;
            if (!K()) {
                j6--;
            }
        }
        return j6 - 719528;
    }
}
