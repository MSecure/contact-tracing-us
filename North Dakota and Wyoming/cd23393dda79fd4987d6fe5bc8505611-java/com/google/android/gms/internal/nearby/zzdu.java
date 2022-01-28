package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdu extends zzeb<Connections.EndpointDiscoveryListener> {
    private final /* synthetic */ zzim zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdu(zzdv zzdv, zzim zzim) {
        super();
        this.zza = zzim;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((Connections.EndpointDiscoveryListener) obj).onEndpointFound(this.zza.zza(), this.zza.zzb(), this.zza.zzc());
    }
}
