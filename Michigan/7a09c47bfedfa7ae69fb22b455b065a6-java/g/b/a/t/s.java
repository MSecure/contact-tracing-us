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

public final class s extends a<s> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final e f6495b;

    public s(e eVar) {
        t.y2(eVar, "date");
        this.f6495b = eVar;
    }

    private Object writeReplace() {
        return new u((byte) 5, this);
    }

    @Override // g.b.a.t.b, g.b.a.t.a
    public final c<s> A(g gVar) {
        return new d(this, gVar);
    }

    @Override // g.b.a.t.b
    public h D() {
        return r.f6494d;
    }

    @Override // g.b.a.t.b
    public i F() {
        return (t) super.F();
    }

    @Override // g.b.a.t.b
    public b G(long j, m mVar) {
        return (s) super.m(j, mVar);
    }

    @Override // g.b.a.t.b, g.b.a.t.a
    public b H(long j, m mVar) {
        return (s) super.s(j, mVar);
    }

    @Override // g.b.a.t.b
    public b L(i iVar) {
        return (s) r.f6494d.i(((l) iVar).a(this));
    }

    @Override // g.b.a.t.b
    public long P() {
        return this.f6495b.P();
    }

    @Override // g.b.a.t.b
    public b Q(f fVar) {
        return (s) r.f6494d.i(fVar.t(this));
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<s> S(long j, m mVar) {
        return (s) super.s(j, mVar);
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<s> T(long j) {
        return Y(this.f6495b.l0(j));
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<s> U(long j) {
        return Y(this.f6495b.m0(j));
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<s> V(long j) {
        return Y(this.f6495b.o0(j));
    }

    public final long W() {
        return ((((long) X()) * 12) + ((long) this.f6495b.f6410c)) - 1;
    }

    public final int X() {
        return this.f6495b.f6409b - 1911;
    }

    public final s Y(e eVar) {
        return eVar.equals(this.f6495b) ? this : new s(eVar);
    }

    /* renamed from: Z */
    public s r(j jVar, long j) {
        if (!(jVar instanceof a)) {
            return (s) jVar.f(this, j);
        }
        a aVar = (a) jVar;
        if (n(aVar) == j) {
            return this;
        }
        switch (aVar.ordinal()) {
            case 24:
                r.f6494d.F(aVar).b(j, aVar);
                return Y(this.f6495b.m0(j - W()));
            case 25:
            case 26:
            case 27:
                int a2 = r.f6494d.F(aVar).a(j, aVar);
                switch (aVar.ordinal()) {
                    case 25:
                        return Y(this.f6495b.t0(X() >= 1 ? a2 + 1911 : (1 - a2) + 1911));
                    case 26:
                        return Y(this.f6495b.t0(a2 + 1911));
                    case 27:
                        return Y(this.f6495b.t0((1 - X()) + 1911));
                }
        }
        return Y(this.f6495b.r(jVar, j));
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
                return this.f6495b.b(jVar);
            }
            if (ordinal != 25) {
                return r.f6494d.F(aVar);
            }
            o oVar = a.YEAR.f6633c;
            if (X() <= 0) {
                j = (-oVar.f6663b) + 1 + 1911;
            } else {
                j = oVar.f6666e - 1911;
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
        if (obj instanceof s) {
            return this.f6495b.equals(((s) obj).f6495b);
        }
        return false;
    }

    @Override // g.b.a.t.b
    public int hashCode() {
        r rVar = r.f6494d;
        return -1990173233 ^ this.f6495b.hashCode();
    }

    @Override // g.b.a.w.d, g.b.a.t.b
    public d i(f fVar) {
        return (s) r.f6494d.i(((e) fVar).t(this));
    }

    @Override // g.b.a.w.d, g.b.a.t.b, g.b.a.v.b
    public d m(long j, m mVar) {
        return (s) super.m(j, mVar);
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
                return this.f6495b.n(jVar);
        }
    }

    @Override // g.b.a.w.d, g.b.a.t.b, g.b.a.t.a
    public d s(long j, m mVar) {
        return (s) super.s(j, mVar);
    }
}
