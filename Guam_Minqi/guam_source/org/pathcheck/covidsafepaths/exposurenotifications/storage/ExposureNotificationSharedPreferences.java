package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class ExposureNotificationSharedPreferences {
    public final SharedPreferences sharedPreferences;

    public ExposureNotificationSharedPreferences(Context context) {
        this.sharedPreferences = context.getSharedPreferences("ExposureNotificationSharedPreferences.SHARED_PREFERENCES_FILE", 0);
    }
}
