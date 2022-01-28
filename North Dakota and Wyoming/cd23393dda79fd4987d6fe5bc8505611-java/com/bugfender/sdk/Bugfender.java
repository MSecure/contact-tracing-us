package com.bugfender.sdk;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bugfender.android.BuildConfig;
import com.bugfender.sdk.a.a.f.b;
import com.bugfender.sdk.a.a.f.c;
import com.bugfender.sdk.a.a.h.f;
import com.bugfender.sdk.a.a.h.g;
import com.bugfender.sdk.a.b.a;
import com.bugfender.sdk.a.c.d;
import com.bugfender.sdk.ui.FeedbackActivity;
import com.bugfender.sdk.ui.FeedbackStyle;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Executors;

public class Bugfender {
    private static final String TAG = "Bugfender";
    private static String apiUrl = null;
    private static String baseUrl = null;
    private static boolean debug = false;
    private static String deviceName = null;
    private static boolean isCheckBugfenderInitializerLogPrinted = false;
    private static boolean isUIEventLoggingEnabled = false;
    private static b logcatManager;
    private static com.bugfender.sdk.a.a.b loggerManager;
    private static d mainThread;

    /* renamed from: com.bugfender.sdk.Bugfender$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bugfender$sdk$LogLevel;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$bugfender$sdk$LogLevel = iArr;
            iArr[LogLevel.Debug.ordinal()] = 1;
            $SwitchMap$com$bugfender$sdk$LogLevel[LogLevel.Warning.ordinal()] = 2;
            try {
                $SwitchMap$com$bugfender$sdk$LogLevel[LogLevel.Error.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static void d(String str, String str2) {
        if (isBugfenderInitialized()) {
            if (shouldPrintLogcatLog()) {
                Log.d("BF/" + str, str2 == null ? "" : str2);
            }
            if (shouldSendBugfenderLog()) {
                loggerManager.a(str, str2);
            }
        }
    }

    public static void disableReflection(boolean z) {
        if (isBugfenderInitialized()) {
            loggerManager.a(z);
        }
    }

    public static void e(String str, String str2) {
        if (isBugfenderInitialized()) {
            if (shouldPrintLogcatLog()) {
                Log.e("BF/" + str, str2 == null ? "" : str2);
            }
            if (shouldSendBugfenderLog()) {
                loggerManager.b(str, str2);
            }
        }
    }

    public static void enableCrashReporting() {
        if (isBugfenderInitialized()) {
            loggerManager.a();
        }
    }

    public static void enableLogcatLogging() {
        if (isBugfenderInitialized()) {
            logcatManager.a();
        }
    }

    public static void enableUIEventLogging(Application application) {
        if (isBugfenderInitialized() && !isUIEventLoggingEnabled) {
            isUIEventLoggingEnabled = true;
            application.registerActivityLifecycleCallbacks(new a(loggerManager, mainThread, shouldPrintLogcatLog(), shouldSendBugfenderLog()));
        }
    }

    public static void f(String str, String str2) {
        if (isBugfenderInitialized()) {
            if (shouldPrintLogcatLog()) {
                Log.d("BF/" + str, str2 == null ? "" : str2);
            }
            if (shouldSendBugfenderLog()) {
                loggerManager.c(str, str2);
            }
        }
    }

    public static void forceSendOnce() {
        if (isBugfenderInitialized()) {
            loggerManager.b();
            if (debug) {
                Log.i(TAG, "Synchronizing all the logs and issues");
            }
        }
    }

    public static URL getDeviceUrl() {
        if (isBugfenderInitialized()) {
            return loggerManager.d();
        }
        return null;
    }

    private static String getProcessName(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static URL getSessionUrl() {
        if (isBugfenderInitialized()) {
            return loggerManager.f();
        }
        return null;
    }

    public static Intent getUserFeedbackActivityIntent(Context context, String str, String str2, String str3, String str4, String str5) {
        return getUserFeedbackActivityIntent(context, str, str2, str3, str4, str5, null);
    }

    public static void i(String str, String str2) {
        if (isBugfenderInitialized()) {
            if (shouldPrintLogcatLog()) {
                Log.d("BF/" + str, str2 == null ? "" : str2);
            }
            if (shouldSendBugfenderLog()) {
                loggerManager.d(str, str2);
            }
        }
    }

    public static synchronized void init(Context context, String str, boolean z) {
        synchronized (Bugfender.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (logcatManager == null) {
                        try {
                            context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                            if (isMainProcess(context)) {
                                debug = z;
                                com.bugfender.sdk.a.e.a aVar = new com.bugfender.sdk.a.e.a();
                                com.bugfender.sdk.a.a.k.a aVar2 = new com.bugfender.sdk.a.a.k.a();
                                com.bugfender.sdk.a.a.c.e.b b = aVar.b();
                                com.bugfender.sdk.a.a.c.e.a a = aVar.a(b);
                                com.bugfender.sdk.a.a.c.f.b d = aVar.d();
                                com.bugfender.sdk.a.a.c.f.a a2 = aVar.a(d);
                                com.bugfender.sdk.a.a.c.d.b a3 = aVar.a();
                                com.bugfender.sdk.a.a.j.b a4 = aVar.a(context, b, a, d, a2, a3, aVar.a(a3));
                                com.bugfender.sdk.a.a.i.d.a a5 = aVar2.a(apiUrl, String.valueOf((int) BuildConfig.VERSION_CODE), str);
                                apiUrl = null;
                                com.bugfender.sdk.a.a.b bVar = new com.bugfender.sdk.a.a.b(str, a4, new com.bugfender.sdk.a.a.i.a(a5), aVar.a(context), aVar.c(context), aVar.a(context, aVar.b(context), aVar.d(context)), aVar.a(str, baseUrl), deviceName);
                                loggerManager = bVar;
                                baseUrl = null;
                                bVar.a(com.bugfender.sdk.a.a.b.y);
                                logcatManager = new c(context.getPackageName(), loggerManager, Executors.newSingleThreadExecutor());
                                mainThread = aVar.c();
                            }
                        } catch (SecurityException unused) {
                        }
                    }
                    return;
                }
            }
            Log.w(TAG, "WARNING: The Bugfender sdk is not initialized. The context or application token provided is null.");
        }
    }

    private static boolean isBugfenderInitialized() {
        if (loggerManager != null) {
            return true;
        }
        if (isCheckBugfenderInitializerLogPrinted) {
            return false;
        }
        isCheckBugfenderInitializerLogPrinted = true;
        Log.w(TAG, "WARNING: Bugfender SDK is not initialized. You should call first to the method Bugfender.init()");
        return false;
    }

    private static boolean isMainProcess(Context context) {
        String processName = getProcessName(context);
        if (processName == null) {
            Log.w(TAG, "WARNING: Bugfender SDK couldn't be initialized.");
        }
        return processName != null && context.getPackageName().equals(processName);
    }

    private static boolean isRelease() {
        return !debug;
    }

    private static boolean isValidUrl(String str) {
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    public static void log(int i, String str, String str2, LogLevel logLevel, String str3, String str4) {
        if (isBugfenderInitialized()) {
            if (shouldPrintLogcatLog()) {
                int i2 = AnonymousClass1.$SwitchMap$com$bugfender$sdk$LogLevel[logLevel.ordinal()];
                if (i2 == 1) {
                    Log.d(str3, str4);
                } else if (i2 == 2) {
                    Log.w(str3, str4);
                } else if (i2 == 3) {
                    Log.e(str3, str4);
                }
            }
            if (shouldSendBugfenderLog()) {
                loggerManager.a(i, str, str2, g.c.a(logLevel), str3, str4);
            }
        }
    }

    public static void overrideDeviceName(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "WARNING: deviceName can not be empty or null. Bugfender.overrideDeviceName() is ignored");
            return;
        }
        deviceName = str;
        if (isBugfenderInitialized()) {
            Log.w(TAG, "WARNING: Bugfender.overrideDeviceName() must be called before the method Bugfender.init(), ignoring this call");
        }
    }

    public static void removeDeviceKey(String str) {
        if (isBugfenderInitialized()) {
            loggerManager.a(str);
        }
    }

    public static URL sendCrash(String str, String str2) {
        if (!isBugfenderInitialized()) {
            return null;
        }
        URL e = loggerManager.e(str, str2);
        loggerManager.b();
        if (debug) {
            String str3 = TAG;
            Log.e(str3, "Reported crash with Title: " + str + " and Message: " + str2);
        }
        return e;
    }

    public static URL sendIssue(String str, String str2) {
        if (!isBugfenderInitialized()) {
            return null;
        }
        URL g = loggerManager.g(str, str2);
        loggerManager.b();
        if (debug) {
            String str3 = TAG;
            Log.e(str3, "Reported issue with Title: " + str + " and Message: " + str2);
        }
        return g;
    }

    public static URL sendUserFeedback(String str, String str2) {
        if (!isBugfenderInitialized()) {
            return null;
        }
        URL i = loggerManager.i(str, str2);
        loggerManager.b();
        if (debug) {
            String str3 = TAG;
            Log.e(str3, "Reported feedback with Title: " + str + " and Message: " + str2);
        }
        return i;
    }

    public static void setApiUrl(String str) {
        if (isBugfenderInitialized()) {
            Log.w(TAG, "WARNING: Bugfender SDK is already initialized. You should call this method before Bugfender.init()");
        } else if (isValidUrl(str)) {
            apiUrl = str;
        } else {
            Log.e(TAG, "The custom URL you have passed is malformed. Using default one.");
        }
    }

    public static void setBaseUrl(String str) {
        if (isBugfenderInitialized()) {
            Log.w(TAG, "WARNING: Bugfender SDK is already initialized. You should call this method before Bugfender.init()");
        } else if (isValidUrl(str)) {
            baseUrl = str;
        } else {
            Log.e(TAG, "The custom URL you have passed is malformed. Using default one.");
        }
    }

    public static void setDeviceBoolean(String str, boolean z) {
        if (isBugfenderInitialized()) {
            loggerManager.a(new f(str, Boolean.valueOf(z)));
        }
    }

    public static void setDeviceFloat(String str, Float f) {
        if (isBugfenderInitialized()) {
            loggerManager.a(new f(str, f));
        }
    }

    public static void setDeviceInteger(String str, Integer num) {
        if (isBugfenderInitialized()) {
            loggerManager.a(new f(str, num));
        }
    }

    public static void setDeviceString(String str, String str2) {
        if (isBugfenderInitialized()) {
            loggerManager.a(new f(str, str2));
        }
    }

    public static void setForceEnabled(boolean z) {
        if (isBugfenderInitialized()) {
            isBugfenderInitialized();
            loggerManager.b(z);
            if (debug) {
                String str = TAG;
                Log.i(str, "Force enable: " + z);
            }
        }
    }

    public static void setMaximumLocalStorageSize(long j) {
        if (!isBugfenderInitialized()) {
            return;
        }
        if (j >= 0) {
            loggerManager.a(j);
            return;
        }
        throw new IllegalArgumentException("The maximum size should be a positive number");
    }

    private static boolean shouldPrintLogcatLog() {
        return !isRelease();
    }

    private static boolean shouldSendBugfenderLog() {
        return true;
    }

    public static void t(String str, String str2) {
        if (isBugfenderInitialized()) {
            if (shouldPrintLogcatLog()) {
                Log.d("BF/" + str, str2 == null ? "" : str2);
            }
            if (shouldSendBugfenderLog()) {
                loggerManager.j(str, str2);
            }
        }
    }

    public static void w(String str, String str2) {
        if (isBugfenderInitialized()) {
            if (shouldPrintLogcatLog()) {
                Log.w("BF/" + str, str2 == null ? "" : str2);
            }
            if (shouldSendBugfenderLog()) {
                loggerManager.k(str, str2);
            }
        }
    }

    public static Intent getUserFeedbackActivityIntent(Context context, String str, String str2, String str3, String str4, String str5, FeedbackStyle feedbackStyle) {
        return FeedbackActivity.getIntent(context, str, str2, str3, str4, str5, feedbackStyle);
    }
}
