package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzam implements zzbc {
    private final zzal zza;
    private final ListenerHolder zzb;
    private final zzbh zzc;
    private final SubscribeOptions zzd;

    zzam(zzal zzal, ListenerHolder listenerHolder, zzbh zzbh, SubscribeOptions subscribeOptions) {
        this.zza = zzal;
        this.zzb = listenerHolder;
        this.zzc = zzbh;
        this.zzd = subscribeOptions;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbc
    public final void zza(zzag zzag, ListenerHolder listenerHolder) {
        this.zza.zza(this.zzb, this.zzc, this.zzd, zzag, listenerHolder);
    }
}
