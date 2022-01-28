package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.d.k.e;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;

public final class zzbm extends zzbw {
    public final /* synthetic */ Message zza;
    public final /* synthetic */ zzbu zzb;
    public final /* synthetic */ PublishOptions zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbm(zzbh zzbh, e eVar, Message message, zzbu zzbu, PublishOptions publishOptions) {
        super(eVar);
        this.zza = message;
        this.zzb = zzbu;
        this.zzc = publishOptions;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.d.k.a$b] */
    @Override // c.b.a.a.d.k.o.d
    public final /* synthetic */ void doExecute(zzai zzai) {
        zzai.zza(zza(), zzag.zza(this.zza), this.zzb, this.zzc);
    }
}
