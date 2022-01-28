package f.b.c.k.w;

import f.b.c.k.w.b;
import f.b.c.k.x.m;
import h.a.c1;

public final /* synthetic */ class f implements Runnable {
    public final b.c b;
    public final c1 c;

    public f(b.c cVar, c1 c1Var) {
        this.b = cVar;
        this.c = c1Var;
    }

    public void run() {
        b.c cVar = this.b;
        c1 c1Var = this.c;
        if (c1Var.e()) {
            m.a(m.a.DEBUG, b.this.getClass().getSimpleName(), "(%x) Stream closed.", Integer.valueOf(System.identityHashCode(b.this)));
        } else {
            m.a(m.a.WARN, b.this.getClass().getSimpleName(), "(%x) Stream closed with status: %s.", Integer.valueOf(System.identityHashCode(b.this)), c1Var);
        }
        b bVar = b.this;
        f.b.a.c.b.o.b.O0(bVar.d(), "Can't handle server close on non-started stream!", new Object[0]);
        bVar.a(m0.Error, c1Var);
    }
}
