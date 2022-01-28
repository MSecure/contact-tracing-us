package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzed extends zzeb<PayloadCallback> {
    private final /* synthetic */ zziq zza;
    private final /* synthetic */ Payload zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzed(zzea zzea, zziq zziq, Payload payload) {
        super();
        this.zza = zziq;
        this.zzb = payload;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadReceived(this.zza.zza(), this.zzb);
    }
}
