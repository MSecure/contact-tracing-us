package androidx.lifecycle;

import e.p.e;
import e.p.g;
import e.p.h;
import e.p.j;
import e.p.p;

public class CompositeGeneratedAdaptersObserver implements h {
    public final e[] a;

    public CompositeGeneratedAdaptersObserver(e[] eVarArr) {
        this.a = eVarArr;
    }

    @Override // e.p.h
    public void d(j jVar, g.a aVar) {
        p pVar = new p();
        for (e eVar : this.a) {
            eVar.a(jVar, aVar, false, pVar);
        }
        for (e eVar2 : this.a) {
            eVar2.a(jVar, aVar, true, pVar);
        }
    }
}
