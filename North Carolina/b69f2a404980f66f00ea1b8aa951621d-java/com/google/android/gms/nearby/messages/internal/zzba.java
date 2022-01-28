package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.c.k.o.k;
import c.b.a.a.c.k.o.m;
import c.b.a.a.g.i;

public final class zzba extends m<zzai, T> {
    public final /* synthetic */ zzbe zza;
    public final /* synthetic */ zzaj zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzba(zzaj zzaj, k kVar, zzbe zzbe) {
        super(kVar);
        this.zzb = zzaj;
        this.zza = zzbe;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.c.k.a$b, c.b.a.a.g.i] */
    @Override // c.b.a.a.c.k.o.m
    public final /* synthetic */ void registerListener(zzai zzai, i iVar) {
        this.zza.zza(zzai, this.zzb.zza(iVar));
    }
}
