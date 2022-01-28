package androidx.lifecycle;

import b.n.d;
import b.n.f;
import b.n.g;
import b.n.i;
import b.n.o;

public class CompositeGeneratedAdaptersObserver implements g {

    /* renamed from: a  reason: collision with root package name */
    public final d[] f157a;

    public CompositeGeneratedAdaptersObserver(d[] dVarArr) {
        this.f157a = dVarArr;
    }

    @Override // b.n.g
    public void d(i iVar, f.a aVar) {
        o oVar = new o();
        for (d dVar : this.f157a) {
            dVar.a(iVar, aVar, false, oVar);
        }
        for (d dVar2 : this.f157a) {
            dVar2.a(iVar, aVar, true, oVar);
        }
    }
}
