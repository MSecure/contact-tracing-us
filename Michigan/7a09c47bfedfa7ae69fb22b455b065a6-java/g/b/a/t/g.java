package g.b.a.t;

import b.x.t;
import g.b.a.c;
import g.b.a.p;
import g.b.a.q;
import g.b.a.t.b;
import g.b.a.w.a;
import g.b.a.w.j;
import g.b.a.w.m;
import g.b.a.x.d;
import g.b.a.x.f;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.List;

public final class g<D extends b> extends f<D> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final d<D> f6458b;

    /* renamed from: c  reason: collision with root package name */
    public final q f6459c;

    /* renamed from: d  reason: collision with root package name */
    public final p f6460d;

    public g(d<D> dVar, q qVar, p pVar) {
        t.y2(dVar, "dateTime");
        this.f6458b = dVar;
        t.y2(qVar, "offset");
        this.f6459c = qVar;
        t.y2(pVar, "zone");
        this.f6460d = pVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005c, code lost:
        if (r2.contains(r13) != false) goto L_0x0065;
     */
    public static <R extends b> f<R> V(d<R> dVar, p pVar, q qVar) {
        t.y2(dVar, "localDateTime");
        t.y2(pVar, "zone");
        if (pVar instanceof q) {
            return new g(dVar, (q) pVar, pVar);
        }
        f B = pVar.B();
        g.b.a.f U = g.b.a.f.U(dVar);
        List<q> c2 = B.c(U);
        if (c2.size() != 1) {
            if (c2.size() == 0) {
                d b2 = B.b(U);
                dVar = dVar.W(dVar.f6456b, 0, 0, c.m((long) (b2.f6695d.f6447c - b2.f6694c.f6447c)).f6401b, 0);
                qVar = b2.f6695d;
            } else if (qVar != null) {
            }
            t.y2(qVar, "offset");
            return new g(dVar, qVar, pVar);
        }
        qVar = c2.get(0);
        t.y2(qVar, "offset");
        return new g(dVar, qVar, pVar);
    }

    public static <R extends b> g<R> W(h hVar, g.b.a.d dVar, p pVar) {
        q a2 = pVar.B().a(dVar);
        t.y2(a2, "offset");
        return new g<>((d) hVar.t(g.b.a.f.Z(dVar.f6404b, dVar.f6405c, a2)), a2, pVar);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new u((byte) 13, this);
    }

    @Override // g.b.a.t.f
    public q B() {
        return this.f6459c;
    }

    @Override // g.b.a.t.f
    public p D() {
        return this.f6460d;
    }

    @Override // g.b.a.t.f
    /* renamed from: G */
    public f<D> s(long j, m mVar) {
        if (!(mVar instanceof g.b.a.w.b)) {
            return L().D().m(mVar.f(this, j));
        }
        return L().D().m(this.f6458b.s(j, mVar).t(this));
    }

    @Override // g.b.a.t.f
    public c<D> P() {
        return this.f6458b;
    }

    @Override // g.b.a.t.f
    /* renamed from: S */
    public f<D> r(j jVar, long j) {
        if (!(jVar instanceof a)) {
            return L().D().m(jVar.f(this, j));
        }
        a aVar = (a) jVar;
        int ordinal = aVar.ordinal();
        if (ordinal == 28) {
            return s(j - H(), g.b.a.w.b.SECONDS);
        }
        if (ordinal != 29) {
            return V(this.f6458b.r(jVar, j), this.f6460d, this.f6459c);
        }
        return W(L().D(), this.f6458b.L(q.R(aVar.f6633c.a(j, aVar))), this.f6460d);
    }

    @Override // g.b.a.t.f
    public f<D> T(p pVar) {
        t.y2(pVar, "zone");
        if (this.f6460d.equals(pVar)) {
            return this;
        }
        return W(L().D(), this.f6458b.L(this.f6459c), pVar);
    }

    @Override // g.b.a.t.f
    public f<D> U(p pVar) {
        return V(this.f6458b, pVar, this.f6459c);
    }

    @Override // g.b.a.t.f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return compareTo((f) obj) == 0;
        }
        return false;
    }

    @Override // g.b.a.t.f
    public int hashCode() {
        return (this.f6458b.hashCode() ^ this.f6459c.f6447c) ^ Integer.rotateLeft(this.f6460d.hashCode(), 3);
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return (jVar instanceof a) || (jVar != null && jVar.d(this));
    }

    @Override // g.b.a.t.f
    public String toString() {
        String str = this.f6458b.toString() + this.f6459c.f6448d;
        if (this.f6459c == this.f6460d) {
            return str;
        }
        return str + '[' + this.f6460d.toString() + ']';
    }

    @Override // g.b.a.w.d
    public long y(g.b.a.w.d dVar, m mVar) {
        f<?> D = L().D().D(dVar);
        if (!(mVar instanceof g.b.a.w.b)) {
            return mVar.d(this, D);
        }
        return this.f6458b.y(D.T(this.f6459c).P(), mVar);
    }
}
