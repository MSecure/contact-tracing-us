package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.d.k.o.k;
import c.b.a.a.g.e.ha;
import com.google.android.gms.nearby.messages.PublishCallback;

public class zzbd extends zzw {
    public static final ha<PublishCallback> zza = new zzbg();
    public final k<PublishCallback> zzb;

    public zzbd(k<PublishCallback> kVar) {
        this.zzb = kVar;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzt
    public void zza() {
        k<PublishCallback> kVar = this.zzb;
        if (kVar != null) {
            kVar.a(zza);
        }
    }
}
