package c.b.a.a.g.e;

import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;

public final class l4 extends k4<PayloadCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m8 f3639a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Payload f3640b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l4(m8 m8Var, Payload payload) {
        super(null);
        this.f3639a = m8Var;
        this.f3640b = payload;
    }

    @Override // c.b.a.a.d.k.o.k.b
    public final void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadReceived(this.f3639a.f3658b, this.f3640b);
    }
}
