package c.b.a.a.g.e;

import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

public final class i4 extends k4<EndpointDiscoveryCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h8 f3606a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i4(h8 h8Var) {
        super(null);
        this.f3606a = h8Var;
    }

    @Override // c.b.a.a.d.k.o.k.b
    public final void notifyListener(Object obj) {
        EndpointDiscoveryCallback endpointDiscoveryCallback = (EndpointDiscoveryCallback) obj;
        if (g4.e0(this.f3606a)) {
            endpointDiscoveryCallback.onEndpointFound("__UNRECOGNIZED_BLUETOOTH_DEVICE__", new DiscoveredEndpointInfo.zza().zza(this.f3606a.f3590c).zza(this.f3606a.f3592e).zza());
        } else {
            endpointDiscoveryCallback.onEndpointFound(this.f3606a.f3589b, new DiscoveredEndpointInfo.zza().zza(this.f3606a.f3590c).zzb(this.f3606a.f3591d).zza(this.f3606a.f3593f).zza());
        }
    }
}
