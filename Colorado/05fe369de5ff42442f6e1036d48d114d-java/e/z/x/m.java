package e.z.x;

import e.z.l;
import e.z.x.t.p.c;

public class m implements Runnable {
    public final /* synthetic */ c b;
    public final /* synthetic */ o c;

    public m(o oVar, c cVar) {
        this.c = oVar;
        this.b = cVar;
    }

    public void run() {
        try {
            l.c().a(o.u, String.format("Starting work for %s", this.c.f1913f.c), new Throwable[0]);
            o oVar = this.c;
            oVar.s = oVar.f1914g.d();
            this.b.l(this.c.s);
        } catch (Throwable th) {
            this.b.k(th);
        }
    }
}
