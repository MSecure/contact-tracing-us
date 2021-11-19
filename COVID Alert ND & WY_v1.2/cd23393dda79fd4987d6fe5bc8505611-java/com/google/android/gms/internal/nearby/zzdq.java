package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdq extends zzeb<EndpointDiscoveryCallback> {
    private final /* synthetic */ zzim zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdq(zzdo zzdo, zzim zzim) {
        super();
        this.zza = zzim;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        EndpointDiscoveryCallback endpointDiscoveryCallback = (EndpointDiscoveryCallback) obj;
        if (zzdo.zzc(this.zza)) {
            endpointDiscoveryCallback.onEndpointFound("__UNRECOGNIZED_BLUETOOTH_DEVICE__", new DiscoveredEndpointInfo.zza().zza(this.zza.zzb()).zza(this.zza.zzd()).zza());
        } else {
            endpointDiscoveryCallback.onEndpointFound(this.zza.zza(), new DiscoveredEndpointInfo.zza().zza(this.zza.zzb()).zzb(this.zza.zzc()).zza(this.zza.zze()).zza());
        }
    }
}
