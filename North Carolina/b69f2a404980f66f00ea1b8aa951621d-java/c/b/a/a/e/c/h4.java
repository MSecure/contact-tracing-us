package c.b.a.a.e.c;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

public final class h4 extends k4<EndpointDiscoveryCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j8 f2601a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h4(j8 j8Var) {
        super(null);
        this.f2601a = j8Var;
    }

    @Override // c.b.a.a.c.k.o.k.b
    public final void notifyListener(Object obj) {
        ((EndpointDiscoveryCallback) obj).onEndpointLost(this.f2601a.f2629b);
    }
}
