package g.b.a;

import b.x.t;
import g.b.a.t.h;
import g.b.a.u.m;
import g.b.a.v.c;
import g.b.a.w.a;
import g.b.a.w.b;
import g.b.a.w.d;
import g.b.a.w.e;
import g.b.a.w.f;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.o;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class n extends c implements d, f, Comparable<n>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final int f6440b;

    static {
        new g.b.a.u.d().n(a.YEAR, 4, 10, m.EXCEEDS_PAD).q();
    }

    public n(int i) {
        this.f6440b = i;
    }

    public static n A(e eVar) {
        if (eVar instanceof n) {
            return (n) eVar;
        }
        try {
            if (!g.b.a.t.m.f6476d.equals(h.p(eVar))) {
                eVar = e.V(eVar);
            }
            return D(eVar.d(a.YEAR));
        } catch (a unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain Year from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(c.a.a.a.a.e(eVar, sb));
        }
    }

    public static boolean B(long j) {
        return (3 & j) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    public static n D(int i) {
        a aVar = a.YEAR;
        aVar.f6633c.b((long) i, aVar);
        return new n(i);
    }

    public static n H(DataInput dataInput) {
        return D(dataInput.readInt());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 67, this);
    }

    /* renamed from: F */
    public n s(long j, g.b.a.w.m mVar) {
        if (!(mVar instanceof b)) {
            return (n) mVar.f(this, j);
        }
        switch (((b) mVar).ordinal()) {
            case 10:
                return G(j);
            case 11:
                return G(t.E2(j, 10));
            case 12:
                return G(t.E2(j, 100));
            case 13:
                return G(t.E2(j, 1000));
            case 14:
                a aVar = a.ERA;
                return r(aVar, t.D2(n(aVar), j));
            default:
                throw new g.b.a.w.n("Unsupported unit: " + mVar);
        }
    }

    public n G(long j) {
        return j == 0 ? this : D(a.YEAR.r(((long) this.f6440b) + j));
    }

    /* renamed from: L */
    public n r(j jVar, long j) {
        if (!(jVar instanceof a)) {
            return (n) jVar.f(this, j);
        }
        a aVar = (a) jVar;
        aVar.f6633c.b(j, aVar);
        switch (aVar.ordinal()) {
            case 25:
                if (this.f6440b < 1) {
                    j = 1 - j;
                }
                return D((int) j);
            case 26:
                return D((int) j);
            case 27:
                return n(a.ERA) == j ? this : D(1 - this.f6440b);
            default:
                throw new g.b.a.w.n(c.a.a.a.a.d("Unsupported field: ", jVar));
        }
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        if (jVar != a.YEAR_OF_ERA) {
            return super.b(jVar);
        }
        return o.d(1, this.f6440b <= 0 ? 1000000000 : 999999999);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(n nVar) {
        return this.f6440b - nVar.f6440b;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public int d(j jVar) {
        return b(jVar).a(n(jVar), jVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            return this.f6440b == ((n) obj).f6440b;
        }
        return false;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        if (lVar == k.f6657b) {
            return (R) g.b.a.t.m.f6476d;
        }
        if (lVar == k.f6658c) {
            return (R) b.YEARS;
        }
        if (lVar == k.f6661f || lVar == k.f6662g || lVar == k.f6659d || lVar == k.f6656a || lVar == k.f6660e) {
            return null;
        }
        return (R) super.f(lVar);
    }

    public int hashCode() {
        return this.f6440b;
    }

    @Override // g.b.a.w.d
    public d i(f fVar) {
        return (n) ((e) fVar).t(this);
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof a ? jVar == a.YEAR || jVar == a.YEAR_OF_ERA || jVar == a.ERA : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.d
    public d m(long j, g.b.a.w.m mVar) {
        return j == Long.MIN_VALUE ? s(Long.MAX_VALUE, mVar).s(1, mVar) : s(-j, mVar);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.k(this);
        }
        int i = 1;
        switch (((a) jVar).ordinal()) {
            case 25:
                int i2 = this.f6440b;
                if (i2 < 1) {
                    i2 = 1 - i2;
                }
                return (long) i2;
            case 26:
                return (long) this.f6440b;
            case 27:
                if (this.f6440b < 1) {
                    i = 0;
                }
                return (long) i;
            default:
                throw new g.b.a.w.n(c.a.a.a.a.d("Unsupported field: ", jVar));
        }
    }

    @Override // g.b.a.w.f
    public d t(d dVar) {
        if (h.p(dVar).equals(g.b.a.t.m.f6476d)) {
            return dVar.r(a.YEAR, (long) this.f6440b);
        }
        throw new a("Adjustment only supported on ISO date-time");
    }

    public String toString() {
        return Integer.toString(this.f6440b);
    }

    @Override // g.b.a.w.d
    public long y(d dVar, g.b.a.w.m mVar) {
        long j;
        n A = A(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, A);
        }
        long j2 = ((long) A.f6440b) - ((long) this.f6440b);
        switch (((b) mVar).ordinal()) {
            case 10:
                return j2;
            case 11:
                j = 10;
                break;
            case 12:
                j = 100;
                break;
            case 13:
                j = 1000;
                break;
            case 14:
                return A.n(a.ERA) - n(a.ERA);
            default:
                throw new g.b.a.w.n("Unsupported unit: " + mVar);
        }
        return j2 / j;
    }
}
