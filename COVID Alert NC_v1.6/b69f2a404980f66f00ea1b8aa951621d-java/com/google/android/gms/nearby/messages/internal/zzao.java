package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.c.k.o.k;
import com.google.android.gms.nearby.messages.SubscribeOptions;

public final /* synthetic */ class zzao implements zzbe {
    public final zzaj zza;
    public final k zzb;
    public final zzbf zzc;
    public final SubscribeOptions zzd;

    public zzao(zzaj zzaj, k kVar, zzbf zzbf, SubscribeOptions subscribeOptions) {
        this.zza = zzaj;
        this.zzb = kVar;
        this.zzc = zzbf;
        this.zzd = subscribeOptions;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbe
    public final void zza(zzai zzai, k kVar) {
        this.zza.zza(this.zzb, this.zzc, this.zzd, zzai, kVar);
    }
}
