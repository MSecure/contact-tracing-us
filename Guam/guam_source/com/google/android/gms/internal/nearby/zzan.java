package com.google.android.gms.internal.nearby;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzan extends zzcs {
    public final /* synthetic */ TaskCompletionSource zza;

    public zzan(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzct
    public final void zza(Status status, List<DailySummary> list) {
        ReactYogaConfigProvider.trySetResultOrApiException(status, list, this.zza);
    }
}
