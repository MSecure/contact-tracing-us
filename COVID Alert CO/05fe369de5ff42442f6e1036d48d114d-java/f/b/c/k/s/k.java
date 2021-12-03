package f.b.c.k.s;

import f.b.a.c.b.o.b;
import f.b.a.c.i.i;
import f.b.c.k.g;
import f.b.c.k.r.f;
import f.b.c.k.t.e;
import f.b.c.k.t.j;
import f.b.c.k.t.r;
import f.b.c.k.w.l0;
import f.b.c.k.x.m;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final /* synthetic */ class k implements Runnable {
    public final n b;
    public final f c;

    public k(n nVar, f fVar) {
        this.b = nVar;
        this.c = fVar;
    }

    public void run() {
        n nVar = this.b;
        f fVar = this.c;
        m.a aVar = m.a.DEBUG;
        b.M0(nVar.f3245d != null, "SyncEngine not yet initialized", new Object[0]);
        m.a(aVar, "FirestoreClient", "Credential changed. Current user: %s", fVar.a);
        b0 b0Var = nVar.f3245d;
        boolean z = !b0Var.m.equals(fVar);
        b0Var.m = fVar;
        if (z) {
            for (Map.Entry<Integer, List<i<Void>>> entry : b0Var.f3205k.entrySet()) {
                for (i<Void> iVar : entry.getValue()) {
                    iVar.a.q(new g("'waitForPendingWrites' task is cancelled due to User change.", g.a.CANCELLED));
                }
            }
            b0Var.f3205k.clear();
            r rVar = b0Var.a;
            List<f.b.c.k.u.p.f> h2 = rVar.b.h();
            rVar.b = rVar.a.b(fVar);
            rVar.a.h("Start MutationQueue", new j(rVar));
            List<f.b.c.k.u.p.f> h3 = rVar.b.h();
            f.b.c.k.t.g gVar = new f.b.c.k.t.g(rVar.c, rVar.b, rVar.a.a());
            rVar.f3290d = gVar;
            ((e) rVar.f3291e).a = gVar;
            f.b.c.g.a.f<f.b.c.k.u.f> fVar2 = f.b.c.k.u.f.c;
            for (List<f.b.c.k.u.p.f> list : Arrays.asList(h2, h3)) {
                for (f.b.c.k.u.p.f fVar3 : list) {
                    for (f.b.c.k.u.p.e eVar : fVar3.f3310d) {
                        fVar2 = fVar2.h(eVar.a);
                    }
                }
            }
            b0Var.h(rVar.f3290d.a(fVar2), null);
        }
        l0 l0Var = b0Var.b;
        if (l0Var.f3341e) {
            m.a(aVar, "RemoteStore", "Restarting streams for new credential.", new Object[0]);
            l0Var.d();
        }
    }
}
