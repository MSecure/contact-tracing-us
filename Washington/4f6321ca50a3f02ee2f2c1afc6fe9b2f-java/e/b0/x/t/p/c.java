package e.b0.x.t.p;

import e.b0.x.t.p.a;
import f.b.b.f.a.u;
import java.util.Objects;

public final class c<V> extends a<V> {
    public boolean j(V v) {
        if (v == null) {
            v = (V) a.f1143h;
        }
        if (!a.f1142g.b(this, null, v)) {
            return false;
        }
        a.c(this);
        return true;
    }

    public boolean k(Throwable th) {
        Objects.requireNonNull(th);
        if (!a.f1142g.b(this, null, new a.d(th))) {
            return false;
        }
        a.c(this);
        return true;
    }

    public boolean l(u<? extends V> uVar) {
        a.g gVar;
        a.d dVar;
        Objects.requireNonNull(uVar);
        Object obj = this.b;
        if (obj == null) {
            if (uVar.isDone()) {
                if (!a.f1142g.b(this, null, a.f(uVar))) {
                    return false;
                }
                a.c(this);
            } else {
                gVar = new a.g(this, uVar);
                if (a.f1142g.b(this, null, gVar)) {
                    try {
                        uVar.a(gVar, b.INSTANCE);
                    } catch (Throwable unused) {
                        dVar = a.d.b;
                    }
                } else {
                    obj = this.b;
                }
            }
            return true;
        }
        if (!(obj instanceof a.c)) {
            return false;
        }
        uVar.cancel(((a.c) obj).a);
        return false;
        a.f1142g.b(this, gVar, dVar);
        return true;
    }
}
