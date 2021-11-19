package com.google.android.gms.nearby.messages.internal;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public class zzb {
    private static final char[] zza = "0123456789abcdef".toCharArray();
    private final byte[] zzb;

    protected zzb(byte[] bArr) {
        this.zzb = bArr;
    }

    public static String zza(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            char[] cArr = zza;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & Ascii.SI]);
        }
        return sb.toString();
    }

    public static byte[] zza(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public final byte[] zza() {
        return this.zzb;
    }

    public final String zzb() {
        return zza(this.zzb);
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
        return Arrays.equals(this.zzb, ((zzb) obj).zzb);
    }

    public int hashCode() {
        return Arrays.hashCode(this.zzb);
    }

    public String toString() {
        return zza(this.zzb);
    }
}
