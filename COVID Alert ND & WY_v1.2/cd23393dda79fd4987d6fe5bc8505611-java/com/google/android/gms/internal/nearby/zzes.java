package com.google.android.gms.internal.nearby;

import com.google.android.gms.tasks.OnSuccessListener;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzes implements OnSuccessListener {
    private final zzei zza;

    zzes(zzei zzei) {
        this.zza = zzei;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.zza.zza((Void) obj);
    }
}
