package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzef extends zzeb<PayloadCallback> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ PayloadTransferUpdate zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzef(zzea zzea, String str, PayloadTransferUpdate payloadTransferUpdate) {
        super();
        this.zza = str;
        this.zzb = payloadTransferUpdate;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadTransferUpdate(this.zza, new PayloadTransferUpdate.Builder(this.zzb).setStatus(2).build());
    }
}
