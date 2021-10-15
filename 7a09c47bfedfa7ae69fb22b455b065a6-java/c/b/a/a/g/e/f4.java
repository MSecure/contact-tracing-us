package c.b.a.a.g.e;

import com.google.android.gms.nearby.connection.DistanceInfo;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

public final class f4 extends k4<EndpointDiscoveryCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f8 f3556a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f4(f8 f8Var) {
        super(null);
        this.f3556a = f8Var;
    }

    @Override // c.b.a.a.d.k.o.k.b
    public final void notifyListener(Object obj) {
        f8 f8Var = this.f3556a;
        ((EndpointDiscoveryCallback) obj).onEndpointDistanceChanged(f8Var.f3563b, new DistanceInfo(f8Var.f3564c, f8Var.f3565d));
    }
}
