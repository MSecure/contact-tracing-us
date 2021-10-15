package com.google.android.gms.nearby.exposurenotification;

import androidx.annotation.RecentlyNonNull;
import c.b.a.a.d.k.o.b;
import c.b.a.a.j.i;
import java.io.File;
import java.util.List;
import java.util.Set;

public interface ExposureNotificationClient {
    public static final String ACTION_EXPOSURE_NOTIFICATION_SETTINGS = "com.google.android.gms.settings.EXPOSURE_NOTIFICATION_SETTINGS";
    public static final String ACTION_EXPOSURE_NOT_FOUND = "com.google.android.gms.exposurenotification.ACTION_EXPOSURE_NOT_FOUND";
    public static final String ACTION_EXPOSURE_STATE_UPDATED = "com.google.android.gms.exposurenotification.ACTION_EXPOSURE_STATE_UPDATED";
    public static final String ACTION_SERVICE_STATE_UPDATED = "com.google.android.gms.exposurenotification.ACTION_SERVICE_STATE_UPDATED";
    @Deprecated
    public static final String EXTRA_EXPOSURE_SUMMARY = "com.google.android.gms.exposurenotification.EXTRA_EXPOSURE_SUMMARY";
    public static final String EXTRA_SERVICE_STATE = "com.google.android.gms.exposurenotification.EXTRA_SERVICE_STATE";
    @Deprecated
    public static final String EXTRA_TOKEN = "com.google.android.gms.exposurenotification.EXTRA_TOKEN";
    @Deprecated
    public static final String TOKEN_A = "TYZWQ32170AXEUVCDW7A";

    boolean deviceSupportsLocationlessScanning();

    @RecentlyNonNull
    /* synthetic */ b<O> getApiKey();

    i<Integer> getCalibrationConfidence();

    i<List<DailySummary>> getDailySummaries(DailySummariesConfig dailySummariesConfig);

    i<DiagnosisKeysDataMapping> getDiagnosisKeysDataMapping();

    @Deprecated
    i<List<ExposureInformation>> getExposureInformation(String str);

    @Deprecated
    i<ExposureSummary> getExposureSummary(String str);

    i<List<ExposureWindow>> getExposureWindows();

    @Deprecated
    i<List<ExposureWindow>> getExposureWindows(String str);

    i<PackageConfiguration> getPackageConfiguration();

    i<Set<ExposureNotificationStatus>> getStatus();

    i<List<TemporaryExposureKey>> getTemporaryExposureKeyHistory();

    i<Long> getVersion();

    i<Boolean> isEnabled();

    i<Void> provideDiagnosisKeys(DiagnosisKeyFileProvider diagnosisKeyFileProvider);

    @Deprecated
    i<Void> provideDiagnosisKeys(List<File> list);

    @Deprecated
    i<Void> provideDiagnosisKeys(List<File> list, ExposureConfiguration exposureConfiguration, String str);

    i<Void> setDiagnosisKeysDataMapping(DiagnosisKeysDataMapping diagnosisKeysDataMapping);

    i<Void> start();

    i<Void> stop();
}
