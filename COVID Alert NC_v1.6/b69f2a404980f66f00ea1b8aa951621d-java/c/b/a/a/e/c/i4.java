package c.b.a.a.e.c;

import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

public final class i4 extends k4<EndpointDiscoveryCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h8 f2618a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i4(h8 h8Var) {
        super(null);
        this.f2618a = h8Var;
    }

    @Override // c.b.a.a.c.k.o.k.b
    public final void notifyListener(Object obj) {
        EndpointDiscoveryCallback endpointDiscoveryCallback = (EndpointDiscoveryCallback) obj;
        if (g4.c(this.f2618a)) {
            endpointDiscoveryCallback.onEndpointFound("__UNRECOGNIZED_BLUETOOTH_DEVICE__", new DiscoveredEndpointInfo.zza().zza(this.f2618a.f2605c).zza(this.f2618a.f2607e).zza());
        } else {
            endpointDiscoveryCallback.onEndpointFound(this.f2618a.f2604b, new DiscoveredEndpointInfo.zza().zza(this.f2618a.f2605c).zzb(this.f2618a.f2606d).zza(this.f2618a.f).zza());
        }
    }
}
