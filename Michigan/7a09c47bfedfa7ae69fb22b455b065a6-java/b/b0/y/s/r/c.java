package b.b0.y.s.r;

import b.b0.y.s.r.a;
import c.b.b.e.a.u;

public final class c<V> extends a<V> {
    public boolean k(V v) {
        if (v == null) {
            v = (V) a.h;
        }
        if (!a.f1308g.b(this, null, v)) {
            return false;
        }
        a.d(this);
        return true;
    }

    public boolean l(Throwable th) {
        if (th != null) {
            if (!a.f1308g.b(this, null, new a.d(th))) {
                return false;
            }
            a.d(this);
            return true;
        }
        throw null;
    }

    public boolean m(u<? extends V> uVar) {
        a.g gVar;
        a.d dVar;
        if (uVar != null) {
            Object obj = this.f1309b;
            if (obj == null) {
                if (uVar.isDone()) {
                    if (!a.f1308g.b(this, null, a.g(uVar))) {
                        return false;
                    }
                    a.d(this);
                } else {
                    gVar = new a.g(this, uVar);
                    if (a.f1308g.b(this, null, gVar)) {
                        try {
                            uVar.b(gVar, b.INSTANCE);
                        } catch (Throwable unused) {
                            dVar = a.d.f1316b;
                        }
                    } else {
                        obj = this.f1309b;
                    }
                }
                return true;
            }
            if (!(obj instanceof a.c)) {
                return false;
            }
            uVar.cancel(((a.c) obj).f1314a);
            return false;
        }
        throw null;
        a.f1308g.b(this, gVar, dVar);
        return true;
    }
}
