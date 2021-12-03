package l.b.a.u;

import g.b.a.c.c.c;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.List;
import l.b.a.e;
import l.b.a.q;
import l.b.a.r;
import l.b.a.u.b;
import l.b.a.x.a;
import l.b.a.x.j;
import l.b.a.x.m;
import l.b.a.y.d;
import l.b.a.y.f;

public final class g<D extends b> extends f<D> implements Serializable {
    public final d<D> b;
    public final r c;

    /* renamed from: d  reason: collision with root package name */
    public final q f4328d;

    public g(d<D> dVar, r rVar, q qVar) {
        c.u(dVar, "dateTime");
        this.b = dVar;
        c.u(rVar, "offset");
        this.c = rVar;
        c.u(qVar, "zone");
        this.f4328d = qVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005c, code lost:
        if (r2.contains(r13) != false) goto L_0x0065;
     */
    public static <R extends b> f<R> E(d<R> dVar, q qVar, r rVar) {
        c.u(dVar, "localDateTime");
        c.u(qVar, "zone");
        if (qVar instanceof r) {
            return new g(dVar, (r) qVar, qVar);
        }
        f s = qVar.s();
        l.b.a.g C = l.b.a.g.C(dVar);
        List<r> c2 = s.c(C);
        if (c2.size() != 1) {
            if (c2.size() == 0) {
                d b2 = s.b(C);
                dVar = dVar.E(dVar.b, 0, 0, l.b.a.d.n((long) (b2.f4483d.c - b2.c.c)).b, 0);
                rVar = b2.f4483d;
            } else if (rVar != null) {
            }
            c.u(rVar, "offset");
            return new g(dVar, rVar, qVar);
        }
        rVar = c2.get(0);
        c.u(rVar, "offset");
        return new g(dVar, rVar, qVar);
    }

    public static <R extends b> g<R> F(h hVar, e eVar, q qVar) {
        r a = qVar.s().a(eVar);
        c.u(a, "offset");
        return new g<>((d) hVar.o(l.b.a.g.G(eVar.b, eVar.c, a)), a, qVar);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new u((byte) 13, this);
    }

    @Override // l.b.a.u.f
    /* renamed from: B */
    public f<D> l(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return x().s().h(jVar.c(this, j2));
        }
        a aVar = (a) jVar;
        int ordinal = aVar.ordinal();
        if (ordinal == 28) {
            return m(j2 - v(), l.b.a.x.b.SECONDS);
        }
        if (ordinal != 29) {
            return E(this.b.l(jVar, j2), this.f4328d, this.c);
        }
        return F(x().s(), this.b.w(r.z(aVar.f4441e.a(j2, aVar))), this.f4328d);
    }

    @Override // l.b.a.u.f
    public f<D> C(q qVar) {
        c.u(qVar, "zone");
        if (this.f4328d.equals(qVar)) {
            return this;
        }
        return F(x().s(), this.b.w(this.c), qVar);
    }

    @Override // l.b.a.u.f
    public f<D> D(q qVar) {
        return E(this.b, qVar, this.c);
    }

    @Override // l.b.a.u.f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && compareTo((f) obj) == 0;
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return (jVar instanceof a) || (jVar != null && jVar.b(this));
    }

    @Override // l.b.a.u.f
    public int hashCode() {
        return (this.b.hashCode() ^ this.c.c) ^ Integer.rotateLeft(this.f4328d.hashCode(), 3);
    }

    @Override // l.b.a.x.d
    public long o(l.b.a.x.d dVar, m mVar) {
        f<?> t = x().s().t(dVar);
        if (!(mVar instanceof l.b.a.x.b)) {
            return mVar.b(this, t);
        }
        return this.b.o(t.C(this.c).y(), mVar);
    }

    @Override // l.b.a.u.f
    public r r() {
        return this.c;
    }

    @Override // l.b.a.u.f
    public q s() {
        return this.f4328d;
    }

    @Override // l.b.a.u.f
    public String toString() {
        String str = this.b.toString() + this.c.f4324d;
        if (this.c == this.f4328d) {
            return str;
        }
        return str + '[' + this.f4328d.toString() + ']';
    }

    @Override // l.b.a.u.f
    /* renamed from: u */
    public f<D> m(long j2, m mVar) {
        if (!(mVar instanceof l.b.a.x.b)) {
            return x().s().h(mVar.c(this, j2));
        }
        return x().s().h(this.b.u(j2, mVar).n(this));
    }

    @Override // l.b.a.u.f
    public c<D> y() {
        return this.b;
    }
}
