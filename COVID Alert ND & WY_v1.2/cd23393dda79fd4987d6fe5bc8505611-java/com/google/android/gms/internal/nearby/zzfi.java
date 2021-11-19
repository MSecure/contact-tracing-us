package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzfi implements OnFailureListener {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzei zzb;

    zzfi(zzei zzei, String str) {
        this.zzb = zzei;
        this.zza = str;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        if (!(exc instanceof ApiException) || ((ApiException) exc).getStatusCode() != 8003) {
            zzei.zza(this.zzb, this.zza);
        }
    }
}
