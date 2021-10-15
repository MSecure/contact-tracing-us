package com.google.android.gms.nearby.messages.internal;

import c.b.a.a.d.k.o.k;
import c.b.a.a.g.e.ha;
import com.google.android.gms.nearby.messages.PublishCallback;

public final class zzbu extends zzw {
    public static final ha<PublishCallback> zza = new zzbt();
    public final k<PublishCallback> zzb;

    public zzbu(k<PublishCallback> kVar) {
        this.zzb = kVar;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzt
    public final void zza() {
        this.zzb.a(zza);
    }
}
