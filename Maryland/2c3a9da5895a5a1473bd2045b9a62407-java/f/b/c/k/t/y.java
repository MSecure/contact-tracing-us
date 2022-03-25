package f.b.c.k.t;

import f.b.c.g.a.f;
import f.b.c.k.u.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class y implements i0 {
    public j0 a;
    public final b0 b;
    public Set<f> c;

    public y(b0 b0Var) {
        this.b = b0Var;
    }

    @Override // f.b.c.k.t.i0
    public void a(f fVar) {
        this.c.remove(fVar);
    }

    @Override // f.b.c.k.t.i0
    public void b(f fVar) {
        if (j(fVar)) {
            this.c.remove(fVar);
        } else {
            this.c.add(fVar);
        }
    }

    @Override // f.b.c.k.t.i0
    public void c(j0 j0Var) {
        this.a = j0Var;
    }

    @Override // f.b.c.k.t.i0
    public long d() {
        return -1;
    }

    @Override // f.b.c.k.t.i0
    public void e() {
        c0 c0Var = this.b.f3173e;
        for (f fVar : this.c) {
            if (!j(fVar)) {
                c0Var.c(fVar);
            }
        }
        this.c = null;
    }

    @Override // f.b.c.k.t.i0
    public void f(d1 d1Var) {
        d0 d0Var = this.b.f3172d;
        Iterator<f> it = d0Var.b.d(d1Var.b).iterator();
        while (true) {
            f.a aVar = (f.a) it;
            if (aVar.hasNext()) {
                this.c.add((f.b.c.k.u.f) aVar.next());
            } else {
                d0Var.a.remove(d1Var.a);
                d0Var.b.g(d1Var.b);
                return;
            }
        }
    }

    @Override // f.b.c.k.t.i0
    public void g() {
        this.c = new HashSet();
    }

    @Override // f.b.c.k.t.i0
    public void h(f.b.c.k.u.f fVar) {
        this.c.add(fVar);
    }

    @Override // f.b.c.k.t.i0
    public void i(f.b.c.k.u.f fVar) {
        this.c.add(fVar);
    }

    public final boolean j(f.b.c.k.u.f fVar) {
        boolean z;
        boolean z2;
        if (this.b.f3172d.b.c(fVar)) {
            return true;
        }
        Iterator<T> it = this.b.b.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            T next = it.next();
            Objects.requireNonNull(next);
            Iterator<Map.Entry<T, Void>> m = next.b.b.m(new c(fVar, 0));
            if (!m.hasNext()) {
                z2 = false;
                continue;
            } else {
                z2 = m.next().getKey().a.equals(fVar);
                continue;
            }
            if (z2) {
                z = true;
                break;
            }
        }
        if (z) {
            return true;
        }
        j0 j0Var = this.a;
        if (j0Var == null || !j0Var.c(fVar)) {
            return false;
        }
        return true;
    }
}
