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
import e.c.a.w.n;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class o extends c implements d, f, Comparable<o>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final int f4998b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4999c;

    static {
        e.c.a.u.d n = new e.c.a.u.d().n(a.YEAR, 4, 10, m.EXCEEDS_PAD);
        n.d('-');
        n.m(a.MONTH_OF_YEAR, 2);
        n.q();
    }

    public o(int i, int i2) {
        this.f4998b = i;
        this.f4999c = i2;
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static o s(e eVar) {
        if (eVar instanceof o) {
            return (o) eVar;
        }
        try {
            if (!e.c.a.t.m.f5027d.equals(h.n(eVar))) {
                eVar = e.F(eVar);
            }
            return u(eVar.d(a.YEAR), eVar.d(a.MONTH_OF_YEAR));
        } catch (a unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain YearMonth from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(c.a.a.a.a.d(eVar, sb));
        }
    }

    public static o u(int i, int i2) {
        a aVar = a.YEAR;
        aVar.f5158c.b((long) i, aVar);
        a aVar2 = a.MONTH_OF_YEAR;
        aVar2.f5158c.b((long) i2, aVar2);
        return new o(i, i2);
    }

    private Object writeReplace() {
        return new m((byte) 68, this);
    }

    public static o y(DataInput dataInput) {
        return u(dataInput.readInt(), dataInput.readByte());
    }

    /* renamed from: A */
    public o n(j jVar, long j) {
        if (!(jVar instanceof a)) {
            return (o) jVar.f(this, j);
        }
        a aVar = (a) jVar;
        aVar.f5158c.b(j, aVar);
        switch (aVar.ordinal()) {
            case 23:
                int i = (int) j;
                a aVar2 = a.MONTH_OF_YEAR;
                aVar2.f5158c.b((long) i, aVar2);
                return z(this.f4998b, i);
            case 24:
                return w(j - l(a.PROLEPTIC_MONTH));
            case 25:
                if (this.f4998b < 1) {
                    j = 1 - j;
                }
                return B((int) j);
            case 26:
                return B((int) j);
            case 27:
                return l(a.ERA) == j ? this : B(1 - this.f4998b);
            default:
                throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
        }
    }

    public o B(int i) {
        a aVar = a.YEAR;
        aVar.f5158c.b((long) i, aVar);
        return z(i, this.f4999c);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public e.c.a.w.o b(j jVar) {
        if (jVar != a.YEAR_OF_ERA) {
            return super.b(jVar);
        }
        return e.c.a.w.o.d(1, this.f4998b <= 0 ? 1000000000 : 999999999);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(o oVar) {
        o oVar2 = oVar;
        int i = this.f4998b - oVar2.f4998b;
        return i == 0 ? this.f4999c - oVar2.f4999c : i;
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public int d(j jVar) {
        return b(jVar).a(l(jVar), jVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f4998b == oVar.f4998b && this.f4999c == oVar.f4999c;
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f5178b) {
            return (R) e.c.a.t.m.f5027d;
        }
        if (lVar == k.f5179c) {
            return (R) b.MONTHS;
        }
        if (lVar == k.f || lVar == k.g || lVar == k.f5180d || lVar == k.f5177a || lVar == k.f5181e) {
            return null;
        }
        return (R) super.f(lVar);
    }

    @Override // e.c.a.w.d
    public d g(f fVar) {
        return (o) ((e) fVar).p(this);
    }

    public int hashCode() {
        return this.f4998b ^ (this.f4999c << 27);
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof a ? jVar == a.YEAR || jVar == a.MONTH_OF_YEAR || jVar == a.PROLEPTIC_MONTH || jVar == a.YEAR_OF_ERA || jVar == a.ERA : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.d
    public d k(long j, e.c.a.w.m mVar) {
        return j == Long.MIN_VALUE ? o(RecyclerView.FOREVER_NS, mVar).o(1, mVar) : o(-j, mVar);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        int i;
        if (!(jVar instanceof a)) {
            return jVar.i(this);
        }
        int i2 = 1;
        switch (((a) jVar).ordinal()) {
            case 23:
                i = this.f4999c;
                break;
            case 24:
                return t();
            case 25:
                int i3 = this.f4998b;
                if (i3 < 1) {
                    i3 = 1 - i3;
                }
                return (long) i3;
            case 26:
                i = this.f4998b;
                break;
            case 27:
                if (this.f4998b < 1) {
                    i2 = 0;
                }
                return (long) i2;
            default:
                throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
        }
        return (long) i;
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        if (h.n(dVar).equals(e.c.a.t.m.f5027d)) {
            return dVar.n(a.PROLEPTIC_MONTH, t());
        }
        throw new a("Adjustment only supported on ISO date-time");
    }

    @Override // e.c.a.w.d
    public long q(d dVar, e.c.a.w.m mVar) {
        long j;
        o s = s(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, s);
        }
        long t = s.t() - t();
        switch (((b) mVar).ordinal()) {
            case 9:
                return t;
            case 10:
                j = 12;
                break;
            case 11:
                j = 120;
                break;
            case 12:
                j = 1200;
                break;
            case 13:
                j = 12000;
                break;
            case 14:
                return s.l(a.ERA) - l(a.ERA);
            default:
                throw new n("Unsupported unit: " + mVar);
        }
        return t / j;
    }

    public final long t() {
        return (((long) this.f4998b) * 12) + ((long) (this.f4999c - 1));
    }

    public String toString() {
        int i;
        int abs = Math.abs(this.f4998b);
        StringBuilder sb = new StringBuilder(9);
        if (abs < 1000) {
            int i2 = this.f4998b;
            if (i2 < 0) {
                sb.append(i2 - 10000);
                i = 1;
            } else {
                sb.append(i2 + 10000);
                i = 0;
            }
            sb.deleteCharAt(i);
        } else {
            sb.append(this.f4998b);
        }
        sb.append(this.f4999c < 10 ? "-0" : "-");
        sb.append(this.f4999c);
        return sb.toString();
    }

    /* renamed from: v */
    public o o(long j, e.c.a.w.m mVar) {
        if (!(mVar instanceof b)) {
            return (o) mVar.f(this, j);
        }
        switch (((b) mVar).ordinal()) {
            case 9:
                return w(j);
            case 10:
                return x(j);
            case 11:
                return x(c.b.a.a.c.n.c.Z1(j, 10));
            case 12:
                return x(c.b.a.a.c.n.c.Z1(j, 100));
            case 13:
                return x(c.b.a.a.c.n.c.Z1(j, 1000));
            case 14:
                a aVar = a.ERA;
                return n(aVar, c.b.a.a.c.n.c.Y1(l(aVar), j));
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public o w(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.f4998b) * 12) + ((long) (this.f4999c - 1)) + j;
        return z(a.YEAR.o(c.b.a.a.c.n.c.R0(j2, 12)), c.b.a.a.c.n.c.T0(j2, 12) + 1);
    }

    public o x(long j) {
        return j == 0 ? this : z(a.YEAR.o(((long) this.f4998b) + j), this.f4999c);
    }

    public final o z(int i, int i2) {
        return (this.f4998b == i && this.f4999c == i2) ? this : new o(i, i2);
    }
}
