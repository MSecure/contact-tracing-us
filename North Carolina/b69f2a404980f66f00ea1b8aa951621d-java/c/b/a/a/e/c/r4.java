package c.b.a.a.e.c;

import b.b.k.i;
import c.b.a.a.c.k.o.e;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections;

public final class r4 extends q7 {

    /* renamed from: a  reason: collision with root package name */
    public final e<Connections.StartAdvertisingResult> f2708a;

    public r4(e<Connections.StartAdvertisingResult> eVar) {
        i.j.s(eVar);
        this.f2708a = eVar;
    }

    @Override // c.b.a.a.e.c.r7
    public final void V(q8 q8Var) {
        Status c2 = v3.c(q8Var.f2703b);
        if (c2.p()) {
            this.f2708a.setResult(new s4(c2, q8Var.f2704c));
        } else {
            this.f2708a.setFailedResult(c2);
        }
    }
}
