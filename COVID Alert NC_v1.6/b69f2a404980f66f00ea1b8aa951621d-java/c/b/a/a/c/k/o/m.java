package c.b.a.a.c.k.o;

import c.b.a.a.c.c;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.a.b;
import c.b.a.a.c.k.o.k;
import c.b.a.a.g.i;

public abstract class m<A extends a.b, L> {
    public final k<L> zajv;
    public final c[] zajw;
    public final boolean zajx;

    public m(k<L> kVar) {
        this.zajv = kVar;
        this.zajw = null;
        this.zajx = false;
    }

    public m(k<L> kVar, c[] cVarArr, boolean z) {
        this.zajv = kVar;
        this.zajw = cVarArr;
        this.zajx = z;
    }

    public void clearListener() {
        k<L> kVar = this.zajv;
        kVar.f2376b = null;
        kVar.f2377c = null;
    }

    public k.a<L> getListenerKey() {
        return this.zajv.f2377c;
    }

    public c[] getRequiredFeatures() {
        return this.zajw;
    }

    public abstract void registerListener(A a2, i<Void> iVar);

    public final boolean shouldAutoResolveMissingFeatures() {
        return this.zajx;
    }
}
