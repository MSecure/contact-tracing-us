package g.b.a.t;

import b.x.t;
import g.b.a.e;
import g.b.a.g;
import g.b.a.l;
import g.b.a.w.a;
import g.b.a.w.d;
import g.b.a.w.f;
import g.b.a.w.i;
import g.b.a.w.j;
import g.b.a.w.m;
import g.b.a.w.n;
import g.b.a.w.o;
import java.io.Serializable;

public final class w extends a<w> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final e f6505b;

    public w(e eVar) {
        t.y2(eVar, "date");
        this.f6505b = eVar;
    }

    private Object writeReplace() {
        return new u((byte) 7, this);
    }

    @Override // g.b.a.t.b, g.b.a.t.a
    public final c<w> A(g gVar) {
        return new d(this, gVar);
    }

    @Override // g.b.a.t.b
    public h D() {
        return v.f6501d;
    }

    @Override // g.b.a.t.b
    public i F() {
        return (x) super.F();
    }

    @Override // g.b.a.t.b
    public b G(long j, m mVar) {
        return (w) super.m(j, mVar);
    }

    @Override // g.b.a.t.b, g.b.a.t.a
    public b H(long j, m mVar) {
        return (w) super.s(j, mVar);
    }

    @Override // g.b.a.t.b
    public b L(i iVar) {
        return (w) v.f6501d.i(((l) iVar).a(this));
    }

    @Override // g.b.a.t.b
    public long P() {
        return this.f6505b.P();
    }

    @Override // g.b.a.t.b
    public b Q(f fVar) {
        return (w) v.f6501d.i(fVar.t(this));
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<w> S(long j, m mVar) {
        return (w) super.s(j, mVar);
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<w> T(long j) {
        return Y(this.f6505b.l0(j));
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<w> U(long j) {
        return Y(this.f6505b.m0(j));
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<w> V(long j) {
        return Y(this.f6505b.o0(j));
    }

    public final long W() {
        return ((((long) X()) * 12) + ((long) this.f6505b.f6410c)) - 1;
    }

    public final int X() {
        return this.f6505b.f6409b + 543;
    }

    public final w Y(e eVar) {
        return eVar.equals(this.f6505b) ? this : new w(eVar);
    }

    /* renamed from: Z */
    public w r(j jVar, long j) {
        if (!(jVar instanceof a)) {
            return (w) jVar.f(this, j);
        }
        a aVar = (a) jVar;
        if (n(aVar) == j) {
            return this;
        }
        switch (aVar.ordinal()) {
            case 24:
                v.f6501d.F(aVar).b(j, aVar);
                return Y(this.f6505b.m0(j - W()));
            case 25:
            case 26:
            case 27:
                int a2 = v.f6501d.F(aVar).a(j, aVar);
                switch (aVar.ordinal()) {
                    case 25:
                        e eVar = this.f6505b;
                        if (X() < 1) {
                            a2 = 1 - a2;
                        }
                        return Y(eVar.t0(a2 - 543));
                    case 26:
                        return Y(this.f6505b.t0(a2 - 543));
                    case 27:
                        return Y(this.f6505b.t0((1 - X()) - 543));
                }
        }
        return Y(this.f6505b.r(jVar, j));
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        long j;
        if (!(jVar instanceof a)) {
            return jVar.p(this);
        }
        if (k(jVar)) {
            a aVar = (a) jVar;
            int ordinal = aVar.ordinal();
            if (ordinal == 18 || ordinal == 19 || ordinal == 21) {
                return this.f6505b.b(jVar);
            }
            if (ordinal != 25) {
                return v.f6501d.F(aVar);
            }
            o oVar = a.YEAR.f6633c;
            if (X() <= 0) {
                j = (-(oVar.f6663b + 543)) + 1;
            } else {
                j = 543 + oVar.f6666e;
            }
            return o.d(1, j);
        }
        throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // g.b.a.t.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            return this.f6505b.equals(((w) obj).f6505b);
        }
        return false;
    }

    @Override // g.b.a.t.b
    public int hashCode() {
        v vVar = v.f6501d;
        return 146118545 ^ this.f6505b.hashCode();
    }

    @Override // g.b.a.w.d, g.b.a.t.b
    public d i(f fVar) {
        return (w) v.f6501d.i(((e) fVar).t(this));
    }

    @Override // g.b.a.w.d, g.b.a.t.b, g.b.a.v.b
    public d m(long j, m mVar) {
        return (w) super.m(j, mVar);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.k(this);
        }
        int i = 1;
        switch (((a) jVar).ordinal()) {
            case 24:
                return W();
            case 25:
                int X = X();
                if (X < 1) {
                    X = 1 - X;
                }
                return (long) X;
            case 26:
                return (long) X();
            case 27:
                if (X() < 1) {
                    i = 0;
                }
                return (long) i;
            default:
                return this.f6505b.n(jVar);
        }
    }

    @Override // g.b.a.w.d, g.b.a.t.b, g.b.a.t.a
    public d s(long j, m mVar) {
        return (w) super.s(j, mVar);
    }
}
