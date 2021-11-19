package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.nearby.exposurenotification.ExposureInformation;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzag extends zzbe {
    private final /* synthetic */ TaskCompletionSource zza;

    zzag(zzt zzt, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzbf
    public final void zza(Status status, List<ExposureInformation> list) {
        TaskUtil.setResultOrApiException(status, list, this.zza);
    }
}
