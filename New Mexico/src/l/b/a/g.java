package l.b.a;

import f.a.a.a.a;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Objects;
import l.b.a.u.c;
import l.b.a.x.b;
import l.b.a.x.d;
import l.b.a.x.e;
import l.b.a.x.f;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.m;
import l.b.a.x.n;
import l.b.a.x.o;
/* loaded from: classes.dex */
public final class g extends c<f> implements d, f, Serializable {

    /* renamed from: d */
    public static final g f4616d = F(f.f4612e, h.f4618f);

    /* renamed from: e */
    public static final g f4617e = F(f.f4613f, h.f4619g);
    public final f b;
    public final h c;

    public g(f fVar, h hVar) {
        this.b = fVar;
        this.c = hVar;
    }

    public static g C(e eVar) {
        if (eVar instanceof g) {
            return (g) eVar;
        }
        if (eVar instanceof t) {
            return ((t) eVar).b;
        }
        try {
            return new g(f.E(eVar), h.s(eVar));
        } catch (b unused) {
            throw new b(a.f(eVar, a.k("Unable to obtain LocalDateTime from TemporalAccessor: ", eVar, ", type ")));
        }
    }

    public static g F(f fVar, h hVar) {
        g.b.a.c.c.d.u(fVar, "date");
        g.b.a.c.c.d.u(hVar, "time");
        return new g(fVar, hVar);
    }

    public static g G(long j2, int i2, r rVar) {
        g.b.a.c.c.d.u(rVar, "offset");
        long j3 = j2 + ((long) rVar.c);
        long i3 = g.b.a.c.c.d.i(j3, 86400);
        int k2 = g.b.a.c.c.d.k(j3, 86400);
        f R = f.R(i3);
        long j4 = (long) k2;
        h hVar = h.f4618f;
        l.b.a.x.a aVar = l.b.a.x.a.SECOND_OF_DAY;
        aVar.f4761e.b(j4, aVar);
        l.b.a.x.a aVar2 = l.b.a.x.a.NANO_OF_SECOND;
        aVar2.f4761e.b((long) i2, aVar2);
        int i4 = (int) (j4 / 3600);
        long j5 = j4 - ((long) (i4 * 3600));
        int i5 = (int) (j5 / 60);
        return new g(R, h.r(i4, i5, (int) (j5 - ((long) (i5 * 60))), i2));
    }

    public static g M(DataInput dataInput) {
        f fVar = f.f4612e;
        return F(f.P(dataInput.readInt(), dataInput.readByte(), dataInput.readByte()), h.D(dataInput));
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new n((byte) 4, this);
    }

    public final int B(g gVar) {
        int B = this.b.B(gVar.b);
        return B == 0 ? this.c.compareTo(gVar.c) : B;
    }

    public boolean D(c<?> cVar) {
        if (cVar instanceof g) {
            return B((g) cVar) < 0;
        }
        int i2 = (x().x() > cVar.x().x() ? 1 : (x().x() == cVar.x().x() ? 0 : -1));
        return i2 < 0 || (i2 == 0 && y().E() < cVar.y().E());
    }

    /* renamed from: E */
    public g t(long j2, m mVar) {
        return j2 == Long.MIN_VALUE ? u(Long.MAX_VALUE, mVar).u(1, mVar) : u(-j2, mVar);
    }

    /* renamed from: H */
    public g u(long j2, m mVar) {
        if (!(mVar instanceof b)) {
            return (g) mVar.c(this, j2);
        }
        switch (((b) mVar).ordinal()) {
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
                g I = I(j2 / 256);
                return I.L(I.b, (j2 % 256) * 12, 0, 0, 0, 1);
            default:
                return N(this.b.v(j2, mVar), this.c);
        }
    }

    public g I(long j2) {
        return N(this.b.V(j2), this.c);
    }

    public g J(long j2) {
        return L(this.b, 0, 0, 0, j2, 1);
    }

    public g K(long j2) {
        return L(this.b, 0, 0, j2, 0, 1);
    }

    public final g L(f fVar, long j2, long j3, long j4, long j5, int i2) {
        h w;
        f fVar2 = fVar;
        if ((j2 | j3 | j4 | j5) == 0) {
            w = this.c;
        } else {
            long j6 = j2 / 24;
            long j7 = j6 + (j3 / 1440) + (j4 / 86400) + (j5 / 86400000000000L);
            long j8 = (long) i2;
            long j9 = ((j2 % 24) * 3600000000000L) + ((j3 % 1440) * 60000000000L) + ((j4 % 86400) * 1000000000) + (j5 % 86400000000000L);
            long E = this.c.E();
            long j10 = (j9 * j8) + E;
            long i3 = g.b.a.c.c.d.i(j10, 86400000000000L) + (j7 * j8);
            long l2 = g.b.a.c.c.d.l(j10, 86400000000000L);
            w = l2 == E ? this.c : h.w(l2);
            fVar2 = fVar2.V(i3);
        }
        return N(fVar2, w);
    }

    public final g N(f fVar, h hVar) {
        return (this.b == fVar && this.c == hVar) ? this : new g(fVar, hVar);
    }

    /* renamed from: O */
    public g z(f fVar) {
        return fVar instanceof f ? N((f) fVar, this.c) : fVar instanceof h ? N(this.b, (h) fVar) : fVar instanceof g ? (g) fVar : (g) fVar.n(this);
    }

    /* renamed from: P */
    public g l(j jVar, long j2) {
        return jVar instanceof l.b.a.x.a ? jVar.i() ? N(this.b, this.c.l(jVar, j2)) : N(this.b.z(jVar, j2), this.c) : (g) jVar.c(this, j2);
    }

    public void Q(DataOutput dataOutput) {
        f fVar = this.b;
        dataOutput.writeInt(fVar.b);
        dataOutput.writeByte(fVar.c);
        dataOutput.writeByte(fVar.f4615d);
        this.c.J(dataOutput);
    }

    public o a(j jVar) {
        return jVar instanceof l.b.a.x.a ? jVar.i() ? this.c.a(jVar) : this.b.a(jVar) : jVar.l(this);
    }

    public int b(j jVar) {
        return jVar instanceof l.b.a.x.a ? jVar.i() ? this.c.b(jVar) : this.b.b(jVar) : super.b(jVar);
    }

    public <R> R c(l<R> lVar) {
        if (lVar == k.f4779f) {
            return (R) this.b;
        }
        return (R) super.c(lVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.b.equals(gVar.b) && this.c.equals(gVar.c);
    }

    public boolean f(j jVar) {
        return jVar instanceof l.b.a.x.a ? jVar.a() || jVar.i() : jVar != null && jVar.b(this);
    }

    public int hashCode() {
        return this.b.hashCode() ^ this.c.hashCode();
    }

    public long i(j jVar) {
        return jVar instanceof l.b.a.x.a ? jVar.i() ? this.c.i(jVar) : this.b.i(jVar) : jVar.f(this);
    }

    public d n(d dVar) {
        return super.n(dVar);
    }

    public long o(d dVar, m mVar) {
        g C = C(dVar);
        if (!(mVar instanceof b)) {
            return mVar.b(this, C);
        }
        b bVar = (b) mVar;
        boolean z = false;
        if (bVar.compareTo(b.DAYS) < 0) {
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
                    return g.b.a.c.c.d.w(g.b.a.c.c.d.y(D, 86400000000000L), E);
                case 1:
                    return g.b.a.c.c.d.w(g.b.a.c.c.d.y(D, 86400000000L), E / 1000);
                case 2:
                    return g.b.a.c.c.d.w(g.b.a.c.c.d.y(D, 86400000), E / 1000000);
                case 3:
                    return g.b.a.c.c.d.w(g.b.a.c.c.d.x(D, 86400), E / 1000000000);
                case 4:
                    return g.b.a.c.c.d.w(g.b.a.c.c.d.x(D, 1440), E / 60000000000L);
                case 5:
                    return g.b.a.c.c.d.w(g.b.a.c.c.d.x(D, 24), E / 3600000000000L);
                case 6:
                    return g.b.a.c.c.d.w(g.b.a.c.c.d.x(D, 2), E / 43200000000000L);
                default:
                    throw new n("Unsupported unit: " + mVar);
            }
        } else {
            f fVar = C.b;
            f fVar2 = this.b;
            Objects.requireNonNull(fVar);
            if (!(fVar2 instanceof f) ? fVar.x() > fVar2.x() : fVar.B(fVar2) > 0) {
                if (C.c.compareTo(this.c) < 0) {
                    fVar = fVar.M(1);
                    return this.b.o(fVar, mVar);
                }
            }
            if (fVar.J(this.b)) {
                if (C.c.compareTo(this.c) > 0) {
                    z = true;
                }
                if (z) {
                    fVar = fVar.V(1);
                }
            }
            return this.b.o(fVar, mVar);
        }
    }

    public l.b.a.u.f q(q qVar) {
        return t.H(this, qVar);
    }

    /* renamed from: r */
    public int compareTo(c<?> cVar) {
        return cVar instanceof g ? B((g) cVar) : super.compareTo(cVar);
    }

    public String toString() {
        return this.b.toString() + 'T' + this.c.toString();
    }

    public l.b.a.u.b x() {
        return this.b;
    }

    public h y() {
        return this.c;
    }
}
