package e.m.a;

import e.e.a;
import e.m.a.z0;

public class h implements Runnable {
    public final /* synthetic */ z0.d b;
    public final /* synthetic */ z0.d c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f1600d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1601e;

    public h(d dVar, z0.d dVar2, z0.d dVar3, boolean z, a aVar) {
        this.b = dVar2;
        this.c = dVar3;
        this.f1600d = z;
        this.f1601e = aVar;
    }

    public void run() {
        s0.c(this.b.c, this.c.c, this.f1600d, this.f1601e, false);
    }
}
