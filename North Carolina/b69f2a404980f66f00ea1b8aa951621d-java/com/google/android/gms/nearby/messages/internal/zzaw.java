package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.c.k.o.k;

public final class zzaw extends zzbd {
    public final /* synthetic */ k zza;
    public final /* synthetic */ zzaj zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaw(zzaj zzaj, k kVar, k kVar2) {
        super(kVar);
        this.zzb = zzaj;
        this.zza = kVar2;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzt, com.google.android.gms.nearby.messages.internal.zzbd
    public final void zza() {
        k.a<L> aVar = this.zza.f2377c;
        if (aVar != null) {
            this.zzb.doUnregisterEventListener(aVar);
        }
        super.zza();
    }
}
