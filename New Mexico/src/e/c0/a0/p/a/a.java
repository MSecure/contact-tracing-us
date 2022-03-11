package e.c0.a0.p.a;

import e.c0.a0.s.o;
import e.c0.n;
/* loaded from: classes.dex */
public class a implements Runnable {
    public final /* synthetic */ o b;
    public final /* synthetic */ b c;

    public a(b bVar, o oVar) {
        this.c = bVar;
        this.b = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        n.c().a(b.f1128d, String.format("Scheduling work %s", this.b.a), new Throwable[0]);
        this.c.a.d(this.b);
    }
}
