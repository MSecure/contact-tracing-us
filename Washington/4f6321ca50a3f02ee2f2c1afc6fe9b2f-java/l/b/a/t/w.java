package l.b.a.t;

import f.b.a.c.b.o.b;
import java.io.Serializable;
import l.b.a.e;
import l.b.a.g;
import l.b.a.l;
import l.b.a.w.a;
import l.b.a.w.d;
import l.b.a.w.f;
import l.b.a.w.i;
import l.b.a.w.j;
import l.b.a.w.m;
import l.b.a.w.n;
import l.b.a.w.o;

public final class w extends a<w> implements Serializable {
    public final e b;

    public w(e eVar) {
        b.B1(eVar, "date");
        this.b = eVar;
    }

    private Object writeReplace() {
        return new u((byte) 7, this);
    }

    /* Return type fixed from 'l.b.a.t.a' to match base method */
    @Override // l.b.a.t.a
    public a<w> A(long j2, m mVar) {
        return (w) super.v(j2, mVar);
    }

    /* Return type fixed from 'l.b.a.t.a' to match base method */
    @Override // l.b.a.t.a
    public a<w> B(long j2) {
        return G(this.b.V(j2));
    }

    /* Return type fixed from 'l.b.a.t.a' to match base method */
    @Override // l.b.a.t.a
    public a<w> C(long j2) {
        return G(this.b.W(j2));
    }

    /* Return type fixed from 'l.b.a.t.a' to match base method */
    @Override // l.b.a.t.a
    public a<w> D(long j2) {
        return G(this.b.Y(j2));
    }

    public final long E() {
        return ((((long) F()) * 12) + ((long) this.b.c)) - 1;
    }

    public final int F() {
        return this.b.b + 543;
    }

    public final w G(e eVar) {
        return eVar.equals(this.b) ? this : new w(eVar);
    }

    /* renamed from: H */
    public w z(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return (w) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        if (i(aVar) == j2) {
            return this;
        }
        switch (aVar.ordinal()) {
            case 24:
                v.f4110d.u(aVar).b(j2, aVar);
                return G(this.b.W(j2 - E()));
            case 25:
            case 26:
            case 27:
                int a = v.f4110d.u(aVar).a(j2, aVar);
                switch (aVar.ordinal()) {
                    case 25:
                        e eVar = this.b;
                        if (F() < 1) {
                            a = 1 - a;
                        }
                        return G(eVar.c0(a - 543));
                    case 26:
                        return G(this.b.c0(a - 543));
                    case 27:
                        return G(this.b.c0((1 - F()) - 543));
                }
        }
        return G(this.b.z(jVar, j2));
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        long j2;
        if (!(jVar instanceof a)) {
            return jVar.l(this);
        }
        if (f(jVar)) {
            a aVar = (a) jVar;
            int ordinal = aVar.ordinal();
            if (ordinal == 18 || ordinal == 19 || ordinal == 21) {
                return this.b.a(jVar);
            }
            if (ordinal != 25) {
                return v.f4110d.u(aVar);
            }
            o oVar = a.YEAR.f4190e;
            if (F() <= 0) {
                j2 = (-(oVar.b + 543)) + 1;
            } else {
                j2 = 543 + oVar.f4211e;
            }
            return o.d(1, j2);
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.d, l.b.a.t.b
    public d e(f fVar) {
        return (w) v.f4110d.e(fVar.n(this));
    }

    @Override // l.b.a.t.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            return this.b.equals(((w) obj).b);
        }
        return false;
    }

    @Override // l.b.a.w.d, l.b.a.t.b, l.b.a.v.b
    public d h(long j2, m mVar) {
        return (w) super.h(j2, mVar);
    }

    @Override // l.b.a.t.b
    public int hashCode() {
        v vVar = v.f4110d;
        return 146118545 ^ this.b.hashCode();
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.f(this);
        }
        int i2 = 1;
        switch (((a) jVar).ordinal()) {
            case 24:
                return E();
            case 25:
                int F = F();
                if (F < 1) {
                    F = 1 - F;
                }
                return (long) F;
            case 26:
                return (long) F();
            case 27:
                if (F() < 1) {
                    i2 = 0;
                }
                return (long) i2;
            default:
                return this.b.i(jVar);
        }
    }

    @Override // l.b.a.w.d, l.b.a.t.a, l.b.a.t.b
    public d m(long j2, m mVar) {
        return (w) super.v(j2, mVar);
    }

    @Override // l.b.a.t.a, l.b.a.t.b
    public final c<w> q(g gVar) {
        return new d(this, gVar);
    }

    @Override // l.b.a.t.b
    public h s() {
        return v.f4110d;
    }

    @Override // l.b.a.t.b
    public i t() {
        return (x) super.t();
    }

    @Override // l.b.a.t.b
    public b u(long j2, m mVar) {
        return (w) super.h(j2, mVar);
    }

    @Override // l.b.a.t.a, l.b.a.t.b
    public b v(long j2, m mVar) {
        return (w) super.v(j2, mVar);
    }

    @Override // l.b.a.t.b
    public b w(i iVar) {
        return (w) v.f4110d.e(((l) iVar).b(this));
    }

    @Override // l.b.a.t.b
    public long x() {
        return this.b.x();
    }

    @Override // l.b.a.t.b
    public b y(f fVar) {
        return (w) v.f4110d.e(fVar.n(this));
    }
}
