package e.b0.a0;

import e.b0.a0.t.s.c;
import e.b0.n;
import f.b.b.f.a.u;

public class m implements Runnable {
    public final /* synthetic */ u b;
    public final /* synthetic */ c c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f1033d;

    public m(o oVar, u uVar, c cVar) {
        this.f1033d = oVar;
        this.b = uVar;
        this.c = cVar;
    }

    public void run() {
        try {
            this.b.get();
            n.c().a(o.u, String.format("Starting work for %s", this.f1033d.f1037f.c), new Throwable[0]);
            o oVar = this.f1033d;
            oVar.s = oVar.f1038g.d();
            this.c.l(this.f1033d.s);
        } catch (Throwable th) {
            this.c.k(th);
        }
    }
}
