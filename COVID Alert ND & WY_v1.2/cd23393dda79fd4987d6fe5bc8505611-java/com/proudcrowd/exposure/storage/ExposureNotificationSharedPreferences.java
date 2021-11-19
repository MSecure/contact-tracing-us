package com.proudcrowd.exposure.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class ExposureNotificationSharedPreferences {
    private static final String CITIZEN_CODE_KEY = "ExposureNotificationSharedPreferences.CITIZEN_CODE";
    private static final String DEVICE_ID_KEY = "ExposureNotificationSharedPreferences.DEVICE_ID";
    private static final String DOWNLOAD_SERVER_ADDRESS_KEY = "ExposureNotificationSharedPreferences.DOWNLOAD_SERVER_ADDRESS_KEY";
    private static final String DOWNLOAD_SERVER_INDEX_NAME_KEY = "ExposureNotificationSharedPreferences.DOWNLOAD_SERVER_INDEX_NAME_KEY";
    private static final String HAVE_CONSENT_KEY = "ExposureNotificationSharedPreferences.HAVE_CONSENT";
    private static final String IS_ENABLED_CACHE_KEY = "ExposureNotificationSharedPreferences.IS_ENABLED_CACHE_KEY";
    private static final String KEYMATCH_SETTINGS_KEY = "ExposureNotificationSharedPreferences.KEYMATCH_SETTINGS_KEY";
    private static final String MESSAGING_KEY = "ExposureNotificationSharedPreferences.MESSAGING_KEY";
    private static final String REGION_KEY = "ExposureNotificationSharedPreferences.REGION";
    private static final String SHARED_PREFERENCES_FILE = "CARE19";
    private static final String UPLOAD_SERVER_ADDRESS_KEY = "ExposureNotificationSharedPreferences.UPLOAD_SERVER_ADDRESS_KEY";
    private static final String USE_BUGFENDER_KEY = "ExposureNotificationSharedPreferences.USE_BUGFENDER_KEY";
    private final SharedPreferences sharedPreferences;

    public ExposureNotificationSharedPreferences(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE, 0);
    }

    public String getDeviceId(String str) {
        return this.sharedPreferences.getString(DEVICE_ID_KEY, str);
    }

    public void setDeviceId(String str) {
        this.sharedPreferences.edit().putString(DEVICE_ID_KEY, str).commit();
    }

    public String getCitizenCode(String str) {
        return this.sharedPreferences.getString(CITIZEN_CODE_KEY, str);
    }

    public void setCitizenCode(String str) {
        this.sharedPreferences.edit().putString(CITIZEN_CODE_KEY, str).commit();
    }

    public String getMessagingToken(String str) {
        return this.sharedPreferences.getString(MESSAGING_KEY, str);
    }

    public void setMessagingToken(String str) {
        this.sharedPreferences.edit().putString(MESSAGING_KEY, str).apply();
    }

    public String getKeymatchSettings() {
        return this.sharedPreferences.getString(KEYMATCH_SETTINGS_KEY, "{}");
    }

    public void setKeymatchSettings(String str) {
        this.sharedPreferences.edit().putString(KEYMATCH_SETTINGS_KEY, str).apply();
    }

    public boolean getHaveConsent(boolean z) {
        return this.sharedPreferences.getBoolean(HAVE_CONSENT_KEY, z);
    }

    public void setHaveConsent(boolean z) {
        this.sharedPreferences.edit().putBoolean(HAVE_CONSENT_KEY, z).commit();
    }

    public String getRegion(String str) {
        return this.sharedPreferences.getString(REGION_KEY, str);
    }

    public void setRegion(String str) {
        this.sharedPreferences.edit().putString(REGION_KEY, str).commit();
    }

    public void clearUploadServerAddress() {
        this.sharedPreferences.edit().remove(UPLOAD_SERVER_ADDRESS_KEY).commit();
    }

    public String getUploadServerAddress(String str) {
        return this.sharedPreferences.getString(UPLOAD_SERVER_ADDRESS_KEY, str);
    }

    public void setUploadServerAddress(String str) {
        if (str.isEmpty()) {
            clearUploadServerAddress();
        } else {
            this.sharedPreferences.edit().putString(UPLOAD_SERVER_ADDRESS_KEY, str).commit();
        }
    }

    public void clearDownloadServerAddress() {
        this.sharedPreferences.edit().remove(DOWNLOAD_SERVER_ADDRESS_KEY).commit();
    }

    public String getDownloadServerAddress(String str) {
        return this.sharedPreferences.getString(DOWNLOAD_SERVER_ADDRESS_KEY, str);
    }

    public void setDownloadServerAddress(String str) {
        if (str.isEmpty()) {
            clearDownloadServerAddress();
        } else {
            this.sharedPreferences.edit().putString(DOWNLOAD_SERVER_ADDRESS_KEY, str).commit();
        }
    }

    public void clearDownloadServerIndexNameAddress() {
        this.sharedPreferences.edit().remove(DOWNLOAD_SERVER_INDEX_NAME_KEY).commit();
    }

    public String getDownloadServerIndexName(String str) {
        return this.sharedPreferences.getString(DOWNLOAD_SERVER_INDEX_NAME_KEY, str);
    }

    public void setDownloadServerIndexName(String str) {
        if (str.isEmpty()) {
            clearDownloadServerIndexNameAddress();
        } else {
            this.sharedPreferences.edit().putString(DOWNLOAD_SERVER_INDEX_NAME_KEY, str).commit();
        }
    }

    public boolean getIsEnabledCache() {
        return this.sharedPreferences.getBoolean(IS_ENABLED_CACHE_KEY, false);
    }

    public void setIsEnabledCache(boolean z) {
        this.sharedPreferences.edit().putBoolean(IS_ENABLED_CACHE_KEY, z).apply();
    }

    public boolean getUseBugfender() {
        return this.sharedPreferences.getBoolean(USE_BUGFENDER_KEY, false);
    }

    public void setUseBugfender(boolean z) {
        this.sharedPreferences.edit().putBoolean(USE_BUGFENDER_KEY, z).apply();
    }
}
