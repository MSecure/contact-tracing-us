package io.realm.log;

import android.util.Log;
import java.util.Locale;

public final class RealmLog {
    public static void error(String str, Object... objArr) {
        log(6, null, str, objArr);
    }

    public static void log(int i, Throwable th, String str, Object... objArr) {
        if (i >= nativeGetLogLevel()) {
            StringBuilder sb = new StringBuilder();
            if (!(str == null || objArr == null || objArr.length <= 0)) {
                str = String.format(Locale.US, str, objArr);
            }
            if (th != null) {
                sb.append(Log.getStackTraceString(th));
            }
            if (str != null) {
                if (th != null) {
                    sb.append("\n");
                }
                sb.append(str);
            }
            nativeLog(i, "REALM_JAVA", th, sb.toString());
        }
    }

    public static native void nativeAddLogger(RealmLogger realmLogger);

    public static native void nativeClearLoggers();

    public static native void nativeCloseCoreLoggerBridge(long j);

    public static native long nativeCreateCoreLoggerBridge(String str);

    public static native int nativeGetLogLevel();

    public static native void nativeLog(int i, String str, Throwable th, String str2);

    public static native void nativeLogToCoreLoggerBridge(long j, int i, String str);

    public static native void nativeRegisterDefaultLogger();

    public static native void nativeRemoveLogger(RealmLogger realmLogger);

    public static native void nativeSetLogLevel(int i);

    public static void warn(String str, Object... objArr) {
        log(5, null, str, objArr);
    }
}
