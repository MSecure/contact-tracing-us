package f.b.a.b.i.s;

import f.b.a.a.a.z.l;
import f.b.a.b.i.f;
import f.b.a.b.i.i;
import f.b.a.b.i.p.m;
import java.util.logging.Logger;

public final /* synthetic */ class a implements Runnable {
    public final c b;
    public final i c;

    /* renamed from: d  reason: collision with root package name */
    public final l f2592d;

    /* renamed from: e  reason: collision with root package name */
    public final f f2593e;

    public a(c cVar, i iVar, l lVar, f fVar) {
        this.b = cVar;
        this.c = iVar;
        this.f2592d = lVar;
        this.f2593e = fVar;
    }

    public void run() {
        c cVar = this.b;
        i iVar = this.c;
        l lVar = this.f2592d;
        f fVar = this.f2593e;
        Logger logger = c.f2594f;
        try {
            m a = cVar.c.a(iVar.b());
            if (a == null) {
                String format = String.format("Transport backend '%s' is not registered", iVar.b());
                c.f2594f.warning(format);
                lVar.a.d(new IllegalArgumentException(format));
                return;
            }
            cVar.f2596e.c(new b(cVar, iVar, a.a(fVar)));
            lVar.a(null);
        } catch (Exception e2) {
            Logger logger2 = c.f2594f;
            StringBuilder h2 = f.a.a.a.a.h("Error scheduling event ");
            h2.append(e2.getMessage());
            logger2.warning(h2.toString());
            lVar.a.d(e2);
        }
    }
}
