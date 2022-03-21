package l.b.a.t;

import l.b.a.e;
import l.b.a.g;
import l.b.a.p;
import l.b.a.q;
import l.b.a.s;
import l.b.a.t.b;
import l.b.a.w.a;
import l.b.a.w.d;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.m;
import l.b.a.w.n;
import l.b.a.w.o;

public abstract class f<D extends b> extends l.b.a.v.b implements d, Comparable<f<?>> {
    /* renamed from: A */
    public f<D> e(l.b.a.w.f fVar) {
        return x().s().h(fVar.n(this));
    }

    /* renamed from: B */
    public abstract f<D> l(j jVar, long j2);

    public abstract f<D> C(p pVar);

    public abstract f<D> D(p pVar);

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        return jVar instanceof a ? (jVar == a.INSTANT_SECONDS || jVar == a.OFFSET_SECONDS) ? jVar.h() : y().a(jVar) : jVar.l(this);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public int b(j jVar) {
        if (!(jVar instanceof a)) {
            return super.b(jVar);
        }
        int ordinal = ((a) jVar).ordinal();
        if (ordinal != 28) {
            return ordinal != 29 ? y().b(jVar) : r().c;
        }
        throw new n(f.a.a.a.a.d("Field too large for an int: ", jVar));
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public <R> R c(l<R> lVar) {
        return (lVar == k.a || lVar == k.f4206d) ? (R) s() : lVar == k.b ? (R) x().s() : lVar == k.c ? (R) l.b.a.w.b.NANOS : lVar == k.f4207e ? (R) r() : lVar == k.f4208f ? (R) e.R(x().x()) : lVar == k.f4209g ? (R) z() : (R) super.c(lVar);
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

    @Override // l.b.a.w.e
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
        int L = f.b.a.c.b.o.b.L(v(), fVar.v());
        if (L != 0) {
            return L;
        }
        int i2 = z().f4052e - fVar.z().f4052e;
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

    public abstract q r();

    public abstract p s();

    /* renamed from: t */
    public f<D> h(long j2, m mVar) {
        return x().s().h(super.h(j2, mVar));
    }

    public String toString() {
        String str = y().toString() + r().f4073d;
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

    public l.b.a.d w() {
        return l.b.a.d.y(v(), (long) ((s) this).b.c.f4052e);
    }

    public D x() {
        return y().x();
    }

    public abstract c<D> y();

    public g z() {
        return y().y();
    }
}
