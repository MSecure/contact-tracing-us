package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeyFileProvider;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final /* synthetic */ class zzag implements RemoteCall {
    public final zzt zza;
    public final ExposureConfiguration zzb;
    public final DiagnosisKeyFileProvider zzc;
    public final String zzd;

    public zzag(zzt zzt, ExposureConfiguration exposureConfiguration, DiagnosisKeyFileProvider diagnosisKeyFileProvider, String str) {
        this.zza = zzt;
        this.zzb = exposureConfiguration;
        this.zzc = diagnosisKeyFileProvider;
        this.zzd = str;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzt zzt = this.zza;
        ExposureConfiguration exposureConfiguration = this.zzb;
        DiagnosisKeyFileProvider diagnosisKeyFileProvider = this.zzc;
        String str = this.zzd;
        zzr zzr = (zzr) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        if (zzt != null) {
            zzej zzej = new zzej(null);
            zzej.zzd = exposureConfiguration;
            zzej.zzf = new zzau(diagnosisKeyFileProvider);
            zzej.zzb = new zzaq(taskCompletionSource);
            zzej.zze = str;
            ((zzdv) zzr.getService()).zza(zzej);
            return;
        }
        throw null;
    }
}
