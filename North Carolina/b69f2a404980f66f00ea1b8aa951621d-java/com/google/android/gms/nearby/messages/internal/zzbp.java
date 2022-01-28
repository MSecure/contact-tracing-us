package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import c.b.a.a.c.k.e;

public final class zzbp extends zzbw {
    public final /* synthetic */ PendingIntent zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbp(zzbh zzbh, e eVar, PendingIntent pendingIntent) {
        super(eVar);
        this.zza = pendingIntent;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.c.k.a$b] */
    @Override // c.b.a.a.c.k.o.d
    public final /* synthetic */ void doExecute(zzai zzai) {
        zzai.zza(zza(), this.zza);
    }
}
