package l.b.a.u;

import l.b.a.e;
import l.b.a.h;
import l.b.a.q;
import l.b.a.r;
import l.b.a.u.b;
import l.b.a.x.a;
import l.b.a.x.d;
import l.b.a.x.f;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.m;
/* loaded from: classes.dex */
public abstract class c<D extends b> extends l.b.a.w.b implements d, f, Comparable<c<?>> {
    /* renamed from: A */
    public abstract c<D> l(j jVar, long j2);

    @Override // l.b.a.w.c, l.b.a.x.e
    public <R> R c(l<R> lVar) {
        if (lVar == k.b) {
            return (R) s();
        }
        if (lVar == k.c) {
            return (R) l.b.a.x.b.NANOS;
        }
        if (lVar == k.f4779f) {
            return (R) l.b.a.f.R(x().x());
        }
        if (lVar == k.f4780g) {
            return (R) y();
        }
        if (lVar == k.f4777d || lVar == k.a || lVar == k.f4778e) {
            return null;
        }
        return (R) super.c(lVar);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && compareTo((c) obj) == 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return x().hashCode() ^ y().hashCode();
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        return dVar.l(a.EPOCH_DAY, x().x()).l(a.NANO_OF_DAY, y().E());
    }

    public abstract f<D> q(q qVar);

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

    @Override // java.lang.Object
    public String toString() {
        return x().toString() + 'T' + y().toString();
    }

    /* renamed from: u */
    public abstract c<D> m(long j2, m mVar);

    public long v(r rVar) {
        g.b.a.c.c.d.u(rVar, "offset");
        return ((x().x() * 86400) + ((long) y().F())) - ((long) rVar.c);
    }

    public e w(r rVar) {
        return e.B(v(rVar), (long) y().f4623e);
    }

    public abstract D x();

    public abstract h y();

    /* renamed from: z */
    public c<D> e(f fVar) {
        return x().s().f(fVar.n(this));
    }
}
