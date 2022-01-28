package c.b.a.a.e.c;

import android.content.Context;
import b.b.k.i;
import b.e.a;
import c.b.a.a.c.k.o.k;
import c.b.a.a.c.n.c;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import java.util.Map;

public final class m4 extends k7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2663a;

    /* renamed from: b  reason: collision with root package name */
    public final k<PayloadCallback> f2664b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<q4, PayloadTransferUpdate> f2665c = new a();

    public m4(Context context, k<PayloadCallback> kVar) {
        i.j.s(context);
        this.f2663a = context;
        i.j.s(kVar);
        this.f2664b = kVar;
    }

    @Override // c.b.a.a.e.c.l7
    public final synchronized void J(m8 m8Var) {
        Payload H2 = c.H2(this.f2663a, m8Var.f2667c);
        if (H2 == null) {
            String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(m8Var.f2667c.f2793b));
            return;
        }
        this.f2665c.put(new q4(m8Var.f2666b, m8Var.f2667c.f2793b), new PayloadTransferUpdate.Builder().setPayloadId(m8Var.f2667c.f2793b).build());
        this.f2664b.a(new l4(m8Var, H2));
    }

    @Override // c.b.a.a.e.c.l7
    public final synchronized void O(o8 o8Var) {
        if (o8Var.f2682c.getStatus() == 3) {
            this.f2665c.put(new q4(o8Var.f2681b, o8Var.f2682c.getPayloadId()), o8Var.f2682c);
        } else {
            this.f2665c.remove(new q4(o8Var.f2681b, o8Var.f2682c.getPayloadId()));
        }
        this.f2664b.a(new o4(o8Var));
    }
}
