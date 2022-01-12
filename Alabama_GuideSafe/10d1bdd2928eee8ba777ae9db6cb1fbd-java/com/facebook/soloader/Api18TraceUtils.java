package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;
import com.android.tools.r8.GeneratedOutlineSupport;

@DoNotOptimize
@TargetApi(18)
public class Api18TraceUtils {
    public static void beginTraceSection(String str, String str2, String str3) {
        String outline11 = GeneratedOutlineSupport.outline11(str, str2, str3);
        if (outline11.length() > 127 && str2 != null) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17(str);
            outline17.append(str2.substring(0, (127 - str.length()) - str3.length()));
            outline17.append(str3);
            outline11 = outline17.toString();
        }
        Trace.beginSection(outline11);
    }
}
