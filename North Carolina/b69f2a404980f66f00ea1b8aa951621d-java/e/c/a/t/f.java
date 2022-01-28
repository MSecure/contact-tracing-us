package e.c.a.t;

import c.b.a.a.c.n.c;
import e.c.a.e;
import e.c.a.g;
import e.c.a.p;
import e.c.a.q;
import e.c.a.t.b;
import e.c.a.w.a;
import e.c.a.w.d;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.m;
import e.c.a.w.n;
import e.c.a.w.o;

public abstract class f<D extends b> extends e.c.a.v.b implements d, Comparable<f<?>> {
    public g A() {
        return z().A();
    }

    /* renamed from: B */
    public f<D> g(e.c.a.w.f fVar) {
        return y().u().k(fVar.p(this));
    }

    /* renamed from: C */
    public abstract f<D> n(j jVar, long j);

    public abstract f<D> D(p pVar);

    public abstract f<D> E(p pVar);

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        return jVar instanceof a ? (jVar == a.INSTANT_SECONDS || jVar == a.OFFSET_SECONDS) ? jVar.k() : z().b(jVar) : jVar.n(this);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public int d(j jVar) {
        if (!(jVar instanceof a)) {
            return super.d(jVar);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal != 28) {
            return ordinal != 29 ? z().d(jVar) : t().f5002b;
        }
        throw new n(c.a.a.a.a.c("Field too large for an int: ", jVar));
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

    @Override // e.c.a.v.c, e.c.a.w.e
    public <R> R f(l<R> lVar) {
        return (lVar == k.f5177a || lVar == k.f5180d) ? (R) u() : lVar == k.f5178b ? (R) y().u() : lVar == k.f5179c ? (R) e.c.a.w.b.NANOS : lVar == k.f5181e ? (R) t() : lVar == k.f ? (R) e.R(y().z()) : lVar == k.g ? (R) A() : (R) super.f(lVar);
    }

    public int hashCode() {
        return (z().hashCode() ^ t().f5002b) ^ Integer.rotateLeft(u().hashCode(), 3);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.i(this);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal != 28) {
            return ordinal != 29 ? z().l(jVar) : (long) t().f5002b;
        }
        return x();
    }

    /* renamed from: s */
    public int compareTo(f<?> fVar) {
        int A = c.A(x(), fVar.x());
        if (A != 0) {
            return A;
        }
        int i = A().f4980e - fVar.A().f4980e;
        if (i != 0) {
            return i;
        }
        int t = z().compareTo(fVar.z());
        if (t != 0) {
            return t;
        }
        int compareTo = u().u().compareTo(fVar.u().u());
        return compareTo == 0 ? y().u().compareTo(fVar.y().u()) : compareTo;
    }

    public abstract q t();

    public String toString() {
        String str = z().toString() + t().f5003c;
        if (t() == u()) {
            return str;
        }
        return str + '[' + u().toString() + ']';
    }

    public abstract p u();

    /* renamed from: v */
    public f<D> k(long j, m mVar) {
        return y().u().k(super.k(j, mVar));
    }

    /* renamed from: w */
    public abstract f<D> o(long j, m mVar);

    public long x() {
        return ((y().z() * 86400) + ((long) A().J())) - ((long) t().f5002b);
    }

    public D y() {
        return z().z();
    }

    public abstract c<D> z();
}
