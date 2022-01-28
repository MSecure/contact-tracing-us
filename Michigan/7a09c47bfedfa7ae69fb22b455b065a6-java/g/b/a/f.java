package g.b.a;

import b.x.t;
import c.a.a.a.a;
import com.google.android.gms.nearby.messages.Strategy;
import g.b.a.t.c;
import g.b.a.w.b;
import g.b.a.w.d;
import g.b.a.w.e;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.m;
import g.b.a.w.n;
import g.b.a.w.o;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class f extends c<e> implements d, g.b.a.w.f, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final f f6412d = Y(e.f6406e, g.f6416f);

    /* renamed from: e  reason: collision with root package name */
    public static final f f6413e = Y(e.f6407f, g.f6417g);

    /* renamed from: b  reason: collision with root package name */
    public final e f6414b;

    /* renamed from: c  reason: collision with root package name */
    public final g f6415c;

    public f(e eVar, g gVar) {
        this.f6414b = eVar;
        this.f6415c = gVar;
    }

    public static f U(e eVar) {
        if (eVar instanceof f) {
            return (f) eVar;
        }
        if (eVar instanceof s) {
            return ((s) eVar).f6453b;
        }
        try {
            return new f(e.V(eVar), g.D(eVar));
        } catch (a unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain LocalDateTime from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(a.e(eVar, sb));
        }
    }

    public static f X(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new f(e.f0(i, i2, i3), g.L(i4, i5, i6, i7));
    }

    public static f Y(e eVar, g gVar) {
        t.y2(eVar, "date");
        t.y2(gVar, "time");
        return new f(eVar, gVar);
    }

    public static f Z(long j, int i, q qVar) {
        t.y2(qVar, "offset");
        long j2 = j + ((long) qVar.f6447c);
        return new f(e.h0(t.t1(j2, 86400)), g.R((long) t.v1(j2, Strategy.TTL_SECONDS_MAX), i));
    }

    public static f f0(DataInput dataInput) {
        return Y(e.p0(dataInput), g.X(dataInput));
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 4, this);
    }

    /* Return type fixed from 'g.b.a.t.f' to match base method */
    @Override // g.b.a.t.c
    public g.b.a.t.f<e> A(p pVar) {
        return s.Y(this, pVar);
    }

    @Override // g.b.a.t.c
    /* renamed from: B */
    public int compareTo(c<?> cVar) {
        return cVar instanceof f ? T((f) cVar) : super.compareTo(cVar);
    }

    /* Return type fixed from 'g.b.a.t.b' to match base method */
    @Override // g.b.a.t.c
    public e P() {
        return this.f6414b;
    }

    @Override // g.b.a.t.c
    public g Q() {
        return this.f6415c;
    }

    public final int T(f fVar) {
        int S = this.f6414b.S(fVar.f6414b);
        return S == 0 ? this.f6415c.compareTo(fVar.f6415c) : S;
    }

    public boolean V(c<?> cVar) {
        if (cVar instanceof f) {
            return T((f) cVar) < 0;
        }
        int i = (this.f6414b.P() > ((f) cVar).f6414b.P() ? 1 : (this.f6414b.P() == ((f) cVar).f6414b.P() ? 0 : -1));
        return i < 0 || (i == 0 && this.f6415c.Y() < ((f) cVar).f6415c.Y());
    }

    /* renamed from: W */
    public f m(long j, m mVar) {
        return j == Long.MIN_VALUE ? s(Long.MAX_VALUE, mVar).s(1, mVar) : s(-j, mVar);
    }

    /* renamed from: a0 */
    public f s(long j, m mVar) {
        if (!(mVar instanceof b)) {
            return (f) mVar.f(this, j);
        }
        switch (((b) mVar).ordinal()) {
            case 0:
                return c0(j);
            case 1:
                return b0(j / 86400000000L).c0((j % 86400000000L) * 1000);
            case 2:
                return b0(j / 86400000).c0((j % 86400000) * 1000000);
            case 3:
                return d0(j);
            case 4:
                return e0(this.f6414b, 0, j, 0, 0, 1);
            case 5:
                return e0(this.f6414b, j, 0, 0, 0, 1);
            case 6:
                f b0 = b0(j / 256);
                return b0.e0(b0.f6414b, (j % 256) * 12, 0, 0, 0, 1);
            default:
                return g0(this.f6414b.s(j, mVar), this.f6415c);
        }
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar.n() ? this.f6415c.b(jVar) : this.f6414b.b(jVar) : jVar.p(this);
    }

    public f b0(long j) {
        return g0(this.f6414b.l0(j), this.f6415c);
    }

    public f c0(long j) {
        return e0(this.f6414b, 0, 0, 0, j, 1);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public int d(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar.n() ? this.f6415c.d(jVar) : this.f6414b.d(jVar) : super.d(jVar);
    }

    public f d0(long j) {
        return e0(this.f6414b, 0, 0, j, 0, 1);
    }

    public final f e0(e eVar, long j, long j2, long j3, long j4, int i) {
        g P;
        e eVar2 = eVar;
        if ((j | j2 | j3 | j4) == 0) {
            P = this.f6415c;
        } else {
            long j5 = j / 24;
            long j6 = j5 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
            long j7 = (long) i;
            long j8 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L);
            long Y = this.f6415c.Y();
            long j9 = (j8 * j7) + Y;
            long t1 = t.t1(j9, 86400000000000L) + (j6 * j7);
            long w1 = t.w1(j9, 86400000000000L);
            P = w1 == Y ? this.f6415c : g.P(w1);
            eVar2 = eVar2.l0(t1);
        }
        return g0(eVar2, P);
    }

    @Override // g.b.a.t.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f6414b.equals(fVar.f6414b) && this.f6415c.equals(fVar.f6415c);
    }

    @Override // g.b.a.w.e, g.b.a.t.c, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        return lVar == k.f6661f ? (R) this.f6414b : (R) super.f(lVar);
    }

    public final f g0(e eVar, g gVar) {
        return (this.f6414b == eVar && this.f6415c == gVar) ? this : new f(eVar, gVar);
    }

    /* renamed from: h0 */
    public f i(g.b.a.w.f fVar) {
        return fVar instanceof e ? g0((e) fVar, this.f6415c) : fVar instanceof g ? g0(this.f6414b, (g) fVar) : fVar instanceof f ? (f) fVar : (f) fVar.t(this);
    }

    @Override // g.b.a.t.c
    public int hashCode() {
        return this.f6414b.hashCode() ^ this.f6415c.hashCode();
    }

    /* renamed from: i0 */
    public f r(j jVar, long j) {
        return jVar instanceof g.b.a.w.a ? jVar.n() ? g0(this.f6414b, this.f6415c.r(jVar, j)) : g0(this.f6414b.r(jVar, j), this.f6415c) : (f) jVar.f(this, j);
    }

    public void j0(DataOutput dataOutput) {
        e eVar = this.f6414b;
        dataOutput.writeInt(eVar.f6409b);
        dataOutput.writeByte(eVar.f6410c);
        dataOutput.writeByte(eVar.f6411d);
        this.f6415c.d0(dataOutput);
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar.b() || jVar.n() : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar.n() ? this.f6415c.n(jVar) : this.f6414b.n(jVar) : jVar.k(this);
    }

    @Override // g.b.a.w.f, g.b.a.t.c
    public d t(d dVar) {
        return super.t(dVar);
    }

    @Override // g.b.a.t.c
    public String toString() {
        return this.f6414b.toString() + 'T' + this.f6415c.toString();
    }

    @Override // g.b.a.w.d
    public long y(d dVar, m mVar) {
        f U = U(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, U);
        }
        b bVar = (b) mVar;
        boolean z = true;
        if (bVar.compareTo(b.DAYS) < 0) {
            long U2 = this.f6414b.U(U.f6414b);
            long Y = U.f6415c.Y() - this.f6415c.Y();
            int i = (U2 > 0 ? 1 : (U2 == 0 ? 0 : -1));
            if (i > 0 && Y < 0) {
                U2--;
                Y += 86400000000000L;
            } else if (i < 0 && Y > 0) {
                U2++;
                Y -= 86400000000000L;
            }
            switch (bVar.ordinal()) {
                case 0:
                    return t.D2(t.F2(U2, 86400000000000L), Y);
                case 1:
                    return t.D2(t.F2(U2, 86400000000L), Y / 1000);
                case 2:
                    return t.D2(t.F2(U2, 86400000), Y / 1000000);
                case 3:
                    return t.D2(t.E2(U2, Strategy.TTL_SECONDS_MAX), Y / 1000000000);
                case 4:
                    return t.D2(t.E2(U2, 1440), Y / 60000000000L);
                case 5:
                    return t.D2(t.E2(U2, 24), Y / 3600000000000L);
                case 6:
                    return t.D2(t.E2(U2, 2), Y / 43200000000000L);
                default:
                    throw new n("Unsupported unit: " + mVar);
            }
        } else {
            e eVar = U.f6414b;
            e eVar2 = this.f6414b;
            if (eVar != null) {
                if (!(eVar2 instanceof e) ? eVar.P() > eVar2.P() : eVar.S(eVar2) > 0) {
                    if (U.f6415c.compareTo(this.f6415c) < 0) {
                        eVar = eVar.d0(1);
                        return this.f6414b.y(eVar, mVar);
                    }
                }
                if (eVar.a0(this.f6414b)) {
                    if (U.f6415c.compareTo(this.f6415c) <= 0) {
                        z = false;
                    }
                    if (z) {
                        eVar = eVar.l0(1);
                    }
                }
                return this.f6414b.y(eVar, mVar);
            }
            throw null;
        }
    }
}
