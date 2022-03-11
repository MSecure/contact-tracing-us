package f.b.a.a.a.t;

import e.g.a.b;
import e.g.a.d;
import f.b.a.c.i.h;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public final /* synthetic */ class r implements d {
    public final /* synthetic */ h a;
    public final /* synthetic */ ScheduledExecutorService b;

    public /* synthetic */ r(h hVar, ScheduledExecutorService scheduledExecutorService) {
        this.a = hVar;
        this.b = scheduledExecutorService;
    }

    @Override // e.g.a.d
    public final Object a(b bVar) {
        this.a.c(this.b, new f.b.a.c.i.d() { // from class: f.b.a.a.a.t.q
            @Override // f.b.a.c.i.d
            public final void a(h hVar) {
                b bVar2 = b.this;
                try {
                    if (hVar.m()) {
                        bVar2.b();
                    } else if (hVar.k() != null) {
                        bVar2.d(hVar.k());
                    } else {
                        bVar2.a(hVar.l());
                    }
                } catch (Exception e2) {
                    while (true) {
                        bVar2.d(e2);
                        return;
                    }
                }
            }
        });
        return "GmsCoreTask";
    }
}
