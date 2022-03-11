package androidx.lifecycle;

import e.r.f;
import e.r.h;
import e.r.j;
import e.r.l;
import e.r.r;
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements j {
    public final f[] a;

    public CompositeGeneratedAdaptersObserver(f[] fVarArr) {
        this.a = fVarArr;
    }

    @Override // e.r.j
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
