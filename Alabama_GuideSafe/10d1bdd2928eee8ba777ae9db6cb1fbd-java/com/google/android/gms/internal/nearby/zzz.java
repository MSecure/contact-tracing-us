package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final /* synthetic */ class zzz implements RemoteCall {
    public final DiagnosisKeysDataMapping zza;

    public zzz(DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        this.zza = diagnosisKeysDataMapping;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = this.zza;
        zzen zzen = new zzen(null);
        zzen.zza = new zzaq((TaskCompletionSource) obj2);
        zzen.zzb = diagnosisKeysDataMapping;
        ((zzdv) ((zzr) obj).getService()).zza(zzen);
    }
}
