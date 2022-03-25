package l.b.a;

import f.b.a.c.b.o.b;
import java.io.InvalidObjectException;
import java.io.Serializable;
import l.b.a.v.c;
import l.b.a.w.a;
import l.b.a.w.e;
import l.b.a.w.f;
import l.b.a.w.i;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.m;
import l.b.a.w.n;
import l.b.a.w.o;

public final class d extends c implements l.b.a.w.d, f, Comparable<d>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final d f4136d = new d(0, 0);
    public final long b;
    public final int c;

    static {
        z(-31557014167219200L, 0);
        z(31556889864403199L, 999999999);
    }

    public d(long j2, int i2) {
        this.b = j2;
        this.c = i2;
    }

    public static d r(long j2, int i2) {
        if ((((long) i2) | j2) == 0) {
            return f4136d;
        }
        if (j2 >= -31557014167219200L && j2 <= 31556889864403199L) {
            return new d(j2, i2);
        }
        throw new a("Instant exceeds minimum or maximum instant");
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static d s(e eVar) {
        try {
            return z(eVar.i(a.INSTANT_SECONDS), (long) eVar.b(a.NANO_OF_SECOND));
        } catch (a e2) {
            throw new a(f.a.a.a.a.f(eVar, f.a.a.a.a.k("Unable to obtain Instant from TemporalAccessor: ", eVar, ", type ")), e2);
        }
    }

    private Object writeReplace() {
        return new m((byte) 2, this);
    }

    public static d y(long j2) {
        return r(b.B0(j2, 1000), b.D0(j2, 1000) * 1000000);
    }

    public static d z(long j2, long j3) {
        return r(b.G1(j2, b.B0(j3, 1000000000)), b.D0(j3, 1000000000));
    }

    public final d A(long j2, long j3) {
        if ((j2 | j3) == 0) {
            return this;
        }
        return z(b.G1(b.G1(this.b, j2), j3 / 1000000000), ((long) this.c) + (j3 % 1000000000));
    }

    /* renamed from: B */
    public d m(long j2, m mVar) {
        if (!(mVar instanceof l.b.a.w.b)) {
            return (d) mVar.c(this, j2);
        }
        switch (((l.b.a.w.b) mVar).ordinal()) {
            case 0:
                return A(0, j2);
            case 1:
                return A(j2 / 1000000, (j2 % 1000000) * 1000);
            case 2:
                return A(j2 / 1000, (j2 % 1000) * 1000000);
            case 3:
                return A(j2, 0);
            case 4:
                return C(b.H1(j2, 60));
            case 5:
                return C(b.H1(j2, 3600));
            case 6:
                return C(b.H1(j2, 43200));
            case 7:
                return C(b.H1(j2, 86400));
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public d C(long j2) {
        return A(j2, 0);
    }

    public final long D(d dVar) {
        long K1 = b.K1(dVar.b, this.b);
        long j2 = (long) (dVar.c - this.c);
        int i2 = (K1 > 0 ? 1 : (K1 == 0 ? 0 : -1));
        return (i2 <= 0 || j2 >= 0) ? (i2 >= 0 || j2 <= 0) ? K1 : K1 + 1 : K1 - 1;
    }

    public long E() {
        long j2 = this.b;
        return j2 >= 0 ? b.G1(b.I1(j2, 1000), (long) (this.c / 1000000)) : b.K1(b.I1(j2 + 1, 1000), 1000 - ((long) (this.c / 1000000)));
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        return super.a(jVar);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public int b(j jVar) {
        if (!(jVar instanceof a)) {
            return super.a(jVar).a(jVar.f(this), jVar);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal == 0) {
            return this.c;
        }
        if (ordinal == 2) {
            return this.c / 1000;
        }
        if (ordinal == 4) {
            return this.c / 1000000;
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.c) {
            return (R) l.b.a.w.b.NANOS;
        }
        if (lVar == k.f4304f || lVar == k.f4305g || lVar == k.b || lVar == k.a || lVar == k.f4302d || lVar == k.f4303e) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // l.b.a.w.d
    public l.b.a.w.d e(f fVar) {
        return (d) fVar.n(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.b == dVar.b && this.c == dVar.c;
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof a ? jVar == a.INSTANT_SECONDS || jVar == a.NANO_OF_SECOND || jVar == a.MICRO_OF_SECOND || jVar == a.MILLI_OF_SECOND : jVar != null && jVar.b(this);
    }

    public int hashCode() {
        long j2 = this.b;
        return (this.c * 51) + ((int) (j2 ^ (j2 >>> 32)));
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        int i2;
        if (!(jVar instanceof a)) {
            return jVar.f(this);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal == 0) {
            i2 = this.c;
        } else if (ordinal == 2) {
            i2 = this.c / 1000;
        } else if (ordinal == 4) {
            i2 = this.c / 1000000;
        } else if (ordinal == 28) {
            return this.b;
        } else {
            throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }
        return (long) i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        if (r3 != r2.c) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r3 != r2.c) goto L_0x0043;
     */
    @Override // l.b.a.w.d
    public l.b.a.w.d l(j jVar, long j2) {
        int i2;
        if (!(jVar instanceof a)) {
            return (d) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        aVar.f4286e.b(j2, aVar);
        int ordinal = aVar.ordinal();
        if (ordinal != 0) {
            if (ordinal == 2) {
                i2 = ((int) j2) * 1000;
            } else if (ordinal == 4) {
                i2 = ((int) j2) * 1000000;
            } else if (ordinal != 28) {
                throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
            } else if (j2 != this.b) {
                i2 = this.c;
                return r(j2, i2);
            }
            j2 = this.b;
            return r(j2, i2);
        } else if (j2 != ((long) this.c)) {
            return r(this.b, (int) j2);
        }
        return this;
    }

    @Override // l.b.a.w.f
    public l.b.a.w.d n(l.b.a.w.d dVar) {
        return dVar.l(a.INSTANT_SECONDS, this.b).l(a.NANO_OF_SECOND, (long) this.c);
    }

    @Override // l.b.a.w.d
    public long o(l.b.a.w.d dVar, m mVar) {
        d s = s(dVar);
        if (!(mVar instanceof l.b.a.w.b)) {
            return mVar.b(this, s);
        }
        switch (((l.b.a.w.b) mVar).ordinal()) {
            case 0:
                return x(s);
            case 1:
                return x(s) / 1000;
            case 2:
                return b.K1(s.E(), E());
            case 3:
                return D(s);
            case 4:
                return D(s) / 60;
            case 5:
                return D(s) / 3600;
            case 6:
                return D(s) / 43200;
            case 7:
                return D(s) / 86400;
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    /* renamed from: q */
    public int compareTo(d dVar) {
        int L = b.L(this.b, dVar.b);
        return L != 0 ? L : this.c - dVar.c;
    }

    public boolean t(d dVar) {
        return compareTo(dVar) > 0;
    }

    public String toString() {
        return l.b.a.u.c.f4220l.b(this);
    }

    public boolean u(d dVar) {
        return compareTo(dVar) < 0;
    }

    /* renamed from: v */
    public d h(long j2, m mVar) {
        return j2 == Long.MIN_VALUE ? m(Long.MAX_VALUE, mVar).m(1, mVar) : m(-j2, mVar);
    }

    public d w(i iVar) {
        return (d) iVar.a(this);
    }

    public final long x(d dVar) {
        return b.G1(b.H1(b.K1(dVar.b, this.b), 1000000000), (long) (dVar.c - this.c));
    }
}
