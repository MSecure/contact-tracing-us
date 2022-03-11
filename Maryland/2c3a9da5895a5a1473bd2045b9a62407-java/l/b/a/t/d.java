package l.b.a.t;

import java.io.Serializable;
import l.b.a.g;
import l.b.a.p;
import l.b.a.t.b;
import l.b.a.w.a;
import l.b.a.w.f;
import l.b.a.w.j;
import l.b.a.w.m;
import l.b.a.w.o;

public final class d<D extends b> extends c<D> implements l.b.a.w.d, f, Serializable {
    public final D b;
    public final g c;

    public d(D d2, g gVar) {
        f.b.a.c.b.o.b.A1(d2, "date");
        f.b.a.c.b.o.b.A1(gVar, "time");
        this.b = d2;
        this.c = gVar;
    }

    private Object writeReplace() {
        return new u((byte) 12, this);
    }

    /* renamed from: B */
    public d<D> u(long j2, m mVar) {
        if (!(mVar instanceof l.b.a.w.b)) {
            return this.b.s().f(mVar.c(this, j2));
        }
        switch (((l.b.a.w.b) mVar).ordinal()) {
            case 0:
                return D(j2);
            case 1:
                return C(j2 / 86400000000L).D((j2 % 86400000000L) * 1000);
            case 2:
                return C(j2 / 86400000).D((j2 % 86400000) * 1000000);
            case 3:
                return E(this.b, 0, 0, j2, 0);
            case 4:
                return E(this.b, 0, j2, 0, 0);
            case 5:
                return E(this.b, j2, 0, 0, 0);
            case 6:
                d<D> C = C(j2 / 256);
                return C.E(C.b, (j2 % 256) * 12, 0, 0, 0);
            default:
                return F(this.b.m(j2, mVar), this.c);
        }
    }

    public final d<D> C(long j2) {
        return F(this.b.m(j2, l.b.a.w.b.DAYS), this.c);
    }

    public final d<D> D(long j2) {
        return E(this.b, 0, 0, 0, j2);
    }

    public final d<D> E(D d2, long j2, long j3, long j4, long j5) {
        g w;
        b bVar = d2;
        if ((j2 | j3 | j4 | j5) == 0) {
            w = this.c;
        } else {
            long j6 = j2 / 24;
            long j7 = ((j2 % 24) * 3600000000000L) + ((j3 % 1440) * 60000000000L) + ((j4 % 86400) * 1000000000) + (j5 % 86400000000000L);
            long E = this.c.E();
            long j8 = j7 + E;
            long B0 = f.b.a.c.b.o.b.B0(j8, 86400000000000L) + j6 + (j3 / 1440) + (j4 / 86400) + (j5 / 86400000000000L);
            long E0 = f.b.a.c.b.o.b.E0(j8, 86400000000000L);
            w = E0 == E ? this.c : g.w(E0);
            bVar = bVar.m(B0, l.b.a.w.b.DAYS);
        }
        return F(bVar, w);
    }

    public final d<D> F(l.b.a.w.d dVar, g gVar) {
        D d2 = this.b;
        return (d2 == dVar && this.c == gVar) ? this : new d<>(d2.s().e(dVar), gVar);
    }

    /* renamed from: G */
    public d<D> z(f fVar) {
        return fVar instanceof b ? F((b) fVar, this.c) : fVar instanceof g ? F(this.b, (g) fVar) : fVar instanceof d ? this.b.s().f((d) fVar) : this.b.s().f((d) fVar.n(this));
    }

    /* renamed from: H */
    public d<D> l(j jVar, long j2) {
        return jVar instanceof a ? jVar.i() ? F(this.b, this.c.l(jVar, j2)) : F(this.b.l(jVar, j2), this.c) : this.b.s().f(jVar.c(this, j2));
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        return jVar instanceof a ? jVar.i() ? this.c.a(jVar) : this.b.a(jVar) : jVar.l(this);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public int b(j jVar) {
        return jVar instanceof a ? jVar.i() ? this.c.b(jVar) : this.b.b(jVar) : a(jVar).a(i(jVar), jVar);
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return jVar instanceof a ? jVar.a() || jVar.i() : jVar != null && jVar.b(this);
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        return jVar instanceof a ? jVar.i() ? this.c.i(jVar) : this.b.i(jVar) : jVar.f(this);
    }

    @Override // l.b.a.w.d
    public long o(l.b.a.w.d dVar, m mVar) {
        long j2;
        int i2;
        c<?> o = this.b.s().o(dVar);
        if (!(mVar instanceof l.b.a.w.b)) {
            return mVar.b(this, o);
        }
        l.b.a.w.b bVar = (l.b.a.w.b) mVar;
        l.b.a.w.b bVar2 = l.b.a.w.b.DAYS;
        boolean z = false;
        if (bVar.compareTo(bVar2) < 0) {
            a aVar = a.EPOCH_DAY;
            long i3 = o.i(aVar) - this.b.i(aVar);
            switch (bVar.ordinal()) {
                case 0:
                    j2 = 86400000000000L;
                    i3 = f.b.a.c.b.o.b.I1(i3, j2);
                    return f.b.a.c.b.o.b.G1(i3, this.c.o(o.y(), mVar));
                case 1:
                    j2 = 86400000000L;
                    i3 = f.b.a.c.b.o.b.I1(i3, j2);
                    return f.b.a.c.b.o.b.G1(i3, this.c.o(o.y(), mVar));
                case 2:
                    j2 = 86400000;
                    i3 = f.b.a.c.b.o.b.I1(i3, j2);
                    return f.b.a.c.b.o.b.G1(i3, this.c.o(o.y(), mVar));
                case 3:
                    i2 = 86400;
                    i3 = f.b.a.c.b.o.b.H1(i3, i2);
                    return f.b.a.c.b.o.b.G1(i3, this.c.o(o.y(), mVar));
                case 4:
                    i2 = 1440;
                    i3 = f.b.a.c.b.o.b.H1(i3, i2);
                    return f.b.a.c.b.o.b.G1(i3, this.c.o(o.y(), mVar));
                case 5:
                    i2 = 24;
                    i3 = f.b.a.c.b.o.b.H1(i3, i2);
                    return f.b.a.c.b.o.b.G1(i3, this.c.o(o.y(), mVar));
                case 6:
                    i2 = 2;
                    i3 = f.b.a.c.b.o.b.H1(i3, i2);
                    return f.b.a.c.b.o.b.G1(i3, this.c.o(o.y(), mVar));
                default:
                    return f.b.a.c.b.o.b.G1(i3, this.c.o(o.y(), mVar));
            }
        } else {
            b x = o.x();
            if (o.y().compareTo(this.c) < 0) {
                z = true;
            }
            if (z) {
                x = x.h(1, bVar2);
            }
            return this.b.o(x, mVar);
        }
    }

    @Override // l.b.a.t.c
    public f<D> q(p pVar) {
        return g.E(this, pVar, null);
    }

    @Override // l.b.a.t.c
    public D x() {
        return this.b;
    }

    @Override // l.b.a.t.c
    public g y() {
        return this.c;
    }
}
