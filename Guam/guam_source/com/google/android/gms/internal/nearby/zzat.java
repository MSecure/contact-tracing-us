package com.google.android.gms.internal.nearby;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzat extends zzcp {
    public final /* synthetic */ TaskCompletionSource zza;

    public zzat(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzcm
    public final void zza(Status status, boolean z) {
        ReactYogaConfigProvider.trySetResultOrApiException(status, Boolean.valueOf(z), this.zza);
    }
}
