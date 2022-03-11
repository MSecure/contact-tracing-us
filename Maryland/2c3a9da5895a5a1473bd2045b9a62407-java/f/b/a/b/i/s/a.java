package f.b.a.b.i.s;

import f.b.a.a.a.o.d;
import f.b.a.b.i.f;
import f.b.a.b.i.i;
import f.b.a.b.i.p.m;
import java.util.logging.Logger;

public final /* synthetic */ class a implements Runnable {
    public final c b;
    public final i c;

    /* renamed from: d  reason: collision with root package name */
    public final d f2449d;

    /* renamed from: e  reason: collision with root package name */
    public final f f2450e;

    public a(c cVar, i iVar, d dVar, f fVar) {
        this.b = cVar;
        this.c = iVar;
        this.f2449d = dVar;
        this.f2450e = fVar;
    }

    public void run() {
        c cVar = this.b;
        i iVar = this.c;
        d dVar = this.f2449d;
        f fVar = this.f2450e;
        Logger logger = c.f2451f;
        try {
            m a = cVar.c.a(iVar.b());
            if (a == null) {
                String format = String.format("Transport backend '%s' is not registered", iVar.b());
                c.f2451f.warning(format);
                dVar.a.c(new IllegalArgumentException(format));
                return;
            }
            cVar.f2453e.c(new b(cVar, iVar, a.a(fVar)));
            dVar.a(null);
        } catch (Exception e2) {
            Logger logger2 = c.f2451f;
            StringBuilder h2 = f.a.a.a.a.h("Error scheduling event ");
            h2.append(e2.getMessage());
            logger2.warning(h2.toString());
            dVar.a.c(e2);
        }
    }
}
