package l.b.a;

import java.io.InvalidObjectException;
import java.io.Serializable;
import l.b.a.w.c;
import l.b.a.x.a;
import l.b.a.x.b;
import l.b.a.x.d;
import l.b.a.x.f;
import l.b.a.x.i;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.m;
import l.b.a.x.n;
import l.b.a.x.o;
/* loaded from: classes.dex */
public final class e extends c implements d, f, Comparable<e>, Serializable {

    /* renamed from: d */
    public static final e f4611d = new e(0, 0);
    public final long b;
    public final int c;

    static {
        B(-31557014167219200L, 0);
        B(31556889864403199L, 999999999);
    }

    public e(long j2, int i2) {
        this.b = j2;
        this.c = i2;
    }

    public static e A(long j2) {
        return r(j2, 0);
    }

    public static e B(long j2, long j3) {
        return r(g.b.a.c.c.d.w(j2, g.b.a.c.c.d.i(j3, 1000000000)), g.b.a.c.c.d.k(j3, 1000000000));
    }

    public static e r(long j2, int i2) {
        if ((((long) i2) | j2) == 0) {
            return f4611d;
        }
        if (j2 >= -31557014167219200L && j2 <= 31556889864403199L) {
            return new e(j2, i2);
        }
        throw new b("Instant exceeds minimum or maximum instant");
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static e s(l.b.a.x.e eVar) {
        try {
            return B(eVar.i(a.INSTANT_SECONDS), (long) eVar.b(a.NANO_OF_SECOND));
        } catch (b e2) {
            throw new b(f.a.a.a.a.f(eVar, f.a.a.a.a.k("Unable to obtain Instant from TemporalAccessor: ", eVar, ", type ")), e2);
        }
    }

    private Object writeReplace() {
        return new n((byte) 2, this);
    }

    public static e y() {
        r rVar = r.f4641g;
        return z(System.currentTimeMillis());
    }

    public static e z(long j2) {
        return r(g.b.a.c.c.d.i(j2, 1000), g.b.a.c.c.d.k(j2, 1000) * 1000000);
    }

    public final e C(long j2, long j3) {
        if ((j2 | j3) == 0) {
            return this;
        }
        return B(g.b.a.c.c.d.w(g.b.a.c.c.d.w(this.b, j2), j3 / 1000000000), ((long) this.c) + (j3 % 1000000000));
    }

    /* renamed from: D */
    public e m(long j2, m mVar) {
        if (!(mVar instanceof b)) {
            return (e) mVar.c(this, j2);
        }
        switch (((b) mVar).ordinal()) {
            case 0:
                return C(0, j2);
            case 1:
                return C(j2 / 1000000, (j2 % 1000000) * 1000);
            case 2:
                return C(j2 / 1000, (j2 % 1000) * 1000000);
            case 3:
                return C(j2, 0);
            case 4:
                return E(g.b.a.c.c.d.x(j2, 60));
            case 5:
                return E(g.b.a.c.c.d.x(j2, 3600));
            case 6:
                return E(g.b.a.c.c.d.x(j2, 43200));
            case 7:
                return E(g.b.a.c.c.d.x(j2, 86400));
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public e E(long j2) {
        return C(j2, 0);
    }

    public final long F(e eVar) {
        long A = g.b.a.c.c.d.A(eVar.b, this.b);
        long j2 = (long) (eVar.c - this.c);
        int i2 = (A > 0 ? 1 : (A == 0 ? 0 : -1));
        return (i2 <= 0 || j2 >= 0) ? (i2 >= 0 || j2 <= 0) ? A : A + 1 : A - 1;
    }

    public long G() {
        long j2 = this.b;
        return j2 >= 0 ? g.b.a.c.c.d.w(g.b.a.c.c.d.y(j2, 1000), (long) (this.c / 1000000)) : g.b.a.c.c.d.A(g.b.a.c.c.d.y(j2 + 1, 1000), 1000 - ((long) (this.c / 1000000)));
    }

    @Override // l.b.a.w.c, l.b.a.x.e
    public o a(j jVar) {
        return super.a(jVar);
    }

    @Override // l.b.a.w.c, l.b.a.x.e
    public int b(j jVar) {
        if (!(jVar instanceof a)) {
            return a(jVar).a(jVar.f(this), jVar);
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

    @Override // l.b.a.w.c, l.b.a.x.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.c) {
            return (R) b.NANOS;
        }
        if (lVar == k.f4779f || lVar == k.f4780g || lVar == k.b || lVar == k.a || lVar == k.f4777d || lVar == k.f4778e) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // l.b.a.x.d
    public d e(f fVar) {
        return (e) fVar.n(this);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.b == eVar.b && this.c == eVar.c;
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return jVar instanceof a ? jVar == a.INSTANT_SECONDS || jVar == a.NANO_OF_SECOND || jVar == a.MICRO_OF_SECOND || jVar == a.MILLI_OF_SECOND : jVar != null && jVar.b(this);
    }

    @Override // java.lang.Object
    public int hashCode() {
        long j2 = this.b;
        return (this.c * 51) + ((int) (j2 ^ (j2 >>> 32)));
    }

    @Override // l.b.a.x.e
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r3 != r2.c) goto L_0x0043;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r3 != r2.c) goto L_0x0043;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
        r4 = r2.b;
     */
    @Override // l.b.a.x.d
    /* Code decompiled incorrectly, please refer to instructions dump */
    public d l(j jVar, long j2) {
        int i2;
        if (!(jVar instanceof a)) {
            return (e) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        aVar.f4761e.b(j2, aVar);
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
            }
            return r(j2, i2);
        } else if (j2 != ((long) this.c)) {
            return r(this.b, (int) j2);
        }
        return this;
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        return dVar.l(a.INSTANT_SECONDS, this.b).l(a.NANO_OF_SECOND, (long) this.c);
    }

    @Override // l.b.a.x.d
    public long o(d dVar, m mVar) {
        e s = s(dVar);
        if (!(mVar instanceof b)) {
            return mVar.b(this, s);
        }
        switch (((b) mVar).ordinal()) {
            case 0:
                return x(s);
            case 1:
                return x(s) / 1000;
            case 2:
                return g.b.a.c.c.d.A(s.G(), G());
            case 3:
                return F(s);
            case 4:
                return F(s) / 60;
            case 5:
                return F(s) / 3600;
            case 6:
                return F(s) / 43200;
            case 7:
                return F(s) / 86400;
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    /* renamed from: q */
    public int compareTo(e eVar) {
        int e2 = g.b.a.c.c.d.e(this.b, eVar.b);
        return e2 != 0 ? e2 : this.c - eVar.c;
    }

    public boolean t(e eVar) {
        return compareTo(eVar) > 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return l.b.a.v.c.f4695l.b(this);
    }

    public boolean u(e eVar) {
        return compareTo(eVar) < 0;
    }

    /* renamed from: v */
    public e h(long j2, m mVar) {
        return j2 == Long.MIN_VALUE ? m(Long.MAX_VALUE, mVar).m(1, mVar) : m(-j2, mVar);
    }

    public e w(i iVar) {
        return (e) iVar.a(this);
    }

    public final long x(e eVar) {
        return g.b.a.c.c.d.w(g.b.a.c.c.d.x(g.b.a.c.c.d.A(eVar.b, this.b), 1000000000), (long) (eVar.c - this.c));
    }
}
