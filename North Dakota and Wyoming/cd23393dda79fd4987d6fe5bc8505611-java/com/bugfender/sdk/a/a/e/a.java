package com.bugfender.sdk.a.a.e;

import com.bugfender.sdk.a.a.j.c;
import com.bumptech.glide.load.Key;
import java.nio.charset.Charset;

public class a {
    private static final int a = (c.h - 1024);

    private static int a(String str) {
        return str.getBytes().length;
    }

    public static boolean b(String str) {
        return a(str) > a;
    }

    public static String c(String str) {
        int a2 = a("…");
        return b(str, a - a2) + "…";
    }

    private static String a(String str, int i) {
        String substring = str.substring(0, (int) Math.round(((double) (((long) str.length()) * ((long) i))) / ((double) str.getBytes().length)));
        while (substring.getBytes().length > i) {
            substring = substring.substring(0, substring.length() - 1);
        }
        return substring;
    }

    private static String b(String str, int i) {
        if (Charset.defaultCharset().displayName().equals(Key.STRING_CHARSET_NAME)) {
            return c(str, i);
        }
        return a(str, i);
    }

    private static String c(String str, int i) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (i4 < str.length()) {
            char charAt = str.charAt(i4);
            if (charAt <= 127) {
                i2 = 0;
                i3 = 1;
            } else {
                if (charAt <= 2047) {
                    i3 = 2;
                } else if (charAt > 55295 && charAt <= 57343) {
                    i3 = 4;
                    i2 = 1;
                } else {
                    i3 = 3;
                }
                i2 = 0;
            }
            i5 += i3;
            if (i5 > i) {
                return str.substring(0, i4);
            }
            i4 = i4 + i2 + 1;
        }
        return str;
    }
}
