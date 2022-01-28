package c.b.a.a.d.k.o;

import c.b.a.a.d.a;
import c.b.a.a.d.k.o.g;
import c.b.a.a.d.m.h;

public final class a0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f2948b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g.c f2949c;

    public a0(g.c cVar, a aVar) {
        this.f2949c = cVar;
        this.f2948b = aVar;
    }

    public final void run() {
        a aVar;
        h hVar;
        g.c cVar = this.f2949c;
        g.a<?> aVar2 = g.this.i.get(cVar.f2993b);
        if (aVar2 != null) {
            if (this.f2948b.x()) {
                g.c cVar2 = this.f2949c;
                cVar2.f2996e = true;
                if (cVar2.f2992a.requiresSignIn()) {
                    g.c cVar3 = this.f2949c;
                    if (cVar3.f2996e && (hVar = cVar3.f2994c) != null) {
                        cVar3.f2992a.getRemoteService(hVar, cVar3.f2995d);
                        return;
                    }
                    return;
                }
                try {
                    this.f2949c.f2992a.getRemoteService(null, this.f2949c.f2992a.getScopesForConnectionlessNonSignIn());
                } catch (SecurityException unused) {
                    this.f2949c.f2992a.disconnect("Failed to get service from broker.");
                    aVar = new a(10);
                }
            } else {
                aVar = this.f2948b;
                aVar2.d(aVar, null);
            }
        }
    }
}
