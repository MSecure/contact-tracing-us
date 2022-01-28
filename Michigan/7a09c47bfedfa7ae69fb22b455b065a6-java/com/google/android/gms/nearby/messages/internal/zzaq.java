package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import c.b.a.a.d.k.o.k;
import com.google.android.gms.nearby.messages.SubscribeOptions;

public final /* synthetic */ class zzaq implements zzbe {
    public final zzaj zza;
    public final PendingIntent zzb;
    public final zzbf zzc;
    public final SubscribeOptions zzd;

    public zzaq(zzaj zzaj, PendingIntent pendingIntent, zzbf zzbf, SubscribeOptions subscribeOptions) {
        this.zza = zzaj;
        this.zzb = pendingIntent;
        this.zzc = zzbf;
        this.zzd = subscribeOptions;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbe
    public final void zza(zzai zzai, k kVar) {
        this.zza.zza(this.zzb, this.zzc, this.zzd, zzai, kVar);
    }
}
