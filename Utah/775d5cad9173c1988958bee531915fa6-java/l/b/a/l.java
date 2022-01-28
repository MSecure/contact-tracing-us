package l.b.a;

import f.a.a.a.a;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Objects;
import l.b.a.w.c;
import l.b.a.x.b;
import l.b.a.x.d;
import l.b.a.x.e;
import l.b.a.x.f;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.m;
import l.b.a.x.n;
import l.b.a.x.o;

public final class l extends c implements d, f, Comparable<l>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f4380d = 0;
    public final h b;
    public final r c;

    static {
        h hVar = h.f4363f;
        r rVar = r.f4388i;
        Objects.requireNonNull(hVar);
        new l(hVar, rVar);
        h hVar2 = h.f4364g;
        r rVar2 = r.f4387h;
        Objects.requireNonNull(hVar2);
        new l(hVar2, rVar2);
    }

    public l(h hVar, r rVar) {
        g.b.a.c.c.d.u(hVar, "time");
        this.b = hVar;
        g.b.a.c.c.d.u(rVar, "offset");
        this.c = rVar;
    }

    public static l q(e eVar) {
        if (eVar instanceof l) {
            return (l) eVar;
        }
        try {
            return new l(h.s(eVar), r.w(eVar));
        } catch (b unused) {
            throw new b(a.f(eVar, a.k("Unable to obtain OffsetTime from TemporalAccessor: ", eVar, ", type ")));
        }
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new n((byte) 66, this);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public o a(j jVar) {
        return jVar instanceof l.b.a.x.a ? jVar == l.b.a.x.a.OFFSET_SECONDS ? jVar.h() : this.b.a(jVar) : jVar.l(this);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public int b(j jVar) {
        return super.b(jVar);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public <R> R c(l.b.a.x.l<R> lVar) {
        if (lVar == k.c) {
            return (R) b.NANOS;
        }
        if (lVar == k.f4523e || lVar == k.f4522d) {
            return (R) this.c;
        }
        if (lVar == k.f4525g) {
            return (R) this.b;
        }
        if (lVar == k.b || lVar == k.f4524f || lVar == k.a) {
            return null;
        }
        return (R) super.c(lVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(l lVar) {
        int e2;
        l lVar2 = lVar;
        return (!this.c.equals(lVar2.c) && (e2 = g.b.a.c.c.d.e(s(), lVar2.s())) != 0) ? e2 : this.b.compareTo(lVar2.b);
    }

    @Override // l.b.a.x.d
    public d e(f fVar) {
        if (fVar instanceof h) {
            return t((h) fVar, this.c);
        }
        if (fVar instanceof r) {
            return t(this.b, (r) fVar);
        }
        boolean z = fVar instanceof l;
        d dVar = fVar;
        if (!z) {
            dVar = fVar.n(this);
        }
        return (l) dVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.b.equals(lVar.b) && this.c.equals(lVar.c);
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return jVar instanceof l.b.a.x.a ? jVar.i() || jVar == l.b.a.x.a.OFFSET_SECONDS : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.x.d
    public d h(long j2, m mVar) {
        return j2 == Long.MIN_VALUE ? m(Long.MAX_VALUE, mVar).m(1, mVar) : m(-j2, mVar);
    }

    public int hashCode() {
        return this.b.hashCode() ^ this.c.c;
    }

    @Override // l.b.a.x.e
    public long i(j jVar) {
        if (!(jVar instanceof l.b.a.x.a)) {
            return jVar.f(this);
        }
        if (jVar == l.b.a.x.a.OFFSET_SECONDS) {
            return (long) this.c.c;
        }
        return this.b.i(jVar);
    }

    @Override // l.b.a.x.d
    public d l(j jVar, long j2) {
        if (!(jVar instanceof l.b.a.x.a)) {
            return (l) jVar.c(this, j2);
        }
        if (jVar != l.b.a.x.a.OFFSET_SECONDS) {
            return t(this.b.l(jVar, j2), this.c);
        }
        l.b.a.x.a aVar = (l.b.a.x.a) jVar;
        return t(this.b, r.z(aVar.f4506e.a(j2, aVar)));
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        return dVar.l(l.b.a.x.a.NANO_OF_DAY, this.b.E()).l(l.b.a.x.a.OFFSET_SECONDS, (long) this.c.c);
    }

    @Override // l.b.a.x.d
    public long o(d dVar, m mVar) {
        long j2;
        l q = q(dVar);
        if (!(mVar instanceof b)) {
            return mVar.b(this, q);
        }
        long s = q.s() - s();
        switch (((b) mVar).ordinal()) {
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
    public l m(long j2, m mVar) {
        return mVar instanceof b ? t(this.b.m(j2, mVar), this.c) : (l) mVar.c(this, j2);
    }

    public final long s() {
        return this.b.E() - (((long) this.c.c) * 1000000000);
    }

    public final l t(h hVar, r rVar) {
        return (this.b != hVar || !this.c.equals(rVar)) ? new l(hVar, rVar) : this;
    }

    public String toString() {
        return this.b.toString() + this.c.f4389d;
    }
}
