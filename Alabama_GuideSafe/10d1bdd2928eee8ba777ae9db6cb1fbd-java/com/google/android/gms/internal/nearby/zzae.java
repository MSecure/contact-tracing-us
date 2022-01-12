package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final /* synthetic */ class zzae implements RemoteCall {
    public final zzt zza;

    public zzae(zzt zzt) {
        this.zza = zzt;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzas zzas = new zzas((TaskCompletionSource) obj2);
        zzce zzce = new zzce(null);
        zzce.zzb = zzas;
        ((zzdv) ((zzr) obj).getService()).zza(zzce);
    }
}
