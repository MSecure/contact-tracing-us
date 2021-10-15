package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import c.b.a.a.d.k.e;
import com.google.android.gms.nearby.messages.SubscribeOptions;

public final class zzbn extends zzbw {
    public final /* synthetic */ PendingIntent zza;
    public final /* synthetic */ zzbv zzb;
    public final /* synthetic */ SubscribeOptions zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbn(zzbh zzbh, e eVar, PendingIntent pendingIntent, zzbv zzbv, SubscribeOptions subscribeOptions) {
        super(eVar);
        this.zza = pendingIntent;
        this.zzb = zzbv;
        this.zzc = subscribeOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.d.k.a$b] */
    @Override // c.b.a.a.d.k.o.d
    public final /* synthetic */ void doExecute(zzai zzai) {
        zzai.zza(zza(), this.zza, this.zzb, this.zzc);
    }
}
