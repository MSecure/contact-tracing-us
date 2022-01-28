package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzab implements RemoteCall {
    private final zzt zza;
    private final String zzb;

    zzab(zzt zzt, String str) {
        this.zza = zzt;
        this.zzb = str;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzt zzt = this.zza;
        ((zzbq) ((zzr) obj).getService()).zza(new zzak().zza(new zzag(zzt, (TaskCompletionSource) obj2)).zza(this.zzb).zza());
    }
}
