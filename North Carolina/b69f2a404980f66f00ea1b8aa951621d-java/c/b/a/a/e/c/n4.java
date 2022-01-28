package c.b.a.a.e.c;

import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

public final class n4 extends k4<PayloadCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2674a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PayloadTransferUpdate f2675b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n4(String str, PayloadTransferUpdate payloadTransferUpdate) {
        super(null);
        this.f2674a = str;
        this.f2675b = payloadTransferUpdate;
    }

    @Override // c.b.a.a.c.k.o.k.b
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadTransferUpdate(this.f2674a, new PayloadTransferUpdate.Builder(this.f2675b).setStatus(2).build());
    }
}
