package c.b.a.a.j;

import b.x.t;

public final class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f4134b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f4135c;

    public s(t tVar, i iVar) {
        this.f4135c = tVar;
        this.f4134b = iVar;
    }

    public final void run() {
        synchronized (this.f4135c.f4137b) {
            if (this.f4135c.f4138c != null) {
                e eVar = this.f4135c.f4138c;
                Exception e2 = this.f4134b.e();
                t.C(e2);
                eVar.c(e2);
            }
        }
    }
}
