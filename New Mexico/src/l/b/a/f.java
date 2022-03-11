package l.b.a;

import java.io.InvalidObjectException;
import java.io.Serializable;
import l.b.a.a;
import l.b.a.u.b;
import l.b.a.u.h;
import l.b.a.u.i;
import l.b.a.u.m;
import l.b.a.v.c;
import l.b.a.x.d;
import l.b.a.x.e;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.n;
import l.b.a.x.o;
/* loaded from: classes.dex */
public final class f extends b implements d, l.b.a.x.f, Serializable {

    /* renamed from: e */
    public static final f f4612e = P(-999999999, 1, 1);

    /* renamed from: f */
    public static final f f4613f = P(999999999, 12, 31);

    /* renamed from: g */
    public static final l<f> f4614g = new a();
    public final int b;
    public final short c;

    /* renamed from: d */
    public final short f4615d;

    /* loaded from: classes.dex */
    public class a implements l<f> {
        @Override // l.b.a.x.l
        public f a(e eVar) {
            return f.E(eVar);
        }
    }

    public f(int i2, int i3, int i4) {
        this.b = i2;
        this.c = (short) i3;
        this.f4615d = (short) i4;
    }

    public static f C(int i2, i iVar, int i3) {
        if (i3 <= 28 || i3 <= iVar.s(m.f4663d.u((long) i2))) {
            return new f(i2, iVar.r(), i3);
        }
        if (i3 == 29) {
            throw new b(f.a.a.a.a.v("Invalid date 'February 29' as '", i2, "' is not a leap year"));
        }
        StringBuilder h2 = f.a.a.a.a.h("Invalid date '");
        h2.append(iVar.name());
        h2.append(" ");
        h2.append(i3);
        h2.append("'");
        throw new b(h2.toString());
    }

    public static f E(e eVar) {
        f fVar = (f) eVar.c(k.f4779f);
        if (fVar != null) {
            return fVar;
        }
        throw new b(f.a.a.a.a.f(eVar, f.a.a.a.a.k("Unable to obtain LocalDate from TemporalAccessor: ", eVar, ", type ")));
    }

    public static f O(a aVar) {
        g.b.a.c.c.d.u(aVar, "clock");
        e a2 = aVar.a();
        return R(g.b.a.c.c.d.i(a2.b + ((long) ((a.C0156a) aVar).b.s().a(a2).c), 86400));
    }

    public static f P(int i2, int i3, int i4) {
        l.b.a.x.a aVar = l.b.a.x.a.YEAR;
        aVar.f4761e.b((long) i2, aVar);
        l.b.a.x.a aVar2 = l.b.a.x.a.MONTH_OF_YEAR;
        aVar2.f4761e.b((long) i3, aVar2);
        l.b.a.x.a aVar3 = l.b.a.x.a.DAY_OF_MONTH;
        aVar3.f4761e.b((long) i4, aVar3);
        return C(i2, i.u(i3), i4);
    }

    public static f Q(int i2, i iVar, int i3) {
        l.b.a.x.a aVar = l.b.a.x.a.YEAR;
        aVar.f4761e.b((long) i2, aVar);
        g.b.a.c.c.d.u(iVar, "month");
        l.b.a.x.a aVar2 = l.b.a.x.a.DAY_OF_MONTH;
        aVar2.f4761e.b((long) i3, aVar2);
        return C(i2, iVar, i3);
    }

    public static f R(long j2) {
        long j3;
        l.b.a.x.a aVar = l.b.a.x.a.EPOCH_DAY;
        aVar.f4761e.b(j2, aVar);
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
        return new f(l.b.a.x.a.YEAR.m(j6 + j3 + ((long) (i3 / 10))), ((i3 + 2) % 12) + 1, (i2 - (((i3 * 306) + 5) / 10)) + 1);
    }

    public static f S(int i2, int i3) {
        l.b.a.x.a aVar = l.b.a.x.a.YEAR;
        long j2 = (long) i2;
        aVar.f4761e.b(j2, aVar);
        l.b.a.x.a aVar2 = l.b.a.x.a.DAY_OF_YEAR;
        aVar2.f4761e.b((long) i3, aVar2);
        boolean u = m.f4663d.u(j2);
        if (i3 != 366 || u) {
            i u2 = i.u(((i3 - 1) / 31) + 1);
            if (i3 > (u2.s(u) + u2.q(u)) - 1) {
                u2 = i.n[((((int) 1) + 12) + u2.ordinal()) % 12];
            }
            return C(i2, u2, (i3 - u2.q(u)) + 1);
        }
        throw new b(f.a.a.a.a.v("Invalid date 'DayOfYear 366' as '", i2, "' is not a leap year"));
    }

    public static f T(CharSequence charSequence, c cVar) {
        g.b.a.c.c.d.u(cVar, "formatter");
        l<f> lVar = f4614g;
        g.b.a.c.c.d.u(charSequence, "text");
        g.b.a.c.c.d.u(lVar, "type");
        try {
            l.b.a.v.a d2 = cVar.d(charSequence, null);
            d2.x(cVar.f4696d, cVar.f4697e);
            return lVar.a(d2);
        } catch (l.b.a.v.f e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw cVar.a(charSequence, e3);
        }
    }

    public static f Z(int i2, int i3, int i4) {
        int i5;
        if (i3 != 2) {
            if (i3 == 4 || i3 == 6 || i3 == 9 || i3 == 11) {
                i5 = 30;
            }
            return P(i2, i3, i4);
        }
        i5 = m.f4663d.u((long) i2) ? 29 : 28;
        i4 = Math.min(i4, i5);
        return P(i2, i3, i4);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new n((byte) 3, this);
    }

    public t A(q qVar) {
        l.b.a.y.d b;
        g.b.a.c.c.d.u(qVar, "zone");
        g F = g.F(this, h.f4620h);
        if (!(qVar instanceof r) && (b = qVar.s().b(F)) != null && b.b()) {
            F = b.a();
        }
        return t.H(F, qVar);
    }

    public int B(f fVar) {
        int i2 = this.b - fVar.b;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.c - fVar.c;
        return i3 == 0 ? this.f4615d - fVar.f4615d : i3;
    }

    public long D(f fVar) {
        return fVar.x() - x();
    }

    public final int F(j jVar) {
        switch (((l.b.a.x.a) jVar).ordinal()) {
            case 15:
                return G().q();
            case 16:
                return ((this.f4615d - 1) % 7) + 1;
            case 17:
                return ((H() - 1) % 7) + 1;
            case 18:
                return this.f4615d;
            case 19:
                return H();
            case 20:
                throw new b(f.a.a.a.a.d("Field too large for an int: ", jVar));
            case 21:
                return ((this.f4615d - 1) / 7) + 1;
            case 22:
                return ((H() - 1) / 7) + 1;
            case 23:
                return this.c;
            case 24:
                throw new b(f.a.a.a.a.d("Field too large for an int: ", jVar));
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

    public c G() {
        return c.r(g.b.a.c.c.d.k(x() + 3, 7) + 1);
    }

    public int H() {
        return (i.u(this.c).q(K()) + this.f4615d) - 1;
    }

    public final long I() {
        return (((long) this.b) * 12) + ((long) (this.c - 1));
    }

    public boolean J(b bVar) {
        return bVar instanceof f ? B((f) bVar) < 0 : x() < bVar.x();
    }

    public boolean K() {
        return m.f4663d.u((long) this.b);
    }

    /* renamed from: L */
    public f u(long j2, l.b.a.x.m mVar) {
        return j2 == Long.MIN_VALUE ? v(Long.MAX_VALUE, mVar).v(1, mVar) : v(-j2, mVar);
    }

    public f M(long j2) {
        return j2 == Long.MIN_VALUE ? V(Long.MAX_VALUE).V(1) : V(-j2);
    }

    public final long N(f fVar) {
        return (((fVar.I() * 32) + ((long) fVar.f4615d)) - ((I() * 32) + ((long) this.f4615d))) / 32;
    }

    /* renamed from: U */
    public f v(long j2, l.b.a.x.m mVar) {
        if (!(mVar instanceof l.b.a.x.b)) {
            return (f) mVar.c(this, j2);
        }
        switch (((l.b.a.x.b) mVar).ordinal()) {
            case 7:
                return V(j2);
            case 8:
                return X(j2);
            case 9:
                return W(j2);
            case 10:
                return Y(j2);
            case 11:
                return Y(g.b.a.c.c.d.x(j2, 10));
            case 12:
                return Y(g.b.a.c.c.d.x(j2, 100));
            case 13:
                return Y(g.b.a.c.c.d.x(j2, 1000));
            case 14:
                l.b.a.x.a aVar = l.b.a.x.a.ERA;
                return z(aVar, g.b.a.c.c.d.w(i(aVar), j2));
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public f V(long j2) {
        return j2 == 0 ? this : R(g.b.a.c.c.d.w(x(), j2));
    }

    public f W(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (((long) this.b) * 12) + ((long) (this.c - 1)) + j2;
        return Z(l.b.a.x.a.YEAR.m(g.b.a.c.c.d.i(j3, 12)), g.b.a.c.c.d.k(j3, 12) + 1, this.f4615d);
    }

    public f X(long j2) {
        return V(g.b.a.c.c.d.x(j2, 7));
    }

    public f Y(long j2) {
        return j2 == 0 ? this : Z(l.b.a.x.a.YEAR.m(((long) this.b) + j2), this.c, this.f4615d);
    }

    @Override // l.b.a.w.c, l.b.a.x.e
    public o a(j jVar) {
        int i2;
        if (!(jVar instanceof l.b.a.x.a)) {
            return jVar.l(this);
        }
        l.b.a.x.a aVar = (l.b.a.x.a) jVar;
        if (aVar.a()) {
            int ordinal = aVar.ordinal();
            if (ordinal == 18) {
                short s = this.c;
                i2 = s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : K() ? 29 : 28;
            } else if (ordinal == 19) {
                i2 = K() ? 366 : 365;
            } else if (ordinal == 21) {
                return o.d(1, (i.u(this.c) != i.FEBRUARY || K()) ? 5 : 4);
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
    public f y(l.b.a.x.f fVar) {
        return fVar instanceof f ? (f) fVar : (f) fVar.n(this);
    }

    @Override // l.b.a.w.c, l.b.a.x.e
    public int b(j jVar) {
        return jVar instanceof l.b.a.x.a ? F(jVar) : a(jVar).a(i(jVar), jVar);
    }

    /* renamed from: b0 */
    public f z(j jVar, long j2) {
        if (!(jVar instanceof l.b.a.x.a)) {
            return (f) jVar.c(this, j2);
        }
        l.b.a.x.a aVar = (l.b.a.x.a) jVar;
        aVar.f4761e.b(j2, aVar);
        switch (aVar.ordinal()) {
            case 15:
                return V(j2 - ((long) G().q()));
            case 16:
                return V(j2 - i(l.b.a.x.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 17:
                return V(j2 - i(l.b.a.x.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 18:
                int i2 = (int) j2;
                return this.f4615d == i2 ? this : P(this.b, this.c, i2);
            case 19:
                int i3 = (int) j2;
                return H() == i3 ? this : S(this.b, i3);
            case 20:
                return R(j2);
            case 21:
                return X(j2 - i(l.b.a.x.a.ALIGNED_WEEK_OF_MONTH));
            case 22:
                return X(j2 - i(l.b.a.x.a.ALIGNED_WEEK_OF_YEAR));
            case 23:
                int i4 = (int) j2;
                if (this.c == i4) {
                    return this;
                }
                l.b.a.x.a aVar2 = l.b.a.x.a.MONTH_OF_YEAR;
                aVar2.f4761e.b((long) i4, aVar2);
                return Z(this.b, i4, this.f4615d);
            case 24:
                return W(j2 - i(l.b.a.x.a.PROLEPTIC_MONTH));
            case 25:
                if (this.b < 1) {
                    j2 = 1 - j2;
                }
                return c0((int) j2);
            case 26:
                return c0((int) j2);
            case 27:
                return i(l.b.a.x.a.ERA) == j2 ? this : c0(1 - this.b);
            default:
                throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.b.a.u.b, l.b.a.w.c, l.b.a.x.e
    public <R> R c(l<R> lVar) {
        return lVar == k.f4779f ? this : (R) super.c(lVar);
    }

    public f c0(int i2) {
        if (this.b == i2) {
            return this;
        }
        l.b.a.x.a aVar = l.b.a.x.a.YEAR;
        aVar.f4761e.b((long) i2, aVar);
        return Z(i2, this.c, this.f4615d);
    }

    @Override // l.b.a.u.b, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && B((f) obj) == 0;
    }

    @Override // l.b.a.u.b, l.b.a.x.e
    public boolean f(j jVar) {
        return super.f(jVar);
    }

    @Override // l.b.a.u.b, java.lang.Object
    public int hashCode() {
        int i2 = this.b;
        return (((i2 << 11) + (this.c << 6)) + this.f4615d) ^ (i2 & -2048);
    }

    @Override // l.b.a.x.e
    public long i(j jVar) {
        return jVar instanceof l.b.a.x.a ? jVar == l.b.a.x.a.EPOCH_DAY ? x() : jVar == l.b.a.x.a.PROLEPTIC_MONTH ? I() : (long) F(jVar) : jVar.f(this);
    }

    @Override // l.b.a.u.b, l.b.a.x.f
    public d n(d dVar) {
        return super.n(dVar);
    }

    @Override // l.b.a.x.d
    public long o(d dVar, l.b.a.x.m mVar) {
        long D;
        long j2;
        f E = E(dVar);
        if (!(mVar instanceof l.b.a.x.b)) {
            return mVar.b(this, E);
        }
        switch (((l.b.a.x.b) mVar).ordinal()) {
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
                l.b.a.x.a aVar = l.b.a.x.a.ERA;
                return E.i(aVar) - i(aVar);
            default:
                throw new n("Unsupported unit: " + mVar);
        }
        return D / j2;
    }

    @Override // l.b.a.u.b
    public l.b.a.u.c q(h hVar) {
        return g.F(this, hVar);
    }

    @Override // l.b.a.u.b
    /* renamed from: r */
    public int compareTo(b bVar) {
        return bVar instanceof f ? B((f) bVar) : super.compareTo(bVar);
    }

    @Override // l.b.a.u.b
    public h s() {
        return m.f4663d;
    }

    @Override // l.b.a.u.b
    public i t() {
        return super.t();
    }

    @Override // l.b.a.u.b, java.lang.Object
    public String toString() {
        int i2;
        int i3 = this.b;
        short s = this.c;
        short s2 = this.f4615d;
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

    @Override // l.b.a.u.b
    public b w(l.b.a.x.i iVar) {
        return (f) ((m) iVar).b(this);
    }

    @Override // l.b.a.u.b
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
        long j6 = (((367 * j4) - 362) / 12) + j2 + ((long) (this.f4615d - 1));
        if (j4 > 2) {
            j6--;
            if (!K()) {
                j6--;
            }
        }
        return j6 - 719528;
    }
}
