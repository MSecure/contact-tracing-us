package e.c.a;

import androidx.recyclerview.widget.RecyclerView;
import c.b.a.a.c.n.c;
import e.c.a.t.f;
import e.c.a.w.b;
import e.c.a.w.d;
import e.c.a.w.e;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.m;
import e.c.a.w.o;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.List;

public final class s extends f<e> implements d, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final l<s> f5007e = new a();

    /* renamed from: b  reason: collision with root package name */
    public final f f5008b;

    /* renamed from: c  reason: collision with root package name */
    public final q f5009c;

    /* renamed from: d  reason: collision with root package name */
    public final p f5010d;

    public class a implements l<s> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.c.a.w.l
        public s a(e eVar) {
            return s.G(eVar);
        }
    }

    public s(f fVar, q qVar, p pVar) {
        this.f5008b = fVar;
        this.f5009c = qVar;
        this.f5010d = pVar;
    }

    public static s F(long j, int i, p pVar) {
        q a2 = pVar.v().a(d.w(j, (long) i));
        return new s(f.J(j, i, a2), a2, pVar);
    }

    public static s G(e eVar) {
        if (eVar instanceof s) {
            return (s) eVar;
        }
        try {
            p s = p.s(eVar);
            if (eVar.i(e.c.a.w.a.INSTANT_SECONDS)) {
                try {
                    return F(eVar.l(e.c.a.w.a.INSTANT_SECONDS), eVar.d(e.c.a.w.a.NANO_OF_SECOND), s);
                } catch (a unused) {
                }
            }
            return I(f.E(eVar), s);
        } catch (a unused2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain ZonedDateTime from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(c.a.a.a.a.d(eVar, sb));
        }
    }

    public static s I(f fVar, p pVar) {
        return J(fVar, pVar, null);
    }

    public static s J(f fVar, p pVar, q qVar) {
        q qVar2;
        c.T1(fVar, "localDateTime");
        c.T1(pVar, "zone");
        if (pVar instanceof q) {
            return new s(fVar, (q) pVar, pVar);
        }
        e.c.a.x.f v = pVar.v();
        List<q> c2 = v.c(fVar);
        if (c2.size() == 1) {
            qVar2 = c2.get(0);
        } else {
            if (c2.size() == 0) {
                e.c.a.x.d b2 = v.b(fVar);
                fVar = fVar.N(c.k((long) (b2.f5208d.f5002b - b2.f5207c.f5002b)).f4964b);
                qVar = b2.f5208d;
            } else if (qVar == null || !c2.contains(qVar)) {
                qVar2 = c2.get(0);
                c.T1(qVar2, "offset");
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

    @Override // e.c.a.t.f
    public g A() {
        return this.f5008b.f4976c;
    }

    /* Return type fixed from 'e.c.a.t.f' to match base method */
    @Override // e.c.a.t.f
    public f<e> E(p pVar) {
        c.T1(pVar, "zone");
        return this.f5010d.equals(pVar) ? this : J(this.f5008b, pVar, this.f5009c);
    }

    /* renamed from: H */
    public s v(long j, m mVar) {
        return j == Long.MIN_VALUE ? w(RecyclerView.FOREVER_NS, mVar).w(1, mVar) : w(-j, mVar);
    }

    /* renamed from: K */
    public s w(long j, m mVar) {
        if (!(mVar instanceof b)) {
            return (s) mVar.f(this, j);
        }
        if (mVar.b()) {
            return L(this.f5008b.w(j, mVar));
        }
        f K = this.f5008b.w(j, mVar);
        q qVar = this.f5009c;
        p pVar = this.f5010d;
        c.T1(K, "localDateTime");
        c.T1(qVar, "offset");
        c.T1(pVar, "zone");
        return F(K.x(qVar), K.f4976c.f4980e, pVar);
    }

    public final s L(f fVar) {
        return J(fVar, this.f5010d, this.f5009c);
    }

    public final s M(q qVar) {
        return (qVar.equals(this.f5009c) || !this.f5010d.v().f(this.f5008b, qVar)) ? this : new s(this.f5008b, qVar, this.f5010d);
    }

    /* renamed from: N */
    public s g(e.c.a.w.f fVar) {
        if (fVar instanceof e) {
            return J(f.I((e) fVar, this.f5008b.f4976c), this.f5010d, this.f5009c);
        }
        if (fVar instanceof g) {
            return J(f.I(this.f5008b.f4975b, (g) fVar), this.f5010d, this.f5009c);
        }
        if (fVar instanceof f) {
            return L((f) fVar);
        }
        if (!(fVar instanceof d)) {
            return fVar instanceof q ? M((q) fVar) : (s) fVar.p(this);
        }
        d dVar = (d) fVar;
        return F(dVar.f4967b, dVar.f4968c, this.f5010d);
    }

    /* renamed from: O */
    public s n(j jVar, long j) {
        if (!(jVar instanceof e.c.a.w.a)) {
            return (s) jVar.f(this, j);
        }
        e.c.a.w.a aVar = (e.c.a.w.a) jVar;
        int ordinal = aVar.ordinal();
        if (ordinal == 28) {
            return F(j, this.f5008b.f4976c.f4980e, this.f5010d);
        }
        if (ordinal != 29) {
            return L(this.f5008b.n(jVar, j));
        }
        return M(q.C(aVar.f5158c.a(j, aVar)));
    }

    /* renamed from: P */
    public s D(p pVar) {
        c.T1(pVar, "zone");
        return this.f5010d.equals(pVar) ? this : F(this.f5008b.x(this.f5009c), this.f5008b.f4976c.f4980e, pVar);
    }

    @Override // e.c.a.t.f, e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        return jVar instanceof e.c.a.w.a ? (jVar == e.c.a.w.a.INSTANT_SECONDS || jVar == e.c.a.w.a.OFFSET_SECONDS) ? jVar.k() : this.f5008b.b(jVar) : jVar.n(this);
    }

    @Override // e.c.a.t.f, e.c.a.v.c, e.c.a.w.e
    public int d(j jVar) {
        if (!(jVar instanceof e.c.a.w.a)) {
            return super.d(jVar);
        }
        int ordinal = ((e.c.a.w.a) jVar).ordinal();
        if (ordinal == 28) {
            throw new a(c.a.a.a.a.c("Field too large for an int: ", jVar));
        } else if (ordinal != 29) {
            return this.f5008b.d(jVar);
        } else {
            return this.f5009c.f5002b;
        }
    }

    @Override // e.c.a.t.f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f5008b.equals(sVar.f5008b) && this.f5009c.equals(sVar.f5009c) && this.f5010d.equals(sVar.f5010d);
    }

    @Override // e.c.a.t.f, e.c.a.v.c, e.c.a.w.e
    public <R> R f(l<R> lVar) {
        return lVar == k.f ? (R) this.f5008b.f4975b : (R) super.f(lVar);
    }

    @Override // e.c.a.t.f
    public int hashCode() {
        return (this.f5008b.hashCode() ^ this.f5009c.f5002b) ^ Integer.rotateLeft(this.f5010d.hashCode(), 3);
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return (jVar instanceof e.c.a.w.a) || (jVar != null && jVar.d(this));
    }

    @Override // e.c.a.t.f, e.c.a.w.e
    public long l(j jVar) {
        if (!(jVar instanceof e.c.a.w.a)) {
            return jVar.i(this);
        }
        int ordinal = ((e.c.a.w.a) jVar).ordinal();
        if (ordinal == 28) {
            return x();
        }
        if (ordinal != 29) {
            return this.f5008b.l(jVar);
        }
        return (long) this.f5009c.f5002b;
    }

    @Override // e.c.a.w.d
    public long q(d dVar, m mVar) {
        s G = G(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, G);
        }
        s P = G.D(this.f5010d);
        if (mVar.b()) {
            return this.f5008b.q(P.f5008b, mVar);
        }
        return new j(this.f5008b, this.f5009c).q(new j(P.f5008b, P.f5009c), mVar);
    }

    @Override // e.c.a.t.f
    public q t() {
        return this.f5009c;
    }

    @Override // e.c.a.t.f
    public String toString() {
        String str = this.f5008b.toString() + this.f5009c.f5003c;
        if (this.f5009c == this.f5010d) {
            return str;
        }
        return str + '[' + this.f5010d.toString() + ']';
    }

    @Override // e.c.a.t.f
    public p u() {
        return this.f5010d;
    }

    /* Return type fixed from 'e.c.a.t.b' to match base method */
    @Override // e.c.a.t.f
    public e y() {
        return this.f5008b.f4975b;
    }

    /* Return type fixed from 'e.c.a.t.c' to match base method */
    @Override // e.c.a.t.f
    public e.c.a.t.c<e> z() {
        return this.f5008b;
    }
}
