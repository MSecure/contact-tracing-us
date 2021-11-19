package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzde extends zzeb<ConnectionLifecycleCallback> {
    private final /* synthetic */ zzia zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzde(zzdf zzdf, zzia zzia) {
        super();
        this.zza = zzia;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onConnectionInitiated(this.zza.zza(), new ConnectionInfo.zza().zza(this.zza.zzb()).zzb(this.zza.zzc()).zza(this.zza.zze()).zza(this.zza.zzd()).zzb(this.zza.zzf()).zzb(this.zza.zzg()).zza());
    }
}
