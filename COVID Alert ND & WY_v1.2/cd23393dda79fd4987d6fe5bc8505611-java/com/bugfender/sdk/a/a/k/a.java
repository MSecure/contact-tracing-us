package com.bugfender.sdk.a.a.k;

import android.text.TextUtils;
import com.bugfender.android.BuildConfig;
import java.net.MalformedURLException;
import java.net.URL;

public class a {
    public com.bugfender.sdk.a.a.i.d.a a(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = BuildConfig.BUGFENDER_API_URL;
            }
            return new com.bugfender.sdk.a.a.i.d.a(new URL(str), str2, str3);
        } catch (MalformedURLException unused) {
            throw new IllegalArgumentException("Illegal URL");
        }
    }
}
