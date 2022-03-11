package f.b.c.k.s;

import f.b.a.c.b.o.b;
import f.b.a.c.i.i;
import f.b.c.k.g;
import f.b.c.k.r.f;
import f.b.c.k.t.e;
import f.b.c.k.t.j;
import f.b.c.k.t.r;
import f.b.c.k.w.l0;
import f.b.c.k.x.c;
import f.b.c.k.x.m;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final /* synthetic */ class m {
    public final n a;
    public final AtomicBoolean b;
    public final i c;

    /* renamed from: d */
    public final c f3562d;

    public m(n nVar, AtomicBoolean atomicBoolean, i iVar, c cVar) {
        this.a = nVar;
        this.b = atomicBoolean;
        this.c = iVar;
        this.f3562d = cVar;
    }

    public void a(Object obj) {
        n nVar = this.a;
        AtomicBoolean atomicBoolean = this.b;
        i iVar = this.c;
        c cVar = this.f3562d;
        f fVar = (f) obj;
        if (atomicBoolean.compareAndSet(false, true)) {
            b.P0(!iVar.a.n(), "Already fulfilled first user task", new Object[0]);
            iVar.a.r(fVar);
            return;
        }
        cVar.b(new Runnable(nVar, fVar) { // from class: f.b.c.k.s.k
            public final n b;
            public final f c;

            {
                this.b = r1;
                this.c = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                n nVar2 = this.b;
                f fVar2 = this.c;
                m.a aVar = m.a.DEBUG;
                b.P0(nVar2.f3563d != null, "SyncEngine not yet initialized", new Object[0]);
                m.a(aVar, "FirestoreClient", "Credential changed. Current user: %s", fVar2.a);
                b0 b0Var = nVar2.f3563d;
                boolean z = !b0Var.m.equals(fVar2);
                b0Var.m = fVar2;
                if (z) {
                    for (Map.Entry<Integer, List<i<Void>>> entry : b0Var.f3523k.entrySet()) {
                        for (i<Void> iVar2 : entry.getValue()) {
                            iVar2.a.q(new g("'waitForPendingWrites' task is cancelled due to User change.", g.a.CANCELLED));
                        }
                    }
                    b0Var.f3523k.clear();
                    r rVar = b0Var.a;
                    List<f.b.c.k.u.p.f> h2 = rVar.b.h();
                    rVar.b = rVar.a.b(fVar2);
                    rVar.a.h("Start MutationQueue", new j(rVar));
                    List<f.b.c.k.u.p.f> h3 = rVar.b.h();
                    f.b.c.k.t.g gVar = new f.b.c.k.t.g(rVar.c, rVar.b, rVar.a.a());
                    rVar.f3608d = gVar;
                    ((e) rVar.f3609e).a = gVar;
                    f.b.c.g.a.f<f.b.c.k.u.f> fVar3 = f.b.c.k.u.f.c;
                    for (List<f.b.c.k.u.p.f> list : Arrays.asList(h2, h3)) {
                        for (f.b.c.k.u.p.f fVar4 : list) {
                            for (f.b.c.k.u.p.e eVar : fVar4.f3628d) {
                                fVar3 = fVar3.h(eVar.a);
                            }
                        }
                    }
                    b0Var.h(rVar.f3608d.a(fVar3), null);
                }
                l0 l0Var = b0Var.b;
                if (l0Var.f3659e) {
                    m.a(aVar, "RemoteStore", "Restarting streams for new credential.", new Object[0]);
                    l0Var.d();
                }
            }
        });
    }
}
