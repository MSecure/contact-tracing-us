package l.b.a;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Objects;
import l.b.a.v.c;
import l.b.a.w.d;
import l.b.a.w.e;
import l.b.a.w.f;
import l.b.a.w.j;
import l.b.a.w.l;
import l.b.a.w.m;
import l.b.a.w.n;
import l.b.a.w.o;

public final class k extends c implements d, f, Comparable<k>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f4160d = 0;
    public final g b;
    public final q c;

    static {
        g gVar = g.f4143f;
        q qVar = q.f4168i;
        Objects.requireNonNull(gVar);
        new k(gVar, qVar);
        g gVar2 = g.f4144g;
        q qVar2 = q.f4167h;
        Objects.requireNonNull(gVar2);
        new k(gVar2, qVar2);
    }

    public k(g gVar, q qVar) {
        b.A1(gVar, "time");
        this.b = gVar;
        b.A1(qVar, "offset");
        this.c = qVar;
    }

    public static k q(e eVar) {
        if (eVar instanceof k) {
            return (k) eVar;
        }
        try {
            return new k(g.s(eVar), q.w(eVar));
        } catch (a unused) {
            throw new a(a.f(eVar, a.k("Unable to obtain OffsetTime from TemporalAccessor: ", eVar, ", type ")));
        }
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 66, this);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        return jVar instanceof l.b.a.w.a ? jVar == l.b.a.w.a.OFFSET_SECONDS ? jVar.h() : this.b.a(jVar) : jVar.l(this);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public int b(j jVar) {
        return super.b(jVar);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == l.b.a.w.k.c) {
            return (R) l.b.a.w.b.NANOS;
        }
        if (lVar == l.b.a.w.k.f4303e || lVar == l.b.a.w.k.f4302d) {
            return (R) this.c;
        }
        if (lVar == l.b.a.w.k.f4305g) {
            return (R) this.b;
        }
        if (lVar == l.b.a.w.k.b || lVar == l.b.a.w.k.f4304f || lVar == l.b.a.w.k.a) {
            return null;
        }
        return (R) super.c(lVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(k kVar) {
        int L;
        k kVar2 = kVar;
        return (!this.c.equals(kVar2.c) && (L = b.L(s(), kVar2.s())) != 0) ? L : this.b.compareTo(kVar2.b);
    }

    @Override // l.b.a.w.d
    public d e(f fVar) {
        if (fVar instanceof g) {
            return t((g) fVar, this.c);
        }
        if (fVar instanceof q) {
            return t(this.b, (q) fVar);
        }
        boolean z = fVar instanceof k;
        d dVar = fVar;
        if (!z) {
            dVar = fVar.n(this);
        }
        return (k) dVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.b.equals(kVar.b) && this.c.equals(kVar.c);
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof l.b.a.w.a ? jVar.i() || jVar == l.b.a.w.a.OFFSET_SECONDS : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.w.d
    public d h(long j2, m mVar) {
        return j2 == Long.MIN_VALUE ? m(Long.MAX_VALUE, mVar).m(1, mVar) : m(-j2, mVar);
    }

    public int hashCode() {
        return this.b.hashCode() ^ this.c.c;
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.f(this);
        }
        if (jVar == l.b.a.w.a.OFFSET_SECONDS) {
            return (long) this.c.c;
        }
        return this.b.i(jVar);
    }

    @Override // l.b.a.w.d
    public d l(j jVar, long j2) {
        if (!(jVar instanceof l.b.a.w.a)) {
            return (k) jVar.c(this, j2);
        }
        if (jVar != l.b.a.w.a.OFFSET_SECONDS) {
            return t(this.b.l(jVar, j2), this.c);
        }
        l.b.a.w.a aVar = (l.b.a.w.a) jVar;
        return t(this.b, q.z(aVar.f4286e.a(j2, aVar)));
    }

    @Override // l.b.a.w.f
    public d n(d dVar) {
        return dVar.l(l.b.a.w.a.NANO_OF_DAY, this.b.E()).l(l.b.a.w.a.OFFSET_SECONDS, (long) this.c.c);
    }

    @Override // l.b.a.w.d
    public long o(d dVar, m mVar) {
        long j2;
        k q = q(dVar);
        if (!(mVar instanceof l.b.a.w.b)) {
            return mVar.b(this, q);
        }
        long s = q.s() - s();
        switch (((l.b.a.w.b) mVar).ordinal()) {
            case 0:
                return s;
            case 1:
                j2 = 1000;
                break;
            case 2:
                j2 = 1000000;
                break;
            case 3:
                j2 = 1000000000;
                break;
            case 4:
                j2 = 60000000000L;
                break;
            case 5:
                j2 = 3600000000000L;
                break;
            case 6:
                j2 = 43200000000000L;
                break;
            default:
                throw new n("Unsupported unit: " + mVar);
        }
        return s / j2;
    }

    /* renamed from: r */
    public k m(long j2, m mVar) {
        return mVar instanceof l.b.a.w.b ? t(this.b.m(j2, mVar), this.c) : (k) mVar.c(this, j2);
    }

    public final long s() {
        return this.b.E() - (((long) this.c.c) * 1000000000);
    }

    public final k t(g gVar, q qVar) {
        return (this.b != gVar || !this.c.equals(qVar)) ? new k(gVar, qVar) : this;
    }

    public String toString() {
        return this.b.toString() + this.c.f4169d;
    }
}
