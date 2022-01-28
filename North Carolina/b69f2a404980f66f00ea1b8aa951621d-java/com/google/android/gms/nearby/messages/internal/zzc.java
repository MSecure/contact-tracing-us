package com.google.android.gms.nearby.messages.internal;

import java.util.Arrays;

public class zzc {
    public static final char[] zza = "0123456789abcdef".toCharArray();
    public final byte[] zzb;

    public zzc(byte[] bArr) {
        this.zzb = bArr;
    }

    public static String zza(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(zza[(b2 >> 4) & 15]);
            sb.append(zza[b2 & 15]);
        }
        return sb.toString();
    }

    public static byte[] zza(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Character.digit(str.charAt(i2 + 1), 16) + (Character.digit(str.charAt(i2), 16) << 4));
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!obj.getClass().isAssignableFrom(getClass())) {
            return false;
        }
        return Arrays.equals(this.zzb, ((zzc) obj).zzb);
    }

    public int hashCode() {
        return Arrays.hashCode(this.zzb);
    }

    public String toString() {
        return zza(this.zzb);
    }

    public final byte[] zza() {
        return this.zzb;
    }

    public final String zzb() {
        return zza(this.zzb);
    }
}
