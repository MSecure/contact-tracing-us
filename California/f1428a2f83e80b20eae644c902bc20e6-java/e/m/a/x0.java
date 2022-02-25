package e.m.a;

import e.p.g;
import e.p.k;
import e.u.a;
import e.u.b;
import e.u.c;

public class x0 implements c {
    public k b = null;
    public b c = null;

    @Override // e.p.j
    public g a() {
        if (this.b == null) {
            this.b = new k(this);
            this.c = new b(this);
        }
        return this.b;
    }

    @Override // e.u.c
    public a c() {
        return this.c.b;
    }

    public void d(g.a aVar) {
        k kVar = this.b;
        kVar.d("handleLifecycleEvent");
        kVar.g(aVar.a());
    }
}
