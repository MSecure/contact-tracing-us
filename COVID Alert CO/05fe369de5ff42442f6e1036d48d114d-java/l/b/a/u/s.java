package l.b.a.u;

import g.b.a.c.c.c;
import java.io.Serializable;
import l.b.a.f;
import l.b.a.h;
import l.b.a.x.a;
import l.b.a.x.d;
import l.b.a.x.i;
import l.b.a.x.j;
import l.b.a.x.m;
import l.b.a.x.n;
import l.b.a.x.o;

public final class s extends a<s> implements Serializable {
    public final f b;

    public s(f fVar) {
        c.u(fVar, "date");
        this.b = fVar;
    }

    private Object writeReplace() {
        return new u((byte) 5, this);
    }

    /* Return type fixed from 'l.b.a.u.a' to match base method */
    @Override // l.b.a.u.a
    public a<s> A(long j2, m mVar) {
        return (s) super.v(j2, mVar);
    }

    /* Return type fixed from 'l.b.a.u.a' to match base method */
    @Override // l.b.a.u.a
    public a<s> B(long j2) {
        return G(this.b.V(j2));
    }

    /* Return type fixed from 'l.b.a.u.a' to match base method */
    @Override // l.b.a.u.a
    public a<s> C(long j2) {
        return G(this.b.W(j2));
    }

    /* Return type fixed from 'l.b.a.u.a' to match base method */
    @Override // l.b.a.u.a
    public a<s> D(long j2) {
        return G(this.b.Y(j2));
    }

    public final long E() {
        return ((((long) F()) * 12) + ((long) this.b.c)) - 1;
    }

    public final int F() {
        return this.b.b - 1911;
    }

    public final s G(f fVar) {
        return fVar.equals(this.b) ? this : new s(fVar);
    }

    /* renamed from: H */
    public s z(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return (s) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        if (i(aVar) == j2) {
            return this;
        }
        switch (aVar.ordinal()) {
            case 24:
                r.f4359d.u(aVar).b(j2, aVar);
                return G(this.b.W(j2 - E()));
            case 25:
            case 26:
            case 27:
                int a = r.f4359d.u(aVar).a(j2, aVar);
                switch (aVar.ordinal()) {
                    case 25:
                        return G(this.b.c0(F() >= 1 ? a + 1911 : (1 - a) + 1911));
                    case 26:
                        return G(this.b.c0(a + 1911));
                    case 27:
                        return G(this.b.c0((1 - F()) + 1911));
                }
        }
        return G(this.b.z(jVar, j2));
    }

    @Override // l.b.a.x.e, l.b.a.w.c
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
                return r.f4359d.u(aVar);
            }
            o oVar = a.YEAR.f4441e;
            if (F() <= 0) {
                j2 = (-oVar.b) + 1 + 1911;
            } else {
                j2 = oVar.f4462e - 1911;
            }
            return o.d(1, j2);
        }
        throw new n(f.a.a.a.a.e("Unsupported field: ", jVar));
    }

    @Override // l.b.a.x.d, l.b.a.u.b
    public d e(l.b.a.x.f fVar) {
        return (s) r.f4359d.e(fVar.n(this));
    }

    @Override // l.b.a.u.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            return this.b.equals(((s) obj).b);
        }
        return false;
    }

    @Override // l.b.a.w.b, l.b.a.x.d, l.b.a.u.b
    public d h(long j2, m mVar) {
        return (s) super.h(j2, mVar);
    }

    @Override // l.b.a.u.b
    public int hashCode() {
        r rVar = r.f4359d;
        return -1990173233 ^ this.b.hashCode();
    }

    @Override // l.b.a.x.e
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

    @Override // l.b.a.x.d, l.b.a.u.a, l.b.a.u.b
    public d m(long j2, m mVar) {
        return (s) super.v(j2, mVar);
    }

    @Override // l.b.a.u.a, l.b.a.u.b
    public final c<s> q(h hVar) {
        return new d(this, hVar);
    }

    @Override // l.b.a.u.b
    public h s() {
        return r.f4359d;
    }

    @Override // l.b.a.u.b
    public i t() {
        return (t) super.t();
    }

    @Override // l.b.a.u.b
    public b u(long j2, m mVar) {
        return (s) super.h(j2, mVar);
    }

    @Override // l.b.a.u.a, l.b.a.u.b
    public b v(long j2, m mVar) {
        return (s) super.v(j2, mVar);
    }

    @Override // l.b.a.u.b
    public b w(i iVar) {
        return (s) r.f4359d.e(((l.b.a.m) iVar).b(this));
    }

    @Override // l.b.a.u.b
    public long x() {
        return this.b.x();
    }

    @Override // l.b.a.u.b
    public b y(l.b.a.x.f fVar) {
        return (s) r.f4359d.e(fVar.n(this));
    }
}
