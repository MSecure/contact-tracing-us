package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzah extends zzbl {
    private final /* synthetic */ TaskCompletionSource zza;

    zzah(zzt zzt, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzbi
    public final void zza(Status status, ExposureSummary exposureSummary) {
        TaskUtil.setResultOrApiException(status, exposureSummary, this.zza);
    }
}
