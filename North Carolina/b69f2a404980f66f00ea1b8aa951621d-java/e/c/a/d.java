package e.c.a;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.nearby.messages.Strategy;
import e.c.a.v.c;
import e.c.a.w.a;
import e.c.a.w.b;
import e.c.a.w.e;
import e.c.a.w.f;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.m;
import e.c.a.w.n;
import e.c.a.w.o;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class d extends c implements e.c.a.w.d, f, Comparable<d>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final d f4966d = new d(0, 0);

    /* renamed from: b  reason: collision with root package name */
    public final long f4967b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4968c;

    static {
        w(-31557014167219200L, 0);
        w(31556889864403199L, 999999999);
    }

    public d(long j, int i) {
        this.f4967b = j;
        this.f4968c = i;
    }

    public static d A(DataInput dataInput) {
        return w(dataInput.readLong(), (long) dataInput.readInt());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static d s(long j, int i) {
        if ((((long) i) | j) == 0) {
            return f4966d;
        }
        if (j >= -31557014167219200L && j <= 31556889864403199L) {
            return new d(j, i);
        }
        throw new a("Instant exceeds minimum or maximum instant");
    }

    public static d t(e eVar) {
        try {
            return w(eVar.l(a.INSTANT_SECONDS), (long) eVar.d(a.NANO_OF_SECOND));
        } catch (a e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain Instant from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(c.a.a.a.a.d(eVar, sb), e2);
        }
    }

    public static d v(long j) {
        return s(c.b.a.a.c.n.c.R0(j, 1000), c.b.a.a.c.n.c.T0(j, 1000) * 1000000);
    }

    public static d w(long j, long j2) {
        return s(c.b.a.a.c.n.c.Y1(j, c.b.a.a.c.n.c.R0(j2, 1000000000)), c.b.a.a.c.n.c.T0(j2, 1000000000));
    }

    private Object writeReplace() {
        return new m((byte) 2, this);
    }

    public final long B(d dVar) {
        long c2 = c.b.a.a.c.n.c.c2(dVar.f4967b, this.f4967b);
        long j = (long) (dVar.f4968c - this.f4968c);
        int i = (c2 > 0 ? 1 : (c2 == 0 ? 0 : -1));
        return (i <= 0 || j >= 0) ? (i >= 0 || j <= 0) ? c2 : c2 + 1 : c2 - 1;
    }

    public long C() {
        long j = this.f4967b;
        return j >= 0 ? c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.a2(j, 1000), (long) (this.f4968c / 1000000)) : c.b.a.a.c.n.c.c2(c.b.a.a.c.n.c.a2(j + 1, 1000), 1000 - ((long) (this.f4968c / 1000000)));
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        return super.b(jVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(d dVar) {
        d dVar2 = dVar;
        int A = c.b.a.a.c.n.c.A(this.f4967b, dVar2.f4967b);
        return A != 0 ? A : this.f4968c - dVar2.f4968c;
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public int d(j jVar) {
        if (!(jVar instanceof a)) {
            return b(jVar).a(jVar.i(this), jVar);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal == 0) {
            return this.f4968c;
        }
        if (ordinal == 2) {
            return this.f4968c / 1000;
        }
        if (ordinal == 4) {
            return this.f4968c / 1000000;
        }
        throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f4967b == dVar.f4967b && this.f4968c == dVar.f4968c;
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f5179c) {
            return (R) b.NANOS;
        }
        if (lVar == k.f || lVar == k.g || lVar == k.f5178b || lVar == k.f5177a || lVar == k.f5180d || lVar == k.f5181e) {
            return null;
        }
        return lVar.a(this);
    }

    @Override // e.c.a.w.d
    public e.c.a.w.d g(f fVar) {
        return (d) ((e) fVar).p(this);
    }

    public int hashCode() {
        long j = this.f4967b;
        return (this.f4968c * 51) + ((int) (j ^ (j >>> 32)));
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof a ? jVar == a.INSTANT_SECONDS || jVar == a.NANO_OF_SECOND || jVar == a.MICRO_OF_SECOND || jVar == a.MILLI_OF_SECOND : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.d
    public e.c.a.w.d k(long j, m mVar) {
        return j == Long.MIN_VALUE ? o(RecyclerView.FOREVER_NS, mVar).o(1, mVar) : o(-j, mVar);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        int i;
        if (!(jVar instanceof a)) {
            return jVar.i(this);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal == 0) {
            i = this.f4968c;
        } else if (ordinal == 2) {
            i = this.f4968c / 1000;
        } else if (ordinal == 4) {
            i = this.f4968c / 1000000;
        } else if (ordinal == 28) {
            return this.f4967b;
        } else {
            throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
        }
        return (long) i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r3 != r2.f4968c) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r3 != r2.f4968c) goto L_0x0042;
     */
    @Override // e.c.a.w.d
    public e.c.a.w.d n(j jVar, long j) {
        int i;
        if (!(jVar instanceof a)) {
            return (d) jVar.f(this, j);
        }
        a aVar = (a) jVar;
        aVar.f5158c.b(j, aVar);
        int ordinal = aVar.ordinal();
        if (ordinal != 0) {
            if (ordinal == 2) {
                i = ((int) j) * 1000;
            } else if (ordinal == 4) {
                i = ((int) j) * 1000000;
            } else if (ordinal != 28) {
                throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
            } else if (j != this.f4967b) {
                i = this.f4968c;
                return s(j, i);
            }
            j = this.f4967b;
            return s(j, i);
        } else if (j != ((long) this.f4968c)) {
            return s(this.f4967b, (int) j);
        }
        return this;
    }

    @Override // e.c.a.w.f
    public e.c.a.w.d p(e.c.a.w.d dVar) {
        return dVar.n(a.INSTANT_SECONDS, this.f4967b).n(a.NANO_OF_SECOND, (long) this.f4968c);
    }

    @Override // e.c.a.w.d
    public long q(e.c.a.w.d dVar, m mVar) {
        d t = t(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, t);
        }
        switch (((b) mVar).ordinal()) {
            case 0:
                return u(t);
            case 1:
                return u(t) / 1000;
            case 2:
                return c.b.a.a.c.n.c.c2(t.C(), C());
            case 3:
                return B(t);
            case 4:
                return B(t) / 60;
            case 5:
                return B(t) / 3600;
            case 6:
                return B(t) / 43200;
            case 7:
                return B(t) / 86400;
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public String toString() {
        return e.c.a.u.c.m.a(this);
    }

    public final long u(d dVar) {
        return c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.Z1(c.b.a.a.c.n.c.c2(dVar.f4967b, this.f4967b), 1000000000), (long) (dVar.f4968c - this.f4968c));
    }

    public final d x(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return w(c.b.a.a.c.n.c.Y1(c.b.a.a.c.n.c.Y1(this.f4967b, j), j2 / 1000000000), ((long) this.f4968c) + (j2 % 1000000000));
    }

    /* renamed from: y */
    public d o(long j, m mVar) {
        if (!(mVar instanceof b)) {
            return (d) mVar.f(this, j);
        }
        switch (((b) mVar).ordinal()) {
            case 0:
                return x(0, j);
            case 1:
                return x(j / 1000000, (j % 1000000) * 1000);
            case 2:
                return x(j / 1000, (j % 1000) * 1000000);
            case 3:
                return x(j, 0);
            case 4:
                return z(c.b.a.a.c.n.c.Z1(j, 60));
            case 5:
                return z(c.b.a.a.c.n.c.Z1(j, 3600));
            case 6:
                return z(c.b.a.a.c.n.c.Z1(j, 43200));
            case 7:
                return z(c.b.a.a.c.n.c.Z1(j, Strategy.TTL_SECONDS_MAX));
            default:
                throw new n("Unsupported unit: " + mVar);
        }
    }

    public d z(long j) {
        return x(j, 0);
    }
}
