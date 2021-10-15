package c.b.a.a.g.e;

import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

public final class n4 extends k4<PayloadCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3666a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PayloadTransferUpdate f3667b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n4(String str, PayloadTransferUpdate payloadTransferUpdate) {
        super(null);
        this.f3666a = str;
        this.f3667b = payloadTransferUpdate;
    }

    @Override // c.b.a.a.d.k.o.k.b
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadTransferUpdate(this.f3666a, new PayloadTransferUpdate.Builder(this.f3667b).setStatus(2).build());
    }
}
