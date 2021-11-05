package com.google.android.gms.nearby.exposurenotification;

import c.b.a.a.c.k.o.b;
import c.b.a.a.g.h;
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

    /* synthetic */ b<O> getApiKey();

    h<Integer> getCalibrationConfidence();

    h<List<DailySummary>> getDailySummaries(DailySummariesConfig dailySummariesConfig);

    h<DiagnosisKeysDataMapping> getDiagnosisKeysDataMapping();

    @Deprecated
    h<List<ExposureInformation>> getExposureInformation(String str);

    @Deprecated
    h<ExposureSummary> getExposureSummary(String str);

    h<List<ExposureWindow>> getExposureWindows();

    @Deprecated
    h<List<ExposureWindow>> getExposureWindows(String str);

    h<PackageConfiguration> getPackageConfiguration();

    h<Set<ExposureNotificationStatus>> getStatus();

    h<List<TemporaryExposureKey>> getTemporaryExposureKeyHistory();

    h<Long> getVersion();

    h<Boolean> isEnabled();

    h<Void> provideDiagnosisKeys(DiagnosisKeyFileProvider diagnosisKeyFileProvider);

    @Deprecated
    h<Void> provideDiagnosisKeys(List<File> list);

    @Deprecated
    h<Void> provideDiagnosisKeys(List<File> list, ExposureConfiguration exposureConfiguration, String str);

    h<Void> setDiagnosisKeysDataMapping(DiagnosisKeysDataMapping diagnosisKeysDataMapping);

    h<Void> start();

    h<Void> stop();
}
