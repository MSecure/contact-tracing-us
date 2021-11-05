package c.b.a.a.e.c;

import com.google.android.gms.nearby.connection.PayloadCallback;

public final class o4 extends k4<PayloadCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o8 f2680a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o4(o8 o8Var) {
        super(null);
        this.f2680a = o8Var;
    }

    @Override // c.b.a.a.c.k.o.k.b
    public final void notifyListener(Object obj) {
        o8 o8Var = this.f2680a;
        ((PayloadCallback) obj).onPayloadTransferUpdate(o8Var.f2681b, o8Var.f2682c);
    }
}
