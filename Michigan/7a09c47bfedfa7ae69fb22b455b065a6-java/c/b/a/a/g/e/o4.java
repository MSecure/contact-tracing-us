package c.b.a.a.g.e;

import com.google.android.gms.nearby.connection.PayloadCallback;

public final class o4 extends k4<PayloadCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o8 f3672a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o4(o8 o8Var) {
        super(null);
        this.f3672a = o8Var;
    }

    @Override // c.b.a.a.d.k.o.k.b
    public final void notifyListener(Object obj) {
        o8 o8Var = this.f3672a;
        ((PayloadCallback) obj).onPayloadTransferUpdate(o8Var.f3673b, o8Var.f3674c);
    }
}
