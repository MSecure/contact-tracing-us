package f.b.a.c.b.l.l;

import f.b.a.c.b.a;
import f.b.a.c.b.l.a;
import f.b.a.c.b.l.l.e;
import f.b.a.c.b.m.h;

public final class t implements Runnable {
    public final /* synthetic */ a b;
    public final /* synthetic */ e.c c;

    public t(e.c cVar, a aVar) {
        this.c = cVar;
        this.b = aVar;
    }

    public final void run() {
        a aVar;
        h hVar;
        e.c cVar = this.c;
        e.a<?> aVar2 = e.this.f2587g.get(cVar.b);
        if (aVar2 != null) {
            if (this.b.d()) {
                e.c cVar2 = this.c;
                cVar2.f2602e = true;
                if (cVar2.a.l()) {
                    e.c cVar3 = this.c;
                    if (cVar3.f2602e && (hVar = cVar3.c) != null) {
                        cVar3.a.h(hVar, cVar3.f2601d);
                        return;
                    }
                    return;
                }
                try {
                    a.e eVar = this.c.a;
                    eVar.h(null, eVar.g());
                } catch (SecurityException unused) {
                    this.c.a.k("Failed to get service from broker.");
                    aVar = new f.b.a.c.b.a(10);
                }
            } else {
                aVar = this.b;
                aVar2.d(aVar, null);
            }
        }
    }
}
