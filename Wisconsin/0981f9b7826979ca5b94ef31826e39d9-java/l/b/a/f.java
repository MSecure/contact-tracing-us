package l.b.a;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Objects;
import l.b.a.t.c;
import l.b.a.w.d;
import l.b.a.w.e;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.m;
import l.b.a.w.n;
import l.b.a.w.o;

public final class f extends c<e> implements d, l.b.a.w.f, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final f f4045d = F(e.f4041e, g.f4047f);

    /* renamed from: e  reason: collision with root package name */
    public static final f f4046e = F(e.f4042f, g.f4048g);
    public final e b;
    public final g c;

    public f(e eVar, g gVar) {
        this.b = eVar;
        this.c = gVar;
    }

    public static f C(e eVar) {
        if (eVar instanceof f) {
            return (f) eVar;
        }
        if (eVar instanceof s) {
            return ((s) eVar).b;
        }
        try {
            return new f(e.E(eVar), g.s(eVar));
        } catch (a unused) {
            throw new a(a.f(eVar, a.k("Unable to obtain LocalDateTime from TemporalAccessor: ", eVar, ", type ")));
        }
    }

    public static f F(e eVar, g gVar) {
        b.B1(eVar, "date");
        b.B1(gVar, "time");
        return new f(eVar, gVar);
    }

    public static f G(long j2, int i2, q qVar) {
        b.B1(qVar, "offset");
        long j3 = j2 + ((long) qVar.c);
        long B0 = b.B0(j3, 86400);
        int C0 = b.C0(j3, 86400);
        e R = e.R(B0);
        long j4 = (long) C0;
        g gVar = g.f4047f;
        l.b.a.w.a aVar = l.b.a.w.a.SECOND_OF_DAY;
        aVar.f4190e.b(j4, aVar);
        l.b.a.w.a aVar2 = l.b.a.w.a.NANO_OF_SECOND;
        aVar2.f4190e.b((long) i2, aVar2);
        int i3 = (int) (j4 / 3600);
        long j5 = j4 - ((long) (i3 * 3600));
        int i4 = (int) (j5 / 60);
        return new f(R, g.r(i3, i4, (int) (j5 - ((long) (i4 * 60))), i2));
    }

    public static f M(DataInput dataInput) {
        e eVar = e.f4041e;
        return F(e.P(dataInput.readInt(), dataInput.readByte(), dataInput.readByte()), g.D(dataInput));
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 4, this);
    }

    public final int B(f fVar) {
        int B = this.b.B(fVar.b);
        return B == 0 ? this.c.compareTo(fVar.c) : B;
    }

    public boolean D(c<?> cVar) {
        if (cVar instanceof f) {
            return B((f) cVar) < 0;
        }
        int i2 = (x().x() > cVar.x().x() ? 1 : (x().x() == cVar.x().x() ? 0 : -1));
        return i2 < 0 || (i2 == 0 && y().E() < cVar.y().E());
    }

    /* renamed from: E */
    public f t(long j2, m mVar) {
        return j2 == Long.MIN_VALUE ? u(Long.MAX_VALUE, mVar).u(1, mVar) : u(-j2, mVar);
    }

    /* renamed from: H */
    public f u(long j2, m mVar) {
        if (!(mVar instanceof l.b.a.w.b)) {
            return (f) mVar.c(this, j2);
        }
        switch (((l.b.a.w.b) mVar).ordinal()) {
            case 0:
                return J(j2);
            case 1:
                return I(j2 / 86400000000L).J((j2 % 86400000000L) * 1000);
            case 2:
                return I(j2 / 86400000).J((j2 % 86400000) * 1000000);
            case 3:
                return K(j2);
            case 4:
                return L(this.b, 0, j2, 0, 0, 1);
            case 5:
                return L(this.b, j2, 0, 0, 0, 1);
            case 6:
                f I = I(j2 / 256);
                return I.L(I.b, (j2 % 256) * 12, 0, 0, 0, 1);
            default:
                return N(this.b.v(j2, mVar), this.c);
        }
    }

    public f I(long j2) {
        return N(this.b.V(j2), this.c);
    }

    public f J(long j2) {
        return L(this.b, 0, 0, 0, j2, 1);
    }

    public f K(long j2) {
        return L(this.b, 0, 0, j2, 0, 1);
    }

    public final f L(e eVar, long j2, long j3, long j4, long j5, int i2) {
        g w;
        e eVar2 = eVar;
        if ((j2 | j3 | j4 | j5) == 0) {
            w = this.c;
        } else {
            long j6 = j2 / 24;
            long j7 = j6 + (j3 / 1440) + (j4 / 86400) + (j5 / 86400000000000L);
            long j8 = (long) i2;
            long j9 = ((j2 % 24) * 3600000000000L) + ((j3 % 1440) * 60000000000L) + ((j4 % 86400) * 1000000000) + (j5 % 86400000000000L);
            long E = this.c.E();
            long j10 = (j9 * j8) + E;
            long B0 = b.B0(j10, 86400000000000L) + (j7 * j8);
            long D0 = b.D0(j10, 86400000000000L);
            w = D0 == E ? this.c : g.w(D0);
            eVar2 = eVar2.V(B0);
        }
        return N(eVar2, w);
    }

    public final f N(e eVar, g gVar) {
        return (this.b == eVar && this.c == gVar) ? this : new f(eVar, gVar);
    }

    /* renamed from: O */
    public f z(l.b.a.w.f fVar) {
        return fVar instanceof e ? N((e) fVar, this.c) : fVar instanceof g ? N(this.b, (g) fVar) : fVar instanceof f ? (f) fVar : (f) fVar.n(this);
    }

    /* renamed from: P */
    public f l(j jVar, long j2) {
        return jVar instanceof l.b.a.w.a ? jVar.i() ? N(this.b, this.c.l(jVar, j2)) : N(this.b.z(jVar, j2), this.c) : (f) jVar.c(this, j2);
    }

    public void Q(DataOutput dataOutput) {
        e eVar = this.b;
        dataOutput.writeInt(eVar.b);
        dataOutput.writeByte(eVar.c);
        dataOutput.writeByte(eVar.f4044d);
        this.c.J(dataOutput);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        return jVar instanceof l.b.a.w.a ? jVar.i() ? this.c.a(jVar) : this.b.a(jVar) : jVar.l(this);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public int b(j jVar) {
        return jVar instanceof l.b.a.w.a ? jVar.i() ? this.c.b(jVar) : this.b.b(jVar) : super.b(jVar);
    }

    @Override // l.b.a.v.c, l.b.a.w.e, l.b.a.t.c
    public <R> R c(l<R> lVar) {
        return lVar == k.f4208f ? (R) this.b : (R) super.c(lVar);
    }

    @Override // l.b.a.t.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.b.equals(fVar.b) && this.c.equals(fVar.c);
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof l.b.a.w.a ? jVar.a() || jVar.i() : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.t.c
    public int hashCode() {
        return this.b.hashCode() ^ this.c.hashCode();
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        return jVar instanceof l.b.a.w.a ? jVar.i() ? this.c.i(jVar) : this.b.i(jVar) : jVar.f(this);
    }

    @Override // l.b.a.w.f, l.b.a.t.c
    public d n(d dVar) {
        return super.n(dVar);
    }

    @Override // l.b.a.w.d
    public long o(d dVar, m mVar) {
        f C = C(dVar);
        if (!(mVar instanceof l.b.a.w.b)) {
            return mVar.b(this, C);
        }
        l.b.a.w.b bVar = (l.b.a.w.b) mVar;
        boolean z = false;
        if (bVar.compareTo(l.b.a.w.b.DAYS) < 0) {
            long D = this.b.D(C.b);
            long E = C.c.E() - this.c.E();
            int i2 = (D > 0 ? 1 : (D == 0 ? 0 : -1));
            if (i2 > 0 && E < 0) {
                D--;
                E += 86400000000000L;
            } else if (i2 < 0 && E > 0) {
                D++;
                E -= 86400000000000L;
            }
            switch (bVar.ordinal()) {
                case 0:
                    return b.H1(b.J1(D, 86400000000000L), E);
                case 1:
                    return b.H1(b.J1(D, 86400000000L), E / 1000);
                case 2:
                    return b.H1(b.J1(D, 86400000), E / 1000000);
                case 3:
                    return b.H1(b.I1(D, 86400), E / 1000000000);
                case 4:
                    return b.H1(b.I1(D, 1440), E / 60000000000L);
                case 5:
                    return b.H1(b.I1(D, 24), E / 3600000000000L);
                case 6:
                    return b.H1(b.I1(D, 2), E / 43200000000000L);
                default:
                    throw new n("Unsupported unit: " + mVar);
            }
        } else {
            e eVar = C.b;
            e eVar2 = this.b;
            Objects.requireNonNull(eVar);
            if (!(eVar2 instanceof e) ? eVar.x() > eVar2.x() : eVar.B(eVar2) > 0) {
                if (C.c.compareTo(this.c) < 0) {
                    eVar = eVar.M(1);
                    return this.b.o(eVar, mVar);
                }
            }
            if (eVar.J(this.b)) {
                if (C.c.compareTo(this.c) > 0) {
                    z = true;
                }
                if (z) {
                    eVar = eVar.V(1);
                }
            }
            return this.b.o(eVar, mVar);
        }
    }

    /* Return type fixed from 'l.b.a.t.f' to match base method */
    @Override // l.b.a.t.c
    public l.b.a.t.f<e> q(p pVar) {
        return s.H(this, pVar);
    }

    @Override // l.b.a.t.c
    /* renamed from: r */
    public int compareTo(c<?> cVar) {
        return cVar instanceof f ? B((f) cVar) : super.compareTo(cVar);
    }

    @Override // l.b.a.t.c
    public String toString() {
        return this.b.toString() + 'T' + this.c.toString();
    }

    /* Return type fixed from 'l.b.a.t.b' to match base method */
    @Override // l.b.a.t.c
    public e x() {
        return this.b;
    }

    @Override // l.b.a.t.c
    public g y() {
        return this.c;
    }
}
