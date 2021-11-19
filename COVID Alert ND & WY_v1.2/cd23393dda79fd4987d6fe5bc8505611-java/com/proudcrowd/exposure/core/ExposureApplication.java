package com.proudcrowd.exposure.core;

import android.app.Application;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import androidx.multidex.MultiDexApplication;
import androidx.work.WorkRequest;
import com.bugfender.sdk.Bugfender;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.jaredrummler.android.device.DeviceName;
import com.proudcrowd.exposure.datamodel.ExposureConfigurationDetail;
import com.proudcrowd.exposure.datamodel.KeyServerDetail;
import com.proudcrowd.exposure.datamodel.StudyDetail;
import com.proudcrowd.exposure.storage.ExposureNotificationSharedPreferences;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ExposureApplication extends MultiDexApplication {
    public static final String TEK_SERVER_VERSION = "v1";
    public static OkHttpClient mOkHttpClient;
    private static final Gson sJsonSerializer = new GsonBuilder().disableHtmlEscaping().create();
    public String mAppVersion;
    public String mCitizenCode;
    public String mDeviceGuid;
    public String mDeviceName;
    public ExposureConfigurationDetail mKeymatchSettings;
    private ExposureNotificationSharedPreferences mPreferences;
    public String mSimOperatorName;
    public StudyDetail mStudy;

    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init((Application) this);
        Bugfender.init(this, "rA11lG1GoytXjjpDXsRUvgkXqJZu8PIs", false);
        Bugfender.setForceEnabled(getPreferences().getUseBugfender());
        Bugfender.d("Bugfender", "Init");
        loadPersistedValues();
        OkHttpClient.Builder cache = new OkHttpClient.Builder().connectTimeout(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS).readTimeout(15000, TimeUnit.MILLISECONDS).cache(new Cache(getCacheDir(), 104857600));
        if (getDebug().booleanValue()) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            cache.addInterceptor(httpLoggingInterceptor);
        }
        mOkHttpClient = cache.build();
    }

    public void setKeyServerUrls(KeyServerDetail keyServerDetail) {
        getPreferences().setDownloadServerIndexName(keyServerDetail.indexFileName);
        getPreferences().setDownloadServerAddress(keyServerDetail.downloadUrl);
        getPreferences().setUploadServerAddress(keyServerDetail.uploadUrl);
    }

    public void setStudy(StudyDetail studyDetail) {
        this.mStudy = studyDetail;
        getPreferences().setRegion(sJsonSerializer.toJson(studyDetail));
    }

    public void setCitizenCode(String str) {
        this.mCitizenCode = str;
        getPreferences().setCitizenCode(str);
    }

    public void setHaveConsent() {
        getPreferences().setHaveConsent(true);
    }

    public boolean getHaveConsent() {
        return getPreferences().getHaveConsent(false);
    }

    public void setKeymatchSettings(ExposureConfigurationDetail exposureConfigurationDetail) {
        this.mKeymatchSettings = exposureConfigurationDetail;
        getPreferences().setKeymatchSettings(sJsonSerializer.toJson(exposureConfigurationDetail));
    }

    public ExposureNotificationSharedPreferences getPreferences() {
        if (this.mPreferences == null) {
            this.mPreferences = new ExposureNotificationSharedPreferences(this);
        }
        return this.mPreferences;
    }

    private void loadPersistedValues() {
        loadDeviceGuid();
        loadDeviceSettings();
        loadCitizenCode();
        loadKeymatchSettings();
        loadStudy();
        loadAppVersion();
    }

    private void loadDeviceGuid() {
        if (this.mDeviceGuid == null) {
            String deviceId = getPreferences().getDeviceId(null);
            this.mDeviceGuid = deviceId;
            if (deviceId == null) {
                this.mDeviceGuid = UUID.randomUUID().toString();
                getPreferences().setDeviceId(this.mDeviceGuid);
            }
        }
    }

    private void loadDeviceSettings() {
        try {
            DeviceName.init(this);
            this.mDeviceName = DeviceName.getDeviceName();
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
            String simOperatorName = telephonyManager.getSimOperatorName();
            this.mSimOperatorName = simOperatorName;
            if (simOperatorName.length() == 0) {
                this.mSimOperatorName = telephonyManager.getNetworkOperatorName();
            }
        } catch (Exception e) {
            Bugfender.sendIssue("SimOperatorName", e.getLocalizedMessage());
        }
    }

    private void loadKeymatchSettings() {
        if (this.mKeymatchSettings == null) {
            this.mKeymatchSettings = (ExposureConfigurationDetail) sJsonSerializer.fromJson(getPreferences().getKeymatchSettings(), ExposureConfigurationDetail.class);
        }
    }

    private void loadStudy() {
        if (this.mStudy == null) {
            this.mStudy = (StudyDetail) sJsonSerializer.fromJson(getPreferences().getRegion(""), StudyDetail.class);
        }
    }

    private void loadCitizenCode() {
        String citizenCode;
        if (this.mCitizenCode == null && (citizenCode = getPreferences().getCitizenCode("")) != null) {
            this.mCitizenCode = citizenCode;
        }
    }

    private void loadAppVersion() {
        try {
            this.mAppVersion = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Boolean getDebug() {
        return Boolean.valueOf((getApplicationInfo().flags & 2) != 0);
    }
}
