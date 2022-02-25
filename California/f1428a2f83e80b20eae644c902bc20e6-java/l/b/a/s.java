package l.b.a;

import f.b.a.c.b.o.b;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.List;
import l.b.a.t.c;
import l.b.a.t.f;
import l.b.a.w.a;
import l.b.a.w.d;
import l.b.a.w.e;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.m;
import l.b.a.w.o;

public final class s extends f<e> implements d, Serializable {
    public final f b;
    public final q c;

    /* renamed from: d  reason: collision with root package name */
    public final p f4068d;

    public s(f fVar, q qVar, p pVar) {
        this.b = fVar;
        this.c = qVar;
        this.f4068d = pVar;
    }

    public static s E(long j2, int i2, p pVar) {
        q a = pVar.s().a(d.y(j2, (long) i2));
        return new s(f.G(j2, i2, a), a, pVar);
    }

    public static s F(e eVar) {
        if (eVar instanceof s) {
            return (s) eVar;
        }
        try {
            p q = p.q(eVar);
            a aVar = a.INSTANT_SECONDS;
            if (eVar.f(aVar)) {
                try {
                    return E(eVar.i(aVar), eVar.b(a.NANO_OF_SECOND), q);
                } catch (a unused) {
                }
            }
            return H(f.C(eVar), q);
        } catch (a unused2) {
            throw new a(f.a.a.a.a.f(eVar, f.a.a.a.a.k("Unable to obtain ZonedDateTime from TemporalAccessor: ", eVar, ", type ")));
        }
    }

    public static s H(f fVar, p pVar) {
        return I(fVar, pVar, null);
    }

    public static s I(f fVar, p pVar, q qVar) {
        q qVar2;
        b.B1(fVar, "localDateTime");
        b.B1(pVar, "zone");
        if (pVar instanceof q) {
            return new s(fVar, (q) pVar, pVar);
        }
        l.b.a.x.f s = pVar.s();
        List<q> c2 = s.c(fVar);
        if (c2.size() == 1) {
            qVar2 = c2.get(0);
        } else {
            if (c2.size() == 0) {
                l.b.a.x.d b2 = s.b(fVar);
                fVar = fVar.K(c.l((long) (b2.f4224d.c - b2.c.c)).b);
                qVar = b2.f4224d;
            } else if (qVar == null || !c2.contains(qVar)) {
                qVar2 = c2.get(0);
                b.B1(qVar2, "offset");
            }
            return new s(fVar, qVar, pVar);
        }
        qVar = qVar2;
        return new s(fVar, qVar, pVar);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 6, this);
    }

    /* Return type fixed from 'l.b.a.t.f' to match base method */
    @Override // l.b.a.t.f
    public f<e> D(p pVar) {
        b.B1(pVar, "zone");
        return this.f4068d.equals(pVar) ? this : I(this.b, pVar, this.c);
    }

    /* renamed from: G */
    public s t(long j2, m mVar) {
        return j2 == Long.MIN_VALUE ? u(Long.MAX_VALUE, mVar).u(1, mVar) : u(-j2, mVar);
    }

    /* renamed from: J */
    public s u(long j2, m mVar) {
        if (!(mVar instanceof l.b.a.w.b)) {
            return (s) mVar.c(this, j2);
        }
        if (mVar.a()) {
            return L(this.b.u(j2, mVar));
        }
        f H = this.b.u(j2, mVar);
        q qVar = this.c;
        p pVar = this.f4068d;
        b.B1(H, "localDateTime");
        b.B1(qVar, "offset");
        b.B1(pVar, "zone");
        return E(H.v(qVar), H.c.f4044e, pVar);
    }

    public s K(long j2) {
        f fVar = this.b;
        return I(fVar.N(fVar.b.V(j2), fVar.c), this.f4068d, this.c);
    }

    public final s L(f fVar) {
        return I(fVar, this.f4068d, this.c);
    }

    public final s M(q qVar) {
        return (qVar.equals(this.c) || !this.f4068d.s().f(this.b, qVar)) ? this : new s(this.b, qVar, this.f4068d);
    }

    /* renamed from: N */
    public s e(l.b.a.w.f fVar) {
        if (fVar instanceof e) {
            return I(f.F((e) fVar, this.b.c), this.f4068d, this.c);
        }
        if (fVar instanceof g) {
            return I(f.F(this.b.b, (g) fVar), this.f4068d, this.c);
        }
        if (fVar instanceof f) {
            return L((f) fVar);
        }
        if (!(fVar instanceof d)) {
            return fVar instanceof q ? M((q) fVar) : (s) fVar.n(this);
        }
        d dVar = (d) fVar;
        return E(dVar.b, dVar.c, this.f4068d);
    }

    /* renamed from: O */
    public s l(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return (s) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        int ordinal = aVar.ordinal();
        if (ordinal == 28) {
            return E(j2, this.b.c.f4044e, this.f4068d);
        }
        if (ordinal != 29) {
            return L(this.b.l(jVar, j2));
        }
        return M(q.z(aVar.f4182e.a(j2, aVar)));
    }

    /* renamed from: P */
    public s C(p pVar) {
        b.B1(pVar, "zone");
        return this.f4068d.equals(pVar) ? this : E(this.b.v(this.c), this.b.c.f4044e, pVar);
    }

    @Override // l.b.a.v.c, l.b.a.t.f, l.b.a.w.e
    public o a(j jVar) {
        return jVar instanceof a ? (jVar == a.INSTANT_SECONDS || jVar == a.OFFSET_SECONDS) ? jVar.h() : this.b.a(jVar) : jVar.l(this);
    }

    @Override // l.b.a.v.c, l.b.a.t.f, l.b.a.w.e
    public int b(j jVar) {
        if (!(jVar instanceof a)) {
            return super.b(jVar);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal == 28) {
            throw new a(f.a.a.a.a.d("Field too large for an int: ", jVar));
        } else if (ordinal != 29) {
            return this.b.b(jVar);
        } else {
            return this.c.c;
        }
    }

    @Override // l.b.a.v.c, l.b.a.t.f, l.b.a.w.e
    public <R> R c(l<R> lVar) {
        return lVar == k.f4200f ? (R) this.b.b : (R) super.c(lVar);
    }

    @Override // l.b.a.t.f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.b.equals(sVar.b) && this.c.equals(sVar.c) && this.f4068d.equals(sVar.f4068d);
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return (jVar instanceof a) || (jVar != null && jVar.b(this));
    }

    @Override // l.b.a.t.f
    public int hashCode() {
        return (this.b.hashCode() ^ this.c.c) ^ Integer.rotateLeft(this.f4068d.hashCode(), 3);
    }

    @Override // l.b.a.t.f, l.b.a.w.e
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

    @Override // l.b.a.w.d
    public long o(d dVar, m mVar) {
        s F = F(dVar);
        if (!(mVar instanceof l.b.a.w.b)) {
            return mVar.b(this, F);
        }
        s P = F.C(this.f4068d);
        if (mVar.a()) {
            return this.b.o(P.b, mVar);
        }
        return new j(this.b, this.c).o(new j(P.b, P.c), mVar);
    }

    @Override // l.b.a.t.f
    public q r() {
        return this.c;
    }

    @Override // l.b.a.t.f
    public p s() {
        return this.f4068d;
    }

    @Override // l.b.a.t.f
    public String toString() {
        String str = this.b.toString() + this.c.f4065d;
        if (this.c == this.f4068d) {
            return str;
        }
        return str + '[' + this.f4068d.toString() + ']';
    }

    /* Return type fixed from 'l.b.a.t.b' to match base method */
    @Override // l.b.a.t.f
    public e x() {
        return this.b.b;
    }

    /* Return type fixed from 'l.b.a.t.c' to match base method */
    @Override // l.b.a.t.f
    public c<e> y() {
        return this.b;
    }

    @Override // l.b.a.t.f
    public g z() {
        return this.b.c;
    }
}
