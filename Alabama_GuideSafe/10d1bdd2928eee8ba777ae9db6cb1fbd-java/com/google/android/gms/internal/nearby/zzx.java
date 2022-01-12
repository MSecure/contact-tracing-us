package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final /* synthetic */ class zzx implements RemoteCall {
    public final zzt zza;
    public final DailySummariesConfig zzb;

    public zzx(zzt zzt, DailySummariesConfig dailySummariesConfig) {
        this.zza = zzt;
        this.zzb = dailySummariesConfig;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        DailySummariesConfig dailySummariesConfig = this.zzb;
        zzan zzan = new zzan((TaskCompletionSource) obj2);
        zzbc zzbc = new zzbc(null);
        zzbc.zza = zzan;
        zzbc.zzb = dailySummariesConfig;
        ((zzdv) ((zzr) obj).getService()).zza(zzbc);
    }
}
