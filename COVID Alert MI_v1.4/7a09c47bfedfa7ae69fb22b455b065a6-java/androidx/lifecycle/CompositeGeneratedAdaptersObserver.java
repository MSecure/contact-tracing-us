package androidx.lifecycle;

import b.o.d;
import b.o.f;
import b.o.g;
import b.o.i;
import b.o.o;

public class CompositeGeneratedAdaptersObserver implements g {

    /* renamed from: a  reason: collision with root package name */
    public final d[] f236a;

    public CompositeGeneratedAdaptersObserver(d[] dVarArr) {
        this.f236a = dVarArr;
    }

    @Override // b.o.g
    public void d(i iVar, f.a aVar) {
        o oVar = new o();
        for (d dVar : this.f236a) {
            dVar.a(iVar, aVar, false, oVar);
        }
        for (d dVar2 : this.f236a) {
            dVar2.a(iVar, aVar, true, oVar);
        }
    }
}
