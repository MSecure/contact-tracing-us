package e.o.a;

import e.j.f.a;
import e.o.a.e0;
import e.o.a.t0;
/* loaded from: classes.dex */
public class n0 implements Runnable {
    public final /* synthetic */ t0.a b;
    public final /* synthetic */ m c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f1843d;

    public n0(t0.a aVar, m mVar, a aVar2) {
        this.b = aVar;
        this.c = mVar;
        this.f1843d = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((e0.d) this.b).a(this.c, this.f1843d);
    }
}
