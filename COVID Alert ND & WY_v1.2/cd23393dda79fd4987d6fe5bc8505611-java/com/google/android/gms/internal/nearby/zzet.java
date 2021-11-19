package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.tasks.OnSuccessListener;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzet implements OnSuccessListener {
    private final zzei zza;
    private final DiscoveryOptions zzb;

    zzet(zzei zzei, DiscoveryOptions discoveryOptions) {
        this.zza = zzei;
        this.zzb = discoveryOptions;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.zza.zza(this.zzb, (Void) obj);
    }
}
