package e.m.a;

import e.p.g;
import e.p.k;
import e.u.a;
import e.u.b;
import e.u.c;

public class a1 implements c {
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

    public void b(g.a aVar) {
        k kVar = this.b;
        kVar.d("handleLifecycleEvent");
        kVar.g(aVar.a());
    }

    @Override // e.u.c
    public a d() {
        return this.c.b;
    }
}
