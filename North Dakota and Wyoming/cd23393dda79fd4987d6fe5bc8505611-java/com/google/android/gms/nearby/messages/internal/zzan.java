package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.Message;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzan implements zzbc {
    private final Message zza;

    zzan(Message message) {
        this.zza = message;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbc
    public final void zza(zzag zzag, ListenerHolder listenerHolder) {
        zzag.zza((Message) listenerHolder, (zzag) zzae.zza(this.zza));
    }
}
