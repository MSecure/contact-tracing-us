package f.b.a.c.b.l.l;

import f.b.a.c.b.a;
import f.b.a.c.b.l.a;
import f.b.a.c.b.l.l.e;
import f.b.a.c.b.m.h;
/* loaded from: classes.dex */
public final class t implements Runnable {
    public final /* synthetic */ a b;
    public final /* synthetic */ e.c c;

    public t(e.c cVar, a aVar) {
        this.c = cVar;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        h hVar;
        e.c cVar = this.c;
        e.a<?> aVar2 = e.this.f2682g.get(cVar.b);
        if (aVar2 != null) {
            if (this.b.d()) {
                e.c cVar2 = this.c;
                cVar2.f2697e = true;
                if (cVar2.a.l()) {
                    e.c cVar3 = this.c;
                    if (cVar3.f2697e && (hVar = cVar3.c) != null) {
                        cVar3.a.h(hVar, cVar3.f2696d);
                        return;
                    }
                    return;
                }
                try {
                    a.e eVar = this.c.a;
                    eVar.h(null, eVar.g());
                    return;
                } catch (SecurityException unused) {
                    this.c.a.k("Failed to get service from broker.");
                    aVar = new f.b.a.c.b.a(10);
                }
            } else {
                aVar = this.b;
            }
            aVar2.d(aVar, null);
        }
    }
}
