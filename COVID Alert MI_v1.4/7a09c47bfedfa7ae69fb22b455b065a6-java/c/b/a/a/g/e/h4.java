package c.b.a.a.g.e;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

public final class h4 extends k4<EndpointDiscoveryCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j8 f3586a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h4(j8 j8Var) {
        super(null);
        this.f3586a = j8Var;
    }

    @Override // c.b.a.a.d.k.o.k.b
    public final void notifyListener(Object obj) {
        ((EndpointDiscoveryCallback) obj).onEndpointLost(this.f3586a.f3617b);
    }
}
