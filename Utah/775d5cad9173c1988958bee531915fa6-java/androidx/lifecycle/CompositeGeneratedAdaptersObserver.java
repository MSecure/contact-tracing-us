package androidx.lifecycle;

import e.q.f;
import e.q.h;
import e.q.j;
import e.q.l;
import e.q.r;

public class CompositeGeneratedAdaptersObserver implements j {
    public final f[] a;

    public CompositeGeneratedAdaptersObserver(f[] fVarArr) {
        this.a = fVarArr;
    }

    @Override // e.q.j
    public void d(l lVar, h.a aVar) {
        r rVar = new r();
        for (f fVar : this.a) {
            fVar.a(lVar, aVar, false, rVar);
        }
        for (f fVar2 : this.a) {
            fVar2.a(lVar, aVar, true, rVar);
        }
    }
}
