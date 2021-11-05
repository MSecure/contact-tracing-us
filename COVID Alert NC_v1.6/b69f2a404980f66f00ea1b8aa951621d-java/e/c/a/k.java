package e.c.a;

import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a.a;
import e.c.a.v.c;
import e.c.a.w.b;
import e.c.a.w.d;
import e.c.a.w.e;
import e.c.a.w.f;
import e.c.a.w.j;
import e.c.a.w.l;
import e.c.a.w.m;
import e.c.a.w.n;
import e.c.a.w.o;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;

public final class k extends c implements d, f, Comparable<k>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final g f4989b;

    /* renamed from: c  reason: collision with root package name */
    public final q f4990c;

    static {
        g gVar = g.f;
        q qVar = q.h;
        if (gVar != null) {
            new k(gVar, qVar);
            g gVar2 = g.g;
            q qVar2 = q.g;
            if (gVar2 != null) {
                new k(gVar2, qVar2);
                return;
            }
            throw null;
        }
        throw null;
    }

    public k(g gVar, q qVar) {
        c.b.a.a.c.n.c.T1(gVar, "time");
        this.f4989b = gVar;
        c.b.a.a.c.n.c.T1(qVar, "offset");
        this.f4990c = qVar;
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static k s(e eVar) {
        if (eVar instanceof k) {
            return (k) eVar;
        }
        try {
            return new k(g.u(eVar), q.z(eVar));
        } catch (a unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain OffsetTime from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(a.d(eVar, sb));
        }
    }

    public static k u(DataInput dataInput) {
        return new k(g.H(dataInput), q.E(dataInput));
    }

    private Object writeReplace() {
        return new m((byte) 66, this);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        return jVar instanceof e.c.a.w.a ? jVar == e.c.a.w.a.OFFSET_SECONDS ? jVar.k() : this.f4989b.b(jVar) : jVar.n(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(k kVar) {
        int A;
        k kVar2 = kVar;
        return (!this.f4990c.equals(kVar2.f4990c) && (A = c.b.a.a.c.n.c.A(v(), kVar2.v())) != 0) ? A : this.f4989b.compareTo(kVar2.f4989b);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
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
        return this.f4989b.equals(kVar.f4989b) && this.f4990c.equals(kVar.f4990c);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == e.c.a.w.k.f5179c) {
            return (R) b.NANOS;
        }
        if (lVar == e.c.a.w.k.f5181e || lVar == e.c.a.w.k.f5180d) {
            return (R) this.f4990c;
        }
        if (lVar == e.c.a.w.k.g) {
            return (R) this.f4989b;
        }
        if (lVar == e.c.a.w.k.f5178b || lVar == e.c.a.w.k.f || lVar == e.c.a.w.k.f5177a) {
            return null;
        }
        return (R) super.f(lVar);
    }

    @Override // e.c.a.w.d
    public d g(f fVar) {
        if (fVar instanceof g) {
            return w((g) fVar, this.f4990c);
        }
        if (fVar instanceof q) {
            return w(this.f4989b, (q) fVar);
        }
        boolean z = fVar instanceof k;
        d dVar = fVar;
        if (!z) {
            dVar = ((e) fVar).p(this);
        }
        return (k) dVar;
    }

    public int hashCode() {
        return this.f4989b.hashCode() ^ this.f4990c.f5002b;
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return jVar instanceof e.c.a.w.a ? jVar.l() || jVar == e.c.a.w.a.OFFSET_SECONDS : jVar != null && jVar.d(this);
    }

    @Override // e.c.a.w.d
    public d k(long j, m mVar) {
        return j == Long.MIN_VALUE ? o(RecyclerView.FOREVER_NS, mVar).o(1, mVar) : o(-j, mVar);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.i(this);
        }
        if (jVar == e.c.a.w.a.OFFSET_SECONDS) {
            return (long) this.f4990c.f5002b;
        }
        return this.f4989b.l(jVar);
    }

    @Override // e.c.a.w.d
    public d n(j jVar, long j) {
        if (!(jVar instanceof e.c.a.w.a)) {
            return (k) jVar.f(this, j);
        }
        if (jVar != e.c.a.w.a.OFFSET_SECONDS) {
            return w(this.f4989b.n(jVar, j), this.f4990c);
        }
        e.c.a.w.a aVar = (e.c.a.w.a) jVar;
        return w(this.f4989b, q.C(aVar.f5158c.a(j, aVar)));
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        return dVar.n(e.c.a.w.a.NANO_OF_DAY, this.f4989b.I()).n(e.c.a.w.a.OFFSET_SECONDS, (long) this.f4990c.f5002b);
    }

    @Override // e.c.a.w.d
    public long q(d dVar, m mVar) {
        long j;
        k s = s(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, s);
        }
        long v = s.v() - v();
        switch (((b) mVar).ordinal()) {
            case 0:
                return v;
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
        return v / j;
    }

    /* renamed from: t */
    public k o(long j, m mVar) {
        return mVar instanceof b ? w(this.f4989b.o(j, mVar), this.f4990c) : (k) mVar.f(this, j);
    }

    public String toString() {
        return this.f4989b.toString() + this.f4990c.f5003c;
    }

    public final long v() {
        return this.f4989b.I() - (((long) this.f4990c.f5002b) * 1000000000);
    }

    public final k w(g gVar, q qVar) {
        return (this.f4989b != gVar || !this.f4990c.equals(qVar)) ? new k(gVar, qVar) : this;
    }
}
