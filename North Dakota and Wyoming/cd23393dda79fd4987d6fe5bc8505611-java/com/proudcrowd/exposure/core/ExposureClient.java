package com.proudcrowd.exposure.core;

import android.content.Context;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.util.List;

public final class ExposureClient {
    private static ExposureClient INSTANCE;
    private final ExposureNotificationClient exposureNotificationClient;

    public static ExposureClient get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ExposureClient(context);
        }
        return INSTANCE;
    }

    ExposureClient(Context context) {
        this.exposureNotificationClient = Nearby.getExposureNotificationClient(context);
    }

    public Task<Void> start() {
        return this.exposureNotificationClient.start();
    }

    public Task<Void> stop() {
        return this.exposureNotificationClient.stop();
    }

    public Task<Boolean> isEnabled() {
        return this.exposureNotificationClient.isEnabled();
    }

    public Task<List<TemporaryExposureKey>> getTemporaryExposureKeyHistory() {
        return this.exposureNotificationClient.getTemporaryExposureKeyHistory();
    }

    public Task<Void> provideDiagnosisKeys(List<File> list, ExposureConfiguration exposureConfiguration) {
        return this.exposureNotificationClient.provideDiagnosisKeys(list, exposureConfiguration, ExposureNotificationClient.TOKEN_A);
    }

    public Task<List<ExposureWindow>> getExposureWindows() {
        return this.exposureNotificationClient.getExposureWindows(ExposureNotificationClient.TOKEN_A);
    }
}
