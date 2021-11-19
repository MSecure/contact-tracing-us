package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.DistanceInfo;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdr extends zzeb<EndpointDiscoveryCallback> {
    private final /* synthetic */ zzik zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdr(zzdo zzdo, zzik zzik) {
        super();
        this.zza = zzik;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((EndpointDiscoveryCallback) obj).onEndpointDistanceChanged(this.zza.zza(), new DistanceInfo(this.zza.zzb(), this.zza.zzc()));
    }
}
