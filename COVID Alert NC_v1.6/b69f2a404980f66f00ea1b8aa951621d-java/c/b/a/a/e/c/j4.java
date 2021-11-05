package c.b.a.a.e.c;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

public final class j4 extends k4<EndpointDiscoveryCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2627a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j4(String str) {
        super(null);
        this.f2627a = str;
    }

    @Override // c.b.a.a.c.k.o.k.b
    public final /* synthetic */ void notifyListener(Object obj) {
        ((EndpointDiscoveryCallback) obj).onEndpointLost(this.f2627a);
    }
}
