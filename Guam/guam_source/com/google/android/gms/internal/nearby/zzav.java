package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzav extends IStatusCallback.Stub {
    public final /* synthetic */ List zza;
    public final /* synthetic */ TaskCompletionSource zzb;

    public zzav(List list, TaskCompletionSource taskCompletionSource) {
        this.zza = list;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        for (ParcelFileDescriptor parcelFileDescriptor : this.zza) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
                Log.w("ExposureNotification", "Failed to close file", e);
            }
        }
        ReactYogaConfigProvider.trySetResultOrApiException(status, null, this.zzb);
    }
}
