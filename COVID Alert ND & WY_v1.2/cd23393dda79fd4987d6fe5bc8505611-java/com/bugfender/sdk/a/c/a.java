package com.bugfender.sdk.a.c;

import com.bugfender.sdk.a.a.e.g.b;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class a {
    public static String a(String str) {
        try {
            return b.a(b(str)).substring(0, 10);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static byte[] b(String str) {
        return MessageDigest.getInstance("SHA-256").digest(str.getBytes(b.a));
    }
}
