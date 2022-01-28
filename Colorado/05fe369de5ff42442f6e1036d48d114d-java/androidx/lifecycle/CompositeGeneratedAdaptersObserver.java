package androidx.lifecycle;

import e.p.f;
import e.p.h;
import e.p.j;
import e.p.l;
import e.p.r;

public class CompositeGeneratedAdaptersObserver implements j {
    public final f[] a;

    public CompositeGeneratedAdaptersObserver(f[] fVarArr) {
        this.a = fVarArr;
    }

    @Override // e.p.j
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
