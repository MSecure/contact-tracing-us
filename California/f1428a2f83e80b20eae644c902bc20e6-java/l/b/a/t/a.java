package l.b.a.t;

import java.io.Serializable;
import l.b.a.e;
import l.b.a.g;
import l.b.a.t.b;
import l.b.a.w.d;
import l.b.a.w.f;
import l.b.a.w.m;

public abstract class a<D extends b> extends b implements d, f, Serializable {
    /* renamed from: A */
    public a<D> v(long j2, m mVar) {
        if (!(mVar instanceof l.b.a.w.b)) {
            return (a) s().e(mVar.c(this, j2));
        }
        switch (((l.b.a.w.b) mVar).ordinal()) {
            case 7:
                return B(j2);
            case 8:
                return B(f.b.a.c.b.o.b.I1(j2, 7));
            case 9:
                return C(j2);
            case 10:
                return D(j2);
            case 11:
                return D(f.b.a.c.b.o.b.I1(j2, 10));
            case 12:
                return D(f.b.a.c.b.o.b.I1(j2, 100));
            case 13:
                return D(f.b.a.c.b.o.b.I1(j2, 1000));
            default:
                throw new l.b.a.a(mVar + " not valid for chronology " + s().n());
        }
    }

    public abstract a<D> B(long j2);

    public abstract a<D> C(long j2);

    public abstract a<D> D(long j2);

    @Override // l.b.a.w.d
    public long o(d dVar, m mVar) {
        b c = s().c(dVar);
        return mVar instanceof l.b.a.w.b ? e.E(this).o(c, mVar) : mVar.b(this, c);
    }

    @Override // l.b.a.t.b
    public c<?> q(g gVar) {
        return new d(this, gVar);
    }
}
