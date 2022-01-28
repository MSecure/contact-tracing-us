package com.google.android.gms.internal.nearby;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzak extends zzdt {
    public final /* synthetic */ TaskCompletionSource zza;

    public zzak(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzdq
    public final void zza(Status status, long j) {
        ReactYogaConfigProvider.trySetResultOrApiException(status, Long.valueOf(j), this.zza);
    }
}
