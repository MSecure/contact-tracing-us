package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzdh extends zzeb<ConnectionLifecycleCallback> {
    private final /* synthetic */ zzig zza;
    private final /* synthetic */ Status zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdh(zzdf zzdf, zzig zzig, Status status) {
        super();
        this.zza = zzig;
        this.zzb = status;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onConnectionResult(this.zza.zza(), new ConnectionResolution(this.zzb));
    }
}
