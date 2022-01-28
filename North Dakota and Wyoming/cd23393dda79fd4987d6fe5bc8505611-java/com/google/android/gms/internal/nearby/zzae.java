package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzae extends zzbo {
    private final /* synthetic */ TaskCompletionSource zza;

    zzae(zzt zzt, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzbp
    public final void zza(Status status, List<ExposureWindow> list) {
        TaskUtil.setResultOrApiException(status, list, this.zza);
    }
}
