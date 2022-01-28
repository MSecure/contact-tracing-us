package c.b.a.a.c.k.o;

import c.b.a.a.c.a;
import c.b.a.a.c.k.o.g;
import c.b.a.a.c.l.j;

public final class e0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f2330b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g.c f2331c;

    public e0(g.c cVar, a aVar) {
        this.f2331c = cVar;
        this.f2330b = aVar;
    }

    public final void run() {
        a aVar;
        j jVar;
        g.c cVar = this.f2331c;
        g.a<?> aVar2 = g.this.i.get(cVar.f2349b);
        if (aVar2 != null) {
            if (this.f2330b.q()) {
                g.c cVar2 = this.f2331c;
                cVar2.f2352e = true;
                if (cVar2.f2348a.requiresSignIn()) {
                    g.c cVar3 = this.f2331c;
                    if (cVar3.f2352e && (jVar = cVar3.f2350c) != null) {
                        cVar3.f2348a.getRemoteService(jVar, cVar3.f2351d);
                        return;
                    }
                    return;
                }
                try {
                    this.f2331c.f2348a.getRemoteService(null, this.f2331c.f2348a.getScopesForConnectionlessNonSignIn());
                } catch (SecurityException unused) {
                    aVar = new a(10);
                }
            } else {
                aVar = this.f2330b;
                aVar2.g(aVar, null);
            }
        }
    }
}
