package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.c.k.o.k;
import c.b.a.a.e.c.ha;
import com.google.android.gms.nearby.messages.SubscribeCallback;

public final class zzbv extends zzac {
    public static final ha<SubscribeCallback> zza = new zzby();
    public final k<SubscribeCallback> zzb;

    public zzbv(k<SubscribeCallback> kVar) {
        this.zzb = kVar;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzz
    public final void zza() {
        this.zzb.a(zza);
    }
}
