package g.b.a.t;

import b.x.t;
import g.b.a.e;
import g.b.a.g;
import g.b.a.p;
import g.b.a.q;
import g.b.a.t.b;
import g.b.a.w.a;
import g.b.a.w.d;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.m;
import g.b.a.w.n;
import g.b.a.w.o;

public abstract class f<D extends b> extends g.b.a.v.b implements d, Comparable<f<?>> {
    /* renamed from: A */
    public int compareTo(f<?> fVar) {
        int L = t.L(H(), fVar.H());
        if (L != 0) {
            return L;
        }
        int i = Q().f6421e - fVar.Q().f6421e;
        if (i != 0) {
            return i;
        }
        int B = P().compareTo(fVar.P());
        if (B != 0) {
            return B;
        }
        int compareTo = D().A().compareTo(fVar.D().A());
        return compareTo == 0 ? L().D().compareTo(fVar.L().D()) : compareTo;
    }

    public abstract q B();

    public abstract p D();

    /* renamed from: F */
    public f<D> m(long j, m mVar) {
        return L().D().m(super.m(j, mVar));
    }

    /* renamed from: G */
    public abstract f<D> s(long j, m mVar);

    public long H() {
        return ((L().P() * 86400) + ((long) Q().Z())) - ((long) B().f6447c);
    }

    public D L() {
        return P().P();
    }

    public abstract c<D> P();

    public g Q() {
        return P().Q();
    }

    /* renamed from: R */
    public f<D> i(g.b.a.w.f fVar) {
        return L().D().m(fVar.t(this));
    }

    /* renamed from: S */
    public abstract f<D> r(j jVar, long j);

    public abstract f<D> T(p pVar);

    public abstract f<D> U(p pVar);

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        return jVar instanceof a ? (jVar == a.INSTANT_SECONDS || jVar == a.OFFSET_SECONDS) ? jVar.m() : P().b(jVar) : jVar.p(this);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public int d(j jVar) {
        if (!(jVar instanceof a)) {
            return super.d(jVar);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal != 28) {
            return ordinal != 29 ? P().d(jVar) : B().f6447c;
        }
        throw new n(c.a.a.a.a.d("Field too large for an int: ", jVar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return compareTo((f) obj) == 0;
        }
        return false;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        return (lVar == k.f6656a || lVar == k.f6659d) ? (R) D() : lVar == k.f6657b ? (R) L().D() : lVar == k.f6658c ? (R) g.b.a.w.b.NANOS : lVar == k.f6660e ? (R) B() : lVar == k.f6661f ? (R) e.h0(L().P()) : lVar == k.f6662g ? (R) Q() : (R) super.f(lVar);
    }

    public int hashCode() {
        return (P().hashCode() ^ B().f6447c) ^ Integer.rotateLeft(D().hashCode(), 3);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.k(this);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal != 28) {
            return ordinal != 29 ? P().n(jVar) : (long) B().f6447c;
        }
        return H();
    }

    public String toString() {
        String str = P().toString() + B().f6448d;
        if (B() == D()) {
            return str;
        }
        return str + '[' + D().toString() + ']';
    }
}
