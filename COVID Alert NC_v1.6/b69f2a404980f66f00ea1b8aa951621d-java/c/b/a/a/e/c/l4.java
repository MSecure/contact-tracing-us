package c.b.a.a.e.c;

import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;

public final class l4 extends k4<PayloadCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m8 f2649a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Payload f2650b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l4(m8 m8Var, Payload payload) {
        super(null);
        this.f2649a = m8Var;
        this.f2650b = payload;
    }

    @Override // c.b.a.a.c.k.o.k.b
    public final void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadReceived(this.f2649a.f2666b, this.f2650b);
    }
}
