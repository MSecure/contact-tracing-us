package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.d.k.e;
import com.google.android.gms.nearby.messages.Message;

public final class zzbl extends zzbw {
    public final /* synthetic */ Message zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbl(zzbh zzbh, e eVar, Message message) {
        super(eVar);
        this.zza = message;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.d.k.a$b] */
    @Override // c.b.a.a.d.k.o.d
    public final /* synthetic */ void doExecute(zzai zzai) {
        zzai.zza(zza(), zzag.zza(this.zza));
    }
}
