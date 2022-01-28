package l.b.a.u;

import g.b.a.c.c.c;
import l.b.a.e;
import l.b.a.h;
import l.b.a.q;
import l.b.a.r;
import l.b.a.t;
import l.b.a.u.b;
import l.b.a.x.a;
import l.b.a.x.d;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.m;
import l.b.a.x.n;
import l.b.a.x.o;

public abstract class f<D extends b> extends l.b.a.w.b implements d, Comparable<f<?>> {
    /* renamed from: A */
    public f<D> e(l.b.a.x.f fVar) {
        return x().s().h(fVar.n(this));
    }

    /* renamed from: B */
    public abstract f<D> l(j jVar, long j2);

    public abstract f<D> C(q qVar);

    public abstract f<D> D(q qVar);

    @Override // l.b.a.x.e, l.b.a.w.c
    public o a(j jVar) {
        return jVar instanceof a ? (jVar == a.INSTANT_SECONDS || jVar == a.OFFSET_SECONDS) ? jVar.h() : y().a(jVar) : jVar.l(this);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public int b(j jVar) {
        if (!(jVar instanceof a)) {
            return super.b(jVar);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal != 28) {
            return ordinal != 29 ? y().b(jVar) : r().c;
        }
        throw new n(f.a.a.a.a.e("Field too large for an int: ", jVar));
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public <R> R c(l<R> lVar) {
        return (lVar == k.a || lVar == k.f4457d) ? (R) s() : lVar == k.b ? (R) x().s() : lVar == k.c ? (R) l.b.a.x.b.NANOS : lVar == k.f4458e ? (R) r() : lVar == k.f4459f ? (R) l.b.a.f.R(x().x()) : lVar == k.f4460g ? (R) z() : (R) super.c(lVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && compareTo((f) obj) == 0;
    }

    public int hashCode() {
        return (y().hashCode() ^ r().c) ^ Integer.rotateLeft(s().hashCode(), 3);
    }

    @Override // l.b.a.x.e
    public long i(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.f(this);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal != 28) {
            return ordinal != 29 ? y().i(jVar) : (long) r().c;
        }
        return v();
    }

    /* renamed from: q */
    public int compareTo(f<?> fVar) {
        int e2 = c.e(v(), fVar.v());
        if (e2 != 0) {
            return e2;
        }
        int i2 = z().f4303e - fVar.z().f4303e;
        if (i2 != 0) {
            return i2;
        }
        int r = y().compareTo(fVar.y());
        if (r != 0) {
            return r;
        }
        int compareTo = s().r().compareTo(fVar.s().r());
        return compareTo == 0 ? x().s().compareTo(fVar.x().s()) : compareTo;
    }

    public abstract r r();

    public abstract q s();

    /* renamed from: t */
    public f<D> h(long j2, m mVar) {
        return x().s().h(super.h(j2, mVar));
    }

    public String toString() {
        String str = y().toString() + r().f4324d;
        if (r() == s()) {
            return str;
        }
        return str + '[' + s().toString() + ']';
    }

    /* renamed from: u */
    public abstract f<D> m(long j2, m mVar);

    public long v() {
        return ((x().x() * 86400) + ((long) z().F())) - ((long) r().c);
    }

    public e w() {
        return e.B(v(), (long) ((t) this).b.c.f4303e);
    }

    public D x() {
        return y().x();
    }

    public abstract c<D> y();

    public h z() {
        return y().y();
    }
}
