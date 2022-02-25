package l.b.a.t;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.List;
import l.b.a.c;
import l.b.a.p;
import l.b.a.q;
import l.b.a.t.b;
import l.b.a.w.a;
import l.b.a.w.j;
import l.b.a.w.m;
import l.b.a.x.d;
import l.b.a.x.f;

public final class g<D extends b> extends f<D> implements Serializable {
    public final d<D> b;
    public final q c;

    /* renamed from: d  reason: collision with root package name */
    public final p f4077d;

    public g(d<D> dVar, q qVar, p pVar) {
        f.b.a.c.b.o.b.B1(dVar, "dateTime");
        this.b = dVar;
        f.b.a.c.b.o.b.B1(qVar, "offset");
        this.c = qVar;
        f.b.a.c.b.o.b.B1(pVar, "zone");
        this.f4077d = pVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005c, code lost:
        if (r2.contains(r13) != false) goto L_0x0065;
     */
    public static <R extends b> f<R> E(d<R> dVar, p pVar, q qVar) {
        f.b.a.c.b.o.b.B1(dVar, "localDateTime");
        f.b.a.c.b.o.b.B1(pVar, "zone");
        if (pVar instanceof q) {
            return new g(dVar, (q) pVar, pVar);
        }
        f s = pVar.s();
        l.b.a.f C = l.b.a.f.C(dVar);
        List<q> c2 = s.c(C);
        if (c2.size() != 1) {
            if (c2.size() == 0) {
                d b2 = s.b(C);
                dVar = dVar.E(dVar.b, 0, 0, c.l((long) (b2.f4232d.c - b2.c.c)).b, 0);
                qVar = b2.f4232d;
            } else if (qVar != null) {
            }
            f.b.a.c.b.o.b.B1(qVar, "offset");
            return new g(dVar, qVar, pVar);
        }
        qVar = c2.get(0);
        f.b.a.c.b.o.b.B1(qVar, "offset");
        return new g(dVar, qVar, pVar);
    }

    public static <R extends b> g<R> F(h hVar, l.b.a.d dVar, p pVar) {
        q a = pVar.s().a(dVar);
        f.b.a.c.b.o.b.B1(a, "offset");
        return new g<>((d) hVar.o(l.b.a.f.G(dVar.b, dVar.c, a)), a, pVar);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new u((byte) 13, this);
    }

    @Override // l.b.a.t.f
    /* renamed from: B */
    public f<D> l(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return x().s().h(jVar.c(this, j2));
        }
        a aVar = (a) jVar;
        int ordinal = aVar.ordinal();
        if (ordinal == 28) {
            return m(j2 - v(), l.b.a.w.b.SECONDS);
        }
        if (ordinal != 29) {
            return E(this.b.l(jVar, j2), this.f4077d, this.c);
        }
        return F(x().s(), this.b.w(q.z(aVar.f4190e.a(j2, aVar))), this.f4077d);
    }

    @Override // l.b.a.t.f
    public f<D> C(p pVar) {
        f.b.a.c.b.o.b.B1(pVar, "zone");
        if (this.f4077d.equals(pVar)) {
            return this;
        }
        return F(x().s(), this.b.w(this.c), pVar);
    }

    @Override // l.b.a.t.f
    public f<D> D(p pVar) {
        return E(this.b, pVar, this.c);
    }

    @Override // l.b.a.t.f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && compareTo((f) obj) == 0;
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return (jVar instanceof a) || (jVar != null && jVar.b(this));
    }

    @Override // l.b.a.t.f
    public int hashCode() {
        return (this.b.hashCode() ^ this.c.c) ^ Integer.rotateLeft(this.f4077d.hashCode(), 3);
    }

    @Override // l.b.a.w.d
    public long o(l.b.a.w.d dVar, m mVar) {
        f<?> t = x().s().t(dVar);
        if (!(mVar instanceof l.b.a.w.b)) {
            return mVar.b(this, t);
        }
        return this.b.o(t.C(this.c).y(), mVar);
    }

    @Override // l.b.a.t.f
    public q r() {
        return this.c;
    }

    @Override // l.b.a.t.f
    public p s() {
        return this.f4077d;
    }

    @Override // l.b.a.t.f
    public String toString() {
        String str = this.b.toString() + this.c.f4073d;
        if (this.c == this.f4077d) {
            return str;
        }
        return str + '[' + this.f4077d.toString() + ']';
    }

    @Override // l.b.a.t.f
    /* renamed from: u */
    public f<D> m(long j2, m mVar) {
        if (!(mVar instanceof l.b.a.w.b)) {
            return x().s().h(mVar.c(this, j2));
        }
        return x().s().h(this.b.u(j2, mVar).n(this));
    }

    @Override // l.b.a.t.f
    public c<D> y() {
        return this.b;
    }
}
