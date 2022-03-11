package e.c0.a0;

import e.c0.a0.t.s.c;
import e.c0.n;
import f.b.b.f.a.u;
/* loaded from: classes.dex */
public class m implements Runnable {
    public final /* synthetic */ u b;
    public final /* synthetic */ c c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f1112d;

    public m(o oVar, u uVar, c cVar) {
        this.f1112d = oVar;
        this.b = uVar;
        this.c = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.b.get();
            n.c().a(o.u, String.format("Starting work for %s", this.f1112d.f1116f.c), new Throwable[0]);
            o oVar = this.f1112d;
            oVar.s = oVar.f1117g.d();
            this.c.l(this.f1112d.s);
        } catch (Throwable th) {
            this.c.k(th);
        }
    }
}
