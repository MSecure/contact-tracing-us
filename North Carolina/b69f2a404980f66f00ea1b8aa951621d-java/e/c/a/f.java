package e.c.a;

import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a.a;
import com.google.android.gms.nearby.messages.Strategy;
import e.c.a.t.c;
import e.c.a.w.b;
import e.c.a.w.d;
import e.c.a.w.e;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.m;
import e.c.a.w.n;
import e.c.a.w.o;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class f extends c<e> implements d, e.c.a.w.f, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final f f4973d = I(e.f4969e, g.f);

    /* renamed from: e  reason: collision with root package name */
    public static final f f4974e = I(e.f, g.g);

    /* renamed from: b  reason: collision with root package name */
    public final e f4975b;

    /* renamed from: c  reason: collision with root package name */
    public final g f4976c;

    public f(e eVar, g gVar) {
        this.f4975b = eVar;
        this.f4976c = gVar;
    }

    public static f E(e eVar) {
        if (eVar instanceof f) {
            return (f) eVar;
        }
        if (eVar instanceof s) {
            return ((s) eVar).f5008b;
        }
        try {
            return new f(e.F(eVar), g.u(eVar));
        } catch (a unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain LocalDateTime from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(a.d(eVar, sb));
        }
    }

    public static f H(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new f(e.P(i, i2, i3), g.y(i4, i5, i6, i7));
    }

    public static f I(e eVar, g gVar) {
        c.b.a.a.c.n.c.T1(eVar, "date");
        c.b.a.a.c.n.c.T1(gVar, "time");
        return new f(eVar, gVar);
    }

    public static f J(long j, int i, q qVar) {
        c.b.a.a.c.n.c.T1(qVar, "offset");
        long j2 = j + ((long) qVar.f5002b);
        return new f(e.R(c.b.a.a.c.n.c.R0(j2, 86400)), g.B((long) c.b.a.a.c.n.c.T0(j2, Strategy.TTL_SECONDS_MAX), i));
    }

    public static f P(DataInput dataInput) {
        return I(e.Z(dataInput), g.H(dataInput));
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 4, this);
    }

    @Override // e.c.a.t.c
    public g A() {
        return this.f4976c;
    }

    public final int D(f fVar) {
        int C = this.f4975b.C(fVar.f4975b);
        return C == 0 ? this.f4976c.compareTo(fVar.f4976c) : C;
    }

    public boolean F(c<?> cVar) {
        if (cVar instanceof f) {
            return D((f) cVar) < 0;
        }
        int i = (this.f4975b.z() > ((f) cVar).f4975b.z() ? 1 : (this.f4975b.z() == ((f) cVar).f4975b.z() ? 0 : -1));
        return i < 0 || (i == 0 && this.f4976c.I() < ((f) cVar).f4976c.I());
    }

    /* renamed from: G */
    public f v(long j, m mVar) {
        return j == Long.MIN_VALUE ? w(RecyclerView.FOREVER_NS, mVar).w(1, mVar) : w(-j, mVar);
    }

    /* renamed from: K */
    public f w(long j, m mVar) {
        if (!(mVar instanceof b)) {
            return (f) mVar.f(this, j);
        }
        switch (((b) mVar).ordinal()) {
            case 0:
                return M(j);
            case 1:
                return L(j / 86400000000L).M((j % 86400000000L) * 1000);
            case 2:
                return L(j / 86400000).M((j % 86400000) * 1000000);
            case 3:
                return N(j);
            case 4:
                return O(this.f4975b, 0, j, 0, 0, 1);
            case 5:
                return O(this.f4975b, j, 0, 0, 0, 1);
            case 6:
                f L = L(j / 256);
                return L.O(L.f4975b, (j % 256) * 12, 0, 0, 0, 1);
            default:
                return Q(this.f4975b.x(j, mVar), this.f4976c);
        }
    }

    public f L(long j) {
        return Q(this.f4975b.V(j), this.f4976c);
    }

    public f M(long j) {
        return O(this.f4975b, 0, 0, 0, j, 1);
    }

    public f N(long j) {
        return O(this.f4975b, 0, 0, j, 0, 1);
    }

    public final f O(e eVar, long j, long j2, long j3, long j4, int i) {
        g z;
        e eVar2 = eVar;
        if ((j | j2 | j3 | j4) == 0) {
            z = this.f4976c;
        } else {
            long j5 = j / 24;
            long j6 = j5 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
            long j7 = (long) i;
            long j8 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L);
            long I = this.f4976c.I();
            long j9 = (j8 * j7) + I;
            long R0 = c.b.a.a.c.n.c.R0(j9, 86400000000000L) + (j6 * j7);
            long U0 = c.b.a.a.c.n.c.U0(j9, 86400000000000L);
            z = U0 == I ? this.f4976c : g.z(U0);
            eVar2 = eVar2.V(R0);
        }
        return Q(eVar2, z);
    }

    public final f Q(e eVar, g gVar) {
        return (this.f4975b == eVar && this.f4976c == gVar) ? this : new f(eVar, gVar);
    }

    /* renamed from: R */
    public f g(e.c.a.w.f fVar) {
        return fVar instanceof e ? Q((e) fVar, this.f4976c) : fVar instanceof g ? Q(this.f4975b, (g) fVar) : fVar instanceof f ? (f) fVar : (f) fVar.p(this);
    }

    /* renamed from: S */
    public f n(j jVar, long j) {
        return jVar instanceof e.c.a.w.a ? jVar.l() ? Q(this.f4975b, this.f4976c.n(jVar, j)) : Q(this.f4975b.n(jVar, j), this.f4976c) : (f) jVar.f(this, j);
    }

    public void T(DataOutput dataOutput) {
        e eVar = this.f4975b;
        dataOutput.writeInt(eVar.f4970b);
        dataOutput.writeByte(eVar.f4971c);
        dataOutput.writeByte(eVar.f4972d);
        this.f4976c.N(dataOutput);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        return jVar instanceof e.c.a.w.a ? jVar.l() ? this.f4976c.b(jVar) : this.f4975b.b(jVar) : jVar.n(this);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public int d(j jVar) {
        return jVar instanceof e.c.a.w.a ? jVar.l() ? this.f4976c.d(jVar) : this.f4975b.d(jVar) : super.d(jVar);
    }

    @Override // e.c.a.t.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f4975b.equals(fVar.f4975b) && this.f4976c.equals(fVar.f4976c);
    }

    @Override // e.c.a.v.c, e.c.a.t.c, e.c.a.w.e
    public <R> R f(l<R> lVar) {
        return lVar == k.f ? (R) this.f4975b : (R) super.f(lVar);
    }

    @Override // e.c.a.t.c
    public int hashCode() {
        return this.f4975b.hashCode() ^ this.f4976c.hashCode();
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof e.c.a.w.a ? jVar.b() || jVar.l() : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        return jVar instanceof e.c.a.w.a ? jVar.l() ? this.f4976c.l(jVar) : this.f4975b.l(jVar) : jVar.i(this);
    }

    @Override // e.c.a.t.c, e.c.a.w.f
    public d p(d dVar) {
        return super.p(dVar);
    }

    @Override // e.c.a.w.d
    public long q(d dVar, m mVar) {
        f E = E(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, E);
        }
        b bVar = (b) mVar;
        boolean z = true;
        if (bVar.compareTo(b.DAYS) < 0) {
            long E2 = this.f4975b.E(E.f4975b);
            long I = E.f4976c.I() - this.f4976c.I();
            int i = (E2 > 0 ? 1 : (E2 == 0 ? 0 : -1));
            if (i > 0 && I < 0) {
                E2--;
                I += 86400000000000L;
            } else if (i < 0 && I > 0) {
                E2++;
                I -= 86400000000000L;
            }
            switch (bVar.ordinal()) {
                case 0:
                    return c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.a2(E2, 86400000000000L), I);
                case 1:
                    return c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.a2(E2, 86400000000L), I / 1000);
                case 2:
                    return c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.a2(E2, 86400000), I / 1000000);
                case 3:
                    return c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.Z1(E2, Strategy.TTL_SECONDS_MAX), I / 1000000000);
                case 4:
                    return c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.Z1(E2, 1440), I / 60000000000L);
                case 5:
                    return c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.Z1(E2, 24), I / 3600000000000L);
                case 6:
                    return c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.Z1(E2, 2), I / 43200000000000L);
                default:
                    throw new n("Unsupported unit: " + mVar);
            }
        } else {
            e eVar = E.f4975b;
            e eVar2 = this.f4975b;
            if (eVar != null) {
                if (!(eVar2 instanceof e) ? eVar.z() > eVar2.z() : eVar.C(eVar2) > 0) {
                    if (E.f4976c.compareTo(this.f4976c) < 0) {
                        eVar = eVar.N(1);
                        return this.f4975b.q(eVar, mVar);
                    }
                }
                if (eVar.K(this.f4975b)) {
                    if (E.f4976c.compareTo(this.f4976c) <= 0) {
                        z = false;
                    }
                    if (z) {
                        eVar = eVar.V(1);
                    }
                }
                return this.f4975b.q(eVar, mVar);
            }
            throw null;
        }
    }

    /* Return type fixed from 'e.c.a.t.f' to match base method */
    @Override // e.c.a.t.c
    public e.c.a.t.f<e> s(p pVar) {
        return s.I(this, pVar);
    }

    @Override // e.c.a.t.c
    /* renamed from: t */
    public int compareTo(c<?> cVar) {
        return cVar instanceof f ? D((f) cVar) : super.compareTo(cVar);
    }

    @Override // e.c.a.t.c
    public String toString() {
        return this.f4975b.toString() + 'T' + this.f4976c.toString();
    }

    /* Return type fixed from 'e.c.a.t.b' to match base method */
    @Override // e.c.a.t.c
    public e z() {
        return this.f4975b;
    }
}
