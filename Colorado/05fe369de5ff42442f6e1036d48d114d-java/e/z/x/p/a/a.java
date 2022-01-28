package e.z.x.p.a;

import e.z.l;
import e.z.x.s.o;

public class a implements Runnable {
    public final /* synthetic */ o b;
    public final /* synthetic */ b c;

    public a(b bVar, o oVar) {
        this.c = bVar;
        this.b = oVar;
    }

    public void run() {
        l.c().a(b.f1925d, String.format("Scheduling work %s", this.b.a), new Throwable[0]);
        this.c.a.d(this.b);
    }
}
