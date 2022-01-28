package c.b.a.a.g.e;

import android.content.Context;
import b.e.a;
import b.x.t;
import c.b.a.a.d.k.o.k;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import java.util.Map;

public final class m4 extends k7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3655a;

    /* renamed from: b  reason: collision with root package name */
    public final k<PayloadCallback> f3656b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<q4, PayloadTransferUpdate> f3657c = new a();

    public m4(Context context, k<PayloadCallback> kVar) {
        t.C(context);
        this.f3655a = context;
        t.C(kVar);
        this.f3656b = kVar;
    }

    @Override // c.b.a.a.g.e.l7
    public final synchronized void G(m8 m8Var) {
        Payload Z3 = t.Z3(this.f3655a, m8Var.f3659c);
        if (Z3 == null) {
            String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(m8Var.f3659c.f3798b));
            return;
        }
        this.f3657c.put(new q4(m8Var.f3658b, m8Var.f3659c.f3798b), new PayloadTransferUpdate.Builder().setPayloadId(m8Var.f3659c.f3798b).build());
        this.f3656b.a(new l4(m8Var, Z3));
    }

    @Override // c.b.a.a.g.e.l7
    public final synchronized void L(o8 o8Var) {
        if (o8Var.f3674c.getStatus() == 3) {
            this.f3657c.put(new q4(o8Var.f3673b, o8Var.f3674c.getPayloadId()), o8Var.f3674c);
        } else {
            this.f3657c.remove(new q4(o8Var.f3673b, o8Var.f3674c.getPayloadId()));
        }
        this.f3656b.a(new o4(o8Var));
    }
}
