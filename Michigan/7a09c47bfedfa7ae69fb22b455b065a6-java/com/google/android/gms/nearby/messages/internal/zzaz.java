package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.d.k.o.k;
import c.b.a.a.d.k.o.s;
import c.b.a.a.j.j;

public final class zzaz extends s<zzai, T> {
    public final /* synthetic */ zzbe zza;
    public final /* synthetic */ zzaj zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaz(zzaj zzaj, k.a aVar, zzbe zzbe) {
        super(aVar);
        this.zzb = zzaj;
        this.zza = zzbe;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.d.k.a$b, c.b.a.a.j.j] */
    @Override // c.b.a.a.d.k.o.s
    public final /* synthetic */ void unregisterListener(zzai zzai, j jVar) {
        this.zza.zza(zzai, this.zzb.zza(jVar));
    }
}
