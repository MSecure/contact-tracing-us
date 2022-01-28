package e.m.a;

import e.p.h;
import e.p.m;
import e.u.a;
import e.u.b;
import e.u.c;

public class y0 implements c {
    public m b = null;
    public b c = null;

    @Override // e.p.l
    public h a() {
        if (this.b == null) {
            this.b = new m(this);
            this.c = new b(this);
        }
        return this.b;
    }

    public void b(h.a aVar) {
        m mVar = this.b;
        mVar.d("handleLifecycleEvent");
        mVar.g(aVar.a());
    }

    @Override // e.u.c
    public a d() {
        return this.c.b;
    }
}
