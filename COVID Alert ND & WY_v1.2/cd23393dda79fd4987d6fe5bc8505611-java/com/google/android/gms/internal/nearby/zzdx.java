package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdx extends zzeb<Connections.EndpointDiscoveryListener> {
    private final /* synthetic */ zzio zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdx(zzdv zzdv, zzio zzio) {
        super();
        this.zza = zzio;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((Connections.EndpointDiscoveryListener) obj).onEndpointLost(this.zza.zza());
    }
}
