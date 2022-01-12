package com.google.android.gms.internal.nearby;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzaq extends IStatusCallback.Stub {
    public final /* synthetic */ TaskCompletionSource zza;

    public zzaq(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        ReactYogaConfigProvider.trySetResultOrApiException(status, null, this.zza);
    }
}
