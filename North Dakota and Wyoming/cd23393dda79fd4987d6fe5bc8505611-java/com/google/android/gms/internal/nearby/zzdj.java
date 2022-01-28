package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.zzd;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdj extends zzeb<ConnectionLifecycleCallback> {
    private final /* synthetic */ zzhy zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdj(zzdf zzdf, zzhy zzhy) {
        super();
        this.zza = zzhy;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ConnectionLifecycleCallback connectionLifecycleCallback = (ConnectionLifecycleCallback) obj;
        this.zza.zza();
        new zzd(this.zza.zzb());
    }
}
