package com.bugsnag.android;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.provider.Settings;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.RecyclerView;
import com.horcrux.svg.PathParser;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: DeviceDataCollector.kt */
public final class DeviceDataCollector {
    public static final String[] ROOT_INDICATORS = {"/system/xbin/su", "/system/bin/su", "/system/app/Superuser.apk", "/system/app/SuperSU.apk", "/system/app/Superuser", "/system/app/SuperSU", "/system/xbin/daemonsu", "/su/bin"};
    public final Context appContext;
    public final DeviceBuildInfo buildInfo;
    public final Connectivity connectivity;
    public final String[] cpuAbi;
    public final File dataDirectory;
    public final DisplayMetrics displayMetrics;
    public final Integer dpi;
    public final boolean emulator;
    public final String installId;
    public final String locale;
    public final Logger logger;
    public final Resources resources;
    public final boolean rooted;
    public final Map<String, Object> runtimeVersions;
    public final Float screenDensity;
    public final String screenResolution;

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x011e  */
    public DeviceDataCollector(Connectivity connectivity2, Context context, Resources resources2, String str, DeviceBuildInfo deviceBuildInfo, File file, Logger logger2) {
        boolean z;
        DisplayMetrics displayMetrics2;
        Integer num;
        String str2;
        Intrinsics.checkParameterIsNotNull(connectivity2, "connectivity");
        Intrinsics.checkParameterIsNotNull(context, "appContext");
        Intrinsics.checkParameterIsNotNull(str, "installId");
        Intrinsics.checkParameterIsNotNull(deviceBuildInfo, "buildInfo");
        Intrinsics.checkParameterIsNotNull(file, "dataDirectory");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        this.connectivity = connectivity2;
        this.appContext = context;
        this.resources = resources2;
        this.installId = str;
        this.buildInfo = deviceBuildInfo;
        this.dataDirectory = file;
        this.logger = logger2;
        String str3 = null;
        this.displayMetrics = resources2 != null ? resources2.getDisplayMetrics() : null;
        String str4 = this.buildInfo.fingerprint;
        this.emulator = str4 != null && (PathParser.startsWith$default(str4, "unknown", false, 2) || StringsKt__StringsKt.contains$default(str4, "generic", false, 2) || StringsKt__StringsKt.contains$default(str4, "vbox", false, 2));
        String str5 = this.buildInfo.tags;
        if (str5 == null || !StringsKt__StringsKt.contains$default(str5, "test-keys", false, 2)) {
            try {
                String[] strArr = ROOT_INDICATORS;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (new File(strArr[i]).exists()) {
                        break;
                    } else {
                        i++;
                    }
                }
            } catch (Throwable th) {
                PathParser.createFailure(th);
            }
            z = false;
            this.rooted = z;
            DisplayMetrics displayMetrics3 = this.displayMetrics;
            this.screenDensity = displayMetrics3 == null ? Float.valueOf(displayMetrics3.density) : null;
            DisplayMetrics displayMetrics4 = this.displayMetrics;
            this.dpi = displayMetrics4 == null ? Integer.valueOf(displayMetrics4.densityDpi) : null;
            displayMetrics2 = this.displayMetrics;
            if (displayMetrics2 != null) {
                int max = Math.max(displayMetrics2.widthPixels, displayMetrics2.heightPixels);
                DisplayMetrics displayMetrics5 = this.displayMetrics;
                int min = Math.min(displayMetrics5.widthPixels, displayMetrics5.heightPixels);
                Locale locale2 = Locale.US;
                Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.US");
                str3 = String.format(locale2, "%dx%d", Arrays.copyOf(new Object[]{Integer.valueOf(max), Integer.valueOf(min)}, 2));
                Intrinsics.checkExpressionValueIsNotNull(str3, "java.lang.String.format(locale, format, *args)");
            }
            this.screenResolution = str3;
            String locale3 = Locale.getDefault().toString();
            Intrinsics.checkExpressionValueIsNotNull(locale3, "Locale.getDefault().toString()");
            this.locale = locale3;
            String[] strArr2 = this.buildInfo.cpuAbis;
            this.cpuAbi = strArr2 == null ? new String[0] : strArr2;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            num = this.buildInfo.apiLevel;
            if (num != null) {
                linkedHashMap.put("androidApiLevel", Integer.valueOf(num.intValue()));
            }
            str2 = this.buildInfo.osBuild;
            if (str2 != null) {
                linkedHashMap.put("osBuild", str2);
            }
            this.runtimeVersions = linkedHashMap;
        }
        z = true;
        this.rooted = z;
        DisplayMetrics displayMetrics32 = this.displayMetrics;
        this.screenDensity = displayMetrics32 == null ? Float.valueOf(displayMetrics32.density) : null;
        DisplayMetrics displayMetrics42 = this.displayMetrics;
        this.dpi = displayMetrics42 == null ? Integer.valueOf(displayMetrics42.densityDpi) : null;
        displayMetrics2 = this.displayMetrics;
        if (displayMetrics2 != null) {
        }
        this.screenResolution = str3;
        String locale32 = Locale.getDefault().toString();
        Intrinsics.checkExpressionValueIsNotNull(locale32, "Locale.getDefault().toString()");
        this.locale = locale32;
        String[] strArr22 = this.buildInfo.cpuAbis;
        this.cpuAbi = strArr22 == null ? new String[0] : strArr22;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        num = this.buildInfo.apiLevel;
        if (num != null) {
        }
        str2 = this.buildInfo.osBuild;
        if (str2 != null) {
        }
        this.runtimeVersions = linkedHashMap2;
    }

    public final String calculateOrientation$bugsnag_android_core_release() {
        Configuration configuration;
        Resources resources2 = this.resources;
        Integer valueOf = (resources2 == null || (configuration = resources2.getConfiguration()) == null) ? null : Integer.valueOf(configuration.orientation);
        if (valueOf != null && valueOf.intValue() == 2) {
            return "landscape";
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            return "portrait";
        }
        return null;
    }

    public final long calculateTotalMemory() {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        return maxMemory != RecyclerView.FOREVER_NS ? maxMemory : runtime.totalMemory();
    }

    public final Device generateDevice() {
        return new Device(this.buildInfo, this.cpuAbi, Boolean.valueOf(this.rooted), this.installId, this.locale, Long.valueOf(calculateTotalMemory()), PathParser.toMutableMap(this.runtimeVersions));
    }

    public final DeviceWithState generateDeviceWithState(long j) {
        long j2;
        DeviceBuildInfo deviceBuildInfo = this.buildInfo;
        Boolean valueOf = Boolean.valueOf(this.rooted);
        String str = this.installId;
        String str2 = this.locale;
        Long valueOf2 = Long.valueOf(calculateTotalMemory());
        Map mutableMap = PathParser.toMutableMap(this.runtimeVersions);
        Long valueOf3 = Long.valueOf(this.dataDirectory.getUsableSpace());
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        if (maxMemory != RecyclerView.FOREVER_NS) {
            j2 = runtime.freeMemory() + (maxMemory - runtime.totalMemory());
        } else {
            j2 = runtime.freeMemory();
        }
        return new DeviceWithState(deviceBuildInfo, valueOf, str, str2, valueOf2, mutableMap, valueOf3, Long.valueOf(j2), calculateOrientation$bugsnag_android_core_release(), new Date(j));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046 A[Catch:{ Exception -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076 A[Catch:{ Exception -> 0x0086 }] */
    public final Map<String, Object> getDeviceMetadata() {
        Float f;
        Boolean bool;
        String string;
        String str;
        Intent registerReceiver;
        boolean z;
        HashMap hashMap = new HashMap();
        String str2 = null;
        try {
            Intent registerReceiver2 = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver2 != null) {
                f = Float.valueOf(((float) registerReceiver2.getIntExtra("level", -1)) / ((float) registerReceiver2.getIntExtra("scale", -1)));
                hashMap.put("batteryLevel", f);
                boolean z2 = false;
                registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (registerReceiver != null) {
                    int intExtra = registerReceiver.getIntExtra("status", -1);
                    if (intExtra != 2) {
                        if (intExtra != 5) {
                            z = false;
                            bool = Boolean.valueOf(z);
                            hashMap.put("charging", bool);
                            string = Settings.Secure.getString(this.appContext.getContentResolver(), "location_providers_allowed");
                            if (string != null) {
                                if (string.length() > 0) {
                                    z2 = true;
                                }
                                if (z2) {
                                    str = "allowed";
                                    str2 = str;
                                    hashMap.put("locationStatus", str2);
                                    hashMap.put("networkAccess", this.connectivity.retrieveNetworkAccessState());
                                    hashMap.put("brand", this.buildInfo.brand);
                                    hashMap.put("screenDensity", this.screenDensity);
                                    hashMap.put("dpi", this.dpi);
                                    hashMap.put("emulator", Boolean.valueOf(this.emulator));
                                    hashMap.put("screenResolution", this.screenResolution);
                                    return hashMap;
                                }
                            }
                            str = "disallowed";
                            str2 = str;
                            hashMap.put("locationStatus", str2);
                            hashMap.put("networkAccess", this.connectivity.retrieveNetworkAccessState());
                            hashMap.put("brand", this.buildInfo.brand);
                            hashMap.put("screenDensity", this.screenDensity);
                            hashMap.put("dpi", this.dpi);
                            hashMap.put("emulator", Boolean.valueOf(this.emulator));
                            hashMap.put("screenResolution", this.screenResolution);
                            return hashMap;
                        }
                    }
                    z = true;
                    bool = Boolean.valueOf(z);
                    hashMap.put("charging", bool);
                    string = Settings.Secure.getString(this.appContext.getContentResolver(), "location_providers_allowed");
                    if (string != null) {
                    }
                    str = "disallowed";
                    str2 = str;
                    hashMap.put("locationStatus", str2);
                    hashMap.put("networkAccess", this.connectivity.retrieveNetworkAccessState());
                    hashMap.put("brand", this.buildInfo.brand);
                    hashMap.put("screenDensity", this.screenDensity);
                    hashMap.put("dpi", this.dpi);
                    hashMap.put("emulator", Boolean.valueOf(this.emulator));
                    hashMap.put("screenResolution", this.screenResolution);
                    return hashMap;
                }
                bool = null;
                hashMap.put("charging", bool);
                string = Settings.Secure.getString(this.appContext.getContentResolver(), "location_providers_allowed");
                if (string != null) {
                }
                str = "disallowed";
                str2 = str;
                hashMap.put("locationStatus", str2);
                hashMap.put("networkAccess", this.connectivity.retrieveNetworkAccessState());
                hashMap.put("brand", this.buildInfo.brand);
                hashMap.put("screenDensity", this.screenDensity);
                hashMap.put("dpi", this.dpi);
                hashMap.put("emulator", Boolean.valueOf(this.emulator));
                hashMap.put("screenResolution", this.screenResolution);
                return hashMap;
            }
        } catch (Exception unused) {
            this.logger.w("Could not get batteryLevel");
        }
        f = null;
        hashMap.put("batteryLevel", f);
        boolean z22 = false;
        try {
            registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
            }
        } catch (Exception unused2) {
            this.logger.w("Could not get charging status");
        }
        bool = null;
        hashMap.put("charging", bool);
        try {
            string = Settings.Secure.getString(this.appContext.getContentResolver(), "location_providers_allowed");
            if (string != null) {
            }
            str = "disallowed";
            str2 = str;
        } catch (Exception unused3) {
            this.logger.w("Could not get locationStatus");
        }
        hashMap.put("locationStatus", str2);
        hashMap.put("networkAccess", this.connectivity.retrieveNetworkAccessState());
        hashMap.put("brand", this.buildInfo.brand);
        hashMap.put("screenDensity", this.screenDensity);
        hashMap.put("dpi", this.dpi);
        hashMap.put("emulator", Boolean.valueOf(this.emulator));
        hashMap.put("screenResolution", this.screenResolution);
        return hashMap;
    }
}
