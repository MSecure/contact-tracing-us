package c.b.a.a.d.k.o;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import c.b.a.a.d.c;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.a.b;
import c.b.a.a.d.k.o.k;
import c.b.a.a.j.j;

public abstract class m<A extends a.b, L> {
    public final k<L> zaa;
    public final c[] zab;
    public final boolean zac;

    public m(@RecentlyNonNull k<L> kVar) {
        this.zaa = kVar;
        this.zab = null;
        this.zac = false;
    }

    public m(@RecentlyNonNull k<L> kVar, @RecentlyNonNull c[] cVarArr, @RecentlyNonNull boolean z) {
        this.zaa = kVar;
        this.zab = cVarArr;
        this.zac = z;
    }

    public void clearListener() {
        k<L> kVar = this.zaa;
        kVar.f3019b = null;
        kVar.f3020c = null;
    }

    @RecentlyNullable
    public k.a<L> getListenerKey() {
        return this.zaa.f3020c;
    }

    @RecentlyNullable
    public c[] getRequiredFeatures() {
        return this.zab;
    }

    public abstract void registerListener(@RecentlyNonNull A a2, @RecentlyNonNull j<Void> jVar);

    @RecentlyNonNull
    public final boolean zaa() {
        return this.zac;
    }
}
