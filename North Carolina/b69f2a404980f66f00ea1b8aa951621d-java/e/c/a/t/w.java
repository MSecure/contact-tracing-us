package e.c.a.t;

import c.b.a.a.c.n.c;
import e.c.a.e;
import e.c.a.g;
import e.c.a.l;
import e.c.a.w.a;
import e.c.a.w.d;
import e.c.a.w.f;
import e.c.a.w.i;
import e.c.a.w.j;
import e.c.a.w.m;
import e.c.a.w.n;
import e.c.a.w.o;
import java.io.Serializable;

public final class w extends a<w> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final e f5050b;

    public w(e eVar) {
        c.T1(eVar, "date");
        this.f5050b = eVar;
    }

    private Object writeReplace() {
        return new u((byte) 7, this);
    }

    @Override // e.c.a.t.b
    public b A(f fVar) {
        return (w) v.f5048d.g(fVar.p(this));
    }

    /* Return type fixed from 'e.c.a.t.a' to match base method */
    @Override // e.c.a.t.a
    public a<w> C(long j, m mVar) {
        return (w) super.x(j, mVar);
    }

    /* Return type fixed from 'e.c.a.t.a' to match base method */
    @Override // e.c.a.t.a
    public a<w> D(long j) {
        return I(this.f5050b.V(j));
    }

    /* Return type fixed from 'e.c.a.t.a' to match base method */
    @Override // e.c.a.t.a
    public a<w> E(long j) {
        return I(this.f5050b.W(j));
    }

    /* Return type fixed from 'e.c.a.t.a' to match base method */
    @Override // e.c.a.t.a
    public a<w> F(long j) {
        return I(this.f5050b.Y(j));
    }

    public final long G() {
        return ((((long) H()) * 12) + ((long) this.f5050b.f4971c)) - 1;
    }

    public final int H() {
        return this.f5050b.f4970b + 543;
    }

    public final w I(e eVar) {
        return eVar.equals(this.f5050b) ? this : new w(eVar);
    }

    /* renamed from: J */
    public w n(j jVar, long j) {
        if (!(jVar instanceof a)) {
            return (w) jVar.f(this, j);
        }
        a aVar = (a) jVar;
        if (l(aVar) == j) {
            return this;
        }
        switch (aVar.ordinal()) {
            case 24:
                v.f5048d.x(aVar).b(j, aVar);
                return I(this.f5050b.W(j - G()));
            case 25:
            case 26:
            case 27:
                int a2 = v.f5048d.x(aVar).a(j, aVar);
                switch (aVar.ordinal()) {
                    case 25:
                        e eVar = this.f5050b;
                        if (H() < 1) {
                            a2 = 1 - a2;
                        }
                        return I(eVar.d0(a2 - 543));
                    case 26:
                        return I(this.f5050b.d0(a2 - 543));
                    case 27:
                        return I(this.f5050b.d0((1 - H()) - 543));
                }
        }
        return I(this.f5050b.n(jVar, j));
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        long j;
        if (!(jVar instanceof a)) {
            return jVar.n(this);
        }
        if (i(jVar)) {
            a aVar = (a) jVar;
            int ordinal = aVar.ordinal();
            if (ordinal == 18 || ordinal == 19 || ordinal == 21) {
                return this.f5050b.b(jVar);
            }
            if (ordinal != 25) {
                return v.f5048d.x(aVar);
            }
            o oVar = a.YEAR.f5158c;
            if (H() <= 0) {
                j = (-(oVar.f5182b + 543)) + 1;
            } else {
                j = 543 + oVar.f5185e;
            }
            return o.d(1, j);
        }
        throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
    }

    @Override // e.c.a.t.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            return this.f5050b.equals(((w) obj).f5050b);
        }
        return false;
    }

    @Override // e.c.a.w.d, e.c.a.t.b
    public d g(f fVar) {
        return (w) v.f5048d.g(((e) fVar).p(this));
    }

    @Override // e.c.a.t.b
    public int hashCode() {
        v vVar = v.f5048d;
        return 146118545 ^ this.f5050b.hashCode();
    }

    @Override // e.c.a.v.b, e.c.a.w.d, e.c.a.t.b
    public d k(long j, m mVar) {
        return (w) super.k(j, mVar);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.i(this);
        }
        int i = 1;
        switch (((a) jVar).ordinal()) {
            case 24:
                return G();
            case 25:
                int H = H();
                if (H < 1) {
                    H = 1 - H;
                }
                return (long) H;
            case 26:
                return (long) H();
            case 27:
                if (H() < 1) {
                    i = 0;
                }
                return (long) i;
            default:
                return this.f5050b.l(jVar);
        }
    }

    @Override // e.c.a.w.d, e.c.a.t.b, e.c.a.t.a
    public d o(long j, m mVar) {
        return (w) super.x(j, mVar);
    }

    @Override // e.c.a.t.b, e.c.a.t.a
    public final c<w> s(g gVar) {
        return new d(this, gVar);
    }

    @Override // e.c.a.t.b
    public h u() {
        return v.f5048d;
    }

    @Override // e.c.a.t.b
    public i v() {
        return (x) super.v();
    }

    @Override // e.c.a.t.b
    public b w(long j, m mVar) {
        return (w) super.k(j, mVar);
    }

    @Override // e.c.a.t.b, e.c.a.t.a
    public b x(long j, m mVar) {
        return (w) super.x(j, mVar);
    }

    @Override // e.c.a.t.b
    public b y(i iVar) {
        return (w) v.f5048d.g(((l) iVar).a(this));
    }

    @Override // e.c.a.t.b
    public long z() {
        return this.f5050b.z();
    }
}
