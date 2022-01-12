package com.facebook.react.modules.systeminfo;

import android.os.Build;
import com.facebook.common.logging.FLog;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;

public class AndroidInfoHelpers {
    public static String metroHostPropValue;

    public static String getFriendlyDeviceName() {
        if (Build.FINGERPRINT.contains("vbox")) {
            return Build.MODEL;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0061, code lost:
        if (r2 == null) goto L_0x0066;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e A[SYNTHETIC, Splitter:B:32:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00aa A[SYNTHETIC, Splitter:B:54:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00af  */
    public static String getServerIpAddress(int i) {
        String str;
        Throwable th;
        Process process;
        BufferedReader bufferedReader;
        Exception e;
        synchronized (AndroidInfoHelpers.class) {
            if (metroHostPropValue != null) {
                str = metroHostPropValue;
            } else {
                BufferedReader bufferedReader2 = null;
                try {
                    process = Runtime.getRuntime().exec(new String[]{"/system/bin/getprop", "metro.host"});
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName(RNCWebViewManager.HTML_ENCODING)));
                        String str2 = "";
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                str2 = readLine;
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    FLog.w("AndroidInfoHelpers", "Failed to query for metro.host prop:", e);
                                    metroHostPropValue = "";
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception unused) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    process = process;
                                    bufferedReader2 = bufferedReader;
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    if (process != null) {
                                        process.destroy();
                                    }
                                    throw th;
                                }
                            }
                        }
                        metroHostPropValue = str2;
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    } catch (Exception e3) {
                        bufferedReader = null;
                        e = e3;
                        FLog.w("AndroidInfoHelpers", "Failed to query for metro.host prop:", e);
                        metroHostPropValue = "";
                        if (bufferedReader != null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedReader2 != null) {
                        }
                        if (process != null) {
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    bufferedReader = null;
                    e = e4;
                    process = null;
                    FLog.w("AndroidInfoHelpers", "Failed to query for metro.host prop:", e);
                    metroHostPropValue = "";
                    if (bufferedReader != null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    process = null;
                    if (bufferedReader2 != null) {
                    }
                    if (process != null) {
                    }
                    throw th;
                }
                process.destroy();
                str = metroHostPropValue;
            }
        }
        if (str.equals("")) {
            if (Build.FINGERPRINT.contains("vbox")) {
                str = "10.0.3.2";
            } else {
                str = Build.FINGERPRINT.contains("generic") ? "10.0.2.2" : "localhost";
            }
        }
        return String.format(Locale.US, "%s:%d", str, Integer.valueOf(i));
    }
}
