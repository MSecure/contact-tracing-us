package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdt extends zzeb<EndpointDiscoveryCallback> {
    private final /* synthetic */ zzio zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdt(zzdo zzdo, zzio zzio) {
        super();
        this.zza = zzio;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((EndpointDiscoveryCallback) obj).onEndpointLost(this.zza.zza());
    }
}
