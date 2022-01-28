package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.c.k.o.k;
import c.b.a.a.c.k.o.r;
import c.b.a.a.g.i;

public final class zzaz extends r<zzai, T> {
    public final /* synthetic */ zzbe zza;
    public final /* synthetic */ zzaj zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaz(zzaj zzaj, k.a aVar, zzbe zzbe) {
        super(aVar);
        this.zzb = zzaj;
        this.zza = zzbe;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.c.k.a$b, c.b.a.a.g.i] */
    @Override // c.b.a.a.c.k.o.r
    public final /* synthetic */ void unregisterListener(zzai zzai, i iVar) {
        this.zza.zza(zzai, this.zzb.zza(iVar));
    }
}
