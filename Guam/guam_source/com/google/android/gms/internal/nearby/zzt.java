package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.nearby.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzt extends GoogleApi<Api.ApiOptions.NoOptions> implements ExposureNotificationClient {
    public static final Api<Api.ApiOptions.NoOptions> zza = new Api<>("Nearby.EXPOSURE_NOTIFICATION_API", new zzal(), new Api.ClientKey());

    public zzt(Context context) {
        super(context, zza, null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static final void zza(zzr zzr, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzev zzev = new zzev((zzeu) null);
        zzev.zza = new zzaq(taskCompletionSource);
        ((zzdv) zzr.getService()).zza(zzev);
    }

    public static final void zzb(zzr zzr, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzer zzer = new zzer(null);
        zzer.zza = new zzaq(taskCompletionSource);
        ((zzdv) zzr.getService()).zza(zzer);
    }

    public final Task<Boolean> isEnabled() {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.zaa = new zzaf(this);
        builder.zac = new Feature[]{zza.zzb};
        return zaa(0, builder.build());
    }

    public final Task<Void> start() {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.zaa = zzs.zza;
        builder.zac = new Feature[]{zza.zzb};
        return zaa(1, builder.build());
    }

    public final Task<Void> stop() {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.zaa = zzac.zza;
        builder.zac = new Feature[]{zza.zzb};
        return zaa(1, builder.build());
    }
}
