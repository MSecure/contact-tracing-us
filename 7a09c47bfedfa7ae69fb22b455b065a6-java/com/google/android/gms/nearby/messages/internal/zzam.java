package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.d.k.o.k;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;

public final /* synthetic */ class zzam implements zzbe {
    public final zzaj zza;
    public final Message zzb;
    public final zzbd zzc;
    public final PublishOptions zzd;

    public zzam(zzaj zzaj, Message message, zzbd zzbd, PublishOptions publishOptions) {
        this.zza = zzaj;
        this.zzb = message;
        this.zzc = zzbd;
        this.zzd = publishOptions;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbe
    public final void zza(zzai zzai, k kVar) {
        this.zza.zza(this.zzb, this.zzc, this.zzd, zzai, kVar);
    }
}
