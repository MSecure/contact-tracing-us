package com.bugfender.sdk.a.a.e;

import com.bumptech.glide.load.Key;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.UUID;
import okio.Utf8;

public class d {

    private static class a {
        static final SecureRandom a = new SecureRandom();

        private a() {
        }
    }

    public static UUID a(UUID uuid) {
        byte[] bArr = new byte[16];
        a.a.nextBytes(bArr);
        bArr[6] = (byte) (bArr[6] & Ascii.SI);
        bArr[6] = (byte) (bArr[6] | SignedBytes.MAX_POWER_OF_TWO);
        bArr[8] = (byte) (bArr[8] & Utf8.REPLACEMENT_BYTE);
        bArr[8] = (byte) (bArr[8] | 128);
        return a(bArr);
    }

    public static UUID b(UUID uuid) {
        return a(uuid, UUID.randomUUID().toString());
    }

    public static UUID a(byte[] bArr) {
        Objects.requireNonNull(bArr, "name == null");
        try {
            return a(MessageDigest.getInstance("SHA-1").digest(bArr), 5);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static UUID a(UUID uuid, byte[] bArr) {
        Objects.requireNonNull(bArr, "name == null");
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            if (uuid == null) {
                instance.update(new byte[16]);
            } else {
                instance.update(a(uuid.getMostSignificantBits(), ByteOrder.BIG_ENDIAN));
                instance.update(a(uuid.getLeastSignificantBits(), ByteOrder.BIG_ENDIAN));
            }
            return a(instance.digest(bArr), 5);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static UUID a(String str) {
        return a(str.getBytes(Charset.forName(Key.STRING_CHARSET_NAME)));
    }

    public static UUID a(UUID uuid, String str) {
        return a(uuid, str.getBytes(Charset.forName(Key.STRING_CHARSET_NAME)));
    }

    static long a(byte[] bArr, int i, ByteOrder byteOrder) {
        long j = 0;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            for (int i2 = i; i2 < i + 8; i2++) {
                j = (j << 8) | (((long) bArr[i2]) & 255);
            }
        } else {
            for (int i3 = i + 7; i3 >= i; i3--) {
                j = (j << 8) | (((long) bArr[i3]) & 255);
            }
        }
        return j;
    }

    static void a(long j, byte[] bArr, int i, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            for (int i2 = i + 7; i2 >= i; i2--) {
                bArr[i2] = (byte) ((int) (j & 255));
                j >>= 8;
            }
            return;
        }
        for (int i3 = i; i3 < i + 8; i3++) {
            bArr[i3] = (byte) ((int) (j & 255));
            j >>= 8;
        }
    }

    static byte[] a(long j, ByteOrder byteOrder) {
        byte[] bArr = new byte[8];
        a(j, bArr, 0, byteOrder);
        return bArr;
    }

    static UUID a(byte[] bArr, int i) {
        long a2 = a(bArr, 0, ByteOrder.BIG_ENDIAN);
        long a3 = a(bArr, 8, ByteOrder.BIG_ENDIAN);
        return new UUID((((long) i) << 12) | (a2 & -61441), (4611686018427387903L & a3) | Long.MIN_VALUE);
    }
}
