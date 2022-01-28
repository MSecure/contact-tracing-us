package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdp extends zzeb<Connections.ConnectionResponseCallback> {
    private final /* synthetic */ zzie zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdp(zzdm zzdm, zzie zzie) {
        super();
        this.zza = zzie;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((Connections.ConnectionResponseCallback) obj).onConnectionResponse(this.zza.zza(), zzdd.zzb(this.zza.zzb()), this.zza.zzc());
    }
}
