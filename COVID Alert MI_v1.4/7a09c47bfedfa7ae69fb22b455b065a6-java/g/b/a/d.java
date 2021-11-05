package g.b.a;

import b.x.t;
import com.google.android.gms.nearby.messages.Strategy;
import g.b.a.v.c;
import g.b.a.w.a;
import g.b.a.w.b;
import g.b.a.w.e;
import g.b.a.w.f;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.m;
import g.b.a.w.n;
import g.b.a.w.o;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class d extends c implements g.b.a.w.d, f, Comparable<d>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final d f6403d = new d(0, 0);

    /* renamed from: b  reason: collision with root package name */
    public final long f6404b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6405c;

    static {
        G(-31557014167219200L, 0);
        G(31556889864403199L, 999999999);
    }

    public d(long j, int i) {
        this.f6404b = j;
        this.f6405c = i;
    }

    public static d A(long j, int i) {
        if ((((long) i) | j) == 0) {
            return f6403d;
        }
        if (j >= -31557014167219200L && j <= 31556889864403199L) {
            return new d(j, i);
        }
        throw new a("Instant exceeds minimum or maximum instant");
    }

    public static d B(e eVar) {
        try {
            return G(eVar.n(a.INSTANT_SECONDS), (long) eVar.d(a.NANO_OF_SECOND));
        } catch (a e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain Instant from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(c.a.a.a.a.e(eVar, sb), e2);
        }
    }

    public static d F(long j) {
        return A(t.t1(j, 1000), t.v1(j, 1000) * 1000000);
    }

    public static d G(long j, long j2) {
        return A(t.D2(j, t.t1(j2, 1000000000)), t.v1(j2, 1000000000));
    }

    public static d Q(DataInput dataInput) {
        return G(dataInput.readLong(), (long) dataInput.readInt());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 2, this);
    }

    public final long D(d dVar) {
        return t.D2(t.E2(t.H2(dVar.f6404b, this.f6404b), 1000000000), (long) (dVar.f6405c - this.f6405c));
    }

    public final d H(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return G(t.D2(t.D2(this.f6404b, j), j2 / 1000000000), ((long) this.f6405c) + (j2 % 1000000000));
    }

    /* renamed from: L */
    public d s(long j, m mVar) {
        if (!(mVar instanceof b)) {
            return (d) mVar.f(this, j);
        }
        switch (((b) mVar).ordinal()) {
            case 0:
                return H(0, j);
            case 1:
                return H(j / 1000000, (j % 1000000) * 1000);
            case 2:
                return H(j / 1000, (j % 1000) * 1000000);
            case 3:
                return H(j, 0);
            case 4:
                return P(t.E2(j, 60));
            case 5:
                return P(t.E2(j, 3600));
            case 6:
                return P(t.E2(j, 43200));
            case 7:
                return P(t.E2(j, Strategy.TTL_SECONDS_MAX));
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public d P(long j) {
        return H(j, 0);
    }

    public final long R(d dVar) {
        long H2 = t.H2(dVar.f6404b, this.f6404b);
        long j = (long) (dVar.f6405c - this.f6405c);
        int i = (H2 > 0 ? 1 : (H2 == 0 ? 0 : -1));
        return (i <= 0 || j >= 0) ? (i >= 0 || j <= 0) ? H2 : H2 + 1 : H2 - 1;
    }

    public long S() {
        long j = this.f6404b;
        return j >= 0 ? t.D2(t.F2(j, 1000), (long) (this.f6405c / 1000000)) : t.H2(t.F2(j + 1, 1000), 1000 - ((long) (this.f6405c / 1000000)));
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        return super.b(jVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(d dVar) {
        d dVar2 = dVar;
        int L = t.L(this.f6404b, dVar2.f6404b);
        return L != 0 ? L : this.f6405c - dVar2.f6405c;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public int d(j jVar) {
        if (!(jVar instanceof a)) {
            return b(jVar).a(jVar.k(this), jVar);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal == 0) {
            return this.f6405c;
        }
        if (ordinal == 2) {
            return this.f6405c / 1000;
        }
        if (ordinal == 4) {
            return this.f6405c / 1000000;
        }
        throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f6404b == dVar.f6404b && this.f6405c == dVar.f6405c;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        if (lVar == k.f6658c) {
            return (R) b.NANOS;
        }
        if (lVar == k.f6661f || lVar == k.f6662g || lVar == k.f6657b || lVar == k.f6656a || lVar == k.f6659d || lVar == k.f6660e) {
            return null;
        }
        return lVar.a(this);
    }

    public int hashCode() {
        long j = this.f6404b;
        return (this.f6405c * 51) + ((int) (j ^ (j >>> 32)));
    }

    @Override // g.b.a.w.d
    public g.b.a.w.d i(f fVar) {
        return (d) ((e) fVar).t(this);
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof a ? jVar == a.INSTANT_SECONDS || jVar == a.NANO_OF_SECOND || jVar == a.MICRO_OF_SECOND || jVar == a.MILLI_OF_SECOND : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.d
    public g.b.a.w.d m(long j, m mVar) {
        return j == Long.MIN_VALUE ? s(Long.MAX_VALUE, mVar).s(1, mVar) : s(-j, mVar);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        int i;
        if (!(jVar instanceof a)) {
            return jVar.k(this);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal == 0) {
            i = this.f6405c;
        } else if (ordinal == 2) {
            i = this.f6405c / 1000;
        } else if (ordinal == 4) {
            i = this.f6405c / 1000000;
        } else if (ordinal == 28) {
            return this.f6404b;
        } else {
            throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
        }
        return (long) i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r3 != r2.f6405c) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r3 != r2.f6405c) goto L_0x0042;
     */
    @Override // g.b.a.w.d
    public g.b.a.w.d r(j jVar, long j) {
        int i;
        if (!(jVar instanceof a)) {
            return (d) jVar.f(this, j);
        }
        a aVar = (a) jVar;
        aVar.f6633c.b(j, aVar);
        int ordinal = aVar.ordinal();
        if (ordinal != 0) {
            if (ordinal == 2) {
                i = ((int) j) * 1000;
            } else if (ordinal == 4) {
                i = ((int) j) * 1000000;
            } else if (ordinal != 28) {
                throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
            } else if (j != this.f6404b) {
                i = this.f6405c;
                return A(j, i);
            }
            j = this.f6404b;
            return A(j, i);
        } else if (j != ((long) this.f6405c)) {
            return A(this.f6404b, (int) j);
        }
        return this;
    }

    @Override // g.b.a.w.f
    public g.b.a.w.d t(g.b.a.w.d dVar) {
        return dVar.r(a.INSTANT_SECONDS, this.f6404b).r(a.NANO_OF_SECOND, (long) this.f6405c);
    }

    public String toString() {
        return g.b.a.u.c.m.a(this);
    }

    @Override // g.b.a.w.d
    public long y(g.b.a.w.d dVar, m mVar) {
        d B = B(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, B);
        }
        switch (((b) mVar).ordinal()) {
            case 0:
                return D(B);
            case 1:
                return D(B) / 1000;
            case 2:
                return t.H2(B.S(), S());
            case 3:
                return R(B);
            case 4:
                return R(B) / 60;
            case 5:
                return R(B) / 3600;
            case 6:
                return R(B) / 43200;
            case 7:
                return R(B) / 86400;
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }
}
