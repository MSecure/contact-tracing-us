package l.b.a;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.List;
import l.b.a.u.c;
import l.b.a.u.f;
import l.b.a.x.a;
import l.b.a.x.b;
import l.b.a.x.d;
import l.b.a.x.e;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.m;
import l.b.a.x.o;

public final class t extends f<f> implements d, Serializable {
    public final g b;
    public final r c;

    /* renamed from: d  reason: collision with root package name */
    public final q f4392d;

    public t(g gVar, r rVar, q qVar) {
        this.b = gVar;
        this.c = rVar;
        this.f4392d = qVar;
    }

    public static t E(long j2, int i2, q qVar) {
        r a = qVar.s().a(e.B(j2, (long) i2));
        return new t(g.G(j2, i2, a), a, qVar);
    }

    public static t F(e eVar) {
        if (eVar instanceof t) {
            return (t) eVar;
        }
        try {
            q q = q.q(eVar);
            a aVar = a.INSTANT_SECONDS;
            if (eVar.f(aVar)) {
                try {
                    return E(eVar.i(aVar), eVar.b(a.NANO_OF_SECOND), q);
                } catch (b unused) {
                }
            }
            return H(g.C(eVar), q);
        } catch (b unused2) {
            throw new b(f.a.a.a.a.f(eVar, f.a.a.a.a.k("Unable to obtain ZonedDateTime from TemporalAccessor: ", eVar, ", type ")));
        }
    }

    public static t H(g gVar, q qVar) {
        return J(gVar, qVar, null);
    }

    public static t I(e eVar, q qVar) {
        g.b.a.c.c.d.u(eVar, "instant");
        g.b.a.c.c.d.u(qVar, "zone");
        return E(eVar.b, eVar.c, qVar);
    }

    public static t J(g gVar, q qVar, r rVar) {
        r rVar2;
        g.b.a.c.c.d.u(gVar, "localDateTime");
        g.b.a.c.c.d.u(qVar, "zone");
        if (qVar instanceof r) {
            return new t(gVar, (r) qVar, qVar);
        }
        l.b.a.y.f s = qVar.s();
        List<r> c2 = s.c(gVar);
        if (c2.size() == 1) {
            rVar2 = c2.get(0);
        } else {
            if (c2.size() == 0) {
                l.b.a.y.d b2 = s.b(gVar);
                gVar = gVar.K(d.n((long) (b2.f4548d.c - b2.c.c)).b);
                rVar = b2.f4548d;
            } else if (rVar == null || !c2.contains(rVar)) {
                rVar2 = c2.get(0);
                g.b.a.c.c.d.u(rVar2, "offset");
            }
            return new t(gVar, rVar, qVar);
        }
        rVar = rVar2;
        return new t(gVar, rVar, qVar);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new n((byte) 6, this);
    }

    /* Return type fixed from 'l.b.a.u.f' to match base method */
    @Override // l.b.a.u.f
    public f<f> D(q qVar) {
        g.b.a.c.c.d.u(qVar, "zone");
        return this.f4392d.equals(qVar) ? this : J(this.b, qVar, this.c);
    }

    /* renamed from: G */
    public t t(long j2, m mVar) {
        return j2 == Long.MIN_VALUE ? u(Long.MAX_VALUE, mVar).u(1, mVar) : u(-j2, mVar);
    }

    /* renamed from: K */
    public t u(long j2, m mVar) {
        if (!(mVar instanceof b)) {
            return (t) mVar.c(this, j2);
        }
        if (mVar.a()) {
            return M(this.b.u(j2, mVar));
        }
        g H = this.b.u(j2, mVar);
        r rVar = this.c;
        q qVar = this.f4392d;
        g.b.a.c.c.d.u(H, "localDateTime");
        g.b.a.c.c.d.u(rVar, "offset");
        g.b.a.c.c.d.u(qVar, "zone");
        return E(H.v(rVar), H.c.f4368e, qVar);
    }

    public t L(long j2) {
        g gVar = this.b;
        return J(gVar.N(gVar.b.V(j2), gVar.c), this.f4392d, this.c);
    }

    public final t M(g gVar) {
        return J(gVar, this.f4392d, this.c);
    }

    public final t N(r rVar) {
        return (rVar.equals(this.c) || !this.f4392d.s().f(this.b, rVar)) ? this : new t(this.b, rVar, this.f4392d);
    }

    /* renamed from: O */
    public t e(l.b.a.x.f fVar) {
        if (fVar instanceof f) {
            return J(g.F((f) fVar, this.b.c), this.f4392d, this.c);
        }
        if (fVar instanceof h) {
            return J(g.F(this.b.b, (h) fVar), this.f4392d, this.c);
        }
        if (fVar instanceof g) {
            return M((g) fVar);
        }
        if (!(fVar instanceof e)) {
            return fVar instanceof r ? N((r) fVar) : (t) fVar.n(this);
        }
        e eVar = (e) fVar;
        return E(eVar.b, eVar.c, this.f4392d);
    }

    /* renamed from: P */
    public t l(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return (t) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        int ordinal = aVar.ordinal();
        if (ordinal == 28) {
            return E(j2, this.b.c.f4368e, this.f4392d);
        }
        if (ordinal != 29) {
            return M(this.b.l(jVar, j2));
        }
        return N(r.z(aVar.f4506e.a(j2, aVar)));
    }

    /* renamed from: Q */
    public t C(q qVar) {
        g.b.a.c.c.d.u(qVar, "zone");
        return this.f4392d.equals(qVar) ? this : E(this.b.v(this.c), this.b.c.f4368e, qVar);
    }

    @Override // l.b.a.x.e, l.b.a.w.c, l.b.a.u.f
    public o a(j jVar) {
        return jVar instanceof a ? (jVar == a.INSTANT_SECONDS || jVar == a.OFFSET_SECONDS) ? jVar.h() : this.b.a(jVar) : jVar.l(this);
    }

    @Override // l.b.a.x.e, l.b.a.w.c, l.b.a.u.f
    public int b(j jVar) {
        if (!(jVar instanceof a)) {
            return super.b(jVar);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal == 28) {
            throw new b(f.a.a.a.a.d("Field too large for an int: ", jVar));
        } else if (ordinal != 29) {
            return this.b.b(jVar);
        } else {
            return this.c.c;
        }
    }

    @Override // l.b.a.x.e, l.b.a.w.c, l.b.a.u.f
    public <R> R c(l<R> lVar) {
        return lVar == k.f4524f ? (R) this.b.b : (R) super.c(lVar);
    }

    @Override // l.b.a.u.f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.b.equals(tVar.b) && this.c.equals(tVar.c) && this.f4392d.equals(tVar.f4392d);
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return (jVar instanceof a) || (jVar != null && jVar.b(this));
    }

    @Override // l.b.a.u.f
    public int hashCode() {
        return (this.b.hashCode() ^ this.c.c) ^ Integer.rotateLeft(this.f4392d.hashCode(), 3);
    }

    @Override // l.b.a.x.e, l.b.a.u.f
    public long i(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.f(this);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal == 28) {
            return v();
        }
        if (ordinal != 29) {
            return this.b.i(jVar);
        }
        return (long) this.c.c;
    }

    @Override // l.b.a.x.d
    public long o(d dVar, m mVar) {
        t F = F(dVar);
        if (!(mVar instanceof b)) {
            return mVar.b(this, F);
        }
        t Q = F.C(this.f4392d);
        if (mVar.a()) {
            return this.b.o(Q.b, mVar);
        }
        return new k(this.b, this.c).o(new k(Q.b, Q.c), mVar);
    }

    @Override // l.b.a.u.f
    public r r() {
        return this.c;
    }

    @Override // l.b.a.u.f
    public q s() {
        return this.f4392d;
    }

    @Override // l.b.a.u.f
    public String toString() {
        String str = this.b.toString() + this.c.f4389d;
        if (this.c == this.f4392d) {
            return str;
        }
        return str + '[' + this.f4392d.toString() + ']';
    }

    /* Return type fixed from 'l.b.a.u.b' to match base method */
    @Override // l.b.a.u.f
    public f x() {
        return this.b.b;
    }

    /* Return type fixed from 'l.b.a.u.c' to match base method */
    @Override // l.b.a.u.f
    public c<f> y() {
        return this.b;
    }

    @Override // l.b.a.u.f
    public h z() {
        return this.b.c;
    }
}
