package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class ExposureNotificationSharedPreferences {
    public final SharedPreferences sharedPreferences;

    public ExposureNotificationSharedPreferences(Context context) {
        this.sharedPreferences = context.getSharedPreferences("ExposureNotificationSharedPreferences.SHARED_PREFERENCES_FILE", 0);
    }

    public void setEscrowVerificationTokens(String str, String str2) {
        this.sharedPreferences.edit().putString("ExposureNotificationSharedPreferences.ESCROW_VERIFICATION_ACCESS_TOKEN", str).putString("ExposureNotificationSharedPreferences.ESCROW_VERIFICATION_REFRESH_TOKEN", str2).commit();
    }
}
