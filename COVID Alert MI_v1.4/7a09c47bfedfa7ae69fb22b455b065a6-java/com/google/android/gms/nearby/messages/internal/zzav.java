package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.d.k.o.k;

public final class zzav extends zzbf {
    public final /* synthetic */ k zza;
    public final /* synthetic */ zzaj zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzav(zzaj zzaj, k kVar, k kVar2) {
        super(kVar);
        this.zzb = zzaj;
        this.zza = kVar2;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbf, com.google.android.gms.nearby.messages.internal.zzz
    public final void zza() {
        k.a<L> aVar = this.zza.f3020c;
        if (aVar != null) {
            this.zzb.doUnregisterEventListener(aVar);
        }
        super.zza();
    }
}
