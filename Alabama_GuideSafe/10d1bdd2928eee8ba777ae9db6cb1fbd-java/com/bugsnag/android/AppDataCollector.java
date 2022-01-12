package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppDataCollector.kt */
public final class AppDataCollector {
    public static final long startTimeMs = SystemClock.elapsedRealtime();
    public final ActivityManager activityManager;
    public ApplicationInfo appInfo;
    public final String appName;
    public String binaryArch;
    public String codeBundleId;
    public final ImmutableConfig config;
    public final Logger logger;
    public PackageInfo packageInfo;
    public final PackageManager packageManager;
    public final String packageName;
    public final String releaseStage;
    public final SessionTracker sessionTracker;
    public final String versionName;

    public AppDataCollector(Context context, PackageManager packageManager2, ImmutableConfig immutableConfig, SessionTracker sessionTracker2, ActivityManager activityManager2, Logger logger2) {
        String str;
        Intrinsics.checkParameterIsNotNull(context, "appContext");
        Intrinsics.checkParameterIsNotNull(immutableConfig, "config");
        Intrinsics.checkParameterIsNotNull(sessionTracker2, "sessionTracker");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        this.packageManager = packageManager2;
        this.config = immutableConfig;
        this.sessionTracker = sessionTracker2;
        this.activityManager = activityManager2;
        this.logger = logger2;
        String packageName2 = context.getPackageName();
        Intrinsics.checkExpressionValueIsNotNull(packageName2, "appContext.packageName");
        this.packageName = packageName2;
        PackageManager packageManager3 = this.packageManager;
        boolean z = false;
        String str2 = null;
        this.packageInfo = packageManager3 != null ? packageManager3.getPackageInfo(packageName2, 0) : null;
        PackageManager packageManager4 = this.packageManager;
        ApplicationInfo applicationInfo = packageManager4 != null ? packageManager4.getApplicationInfo(this.packageName, 0) : null;
        this.appInfo = applicationInfo;
        if (!(this.packageManager == null || applicationInfo == null)) {
            z = true;
        }
        if (z) {
            PackageManager packageManager5 = this.packageManager;
            str = String.valueOf(packageManager5 != null ? packageManager5.getApplicationLabel(this.appInfo) : null);
        } else {
            str = null;
        }
        this.appName = str;
        ImmutableConfig immutableConfig2 = this.config;
        this.releaseStage = immutableConfig2.releaseStage;
        String str3 = immutableConfig2.appVersion;
        if (str3 != null) {
            str2 = str3;
        } else {
            PackageInfo packageInfo2 = this.packageInfo;
            if (packageInfo2 != null) {
                str2 = packageInfo2.versionName;
            }
        }
        this.versionName = str2;
    }

    public final AppWithState generateAppWithState() {
        Long valueOf;
        ImmutableConfig immutableConfig = this.config;
        String str = this.binaryArch;
        String str2 = this.packageName;
        String str3 = this.releaseStage;
        String str4 = this.versionName;
        String str5 = this.codeBundleId;
        Long valueOf2 = Long.valueOf(SystemClock.elapsedRealtime() - startTimeMs);
        long currentTimeMillis = System.currentTimeMillis();
        SessionTracker sessionTracker2 = this.sessionTracker;
        long j = sessionTracker2.lastEnteredForegroundMs.get();
        Boolean isInForeground = sessionTracker2.isInForeground();
        if (isInForeground == null) {
            valueOf = null;
        } else {
            long j2 = 0;
            long j3 = (!isInForeground.booleanValue() || j == 0) ? 0 : currentTimeMillis - j;
            if (j3 > 0) {
                j2 = j3;
            }
            valueOf = Long.valueOf(j2);
        }
        return new AppWithState(immutableConfig, str, str2, str3, str4, str5, valueOf2, valueOf, this.sessionTracker.isInForeground());
    }

    public final Map<String, Object> getAppDataMetadata() {
        Boolean bool;
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.appName);
        hashMap.put("activeScreen", this.sessionTracker.getContextActivity());
        Runtime runtime = Runtime.getRuntime();
        hashMap.put("memoryUsage", Long.valueOf(runtime.totalMemory() - runtime.freeMemory()));
        try {
            if (this.activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                this.activityManager.getMemoryInfo(memoryInfo);
                bool = Boolean.valueOf(memoryInfo.lowMemory);
                hashMap.put("lowMemory", bool);
                return hashMap;
            }
        } catch (Exception unused) {
            this.logger.w("Could not check lowMemory status");
        }
        bool = null;
        hashMap.put("lowMemory", bool);
        return hashMap;
    }
}
