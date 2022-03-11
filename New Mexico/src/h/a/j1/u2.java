package h.a.j1;

import h.a.j1.t2;
/* loaded from: classes.dex */
public class u2 implements Runnable {
    public final /* synthetic */ t2.b b;
    public final /* synthetic */ t2.c c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f4333d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ t2 f4334e;

    public u2(t2 t2Var, t2.b bVar, t2.c cVar, Object obj) {
        this.f4334e = t2Var;
        this.b = bVar;
        this.c = cVar;
        this.f4333d = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f4334e) {
            if (this.b.b == 0) {
                this.c.b(this.f4333d);
                this.f4334e.a.remove(this.c);
                if (this.f4334e.a.isEmpty()) {
                    this.f4334e.c.shutdown();
                    this.f4334e.c = null;
                }
            }
        }
    }
}
