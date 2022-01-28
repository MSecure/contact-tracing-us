package e.c.a;

import androidx.recyclerview.widget.RecyclerView;
import c.b.a.a.c.n.c;
import e.c.a.t.b;
import e.c.a.t.h;
import e.c.a.t.i;
import e.c.a.t.m;
import e.c.a.w.d;
import e.c.a.w.f;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.n;
import e.c.a.w.o;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class e extends b implements d, f, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final e f4969e = P(-999999999, 1, 1);
    public static final e f = P(999999999, 12, 31);
    public static final l<e> g = new a();

    /* renamed from: b  reason: collision with root package name */
    public final int f4970b;

    /* renamed from: c  reason: collision with root package name */
    public final short f4971c;

    /* renamed from: d  reason: collision with root package name */
    public final short f4972d;

    public class a implements l<e> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.c.a.w.l
        public e a(e.c.a.w.e eVar) {
            return e.F(eVar);
        }
    }

    public e(int i, int i2, int i3) {
        this.f4970b = i;
        this.f4971c = (short) i2;
        this.f4972d = (short) i3;
    }

    public static e D(int i, h hVar, int i2) {
        if (i2 <= 28 || i2 <= hVar.u(m.f5027d.x((long) i))) {
            return new e(i, hVar.t(), i2);
        }
        if (i2 == 29) {
            throw new a(c.a.a.a.a.m("Invalid date 'February 29' as '", i, "' is not a leap year"));
        }
        StringBuilder g2 = c.a.a.a.a.g("Invalid date '");
        g2.append(hVar.name());
        g2.append(" ");
        g2.append(i2);
        g2.append("'");
        throw new a(g2.toString());
    }

    public static e F(e.c.a.w.e eVar) {
        e eVar2 = (e) eVar.f(k.f);
        if (eVar2 != null) {
            return eVar2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to obtain LocalDate from TemporalAccessor: ");
        sb.append(eVar);
        sb.append(", type ");
        throw new a(c.a.a.a.a.d(eVar, sb));
    }

    public static e P(int i, int i2, int i3) {
        e.c.a.w.a aVar = e.c.a.w.a.YEAR;
        aVar.f5158c.b((long) i, aVar);
        e.c.a.w.a aVar2 = e.c.a.w.a.MONTH_OF_YEAR;
        aVar2.f5158c.b((long) i2, aVar2);
        e.c.a.w.a aVar3 = e.c.a.w.a.DAY_OF_MONTH;
        aVar3.f5158c.b((long) i3, aVar3);
        return D(i, h.w(i2), i3);
    }

    public static e Q(int i, h hVar, int i2) {
        e.c.a.w.a aVar = e.c.a.w.a.YEAR;
        aVar.f5158c.b((long) i, aVar);
        c.T1(hVar, "month");
        e.c.a.w.a aVar2 = e.c.a.w.a.DAY_OF_MONTH;
        aVar2.f5158c.b((long) i2, aVar2);
        return D(i, hVar, i2);
    }

    public static e R(long j) {
        long j2;
        e.c.a.w.a aVar = e.c.a.w.a.EPOCH_DAY;
        aVar.f5158c.b(j, aVar);
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
        return new e(e.c.a.w.a.YEAR.o(j5 + j2 + ((long) (i2 / 10))), ((i2 + 2) % 12) + 1, (i - (((i2 * 306) + 5) / 10)) + 1);
    }

    public static e S(int i, int i2) {
        e.c.a.w.a aVar = e.c.a.w.a.YEAR;
        long j = (long) i;
        aVar.f5158c.b(j, aVar);
        e.c.a.w.a aVar2 = e.c.a.w.a.DAY_OF_YEAR;
        aVar2.f5158c.b((long) i2, aVar2);
        boolean x = m.f5027d.x(j);
        if (i2 != 366 || x) {
            h w = h.w(((i2 - 1) / 31) + 1);
            if (i2 > (w.u(x) + w.s(x)) - 1) {
                w = h.n[((((int) 1) + 12) + w.ordinal()) % 12];
            }
            return D(i, w, (i2 - w.s(x)) + 1);
        }
        throw new a(c.a.a.a.a.m("Invalid date 'DayOfYear 366' as '", i, "' is not a leap year"));
    }

    public static e T(CharSequence charSequence, e.c.a.u.c cVar) {
        c.T1(cVar, "formatter");
        return (e) cVar.c(charSequence, g);
    }

    public static e Z(DataInput dataInput) {
        return P(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    public static e a0(int i, int i2, int i3) {
        int i4;
        if (i2 != 2) {
            if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
                i4 = 30;
            }
            return P(i, i2, i3);
        }
        i4 = m.f5027d.x((long) i) ? 29 : 28;
        i3 = Math.min(i3, i4);
        return P(i, i2, i3);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 3, this);
    }

    public int C(e eVar) {
        int i = this.f4970b - eVar.f4970b;
        if (i != 0) {
            return i;
        }
        int i2 = this.f4971c - eVar.f4971c;
        return i2 == 0 ? this.f4972d - eVar.f4972d : i2;
    }

    public long E(e eVar) {
        return eVar.z() - z();
    }

    public final int G(j jVar) {
        switch (((e.c.a.w.a) jVar).ordinal()) {
            case 15:
                return H().s();
            case 16:
                return ((this.f4972d - 1) % 7) + 1;
            case 17:
                return ((I() - 1) % 7) + 1;
            case 18:
                return this.f4972d;
            case 19:
                return I();
            case 20:
                throw new a(c.a.a.a.a.c("Field too large for an int: ", jVar));
            case 21:
                return ((this.f4972d - 1) / 7) + 1;
            case 22:
                return ((I() - 1) / 7) + 1;
            case 23:
                return this.f4971c;
            case 24:
                throw new a(c.a.a.a.a.c("Field too large for an int: ", jVar));
            case 25:
                int i = this.f4970b;
                return i >= 1 ? i : 1 - i;
            case 26:
                return this.f4970b;
            case 27:
                return this.f4970b >= 1 ? 1 : 0;
            default:
                throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
        }
    }

    public b H() {
        return b.t(c.T0(z() + 3, 7) + 1);
    }

    public int I() {
        return (h.w(this.f4971c).s(L()) + this.f4972d) - 1;
    }

    public final long J() {
        return (((long) this.f4970b) * 12) + ((long) (this.f4971c - 1));
    }

    public boolean K(b bVar) {
        return bVar instanceof e ? C((e) bVar) < 0 : z() < bVar.z();
    }

    public boolean L() {
        return m.f5027d.x((long) this.f4970b);
    }

    /* renamed from: M */
    public e w(long j, e.c.a.w.m mVar) {
        return j == Long.MIN_VALUE ? x(RecyclerView.FOREVER_NS, mVar).x(1, mVar) : x(-j, mVar);
    }

    public e N(long j) {
        return j == Long.MIN_VALUE ? V(RecyclerView.FOREVER_NS).V(1) : V(-j);
    }

    public final long O(e eVar) {
        return (((eVar.J() * 32) + ((long) eVar.f4972d)) - ((J() * 32) + ((long) this.f4972d))) / 32;
    }

    /* renamed from: U */
    public e x(long j, e.c.a.w.m mVar) {
        if (!(mVar instanceof e.c.a.w.b)) {
            return (e) mVar.f(this, j);
        }
        switch (((e.c.a.w.b) mVar).ordinal()) {
            case 7:
                return V(j);
            case 8:
                return X(j);
            case 9:
                return W(j);
            case 10:
                return Y(j);
            case 11:
                return Y(c.Z1(j, 10));
            case 12:
                return Y(c.Z1(j, 100));
            case 13:
                return Y(c.Z1(j, 1000));
            case 14:
                e.c.a.w.a aVar = e.c.a.w.a.ERA;
                return n(aVar, c.Y1(l(aVar), j));
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public e V(long j) {
        return j == 0 ? this : R(c.Y1(z(), j));
    }

    public e W(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.f4970b) * 12) + ((long) (this.f4971c - 1)) + j;
        return a0(e.c.a.w.a.YEAR.o(c.R0(j2, 12)), c.T0(j2, 12) + 1, this.f4972d);
    }

    public e X(long j) {
        return V(c.Z1(j, 7));
    }

    public e Y(long j) {
        return j == 0 ? this : a0(e.c.a.w.a.YEAR.o(((long) this.f4970b) + j), this.f4971c, this.f4972d);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        int i;
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.n(this);
        }
        e.c.a.w.a aVar = (e.c.a.w.a) jVar;
        if (aVar.b()) {
            int ordinal = aVar.ordinal();
            if (ordinal == 18) {
                short s = this.f4971c;
                i = s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : L() ? 29 : 28;
            } else if (ordinal == 19) {
                i = L() ? 366 : 365;
            } else if (ordinal == 21) {
                return o.d(1, (h.w(this.f4971c) != h.FEBRUARY || L()) ? 5 : 4);
            } else if (ordinal != 25) {
                return jVar.k();
            } else {
                return o.d(1, this.f4970b <= 0 ? 1000000000 : 999999999);
            }
            return o.d(1, (long) i);
        }
        throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
    }

    /* renamed from: b0 */
    public e g(f fVar) {
        return fVar instanceof e ? (e) fVar : (e) fVar.p(this);
    }

    /* renamed from: c0 */
    public e n(j jVar, long j) {
        if (!(jVar instanceof e.c.a.w.a)) {
            return (e) jVar.f(this, j);
        }
        e.c.a.w.a aVar = (e.c.a.w.a) jVar;
        aVar.f5158c.b(j, aVar);
        switch (aVar.ordinal()) {
            case 15:
                return V(j - ((long) H().s()));
            case 16:
                return V(j - l(e.c.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 17:
                return V(j - l(e.c.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 18:
                int i = (int) j;
                return this.f4972d == i ? this : P(this.f4970b, this.f4971c, i);
            case 19:
                int i2 = (int) j;
                return I() == i2 ? this : S(this.f4970b, i2);
            case 20:
                return R(j);
            case 21:
                return X(j - l(e.c.a.w.a.ALIGNED_WEEK_OF_MONTH));
            case 22:
                return X(j - l(e.c.a.w.a.ALIGNED_WEEK_OF_YEAR));
            case 23:
                int i3 = (int) j;
                if (this.f4971c == i3) {
                    return this;
                }
                e.c.a.w.a aVar2 = e.c.a.w.a.MONTH_OF_YEAR;
                aVar2.f5158c.b((long) i3, aVar2);
                return a0(this.f4970b, i3, this.f4972d);
            case 24:
                return W(j - l(e.c.a.w.a.PROLEPTIC_MONTH));
            case 25:
                if (this.f4970b < 1) {
                    j = 1 - j;
                }
                return d0((int) j);
            case 26:
                return d0((int) j);
            case 27:
                return l(e.c.a.w.a.ERA) == j ? this : d0(1 - this.f4970b);
            default:
                throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
        }
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public int d(j jVar) {
        return jVar instanceof e.c.a.w.a ? G(jVar) : b(jVar).a(l(jVar), jVar);
    }

    public e d0(int i) {
        if (this.f4970b == i) {
            return this;
        }
        e.c.a.w.a aVar = e.c.a.w.a.YEAR;
        aVar.f5158c.b((long) i, aVar);
        return a0(i, this.f4971c, this.f4972d);
    }

    @Override // e.c.a.t.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return C((e) obj) == 0;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: e.c.a.e */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.v.c, e.c.a.w.e, e.c.a.t.b
    public <R> R f(l<R> lVar) {
        return lVar == k.f ? this : (R) super.f(lVar);
    }

    @Override // e.c.a.t.b
    public int hashCode() {
        int i = this.f4970b;
        return (((i << 11) + (this.f4971c << 6)) + this.f4972d) ^ (i & -2048);
    }

    @Override // e.c.a.w.e, e.c.a.t.b
    public boolean i(j jVar) {
        return super.i(jVar);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        return jVar instanceof e.c.a.w.a ? jVar == e.c.a.w.a.EPOCH_DAY ? z() : jVar == e.c.a.w.a.PROLEPTIC_MONTH ? J() : (long) G(jVar) : jVar.i(this);
    }

    @Override // e.c.a.w.f, e.c.a.t.b
    public d p(d dVar) {
        return super.p(dVar);
    }

    @Override // e.c.a.w.d
    public long q(d dVar, e.c.a.w.m mVar) {
        e F = F(dVar);
        if (!(mVar instanceof e.c.a.w.b)) {
            return mVar.d(this, F);
        }
        switch (((e.c.a.w.b) mVar).ordinal()) {
            case 7:
                return E(F);
            case 8:
                return E(F) / 7;
            case 9:
                return O(F);
            case 10:
                return O(F) / 12;
            case 11:
                return O(F) / 120;
            case 12:
                return O(F) / 1200;
            case 13:
                return O(F) / 12000;
            case 14:
                return F.l(e.c.a.w.a.ERA) - l(e.c.a.w.a.ERA);
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    @Override // e.c.a.t.b
    public e.c.a.t.c s(g gVar) {
        return f.I(this, gVar);
    }

    @Override // e.c.a.t.b
    /* renamed from: t */
    public int compareTo(b bVar) {
        return bVar instanceof e ? C((e) bVar) : super.compareTo(bVar);
    }

    @Override // e.c.a.t.b
    public String toString() {
        int i;
        int i2 = this.f4970b;
        short s = this.f4971c;
        short s2 = this.f4972d;
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

    @Override // e.c.a.t.b
    public h u() {
        return m.f5027d;
    }

    @Override // e.c.a.t.b
    public i v() {
        return super.v();
    }

    @Override // e.c.a.t.b
    public b y(e.c.a.w.i iVar) {
        return (e) ((l) iVar).a(this);
    }

    @Override // e.c.a.t.b
    public long z() {
        long j;
        long j2 = (long) this.f4970b;
        long j3 = (long) this.f4971c;
        long j4 = (365 * j2) + 0;
        if (j2 >= 0) {
            j = ((j2 + 399) / 400) + (((3 + j2) / 4) - ((99 + j2) / 100)) + j4;
        } else {
            j = j4 - ((j2 / -400) + ((j2 / -4) - (j2 / -100)));
        }
        long j5 = (((367 * j3) - 362) / 12) + j + ((long) (this.f4972d - 1));
        if (j3 > 2) {
            j5--;
            if (!L()) {
                j5--;
            }
        }
        return j5 - 719528;
    }
}
