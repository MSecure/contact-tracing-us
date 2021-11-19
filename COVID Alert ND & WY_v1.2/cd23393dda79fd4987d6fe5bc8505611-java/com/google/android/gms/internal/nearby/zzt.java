package com.google.android.gms.internal.nearby;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.ExposureInformation;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.android.gms.nearby.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzt extends GoogleApi<Api.ApiOptions.NoOptions> implements ExposureNotificationClient {
    private static final Api<Api.ApiOptions.NoOptions> zza = new Api<>("Nearby.EXPOSURE_NOTIFICATION_API", new zzaa(), new Api.ClientKey());

    public zzt(Context context) {
        super(context, zza, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> start() {
        return doWrite(TaskApiCall.builder().run(zzs.zza).setFeatures(zza.zzb).build());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> stop() {
        return doWrite(TaskApiCall.builder().run(zzv.zza).setFeatures(zza.zzb).build());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Boolean> isEnabled() {
        return doRead(TaskApiCall.builder().run(new zzu(this)).setFeatures(zza.zzb).build());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<List<TemporaryExposureKey>> getTemporaryExposureKeyHistory() {
        return doRead(TaskApiCall.builder().run(new zzx(this)).setFeatures(zza.zzb).build());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> provideDiagnosisKeys(List<File> list, ExposureConfiguration exposureConfiguration, String str) {
        return doWrite(TaskApiCall.builder().run(new zzw(this, list, exposureConfiguration, str)).setFeatures(zza.zzb).build());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<List<ExposureWindow>> getExposureWindows(String str) {
        return doRead(TaskApiCall.builder().run(new zzz(this, str)).setFeatures(zza.zzb).build());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<ExposureSummary> getExposureSummary(String str) {
        return doRead(TaskApiCall.builder().run(new zzy(this, str)).setFeatures(zza.zzb).build());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<List<ExposureInformation>> getExposureInformation(String str) {
        return doRead(TaskApiCall.builder().run(new zzab(this, str)).setFeatures(zza.zzb).build());
    }

    private static IStatusCallback zza(TaskCompletionSource<Void> taskCompletionSource) {
        return new zzaj(taskCompletionSource);
    }
}
