package c.b.a.a.g.e;

import b.x.t;
import c.b.a.a.d.k.o.e;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections;

public final class r4 extends q7 {

    /* renamed from: a  reason: collision with root package name */
    public final e<Connections.StartAdvertisingResult> f3702a;

    public r4(e<Connections.StartAdvertisingResult> eVar) {
        t.C(eVar);
        this.f3702a = eVar;
    }

    @Override // c.b.a.a.g.e.r7
    public final void S(q8 q8Var) {
        Status c2 = v3.c(q8Var.f3697b);
        if (c2.t()) {
            this.f3702a.setResult(new s4(c2, q8Var.f3698c));
        } else {
            this.f3702a.setFailedResult(c2);
        }
    }
}
