package e.m.a;

import e.e.a;
import e.m.a.c1;

public class h implements Runnable {
    public final /* synthetic */ c1.d b;
    public final /* synthetic */ c1.d c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f1614d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1615e;

    public h(d dVar, c1.d dVar2, c1.d dVar3, boolean z, a aVar) {
        this.b = dVar2;
        this.c = dVar3;
        this.f1614d = z;
        this.f1615e = aVar;
    }

    public void run() {
        v0.c(this.b.c, this.c.c, this.f1614d, this.f1615e, false);
    }
}
