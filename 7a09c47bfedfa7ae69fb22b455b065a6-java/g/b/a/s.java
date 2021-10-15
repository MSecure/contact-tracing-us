package g.b.a;

import b.x.t;
import g.b.a.t.c;
import g.b.a.t.f;
import g.b.a.w.b;
import g.b.a.w.d;
import g.b.a.w.e;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.m;
import g.b.a.w.o;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.List;

public final class s extends f<e> implements d, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final l<s> f6452e = new a();

    /* renamed from: b  reason: collision with root package name */
    public final f f6453b;

    /* renamed from: c  reason: collision with root package name */
    public final q f6454c;

    /* renamed from: d  reason: collision with root package name */
    public final p f6455d;

    public class a implements l<s> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // g.b.a.w.l
        public s a(e eVar) {
            return s.W(eVar);
        }
    }

    public s(f fVar, q qVar, p pVar) {
        this.f6453b = fVar;
        this.f6454c = qVar;
        this.f6455d = pVar;
    }

    public static s V(long j, int i, p pVar) {
        q a2 = pVar.B().a(d.G(j, (long) i));
        return new s(f.Z(j, i, a2), a2, pVar);
    }

    public static s W(e eVar) {
        if (eVar instanceof s) {
            return (s) eVar;
        }
        try {
            p p = p.p(eVar);
            if (eVar.k(g.b.a.w.a.INSTANT_SECONDS)) {
                try {
                    return V(eVar.n(g.b.a.w.a.INSTANT_SECONDS), eVar.d(g.b.a.w.a.NANO_OF_SECOND), p);
                } catch (a unused) {
                }
            }
            return Y(f.U(eVar), p);
        } catch (a unused2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain ZonedDateTime from TemporalAccessor: ");
            sb.append(eVar);
            sb.append(", type ");
            throw new a(c.a.a.a.a.e(eVar, sb));
        }
    }

    public static s Y(f fVar, p pVar) {
        return a0(fVar, pVar, null);
    }

    public static s Z(d dVar, p pVar) {
        t.y2(dVar, "instant");
        t.y2(pVar, "zone");
        return V(dVar.f6404b, dVar.f6405c, pVar);
    }

    public static s a0(f fVar, p pVar, q qVar) {
        q qVar2;
        t.y2(fVar, "localDateTime");
        t.y2(pVar, "zone");
        if (pVar instanceof q) {
            return new s(fVar, (q) pVar, pVar);
        }
        g.b.a.x.f B = pVar.B();
        List<q> c2 = B.c(fVar);
        if (c2.size() == 1) {
            qVar2 = c2.get(0);
        } else {
            if (c2.size() == 0) {
                g.b.a.x.d b2 = B.b(fVar);
                fVar = fVar.d0(c.m((long) (b2.f6695d.f6447c - b2.f6694c.f6447c)).f6401b);
                qVar = b2.f6695d;
            } else if (qVar == null || !c2.contains(qVar)) {
                qVar2 = c2.get(0);
                t.y2(qVar2, "offset");
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

    @Override // g.b.a.t.f
    public q B() {
        return this.f6454c;
    }

    @Override // g.b.a.t.f
    public p D() {
        return this.f6455d;
    }

    /* Return type fixed from 'g.b.a.t.b' to match base method */
    @Override // g.b.a.t.f
    public e L() {
        return this.f6453b.f6414b;
    }

    /* Return type fixed from 'g.b.a.t.c' to match base method */
    @Override // g.b.a.t.f
    public c<e> P() {
        return this.f6453b;
    }

    @Override // g.b.a.t.f
    public g Q() {
        return this.f6453b.f6415c;
    }

    /* Return type fixed from 'g.b.a.t.f' to match base method */
    @Override // g.b.a.t.f
    public f<e> U(p pVar) {
        t.y2(pVar, "zone");
        return this.f6455d.equals(pVar) ? this : a0(this.f6453b, pVar, this.f6454c);
    }

    /* renamed from: X */
    public s m(long j, m mVar) {
        return j == Long.MIN_VALUE ? s(Long.MAX_VALUE, mVar).s(1, mVar) : s(-j, mVar);
    }

    @Override // g.b.a.t.f, g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        return jVar instanceof g.b.a.w.a ? (jVar == g.b.a.w.a.INSTANT_SECONDS || jVar == g.b.a.w.a.OFFSET_SECONDS) ? jVar.m() : this.f6453b.b(jVar) : jVar.p(this);
    }

    /* renamed from: b0 */
    public s s(long j, m mVar) {
        if (!(mVar instanceof b)) {
            return (s) mVar.f(this, j);
        }
        if (mVar.b()) {
            return c0(this.f6453b.s(j, mVar));
        }
        f a0 = this.f6453b.s(j, mVar);
        q qVar = this.f6454c;
        p pVar = this.f6455d;
        t.y2(a0, "localDateTime");
        t.y2(qVar, "offset");
        t.y2(pVar, "zone");
        return V(a0.H(qVar), a0.f6415c.f6421e, pVar);
    }

    public final s c0(f fVar) {
        return a0(fVar, this.f6455d, this.f6454c);
    }

    @Override // g.b.a.t.f, g.b.a.w.e, g.b.a.v.c
    public int d(j jVar) {
        if (!(jVar instanceof g.b.a.w.a)) {
            return super.d(jVar);
        }
        int ordinal = ((g.b.a.w.a) jVar).ordinal();
        if (ordinal == 28) {
            throw new a(c.a.a.a.a.d("Field too large for an int: ", jVar));
        } else if (ordinal != 29) {
            return this.f6453b.d(jVar);
        } else {
            return this.f6454c.f6447c;
        }
    }

    public final s d0(q qVar) {
        return (qVar.equals(this.f6454c) || !this.f6455d.B().f(this.f6453b, qVar)) ? this : new s(this.f6453b, qVar, this.f6455d);
    }

    /* renamed from: e0 */
    public s i(g.b.a.w.f fVar) {
        if (fVar instanceof e) {
            return a0(f.Y((e) fVar, this.f6453b.f6415c), this.f6455d, this.f6454c);
        }
        if (fVar instanceof g) {
            return a0(f.Y(this.f6453b.f6414b, (g) fVar), this.f6455d, this.f6454c);
        }
        if (fVar instanceof f) {
            return c0((f) fVar);
        }
        if (!(fVar instanceof d)) {
            return fVar instanceof q ? d0((q) fVar) : (s) fVar.t(this);
        }
        d dVar = (d) fVar;
        return V(dVar.f6404b, dVar.f6405c, this.f6455d);
    }

    @Override // g.b.a.t.f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f6453b.equals(sVar.f6453b) && this.f6454c.equals(sVar.f6454c) && this.f6455d.equals(sVar.f6455d);
    }

    @Override // g.b.a.t.f, g.b.a.w.e, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        return lVar == k.f6661f ? (R) this.f6453b.f6414b : (R) super.f(lVar);
    }

    /* renamed from: f0 */
    public s r(j jVar, long j) {
        if (!(jVar instanceof g.b.a.w.a)) {
            return (s) jVar.f(this, j);
        }
        g.b.a.w.a aVar = (g.b.a.w.a) jVar;
        int ordinal = aVar.ordinal();
        if (ordinal == 28) {
            return V(j, this.f6453b.f6415c.f6421e, this.f6455d);
        }
        if (ordinal != 29) {
            return c0(this.f6453b.r(jVar, j));
        }
        return d0(q.R(aVar.f6633c.a(j, aVar)));
    }

    /* renamed from: g0 */
    public s T(p pVar) {
        t.y2(pVar, "zone");
        return this.f6455d.equals(pVar) ? this : V(this.f6453b.H(this.f6454c), this.f6453b.f6415c.f6421e, pVar);
    }

    @Override // g.b.a.t.f
    public int hashCode() {
        return (this.f6453b.hashCode() ^ this.f6454c.f6447c) ^ Integer.rotateLeft(this.f6455d.hashCode(), 3);
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return (jVar instanceof g.b.a.w.a) || (jVar != null && jVar.d(this));
    }

    @Override // g.b.a.t.f, g.b.a.w.e
    public long n(j jVar) {
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.k(this);
        }
        int ordinal = ((g.b.a.w.a) jVar).ordinal();
        if (ordinal == 28) {
            return H();
        }
        if (ordinal != 29) {
            return this.f6453b.n(jVar);
        }
        return (long) this.f6454c.f6447c;
    }

    @Override // g.b.a.t.f
    public String toString() {
        String str = this.f6453b.toString() + this.f6454c.f6448d;
        if (this.f6454c == this.f6455d) {
            return str;
        }
        return str + '[' + this.f6455d.toString() + ']';
    }

    @Override // g.b.a.w.d
    public long y(d dVar, m mVar) {
        s W = W(dVar);
        if (!(mVar instanceof b)) {
            return mVar.d(this, W);
        }
        s g0 = W.T(this.f6455d);
        if (mVar.b()) {
            return this.f6453b.y(g0.f6453b, mVar);
        }
        return new j(this.f6453b, this.f6454c).y(new j(g0.f6453b, g0.f6454c), mVar);
    }
}
