package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final /* synthetic */ class zzaf implements RemoteCall {
    public final zzt zza;

    public zzaf(zzt zzt) {
        this.zza = zzt;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzat zzat = new zzat((TaskCompletionSource) obj2);
        zzef zzef = new zzef(null);
        zzef.zzb = zzat;
        ((zzdv) ((zzr) obj).getService()).zza(zzef);
    }
}
