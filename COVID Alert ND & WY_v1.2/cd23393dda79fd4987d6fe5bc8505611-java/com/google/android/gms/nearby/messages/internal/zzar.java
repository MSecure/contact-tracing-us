package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzar implements zzbc {
    private final PendingIntent zza;

    zzar(PendingIntent pendingIntent) {
        this.zza = pendingIntent;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbc
    public final void zza(zzag zzag, ListenerHolder listenerHolder) {
        zzag.zza((PendingIntent) listenerHolder, (zzag) this.zza);
    }
}
