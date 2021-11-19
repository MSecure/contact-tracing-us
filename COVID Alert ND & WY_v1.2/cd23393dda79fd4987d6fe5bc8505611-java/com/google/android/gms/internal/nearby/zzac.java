package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzac extends zzbx {
    private final /* synthetic */ TaskCompletionSource zza;

    zzac(zzt zzt, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzbu
    public final void zza(Status status, List<TemporaryExposureKey> list) {
        TaskUtil.setResultOrApiException(status, list, this.zza);
    }
}
