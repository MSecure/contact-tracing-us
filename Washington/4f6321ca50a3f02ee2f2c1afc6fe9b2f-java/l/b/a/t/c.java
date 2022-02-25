package l.b.a.t;

import l.b.a.e;
import l.b.a.g;
import l.b.a.p;
import l.b.a.q;
import l.b.a.t.b;
import l.b.a.w.a;
import l.b.a.w.d;
import l.b.a.w.f;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.m;

public abstract class c<D extends b> extends l.b.a.v.b implements d, f, Comparable<c<?>> {
    /* renamed from: A */
    public abstract c<D> l(j jVar, long j2);

    @Override // l.b.a.v.c, l.b.a.w.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.b) {
            return (R) s();
        }
        if (lVar == k.c) {
            return (R) l.b.a.w.b.NANOS;
        }
        if (lVar == k.f4208f) {
            return (R) e.R(x().x());
        }
        if (lVar == k.f4209g) {
            return (R) y();
        }
        if (lVar == k.f4206d || lVar == k.a || lVar == k.f4207e) {
            return null;
        }
        return (R) super.c(lVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && compareTo((c) obj) == 0;
    }

    public int hashCode() {
        return x().hashCode() ^ y().hashCode();
    }

    @Override // l.b.a.w.f
    public d n(d dVar) {
        return dVar.l(a.EPOCH_DAY, x().x()).l(a.NANO_OF_DAY, y().E());
    }

    public abstract f<D> q(p pVar);

    /* renamed from: r */
    public int compareTo(c<?> cVar) {
        int r = x().compareTo(cVar.x());
        if (r != 0) {
            return r;
        }
        int q = y().compareTo(cVar.y());
        return q == 0 ? s().compareTo(cVar.s()) : q;
    }

    public h s() {
        return x().s();
    }

    /* renamed from: t */
    public c<D> h(long j2, m mVar) {
        return x().s().f(super.h(j2, mVar));
    }

    public String toString() {
        return x().toString() + 'T' + y().toString();
    }

    /* renamed from: u */
    public abstract c<D> m(long j2, m mVar);

    public long v(q qVar) {
        f.b.a.c.b.o.b.B1(qVar, "offset");
        return ((x().x() * 86400) + ((long) y().F())) - ((long) qVar.c);
    }

    public l.b.a.d w(q qVar) {
        return l.b.a.d.y(v(qVar), (long) y().f4052e);
    }

    public abstract D x();

    public abstract g y();

    /* renamed from: z */
    public c<D> e(f fVar) {
        return x().s().f(fVar.n(this));
    }
}
