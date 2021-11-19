package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdn extends zzeb<Connections.ConnectionRequestListener> {
    private final /* synthetic */ zzic zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdn(zzdk zzdk, zzic zzic) {
        super();
        this.zza = zzic;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((Connections.ConnectionRequestListener) obj).onConnectionRequest(this.zza.zza(), this.zza.zzb(), this.zza.zzc());
    }
}
