package e.c.a.t;

import c.b.a.a.c.n.c;
import e.c.a.e;
import e.c.a.g;
import e.c.a.t.b;
import e.c.a.w.d;
import e.c.a.w.f;
import e.c.a.w.m;
import java.io.Serializable;

public abstract class a<D extends b> extends b implements d, f, Serializable {
    /* renamed from: C */
    public a<D> x(long j, m mVar) {
        if (!(mVar instanceof e.c.a.w.b)) {
            return (a) u().g(mVar.f(this, j));
        }
        switch (((e.c.a.w.b) mVar).ordinal()) {
            case 7:
                return D(j);
            case 8:
                return D(c.Z1(j, 7));
            case 9:
                return E(j);
            case 10:
                return F(j);
            case 11:
                return F(c.Z1(j, 10));
            case 12:
                return F(c.Z1(j, 100));
            case 13:
                return F(c.Z1(j, 1000));
            default:
                throw new e.c.a.a(mVar + " not valid for chronology " + u().p());
        }
    }

    public abstract a<D> D(long j);

    public abstract a<D> E(long j);

    public abstract a<D> F(long j);

    @Override // e.c.a.w.d
    public long q(d dVar, m mVar) {
        b f = u().f(dVar);
        return mVar instanceof e.c.a.w.b ? e.F(this).q(f, mVar) : mVar.d(this, f);
    }

    @Override // e.c.a.t.b
    public c<?> s(g gVar) {
        return new d(this, gVar);
    }
}
