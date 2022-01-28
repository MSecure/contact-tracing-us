package g.b.a;

import b.x.t;
import c.a.a.a.a;
import g.b.a.v.c;
import g.b.a.w.b;
import g.b.a.w.d;
import g.b.a.w.e;
import g.b.a.w.f;
import g.b.a.w.j;
import g.b.a.w.l;
import g.b.a.w.m;
import g.b.a.w.n;
import g.b.a.w.o;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class k extends c implements d, f, Comparable<k>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final g f6432b;

    /* renamed from: c  reason: collision with root package name */
    public final q f6433c;

    static {
        g gVar = g.f6416f;
        q qVar = q.i;
        if (gVar != null) {
            new k(gVar, qVar);
            g gVar2 = g.f6417g;
            q qVar2 = q.h;
            if (gVar2 != null) {
                new k(gVar2, qVar2);
                return;
            }
            throw null;
        }
        throw null;
    }

    public k(g gVar, q qVar) {
        t.y2(gVar, "time");
        this.f6432b = gVar;
        t.y2(qVar, "offset");
        this.f6433c = qVar;
    }

    public static k A(e eVar) {
        if (eVar instanceof k) {
            return (k) eVar;
        }
        try {
            return new k(g.D(eVar), q.L(eVar));
        } catch (a unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain OffsetTime from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(a.e(eVar, sb));
        }
    }

    public static k D(DataInput dataInput) {
        return new k(g.X(dataInput), q.T(dataInput));
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 66, this);
    }

    /* renamed from: B */
    public k s(long j, m mVar) {
        return mVar instanceof b ? G(this.f6432b.s(j, mVar), this.f6433c) : (k) mVar.f(this, j);
    }

    public final long F() {
        return this.f6432b.Y() - (((long) this.f6433c.f6447c) * 1000000000);
    }

    public final k G(g gVar, q qVar) {
        return (this.f6432b != gVar || !this.f6433c.equals(qVar)) ? new k(gVar, qVar) : this;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar == g.b.a.w.a.OFFSET_SECONDS ? jVar.m() : this.f6432b.b(jVar) : jVar.p(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(k kVar) {
        int L;
        k kVar2 = kVar;
        return (!this.f6433c.equals(kVar2.f6433c) && (L = t.L(F(), kVar2.F())) != 0) ? L : this.f6432b.compareTo(kVar2.f6432b);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public int d(j jVar) {
        return super.d(jVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f6432b.equals(kVar.f6432b) && this.f6433c.equals(kVar.f6433c);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        if (lVar == g.b.a.w.k.f6658c) {
            return (R) b.NANOS;
        }
        if (lVar == g.b.a.w.k.f6660e || lVar == g.b.a.w.k.f6659d) {
            return (R) this.f6433c;
        }
        if (lVar == g.b.a.w.k.f6662g) {
            return (R) this.f6432b;
        }
        if (lVar == g.b.a.w.k.f6657b || lVar == g.b.a.w.k.f6661f || lVar == g.b.a.w.k.f6656a) {
            return null;
        }
        return (R) super.f(lVar);
    }

    public int hashCode() {
        return this.f6432b.hashCode() ^ this.f6433c.f6447c;
    }

    @Override // g.b.a.w.d
    public d i(f fVar) {
        if (fVar instanceof g) {
            return G((g) fVar, this.f6433c);
        }
        if (fVar instanceof q) {
            return G(this.f6432b, (q) fVar);
        }
        boolean z = fVar instanceof k;
        d dVar = fVar;
        if (!z) {
            dVar = ((e) fVar).t(this);
        }
        return (k) dVar;
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return jVar instanceof g.b.a.w.a ? jVar.n() || jVar == g.b.a.w.a.OFFSET_SECONDS : jVar != null && jVar.d(this);
    }

    @Override // g.b.a.w.d
    public d m(long j, m mVar) {
        return j == Long.MIN_VALUE ? s(Long.MAX_VALUE, mVar).s(1, mVar) : s(-j, mVar);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.k(this);
        }
        if (jVar == g.b.a.w.a.OFFSET_SECONDS) {
            return (long) this.f6433c.f6447c;
        }
        return this.f6432b.n(jVar);
    }

    @Override // g.b.a.w.d
    public d r(j jVar, long j) {
        if (!(jVar instanceof g.b.a.w.a)) {
            return (k) jVar.f(this, j);
        }
        if (jVar != g.b.a.w.a.OFFSET_SECONDS) {
            return G(this.f6432b.r(jVar, j), this.f6433c);
        }
        g.b.a.w.a aVar = (g.b.a.w.a) jVar;
        return G(this.f6432b, q.R(aVar.f6633c.a(j, aVar)));
    }

    @Override // g.b.a.w.f
    public d t(d dVar) {
        return dVar.r(g.b.a.w.a.NANO_OF_DAY, this.f6432b.Y()).r(g.b.a.w.a.OFFSET_SECONDS, (long) this.f6433c.f6447c);
    }

    public String toString() {
        return this.f6432b.toString() + this.f6433c.f6448d;
    }

    @Override // g.b.a.w.d
    public long y(d dVar, m mVar) {
        long j;
        k A = A(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, A);
        }
        long F = A.F() - F();
        switch (((b) mVar).ordinal()) {
            case 0:
                return F;
            case 1:
                j = 1000;
                break;
            case 2:
                j = 1000000;
                break;
            case 3:
                j = 1000000000;
                break;
            case 4:
                j = 60000000000L;
                break;
            case 5:
                j = 3600000000000L;
                break;
            case 6:
                j = 43200000000000L;
                break;
            default:
                throw new n("Unsupported unit: " + mVar);
        }
        return F / j;
    }
}
