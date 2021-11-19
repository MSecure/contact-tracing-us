package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzak implements zzbc {
    private final zzal zza;
    private final Message zzb;
    private final zzbf zzc;
    private final PublishOptions zzd;

    zzak(zzal zzal, Message message, zzbf zzbf, PublishOptions publishOptions) {
        this.zza = zzal;
        this.zzb = message;
        this.zzc = zzbf;
        this.zzd = publishOptions;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbc
    public final void zza(zzag zzag, ListenerHolder listenerHolder) {
        this.zza.zza(this.zzb, this.zzc, this.zzd, zzag, listenerHolder);
    }
}
