package l.b.a;

import f.a.a.a.a;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Objects;
import l.b.a.u.m;
import l.b.a.w.b;
import l.b.a.x.d;
import l.b.a.x.e;
import l.b.a.x.f;
import l.b.a.x.j;
import l.b.a.x.l;
import l.b.a.x.o;
import l.b.a.y.f;

public final class k extends b implements d, f, Comparable<k>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f4379d = 0;
    public final g b;
    public final r c;

    static {
        g gVar = g.f4361d;
        r rVar = r.f4388i;
        Objects.requireNonNull(gVar);
        new k(gVar, rVar);
        g gVar2 = g.f4362e;
        r rVar2 = r.f4387h;
        Objects.requireNonNull(gVar2);
        new k(gVar2, rVar2);
    }

    public k(g gVar, r rVar) {
        g.b.a.c.c.d.u(gVar, "dateTime");
        this.b = gVar;
        g.b.a.c.c.d.u(rVar, "offset");
        this.c = rVar;
    }

    public static k q(e eVar) {
        if (eVar instanceof k) {
            return (k) eVar;
        }
        try {
            r w = r.w(eVar);
            try {
                return new k(g.C(eVar), w);
            } catch (b unused) {
                return s(e.s(eVar), w);
            }
        } catch (b unused2) {
            throw new b(a.f(eVar, a.k("Unable to obtain OffsetDateTime from TemporalAccessor: ", eVar, ", type ")));
        }
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static k s(e eVar, q qVar) {
        g.b.a.c.c.d.u(eVar, "instant");
        g.b.a.c.c.d.u(qVar, "zone");
        r rVar = ((f.a) qVar.s()).b;
        return new k(g.G(eVar.b, eVar.c, rVar), rVar);
    }

    private Object writeReplace() {
        return new n((byte) 69, this);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public o a(j jVar) {
        return jVar instanceof l.b.a.x.a ? (jVar == l.b.a.x.a.INSTANT_SECONDS || jVar == l.b.a.x.a.OFFSET_SECONDS) ? jVar.h() : this.b.a(jVar) : jVar.l(this);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public int b(j jVar) {
        if (!(jVar instanceof l.b.a.x.a)) {
            return super.b(jVar);
        }
        int ordinal = ((l.b.a.x.a) jVar).ordinal();
        if (ordinal == 28) {
            throw new b(a.d("Field too large for an int: ", jVar));
        } else if (ordinal != 29) {
            return this.b.b(jVar);
        } else {
            return this.c.c;
        }
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public <R> R c(l<R> lVar) {
        if (lVar == l.b.a.x.k.b) {
            return (R) m.f4408d;
        }
        if (lVar == l.b.a.x.k.c) {
            return (R) l.b.a.x.b.NANOS;
        }
        if (lVar == l.b.a.x.k.f4523e || lVar == l.b.a.x.k.f4522d) {
            return (R) this.c;
        }
        if (lVar == l.b.a.x.k.f4524f) {
            return (R) this.b.b;
        }
        if (lVar == l.b.a.x.k.f4525g) {
            return (R) this.b.c;
        }
        if (lVar == l.b.a.x.k.a) {
            return null;
        }
        return (R) super.c(lVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(k kVar) {
        g gVar;
        g gVar2;
        k kVar2 = kVar;
        if (this.c.equals(kVar2.c)) {
            gVar2 = this.b;
            gVar = kVar2.b;
        } else {
            int e2 = g.b.a.c.c.d.e(u(), kVar2.u());
            if (e2 != 0) {
                return e2;
            }
            gVar2 = this.b;
            int i2 = gVar2.c.f4368e;
            gVar = kVar2.b;
            int i3 = i2 - gVar.c.f4368e;
            if (i3 != 0) {
                return i3;
            }
        }
        return gVar2.compareTo(gVar);
    }

    @Override // l.b.a.x.d
    public d e(l.b.a.x.f fVar) {
        if ((fVar instanceof f) || (fVar instanceof h) || (fVar instanceof g)) {
            return v(this.b.z(fVar), this.c);
        }
        if (fVar instanceof e) {
            return s((e) fVar, this.c);
        }
        if (fVar instanceof r) {
            return v(this.b, (r) fVar);
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

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return (jVar instanceof l.b.a.x.a) || (jVar != null && jVar.b(this));
    }

    @Override // l.b.a.w.b, l.b.a.x.d
    public d h(long j2, l.b.a.x.m mVar) {
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
        int ordinal = ((l.b.a.x.a) jVar).ordinal();
        if (ordinal == 28) {
            return u();
        }
        if (ordinal != 29) {
            return this.b.i(jVar);
        }
        return (long) this.c.c;
    }

    @Override // l.b.a.x.d
    public d l(j jVar, long j2) {
        r rVar;
        g gVar;
        if (!(jVar instanceof l.b.a.x.a)) {
            return (k) jVar.c(this, j2);
        }
        l.b.a.x.a aVar = (l.b.a.x.a) jVar;
        int ordinal = aVar.ordinal();
        if (ordinal == 28) {
            return s(e.B(j2, (long) r()), this.c);
        }
        if (ordinal != 29) {
            gVar = this.b.l(jVar, j2);
            rVar = this.c;
        } else {
            gVar = this.b;
            rVar = r.z(aVar.f4506e.a(j2, aVar));
        }
        return v(gVar, rVar);
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        return dVar.l(l.b.a.x.a.EPOCH_DAY, this.b.b.x()).l(l.b.a.x.a.NANO_OF_DAY, this.b.c.E()).l(l.b.a.x.a.OFFSET_SECONDS, (long) this.c.c);
    }

    @Override // l.b.a.x.d
    public long o(d dVar, l.b.a.x.m mVar) {
        k q = q(dVar);
        if (!(mVar instanceof l.b.a.x.b)) {
            return mVar.b(this, q);
        }
        r rVar = this.c;
        if (!rVar.equals(q.c)) {
            q = new k(q.b.K((long) (rVar.c - q.c.c)), rVar);
        }
        return this.b.o(q.b, mVar);
    }

    public int r() {
        return this.b.c.f4368e;
    }

    /* renamed from: t */
    public k m(long j2, l.b.a.x.m mVar) {
        return mVar instanceof l.b.a.x.b ? v(this.b.u(j2, mVar), this.c) : (k) mVar.c(this, j2);
    }

    public String toString() {
        return this.b.toString() + this.c.f4389d;
    }

    public long u() {
        return this.b.v(this.c);
    }

    public final k v(g gVar, r rVar) {
        return (this.b != gVar || !this.c.equals(rVar)) ? new k(gVar, rVar) : this;
    }
}
