package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;
import com.android.tools.r8.GeneratedOutlineSupport;

@DoNotOptimize
@TargetApi(18)
public class Api18TraceUtils {
    public static void beginTraceSection(String str, String str2, String str3) {
        String outline9 = GeneratedOutlineSupport.outline9(str, str2, str3);
        if (outline9.length() > 127 && str2 != null) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15(str);
            outline15.append(str2.substring(0, (127 - str.length()) - str3.length()));
            outline15.append(str3);
            outline9 = outline15.toString();
        }
        Trace.beginSection(outline9);
    }
}
