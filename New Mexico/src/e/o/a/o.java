package e.o.a;

import e.a.e.c;
import e.a.e.f.a;
import e.j.a.d;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class o extends c<I> {
    public final /* synthetic */ AtomicReference a;

    public o(m mVar, AtomicReference atomicReference, a aVar) {
        this.a = atomicReference;
    }

    @Override // e.a.e.c
    public void a(I i2, d dVar) {
        c cVar = (c) this.a.get();
        if (cVar != null) {
            cVar.a(i2, dVar);
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
