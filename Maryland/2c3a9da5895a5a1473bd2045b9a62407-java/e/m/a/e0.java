package e.m.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import e.b0.a.b;
import e.m.a.f0;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class e0 {
    public final CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList<>();
    public final f0 b;

    public static final class a {
        public final f0.k a;
        public final boolean b;

        public a(f0.k kVar, boolean z) {
            this.a = kVar;
            this.b = z;
        }
    }

    public e0(f0 f0Var) {
        this.b = f0Var;
    }

    public void a(l lVar, Bundle bundle, boolean z) {
        l lVar2 = this.b.s;
        if (lVar2 != null) {
            lVar2.t().n.a(lVar, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.a);
            }
        }
    }

    public void b(l lVar, boolean z) {
        f0 f0Var = this.b;
        Context context = f0Var.q.c;
        l lVar2 = f0Var.s;
        if (lVar2 != null) {
            lVar2.t().n.b(lVar, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.a);
            }
        }
    }

    public void c(l lVar, Bundle bundle, boolean z) {
        l lVar2 = this.b.s;
        if (lVar2 != null) {
            lVar2.t().n.c(lVar, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.a);
            }
        }
    }

    public void d(l lVar, boolean z) {
        l lVar2 = this.b.s;
        if (lVar2 != null) {
            lVar2.t().n.d(lVar, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.a);
            }
        }
    }

    public void e(l lVar, boolean z) {
        l lVar2 = this.b.s;
        if (lVar2 != null) {
            lVar2.t().n.e(lVar, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.a);
            }
        }
    }

    public void f(l lVar, boolean z) {
        l lVar2 = this.b.s;
        if (lVar2 != null) {
            lVar2.t().n.f(lVar, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.a);
            }
        }
    }

    public void g(l lVar, boolean z) {
        f0 f0Var = this.b;
        Context context = f0Var.q.c;
        l lVar2 = f0Var.s;
        if (lVar2 != null) {
            lVar2.t().n.g(lVar, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.a);
            }
        }
    }

    public void h(l lVar, Bundle bundle, boolean z) {
        l lVar2 = this.b.s;
        if (lVar2 != null) {
            lVar2.t().n.h(lVar, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.a);
            }
        }
    }

    public void i(l lVar, boolean z) {
        l lVar2 = this.b.s;
        if (lVar2 != null) {
            lVar2.t().n.i(lVar, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.a);
            }
        }
    }

    public void j(l lVar, Bundle bundle, boolean z) {
        l lVar2 = this.b.s;
        if (lVar2 != null) {
            lVar2.t().n.j(lVar, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.a);
            }
        }
    }

    public void k(l lVar, boolean z) {
        l lVar2 = this.b.s;
        if (lVar2 != null) {
            lVar2.t().n.k(lVar, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.a);
            }
        }
    }

    public void l(l lVar, boolean z) {
        l lVar2 = this.b.s;
        if (lVar2 != null) {
            lVar2.t().n.l(lVar, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.a);
            }
        }
    }

    public void m(l lVar, View view, Bundle bundle, boolean z) {
        l lVar2 = this.b.s;
        if (lVar2 != null) {
            lVar2.t().n.m(lVar, view, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                f0.k kVar = next.a;
                f0 f0Var = this.b;
                b bVar = (b) kVar;
                if (lVar == bVar.a) {
                    e0 e0Var = f0Var.n;
                    synchronized (e0Var.a) {
                        int i2 = 0;
                        int size = e0Var.a.size();
                        while (true) {
                            if (i2 >= size) {
                                break;
                            } else if (e0Var.a.get(i2).a == bVar) {
                                e0Var.a.remove(i2);
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    bVar.c.p(view, bVar.b);
                } else {
                    continue;
                }
            }
        }
    }

    public void n(l lVar, boolean z) {
        l lVar2 = this.b.s;
        if (lVar2 != null) {
            lVar2.t().n.n(lVar, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.a);
            }
        }
    }
}
