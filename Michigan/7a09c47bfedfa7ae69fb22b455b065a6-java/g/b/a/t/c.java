package g.b.a.t;

import b.x.t;
import g.b.a.e;
import g.b.a.g;
import g.b.a.p;
import g.b.a.q;
import g.b.a.t.b;
import g.b.a.w.a;
import g.b.a.w.d;
import g.b.a.w.f;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.m;

public abstract class c<D extends b> extends g.b.a.v.b implements d, f, Comparable<c<?>> {
    public abstract f<D> A(p pVar);

    /* renamed from: B */
    public int compareTo(c<?> cVar) {
        int B = P().compareTo(cVar.P());
        if (B != 0) {
            return B;
        }
        int A = Q().compareTo(cVar.Q());
        return A == 0 ? D().compareTo(cVar.D()) : A;
    }

    public h D() {
        return P().D();
    }

    /* renamed from: F */
    public c<D> m(long j, m mVar) {
        return P().D().k(super.m(j, mVar));
    }

    /* renamed from: G */
    public abstract c<D> s(long j, m mVar);

    public long H(q qVar) {
        t.y2(qVar, "offset");
        return ((P().P() * 86400) + ((long) Q().Z())) - ((long) qVar.f6447c);
    }

    public g.b.a.d L(q qVar) {
        return g.b.a.d.G(H(qVar), (long) Q().f6421e);
    }

    public abstract D P();

    public abstract g Q();

    /* renamed from: R */
    public c<D> i(f fVar) {
        return P().D().k(fVar.t(this));
    }

    /* renamed from: S */
    public abstract c<D> r(j jVar, long j);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return compareTo((c) obj) == 0;
        }
        return false;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        if (lVar == k.f6657b) {
            return (R) D();
        }
        if (lVar == k.f6658c) {
            return (R) g.b.a.w.b.NANOS;
        }
        if (lVar == k.f6661f) {
            return (R) e.h0(P().P());
        }
        if (lVar == k.f6662g) {
            return (R) Q();
        }
        if (lVar == k.f6659d || lVar == k.f6656a || lVar == k.f6660e) {
            return null;
        }
        return (R) super.f(lVar);
    }

    public int hashCode() {
        return P().hashCode() ^ Q().hashCode();
    }

    @Override // g.b.a.w.f
    public d t(d dVar) {
        return dVar.r(a.EPOCH_DAY, P().P()).r(a.NANO_OF_DAY, Q().Y());
    }

    public String toString() {
        return P().toString() + 'T' + Q().toString();
    }
}
