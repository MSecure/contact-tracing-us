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
/* loaded from: classes.dex */
public final class t extends f<f> implements d, Serializable {
    public final g b;
    public final r c;

    /* renamed from: d */
    public final q f4647d;

    public t(g gVar, r rVar, q qVar) {
        this.b = gVar;
        this.c = rVar;
        this.f4647d = qVar;
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
        List<r> c = s.c(gVar);
        if (c.size() == 1) {
            rVar2 = c.get(0);
        } else {
            if (c.size() == 0) {
                l.b.a.y.d b = s.b(gVar);
                gVar = gVar.K(d.n((long) (b.f4803d.c - b.c.c)).b);
                rVar = b.f4803d;
            } else if (rVar == null || !c.contains(rVar)) {
                rVar2 = c.get(0);
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

    public f D(q qVar) {
        g.b.a.c.c.d.u(qVar, "zone");
        return this.f4647d.equals(qVar) ? this : J(this.b, qVar, this.c);
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
        q qVar = this.f4647d;
        g.b.a.c.c.d.u(H, "localDateTime");
        g.b.a.c.c.d.u(rVar, "offset");
        g.b.a.c.c.d.u(qVar, "zone");
        return E(H.v(rVar), H.c.f4623e, qVar);
    }

    public t L(long j2) {
        g gVar = this.b;
        return J(gVar.N(gVar.b.V(j2), gVar.c), this.f4647d, this.c);
    }

    public final t M(g gVar) {
        return J(gVar, this.f4647d, this.c);
    }

    public final t N(r rVar) {
        return (rVar.equals(this.c) || !this.f4647d.s().f(this.b, rVar)) ? this : new t(this.b, rVar, this.f4647d);
    }

    /* renamed from: O */
    public t e(l.b.a.x.f fVar) {
        if (fVar instanceof f) {
            return J(g.F((f) fVar, this.b.c), this.f4647d, this.c);
        }
        if (fVar instanceof h) {
            return J(g.F(this.b.b, (h) fVar), this.f4647d, this.c);
        }
        if (fVar instanceof g) {
            return M((g) fVar);
        }
        if (!(fVar instanceof e)) {
            return fVar instanceof r ? N((r) fVar) : (t) fVar.n(this);
        }
        e eVar = (e) fVar;
        return E(eVar.b, eVar.c, this.f4647d);
    }

    /* renamed from: P */
    public t l(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return (t) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        int ordinal = aVar.ordinal();
        if (ordinal == 28) {
            return E(j2, this.b.c.f4623e, this.f4647d);
        }
        if (ordinal != 29) {
            return M(this.b.l(jVar, j2));
        }
        return N(r.z(aVar.f4761e.a(j2, aVar)));
    }

    /* renamed from: Q */
    public t C(q qVar) {
        g.b.a.c.c.d.u(qVar, "zone");
        if (this.f4647d.equals(qVar)) {
            return this;
        }
        return E(this.b.v(this.c), this.b.c.f4623e, qVar);
    }

    public o a(j jVar) {
        return jVar instanceof a ? (jVar == a.INSTANT_SECONDS || jVar == a.OFFSET_SECONDS) ? jVar.h() : this.b.a(jVar) : jVar.l(this);
    }

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

    public <R> R c(l<R> lVar) {
        if (lVar == k.f4779f) {
            return (R) this.b.b;
        }
        return (R) super.c(lVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.b.equals(tVar.b) && this.c.equals(tVar.c) && this.f4647d.equals(tVar.f4647d);
    }

    public boolean f(j jVar) {
        return (jVar instanceof a) || (jVar != null && jVar.b(this));
    }

    public int hashCode() {
        return (this.b.hashCode() ^ this.c.c) ^ Integer.rotateLeft(this.f4647d.hashCode(), 3);
    }

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

    public long o(d dVar, m mVar) {
        t F = F(dVar);
        if (!(mVar instanceof b)) {
            return mVar.b(this, F);
        }
        t Q = F.C(this.f4647d);
        if (mVar.a()) {
            return this.b.o(Q.b, mVar);
        }
        return new k(this.b, this.c).o(new k(Q.b, Q.c), mVar);
    }

    public r r() {
        return this.c;
    }

    public q s() {
        return this.f4647d;
    }

    public String toString() {
        String str = this.b.toString() + this.c.f4644d;
        if (this.c == this.f4647d) {
            return str;
        }
        return str + '[' + this.f4647d.toString() + ']';
    }

    public l.b.a.u.b x() {
        return this.b.b;
    }

    public c y() {
        return this.b;
    }

    public h z() {
        return this.b.c;
    }
}
