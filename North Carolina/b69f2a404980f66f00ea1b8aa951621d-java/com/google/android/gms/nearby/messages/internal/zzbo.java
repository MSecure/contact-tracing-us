package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.c.k.e;
import c.b.a.a.c.k.o.k;
import com.google.android.gms.nearby.messages.SubscribeOptions;

public final class zzbo extends zzbw {
    public final /* synthetic */ k zza;
    public final /* synthetic */ zzbv zzb;
    public final /* synthetic */ SubscribeOptions zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbo(zzbh zzbh, e eVar, k kVar, zzbv zzbv, SubscribeOptions subscribeOptions) {
        super(eVar);
        this.zza = kVar;
        this.zzb = zzbv;
        this.zzc = subscribeOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.c.k.a$b] */
    @Override // c.b.a.a.c.k.o.d
    public final /* synthetic */ void doExecute(zzai zzai) {
        zzai.zza(zza(), this.zza, this.zzb, this.zzc, (byte[]) null);
    }
}
