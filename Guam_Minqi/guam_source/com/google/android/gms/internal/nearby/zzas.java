package com.google.android.gms.internal.nearby;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzas extends zzed {
    public final /* synthetic */ TaskCompletionSource zza;

    public zzas(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzea
    public final void zza(Status status, List<TemporaryExposureKey> list) {
        ReactYogaConfigProvider.trySetResultOrApiException(status, list, this.zza);
    }
}
