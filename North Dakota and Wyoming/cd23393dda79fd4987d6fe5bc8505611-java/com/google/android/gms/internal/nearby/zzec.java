package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.PayloadCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzec extends zzeb<PayloadCallback> {
    private final /* synthetic */ zzis zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzec(zzea zzea, zzis zzis) {
        super();
        this.zza = zzis;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadTransferUpdate(this.zza.zza(), this.zza.zzb());
    }
}
