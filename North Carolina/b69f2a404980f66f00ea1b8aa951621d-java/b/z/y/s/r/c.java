package b.z.y.s.r;

import b.z.y.s.r.a;
import c.b.b.e.a.u;

public final class c<V> extends a<V> {
    public boolean k(V v) {
        if (v == null) {
            v = (V) a.h;
        }
        if (!a.g.b(this, null, v)) {
            return false;
        }
        a.d(this);
        return true;
    }

    public boolean l(Throwable th) {
        if (th != null) {
            if (!a.g.b(this, null, new a.d(th))) {
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
            Object obj = this.f2158b;
            if (obj == null) {
                if (uVar.isDone()) {
                    if (!a.g.b(this, null, a.g(uVar))) {
                        return false;
                    }
                    a.d(this);
                } else {
                    gVar = new a.g(this, uVar);
                    if (a.g.b(this, null, gVar)) {
                        try {
                            uVar.b(gVar, b.INSTANCE);
                        } catch (Throwable unused) {
                            dVar = a.d.f2165b;
                        }
                    } else {
                        obj = this.f2158b;
                    }
                }
                return true;
            }
            if (!(obj instanceof a.c)) {
                return false;
            }
            uVar.cancel(((a.c) obj).f2163a);
            return false;
        }
        throw null;
        a.g.b(this, gVar, dVar);
        return true;
    }
}
