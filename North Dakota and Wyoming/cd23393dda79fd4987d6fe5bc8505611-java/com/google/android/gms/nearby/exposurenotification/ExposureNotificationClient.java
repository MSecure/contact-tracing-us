package com.google.android.gms.nearby.exposurenotification;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public interface ExposureNotificationClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    public static final String ACTION_EXPOSURE_NOTIFICATION_SETTINGS = "com.google.android.gms.settings.EXPOSURE_NOTIFICATION_SETTINGS";
    public static final String ACTION_EXPOSURE_NOT_FOUND = "com.google.android.gms.exposurenotification.ACTION_EXPOSURE_NOT_FOUND";
    public static final String ACTION_EXPOSURE_STATE_UPDATED = "com.google.android.gms.exposurenotification.ACTION_EXPOSURE_STATE_UPDATED";
    public static final String EXTRA_EXPOSURE_SUMMARY = "com.google.android.gms.exposurenotification.EXTRA_EXPOSURE_SUMMARY";
    public static final String EXTRA_TOKEN = "com.google.android.gms.exposurenotification.EXTRA_TOKEN";
    public static final String TOKEN_A = "TYZWQ32170AXEUVCDW7A";

    @Deprecated
    Task<List<ExposureInformation>> getExposureInformation(String str);

    Task<ExposureSummary> getExposureSummary(String str);

    Task<List<ExposureWindow>> getExposureWindows(String str);

    Task<List<TemporaryExposureKey>> getTemporaryExposureKeyHistory();

    Task<Boolean> isEnabled();

    Task<Void> provideDiagnosisKeys(List<File> list, ExposureConfiguration exposureConfiguration, String str);

    Task<Void> start();

    Task<Void> stop();
}
