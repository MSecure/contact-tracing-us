package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.c.k.o.k;
import c.b.a.a.e.c.ha;
import com.google.android.gms.nearby.messages.SubscribeCallback;

public class zzbf extends zzac {
    public static final ha<SubscribeCallback> zza = new zzbi();
    public final k<SubscribeCallback> zzb;

    public zzbf(k<SubscribeCallback> kVar) {
        this.zzb = kVar;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzz
    public void zza() {
        k<SubscribeCallback> kVar = this.zzb;
        if (kVar != null) {
            kVar.a(zza);
        }
    }
}
