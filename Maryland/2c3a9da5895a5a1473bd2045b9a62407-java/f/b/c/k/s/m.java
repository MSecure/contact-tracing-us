package f.b.c.k.s;

import f.b.a.c.b.o.b;
import f.b.a.c.i.i;
import f.b.c.k.r.f;
import f.b.c.k.x.c;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class m {
    public final n a;
    public final AtomicBoolean b;
    public final i c;

    /* renamed from: d  reason: collision with root package name */
    public final c f3149d;

    public m(n nVar, AtomicBoolean atomicBoolean, i iVar, c cVar) {
        this.a = nVar;
        this.b = atomicBoolean;
        this.c = iVar;
        this.f3149d = cVar;
    }

    public void a(Object obj) {
        n nVar = this.a;
        AtomicBoolean atomicBoolean = this.b;
        i iVar = this.c;
        c cVar = this.f3149d;
        f fVar = (f) obj;
        if (atomicBoolean.compareAndSet(false, true)) {
            b.b1(!iVar.a.m(), "Already fulfilled first user task", new Object[0]);
            iVar.a.q(fVar);
            return;
        }
        cVar.b(new k(nVar, fVar));
    }
}
