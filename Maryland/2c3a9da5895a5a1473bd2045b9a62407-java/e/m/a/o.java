package e.m.a;

import e.a.e.c;
import e.a.e.f.a;
import java.util.concurrent.atomic.AtomicReference;

public class o extends c<I> {
    public final /* synthetic */ AtomicReference a;

    public o(l lVar, AtomicReference atomicReference, a aVar) {
        this.a = atomicReference;
    }

    @Override // e.a.e.c
    public void a(I i2, e.i.a.c cVar) {
        c cVar2 = (c) this.a.get();
        if (cVar2 != null) {
            cVar2.a(i2, cVar);
            return;
        }
        throw new IllegalStateException("Operation cannot be started before fragment is in created state");
    }

    @Override // e.a.e.c
    public void b() {
        c cVar = (c) this.a.getAndSet(null);
        if (cVar != null) {
            cVar.b();
        }
    }
}
