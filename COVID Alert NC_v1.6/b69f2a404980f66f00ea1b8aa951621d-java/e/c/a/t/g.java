package e.c.a.t;

import c.b.a.a.c.n.c;
import e.c.a.p;
import e.c.a.q;
import e.c.a.t.b;
import e.c.a.w.a;
import e.c.a.w.j;
import e.c.a.w.m;
import e.c.a.x.d;
import e.c.a.x.f;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.List;

public final class g<D extends b> extends f<D> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final d<D> f5013b;

    /* renamed from: c  reason: collision with root package name */
    public final q f5014c;

    /* renamed from: d  reason: collision with root package name */
    public final p f5015d;

    public g(d<D> dVar, q qVar, p pVar) {
        c.T1(dVar, "dateTime");
        this.f5013b = dVar;
        c.T1(qVar, "offset");
        this.f5014c = qVar;
        c.T1(pVar, "zone");
        this.f5015d = pVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005c, code lost:
        if (r2.contains(r13) != false) goto L_0x0065;
     */
    public static <R extends b> f<R> F(d<R> dVar, p pVar, q qVar) {
        c.T1(dVar, "localDateTime");
        c.T1(pVar, "zone");
        if (pVar instanceof q) {
            return new g(dVar, (q) pVar, pVar);
        }
        f v = pVar.v();
        e.c.a.f E = e.c.a.f.E(dVar);
        List<q> c2 = v.c(E);
        if (c2.size() != 1) {
            if (c2.size() == 0) {
                d b2 = v.b(E);
                dVar = dVar.G(dVar.f5011b, 0, 0, e.c.a.c.k((long) (b2.f5208d.f5002b - b2.f5207c.f5002b)).f4964b, 0);
                qVar = b2.f5208d;
            } else if (qVar != null) {
            }
            c.T1(qVar, "offset");
            return new g(dVar, qVar, pVar);
        }
        qVar = c2.get(0);
        c.T1(qVar, "offset");
        return new g(dVar, qVar, pVar);
    }

    public static <R extends b> g<R> G(h hVar, e.c.a.d dVar, p pVar) {
        q a2 = pVar.v().a(dVar);
        c.T1(a2, "offset");
        return new g<>((d) hVar.q(e.c.a.f.J(dVar.f4967b, dVar.f4968c, a2)), a2, pVar);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new u((byte) 13, this);
    }

    @Override // e.c.a.t.f
    /* renamed from: C */
    public f<D> n(j jVar, long j) {
        if (!(jVar instanceof a)) {
            return y().u().k(jVar.f(this, j));
        }
        a aVar = (a) jVar;
        int ordinal = aVar.ordinal();
        if (ordinal == 28) {
            return o(j - x(), e.c.a.w.b.SECONDS);
        }
        if (ordinal != 29) {
            return F(this.f5013b.n(jVar, j), this.f5015d, this.f5014c);
        }
        return G(y().u(), this.f5013b.y(q.C(aVar.f5158c.a(j, aVar))), this.f5015d);
    }

    @Override // e.c.a.t.f
    public f<D> D(p pVar) {
        c.T1(pVar, "zone");
        if (this.f5015d.equals(pVar)) {
            return this;
        }
        return G(y().u(), this.f5013b.y(this.f5014c), pVar);
    }

    @Override // e.c.a.t.f
    public f<D> E(p pVar) {
        return F(this.f5013b, pVar, this.f5014c);
    }

    @Override // e.c.a.t.f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return compareTo((f) obj) == 0;
        }
        return false;
    }

    @Override // e.c.a.t.f
    public int hashCode() {
        return (this.f5013b.hashCode() ^ this.f5014c.f5002b) ^ Integer.rotateLeft(this.f5015d.hashCode(), 3);
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return (jVar instanceof a) || (jVar != null && jVar.d(this));
    }

    @Override // e.c.a.w.d
    public long q(e.c.a.w.d dVar, m mVar) {
        f<?> w = y().u().w(dVar);
        if (!(mVar instanceof e.c.a.w.b)) {
            return mVar.d(this, w);
        }
        return this.f5013b.q(w.D(this.f5014c).z(), mVar);
    }

    @Override // e.c.a.t.f
    public q t() {
        return this.f5014c;
    }

    @Override // e.c.a.t.f
    public String toString() {
        String str = this.f5013b.toString() + this.f5014c.f5003c;
        if (this.f5014c == this.f5015d) {
            return str;
        }
        return str + '[' + this.f5015d.toString() + ']';
    }

    @Override // e.c.a.t.f
    public p u() {
        return this.f5015d;
    }

    @Override // e.c.a.t.f
    /* renamed from: w */
    public f<D> o(long j, m mVar) {
        if (!(mVar instanceof e.c.a.w.b)) {
            return y().u().k(mVar.f(this, j));
        }
        return y().u().k(this.f5013b.w(j, mVar).p(this));
    }

    @Override // e.c.a.t.f
    public c<D> z() {
        return this.f5013b;
    }
}
