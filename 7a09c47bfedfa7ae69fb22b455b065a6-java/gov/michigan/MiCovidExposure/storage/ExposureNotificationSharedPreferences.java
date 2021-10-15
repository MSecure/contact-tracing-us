package gov.michigan.MiCovidExposure.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import androidx.recyclerview.widget.RecyclerView;
import b.u.a.a;
import b.u.a.b;
import b.u.a.c;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExposureNotificationSharedPreferences {
    public static final String ATTENUATION_THRESHOLD_1_KEY = "ExposureNotificationSharedPreferences.ATTENUATION_THRESHOLD_1_KEY";
    public static final String ATTENUATION_THRESHOLD_2_KEY = "ExposureNotificationSharedPreferences.ATTENUATION_THRESHOLD_2_KEY";
    public static final String CUSTOM_LOGGING_ENABLED = "ExposureNotificationSharedPreferences.CUSTOM_LOGGING_ENABLED";
    public static final String DAYS_SINCE_LAST_EXPOSURE = "ExposureNotificationSharedPreferences.DAYS_SINCE_LAST_EXPOSURE";
    public static final String DEFAULT_MASTER_KEY_ALIAS = "MiCovidExposure";
    public static final String DISABLED_NOTIFICATIONS = "ExposureNotificationSharedPreferences.DISABLED_NOTIFICATIONS";
    public static final String DOWNLOADED_FILES = "ExposureNotificationSharedPreferences.DOWNLOADED_FILES";
    public static final String FIRST_ONBOARDING_DONE = "ExposureNotificationSharedPreferences.FIRST_ONBOARDING_DONE";
    public static final String HAS_EVER_RCVD_NTFCN = "ExposureNotificationSharedPreferences.HAS_EVER_RCVD_NTFCN";
    public static final String LAST_EXPOSURE = "ExposureNotificationSharedPreferences.LAST_EXPOSURE";
    public static final String LAST_NOTIFICATION_TIME_IN_MILLIS = "ExposureNotificationSharedPreferences.LAST_NOTIFICATION_TIME_IN_MILLIS";
    public static final String LAST_RETRY_TIME_IN_MILLIS = "ExposureNotificationSharedPreferences.LAST_RETRY_TIME_IN_MILLIS";
    public static final String MIGRATION = "ExposureNotificationSharedPreferences.MIGRATION";
    public static final String NETWORK_MODE_KEY = "ExposureNotificationSharedPreferences.NETWORK_MODE_KEY";
    public static final String ONBOARDING_STATE_KEY = "ExposureNotificationSharedPreferences.ONBOARDING_STATE_KEY";
    public static final String ON_SET_VALUE = "ExposureNotificationSharedPreferences.ON_SET_VALUE";
    public static final String PIN_TOKEN = "ExposureNotificationSharedPreferences.PIN_TOKEN";
    public static final String POSSIBLE_EXPOSURE_FOUND = "ExposureNotificationSharedPreferences.POSSIBLE_EXPOSURE_FOUND";
    public static final String RETRIES_EXHAUSTED = "ExposureNotificationSharedPreferences.RETRIES_EXHAUSTED";
    public static final String REVISION_TOKEN = "ExposureNotificationSharedPreferences.REVISION_TOKEN";
    public static final String SHARED_PREFERENCES_FILE = "ExposureNotificationSharedPreferences.SHARED_PREFERENCES_FILE";
    public static final String TEST_EXPOSURE = "ExposureNotificationSharedPreferences.TEST_EXPOSURE";
    public static final String TIMESTAMP_SINCE_LAST_EXPOSURE = "ExposureNotificationSharedPreferences.TIMESTAMP_SINCE_LAST_EXPOSURE";
    public Map<String, Object> oldShrdPrefMap;
    public final SharedPreferences sharedPreferences;

    public enum NetworkMode {
        TEST,
        FAKE
    }

    public enum OnboardingStatus {
        UNKNOWN(0),
        ONBOARDED(1),
        SKIPPED(2);
        
        public final int value;

        /* access modifiers changed from: public */
        OnboardingStatus(int i) {
            this.value = i;
        }

        public static OnboardingStatus fromValue(int i) {
            return i != 1 ? i != 2 ? UNKNOWN : SKIPPED : ONBOARDED;
        }

        public int value() {
            return this.value;
        }
    }

    public ExposureNotificationSharedPreferences(Context context) {
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(SHARED_PREFERENCES_FILE, 0);
        if (!sharedPreferences2.getBoolean(MIGRATION, false)) {
            this.oldShrdPrefMap = getOldShrePrefMap(sharedPreferences2);
        }
        try {
            context.getApplicationContext();
            KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(DEFAULT_MASTER_KEY_ALIAS, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(RecyclerView.a0.FLAG_TMP_DETACHED).build();
            if (!DEFAULT_MASTER_KEY_ALIAS.equals(build.getKeystoreAlias())) {
                throw new IllegalArgumentException("KeyGenParamSpec's key alias does not match provided alias (" + DEFAULT_MASTER_KEY_ALIAS + " vs " + build.getKeystoreAlias());
            } else if (build != null) {
                sharedPreferences2 = a.a(context, SHARED_PREFERENCES_FILE, new b(c.a(build), build), a.c.AES256_SIV, a.d.AES256_GCM);
                this.sharedPreferences = sharedPreferences2;
                if (!context.getSharedPreferences(SHARED_PREFERENCES_FILE, 0).getBoolean(MIGRATION, false)) {
                    checkUpdateFromOldPref(this.oldShrdPrefMap, sharedPreferences2, context);
                }
            } else {
                throw new IllegalArgumentException("build() called before setKeyGenParameterSpec or setKeyScheme.");
            }
        } catch (GeneralSecurityException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    private void checkUpdateFromOldPref(Map<String, Object> map, SharedPreferences sharedPreferences2, Context context) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                sharedPreferences2.edit().putString(entry.getKey(), entry.getValue().toString()).apply();
            }
            if (entry.getValue() instanceof Boolean) {
                sharedPreferences2.edit().putBoolean(entry.getKey(), ((Boolean) entry.getValue()).booleanValue()).apply();
            }
            if (entry.getValue() instanceof Integer) {
                sharedPreferences2.edit().putInt(entry.getKey(), ((Integer) entry.getValue()).intValue()).apply();
            }
            if (entry.getValue() instanceof Long) {
                sharedPreferences2.edit().putLong(entry.getKey(), ((Long) entry.getValue()).longValue()).apply();
            }
        }
        context.getSharedPreferences(SHARED_PREFERENCES_FILE, 0).edit().putBoolean(MIGRATION, true).apply();
    }

    private Map<String, Object> getOldShrePrefMap(SharedPreferences sharedPreferences2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(ONBOARDING_STATE_KEY, Integer.valueOf(sharedPreferences2.getInt(ONBOARDING_STATE_KEY, 0)));
        sharedPreferences2.edit().remove(ONBOARDING_STATE_KEY).apply();
        NetworkMode networkMode = NetworkMode.TEST;
        treeMap.put(NETWORK_MODE_KEY, sharedPreferences2.getString(NETWORK_MODE_KEY, "TEST"));
        sharedPreferences2.edit().remove(NETWORK_MODE_KEY).apply();
        treeMap.put(POSSIBLE_EXPOSURE_FOUND, Boolean.valueOf(sharedPreferences2.getBoolean(POSSIBLE_EXPOSURE_FOUND, false)));
        sharedPreferences2.edit().remove(POSSIBLE_EXPOSURE_FOUND).apply();
        treeMap.put(PIN_TOKEN, sharedPreferences2.getString(PIN_TOKEN, ""));
        sharedPreferences2.edit().remove(PIN_TOKEN).apply();
        treeMap.put(LAST_RETRY_TIME_IN_MILLIS, Long.valueOf(sharedPreferences2.getLong(LAST_RETRY_TIME_IN_MILLIS, 0)));
        sharedPreferences2.edit().remove(LAST_RETRY_TIME_IN_MILLIS).apply();
        treeMap.put(DAYS_SINCE_LAST_EXPOSURE, Integer.valueOf(sharedPreferences2.getInt(DAYS_SINCE_LAST_EXPOSURE, 0)));
        sharedPreferences2.edit().remove(DAYS_SINCE_LAST_EXPOSURE).apply();
        treeMap.put(LAST_EXPOSURE, Long.valueOf(sharedPreferences2.getLong(LAST_EXPOSURE, 0)));
        sharedPreferences2.edit().remove(LAST_EXPOSURE).apply();
        treeMap.put(FIRST_ONBOARDING_DONE, Boolean.valueOf(sharedPreferences2.getBoolean(FIRST_ONBOARDING_DONE, false)));
        sharedPreferences2.edit().remove(FIRST_ONBOARDING_DONE).apply();
        treeMap.put(LAST_NOTIFICATION_TIME_IN_MILLIS, Long.valueOf(sharedPreferences2.getLong(LAST_NOTIFICATION_TIME_IN_MILLIS, 0)));
        sharedPreferences2.edit().remove(LAST_NOTIFICATION_TIME_IN_MILLIS).apply();
        treeMap.put(TIMESTAMP_SINCE_LAST_EXPOSURE, Long.valueOf(sharedPreferences2.getLong(TIMESTAMP_SINCE_LAST_EXPOSURE, 0)));
        sharedPreferences2.edit().remove(TIMESTAMP_SINCE_LAST_EXPOSURE).apply();
        treeMap.put(TEST_EXPOSURE, Boolean.valueOf(sharedPreferences2.getBoolean(TEST_EXPOSURE, false)));
        sharedPreferences2.edit().remove(TEST_EXPOSURE).apply();
        treeMap.put(REVISION_TOKEN, sharedPreferences2.getString(REVISION_TOKEN, ""));
        sharedPreferences2.edit().remove(REVISION_TOKEN).apply();
        treeMap.put(ON_SET_VALUE, Long.valueOf(sharedPreferences2.getLong(ON_SET_VALUE, 0)));
        sharedPreferences2.edit().remove(ON_SET_VALUE).apply();
        return treeMap;
    }

    public int getAttenuationThreshold1(int i) {
        return this.sharedPreferences.getInt(ATTENUATION_THRESHOLD_1_KEY, i);
    }

    public int getAttenuationThreshold2(int i) {
        return this.sharedPreferences.getInt(ATTENUATION_THRESHOLD_2_KEY, i);
    }

    public int getDaysSinceLastExposure(int i) {
        return this.sharedPreferences.getInt(DAYS_SINCE_LAST_EXPOSURE, i);
    }

    public boolean getDisabledNotifications(boolean z) {
        return this.sharedPreferences.getBoolean(DISABLED_NOTIFICATIONS, z);
    }

    public Set<String> getDownloadedFiles(Set<String> set) {
        return this.sharedPreferences.getStringSet(DOWNLOADED_FILES, set);
    }

    public boolean getFirstOnboardingStatus(boolean z) {
        return this.sharedPreferences.getBoolean(FIRST_ONBOARDING_DONE, z);
    }

    public Long getLastExposure(Long l) {
        return Long.valueOf(this.sharedPreferences.getLong(LAST_EXPOSURE, l.longValue()));
    }

    public long getLastNotificationTimeInMillis(Long l) {
        return this.sharedPreferences.getLong(LAST_NOTIFICATION_TIME_IN_MILLIS, l.longValue());
    }

    public Long getLastRetryTimeInMillis(Long l) {
        return Long.valueOf(this.sharedPreferences.getLong(LAST_RETRY_TIME_IN_MILLIS, l.longValue()));
    }

    public NetworkMode getNetworkMode(NetworkMode networkMode) {
        return NetworkMode.valueOf(this.sharedPreferences.getString(NETWORK_MODE_KEY, networkMode.toString()));
    }

    public long getOnSetValue(long j) {
        return this.sharedPreferences.getLong(ON_SET_VALUE, j);
    }

    public OnboardingStatus getOnboardedState() {
        return OnboardingStatus.fromValue(this.sharedPreferences.getInt(ONBOARDING_STATE_KEY, 0));
    }

    public String getPinToken(String str) {
        return this.sharedPreferences.getString(PIN_TOKEN, str);
    }

    public boolean getPossibleExposureFound(boolean z) {
        return this.sharedPreferences.getBoolean(POSSIBLE_EXPOSURE_FOUND, z);
    }

    public boolean getRetriesExhausted(boolean z) {
        return this.sharedPreferences.getBoolean(RETRIES_EXHAUSTED, z);
    }

    public String getRevisionToken(String str) {
        return this.sharedPreferences.getString(REVISION_TOKEN, str);
    }

    public boolean getTestExposure(boolean z) {
        return this.sharedPreferences.getBoolean(TEST_EXPOSURE, z);
    }

    public long getTimestampSinceLastExposure(Long l) {
        return this.sharedPreferences.getLong(TIMESTAMP_SINCE_LAST_EXPOSURE, l.longValue());
    }

    public boolean gethasEverReceivedNotification(boolean z) {
        return this.sharedPreferences.getBoolean(HAS_EVER_RCVD_NTFCN, z);
    }

    public void setAttenuationThreshold1(int i) {
        this.sharedPreferences.edit().putInt(ATTENUATION_THRESHOLD_1_KEY, i).apply();
    }

    public void setAttenuationThreshold2(int i) {
        this.sharedPreferences.edit().putInt(ATTENUATION_THRESHOLD_2_KEY, i).apply();
    }

    public void setDaysSinceLastExposure(int i) {
        this.sharedPreferences.edit().putInt(DAYS_SINCE_LAST_EXPOSURE, i).apply();
    }

    public void setDisabledNotifications(boolean z) {
        this.sharedPreferences.edit().putBoolean(DISABLED_NOTIFICATIONS, z).apply();
    }

    public void setDownloadedFiles(Set<String> set) {
        this.sharedPreferences.edit().putStringSet(DOWNLOADED_FILES, set).apply();
    }

    public void setFirstOnboardingStatus(boolean z) {
        this.sharedPreferences.edit().putBoolean(FIRST_ONBOARDING_DONE, z).apply();
    }

    public void setLastExposure(Long l) {
        this.sharedPreferences.edit().putLong(LAST_EXPOSURE, l.longValue()).apply();
    }

    public void setLastNotificationTimeInMillis(Long l) {
        this.sharedPreferences.edit().putLong(LAST_NOTIFICATION_TIME_IN_MILLIS, l.longValue()).apply();
    }

    public void setLastRetryTimeInMillis(Long l) {
        this.sharedPreferences.edit().putLong(LAST_RETRY_TIME_IN_MILLIS, l.longValue()).apply();
    }

    public void setNetworkMode(NetworkMode networkMode) {
        this.sharedPreferences.edit().putString(NETWORK_MODE_KEY, networkMode.toString()).apply();
    }

    public void setOnSetValue(long j) {
        this.sharedPreferences.edit().putLong(ON_SET_VALUE, j).apply();
    }

    public void setOnboardedState(boolean z) {
        this.sharedPreferences.edit().putInt(ONBOARDING_STATE_KEY, (z ? OnboardingStatus.ONBOARDED : OnboardingStatus.UNKNOWN).value()).apply();
    }

    public void setPinToken(String str) {
        this.sharedPreferences.edit().putString(PIN_TOKEN, str).apply();
    }

    public void setPossibleExposureFound(boolean z) {
        this.sharedPreferences.edit().putBoolean(POSSIBLE_EXPOSURE_FOUND, z).apply();
    }

    public void setRetriesExhausted(boolean z) {
        this.sharedPreferences.edit().putBoolean(RETRIES_EXHAUSTED, z).apply();
    }

    public void setRevisionToken(String str) {
        this.sharedPreferences.edit().putString(REVISION_TOKEN, str).apply();
    }

    public void setTestExposure(boolean z) {
        this.sharedPreferences.edit().putBoolean(TEST_EXPOSURE, z).apply();
    }

    public void setTimestampSinceLastExposure(Long l) {
        this.sharedPreferences.edit().putLong(TIMESTAMP_SINCE_LAST_EXPOSURE, l.longValue()).apply();
    }

    public void sethasEverReceivedNotification(boolean z) {
        this.sharedPreferences.edit().putBoolean(HAS_EVER_RCVD_NTFCN, z).apply();
    }
}
