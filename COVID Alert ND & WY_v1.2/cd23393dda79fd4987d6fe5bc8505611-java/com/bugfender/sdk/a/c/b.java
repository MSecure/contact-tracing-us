package com.bugfender.sdk.a.c;

import java.util.Arrays;

public class b {
    public static final char[] a;
    private static final char b;

    static {
        char[] charArray = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();
        a = charArray;
        b = charArray[0];
    }

    public static String a(byte[] bArr) {
        if (bArr.length == 0) {
            return "";
        }
        int i = 0;
        while (i < bArr.length && bArr[i] == 0) {
            i++;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        int length = copyOf.length * 2;
        char[] cArr = new char[length];
        int i2 = i;
        int i3 = length;
        while (i2 < copyOf.length) {
            i3--;
            cArr[i3] = a[a(copyOf, i2, 256, 58)];
            if (copyOf[i2] == 0) {
                i2++;
            }
        }
        while (i3 < length && cArr[i3] == b) {
            i3++;
        }
        while (true) {
            i--;
            if (i < 0) {
                return new String(cArr, i3, length - i3);
            }
            i3--;
            cArr[i3] = b;
        }
    }

    private static byte a(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i < bArr.length) {
            int i5 = (i4 * i2) + (bArr[i] & 255);
            bArr[i] = (byte) (i5 / i3);
            i4 = i5 % i3;
            i++;
        }
        return (byte) i4;
    }
}
