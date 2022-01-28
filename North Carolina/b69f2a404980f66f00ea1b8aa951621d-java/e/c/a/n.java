package e.c.a;

import androidx.recyclerview.widget.RecyclerView;
import e.c.a.t.h;
import e.c.a.u.m;
import e.c.a.v.c;
import e.c.a.w.a;
import e.c.a.w.b;
import e.c.a.w.d;
import e.c.a.w.e;
import e.c.a.w.f;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.o;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class n extends c implements d, f, Comparable<n>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final int f4997b;

    static {
        new e.c.a.u.d().n(a.YEAR, 4, 10, m.EXCEEDS_PAD).q();
    }

    public n(int i) {
        this.f4997b = i;
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static n s(e eVar) {
        if (eVar instanceof n) {
            return (n) eVar;
        }
        try {
            if (!e.c.a.t.m.f5027d.equals(h.n(eVar))) {
                eVar = e.F(eVar);
            }
            return u(eVar.d(a.YEAR));
        } catch (a unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain Year from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(c.a.a.a.a.d(eVar, sb));
        }
    }

    public static boolean t(long j) {
        return (3 & j) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    public static n u(int i) {
        a aVar = a.YEAR;
        aVar.f5158c.b((long) i, aVar);
        return new n(i);
    }

    private Object writeReplace() {
        return new m((byte) 67, this);
    }

    public static n x(DataInput dataInput) {
        return u(dataInput.readInt());
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        if (jVar != a.YEAR_OF_ERA) {
            return super.b(jVar);
        }
        return o.d(1, this.f4997b <= 0 ? 1000000000 : 999999999);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(n nVar) {
        return this.f4997b - nVar.f4997b;
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public int d(j jVar) {
        return b(jVar).a(l(jVar), jVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            return this.f4997b == ((n) obj).f4997b;
        }
        return false;
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f5178b) {
            return (R) e.c.a.t.m.f5027d;
        }
        if (lVar == k.f5179c) {
            return (R) b.YEARS;
        }
        if (lVar == k.f || lVar == k.g || lVar == k.f5180d || lVar == k.f5177a || lVar == k.f5181e) {
            return null;
        }
        return (R) super.f(lVar);
    }

    @Override // e.c.a.w.d
    public d g(f fVar) {
        return (n) ((e) fVar).p(this);
    }

    public int hashCode() {
        return this.f4997b;
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof a ? jVar == a.YEAR || jVar == a.YEAR_OF_ERA || jVar == a.ERA : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.d
    public d k(long j, e.c.a.w.m mVar) {
        return j == Long.MIN_VALUE ? o(RecyclerView.FOREVER_NS, mVar).o(1, mVar) : o(-j, mVar);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.i(this);
        }
        int i = 1;
        switch (((a) jVar).ordinal()) {
            case 25:
                int i2 = this.f4997b;
                if (i2 < 1) {
                    i2 = 1 - i2;
                }
                return (long) i2;
            case 26:
                return (long) this.f4997b;
            case 27:
                if (this.f4997b < 1) {
                    i = 0;
                }
                return (long) i;
            default:
                throw new e.c.a.w.n(c.a.a.a.a.c("Unsupported field: ", jVar));
        }
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        if (h.n(dVar).equals(e.c.a.t.m.f5027d)) {
            return dVar.n(a.YEAR, (long) this.f4997b);
        }
        throw new a("Adjustment only supported on ISO date-time");
    }

    @Override // e.c.a.w.d
    public long q(d dVar, e.c.a.w.m mVar) {
        long j;
        n s = s(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, s);
        }
        long j2 = ((long) s.f4997b) - ((long) this.f4997b);
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
                return s.l(a.ERA) - l(a.ERA);
            default:
                throw new e.c.a.w.n("Unsupported unit: " + mVar);
        }
        return j2 / j;
    }

    public String toString() {
        return Integer.toString(this.f4997b);
    }

    /* renamed from: v */
    public n o(long j, e.c.a.w.m mVar) {
        if (!(mVar instanceof b)) {
            return (n) mVar.f(this, j);
        }
        switch (((b) mVar).ordinal()) {
            case 10:
                return w(j);
            case 11:
                return w(c.b.a.a.c.n.c.Z1(j, 10));
            case 12:
                return w(c.b.a.a.c.n.c.Z1(j, 100));
            case 13:
                return w(c.b.a.a.c.n.c.Z1(j, 1000));
            case 14:
                a aVar = a.ERA;
                return n(aVar, c.b.a.a.c.n.c.Y1(l(aVar), j));
            default:
                throw new e.c.a.w.n("Unsupported unit: " + mVar);
        }
    }

    public n w(long j) {
        return j == 0 ? this : u(a.YEAR.o(((long) this.f4997b) + j));
    }

    /* renamed from: y */
    public n n(j jVar, long j) {
        if (!(jVar instanceof a)) {
            return (n) jVar.f(this, j);
        }
        a aVar = (a) jVar;
        aVar.f5158c.b(j, aVar);
        switch (aVar.ordinal()) {
            case 25:
                if (this.f4997b < 1) {
                    j = 1 - j;
                }
                return u((int) j);
            case 26:
                return u((int) j);
            case 27:
                return l(a.ERA) == j ? this : u(1 - this.f4997b);
            default:
                throw new e.c.a.w.n(c.a.a.a.a.c("Unsupported field: ", jVar));
        }
    }
}
