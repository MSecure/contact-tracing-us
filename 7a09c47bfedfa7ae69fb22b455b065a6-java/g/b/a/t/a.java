package g.b.a.t;

import b.x.t;
import g.b.a.e;
import g.b.a.g;
import g.b.a.t.b;
import g.b.a.w.d;
import g.b.a.w.f;
import g.b.a.w.m;
import java.io.Serializable;

public abstract class a<D extends b> extends b implements d, f, Serializable {
    @Override // g.b.a.t.b
    public c<?> A(g gVar) {
        return new d(this, gVar);
    }

    /* renamed from: S */
    public a<D> s(long j, m mVar) {
        if (!(mVar instanceof g.b.a.w.b)) {
            return (a) D().i(mVar.f(this, j));
        }
        switch (((g.b.a.w.b) mVar).ordinal()) {
            case 7:
                return T(j);
            case 8:
                return T(t.E2(j, 7));
            case 9:
                return U(j);
            case 10:
                return V(j);
            case 11:
                return V(t.E2(j, 10));
            case 12:
                return V(t.E2(j, 100));
            case 13:
                return V(t.E2(j, 1000));
            default:
                throw new g.b.a.a(mVar + " not valid for chronology " + D().s());
        }
    }

    public abstract a<D> T(long j);

    public abstract a<D> U(long j);

    public abstract a<D> V(long j);

    @Override // g.b.a.w.d
    public long y(d dVar, m mVar) {
        b f2 = D().f(dVar);
        return mVar instanceof g.b.a.w.b ? e.V(this).y(f2, mVar) : mVar.d(this, f2);
    }
}
