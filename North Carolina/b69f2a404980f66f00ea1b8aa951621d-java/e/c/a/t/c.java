package e.c.a.t;

import e.c.a.e;
import e.c.a.g;
import e.c.a.p;
import e.c.a.q;
import e.c.a.t.b;
import e.c.a.w.a;
import e.c.a.w.d;
import e.c.a.w.f;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.m;

public abstract class c<D extends b> extends e.c.a.v.b implements d, f, Comparable<c<?>> {
    public abstract g A();

    /* renamed from: B */
    public c<D> g(f fVar) {
        return z().u().i(fVar.p(this));
    }

    /* renamed from: C */
    public abstract c<D> n(j jVar, long j);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return compareTo((c) obj) == 0;
        }
        return false;
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public <R> R f(l<R> lVar) {
        if (lVar == k.f5178b) {
            return (R) u();
        }
        if (lVar == k.f5179c) {
            return (R) e.c.a.w.b.NANOS;
        }
        if (lVar == k.f) {
            return (R) e.R(z().z());
        }
        if (lVar == k.g) {
            return (R) A();
        }
        if (lVar == k.f5180d || lVar == k.f5177a || lVar == k.f5181e) {
            return null;
        }
        return (R) super.f(lVar);
    }

    public int hashCode() {
        return z().hashCode() ^ A().hashCode();
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        return dVar.n(a.EPOCH_DAY, z().z()).n(a.NANO_OF_DAY, A().I());
    }

    public abstract f<D> s(p pVar);

    /* renamed from: t */
    public int compareTo(c<?> cVar) {
        int t = z().compareTo(cVar.z());
        if (t != 0) {
            return t;
        }
        int s = A().compareTo(cVar.A());
        return s == 0 ? u().compareTo(cVar.u()) : s;
    }

    public String toString() {
        return z().toString() + 'T' + A().toString();
    }

    public h u() {
        return z().u();
    }

    /* renamed from: v */
    public c<D> k(long j, m mVar) {
        return z().u().i(super.k(j, mVar));
    }

    /* renamed from: w */
    public abstract c<D> o(long j, m mVar);

    public long x(q qVar) {
        c.b.a.a.c.n.c.T1(qVar, "offset");
        return ((z().z() * 86400) + ((long) A().J())) - ((long) qVar.f5002b);
    }

    public e.c.a.d y(q qVar) {
        return e.c.a.d.w(x(qVar), (long) A().f4980e);
    }

    public abstract D z();
}
