package l.b.a.u;

import java.io.Serializable;
import l.b.a.h;
import l.b.a.u.b;
import l.b.a.x.d;
import l.b.a.x.f;
import l.b.a.x.m;
/* loaded from: classes.dex */
public abstract class a<D extends b> extends b implements d, f, Serializable {
    /* renamed from: A */
    public a<D> v(long j2, m mVar) {
        if (!(mVar instanceof l.b.a.x.b)) {
            return (a) s().e(mVar.c(this, j2));
        }
        switch (((l.b.a.x.b) mVar).ordinal()) {
            case 7:
                return B(j2);
            case 8:
                return B(g.b.a.c.c.d.x(j2, 7));
            case 9:
                return C(j2);
            case 10:
                return D(j2);
            case 11:
                return D(g.b.a.c.c.d.x(j2, 10));
            case 12:
                return D(g.b.a.c.c.d.x(j2, 100));
            case 13:
                return D(g.b.a.c.c.d.x(j2, 1000));
            default:
                throw new l.b.a.b(mVar + " not valid for chronology " + s().n());
        }
    }

    public abstract a<D> B(long j2);

    public abstract a<D> C(long j2);

    public abstract a<D> D(long j2);

    @Override // l.b.a.x.d
    public long o(d dVar, m mVar) {
        b c = s().c(dVar);
        return mVar instanceof l.b.a.x.b ? l.b.a.f.E(this).o(c, mVar) : mVar.b(this, c);
    }

    @Override // l.b.a.u.b
    public c<?> q(h hVar) {
        return new d(this, hVar);
    }
}
