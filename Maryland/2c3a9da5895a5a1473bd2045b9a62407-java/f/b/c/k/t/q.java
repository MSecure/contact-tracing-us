package f.b.c.k.t;

import f.b.a.c.b.o.b;
import f.b.c.g.a.f;
import f.b.c.k.u.f;
import java.util.Iterator;

public final /* synthetic */ class q implements Runnable {
    public final r b;
    public final int c;

    public q(r rVar, int i2) {
        this.b = rVar;
        this.c = i2;
    }

    public void run() {
        r rVar = this.b;
        int i2 = this.c;
        d1 d1Var = rVar.f3199h.get(i2);
        b.b1(d1Var != null, "Tried to release nonexistent target: %s", Integer.valueOf(i2));
        Iterator<f> it = rVar.f3197f.g(i2).iterator();
        while (true) {
            f.a aVar = (f.a) it;
            if (aVar.hasNext()) {
                rVar.a.c().i((f.b.c.k.u.f) aVar.next());
            } else {
                rVar.a.c().f(d1Var);
                rVar.f3199h.remove(i2);
                rVar.f3200i.remove(d1Var.a);
                return;
            }
        }
    }
}
