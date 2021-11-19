package com.bugfender.sdk.a.a.f.e;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    private static final Pattern d = Pattern.compile("(.)/(.*?)\\s*\\(([\\d\\s]+)\\):\\s(.*)");
    private final b a;
    private final String b;
    private final String c;

    public a(b bVar, String str, String str2) {
        this.a = bVar;
        this.b = str;
        this.c = str2;
    }

    public static a a(String str, int i) {
        Matcher matcher = d.matcher(str);
        if (!matcher.find()) {
            throw new com.bugfender.sdk.a.a.f.d.a("The trace is not valid");
        } else if (matcher.groupCount() >= 4) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            String group4 = matcher.group(4);
            try {
                if (Integer.valueOf(!TextUtils.isEmpty(group3) ? group3.trim() : "").intValue() == i) {
                    return new a(b.a(group.charAt(0)), group2, group4);
                }
                throw new com.bugfender.sdk.a.a.f.d.a("The trace is not valid");
            } catch (NumberFormatException unused) {
                throw new com.bugfender.sdk.a.a.f.d.a("The trace is not valid");
            }
        } else {
            throw new com.bugfender.sdk.a.a.f.d.a("The trace is not valid");
        }
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public b a() {
        return this.a;
    }
}
