package c.b.c.a.m0;

import gov.michigan.MiCovidExposure.BuildConfig;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class d implements c.b.c.a.a {

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadLocal<Cipher> f5111e = new a();

    /* renamed from: f  reason: collision with root package name */
    public static final ThreadLocal<Cipher> f5112f = new b();

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f5113a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f5114b;

    /* renamed from: c  reason: collision with root package name */
    public final SecretKeySpec f5115c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5116d;

    public class a extends ThreadLocal<Cipher> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return a0.f5097f.a("AES/ECB/NOPADDING");
            } catch (GeneralSecurityException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public class b extends ThreadLocal<Cipher> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return a0.f5097f.a("AES/CTR/NOPADDING");
            } catch (GeneralSecurityException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public d(byte[] bArr, int i) {
        if (i == 12 || i == 16) {
            this.f5116d = i;
            n0.a(bArr.length);
            this.f5115c = new SecretKeySpec(bArr, "AES");
            Cipher cipher = f5111e.get();
            cipher.init(1, this.f5115c);
            byte[] c2 = c(cipher.doFinal(new byte[16]));
            this.f5113a = c2;
            this.f5114b = c(c2);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) (((bArr[i2] << 1) ^ ((bArr[i3] & 255) >>> 7)) & BuildConfig.VERSION_CODE);
            i2 = i3;
        }
        int i4 = bArr[15] << 1;
        if ((bArr[0] & 128) != 0) {
            i = 135;
        }
        bArr2[15] = (byte) (i4 ^ i);
        return bArr2;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    @Override // c.b.c.a.a
    public byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.f5116d;
        if (length <= (Integer.MAX_VALUE - i) - 16) {
            byte[] bArr3 = new byte[(bArr.length + i + 16)];
            byte[] a2 = i0.a(i);
            System.arraycopy(a2, 0, bArr3, 0, this.f5116d);
            Cipher cipher = f5111e.get();
            cipher.init(1, this.f5115c);
            byte[] d2 = d(cipher, 0, a2, 0, a2.length);
            byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
            byte[] d3 = d(cipher, 1, bArr4, 0, bArr4.length);
            Cipher cipher2 = f5112f.get();
            cipher2.init(1, this.f5115c, new IvParameterSpec(d2));
            cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.f5116d);
            byte[] d4 = d(cipher, 2, bArr3, this.f5116d, bArr.length);
            int length2 = bArr.length + this.f5116d;
            for (int i2 = 0; i2 < 16; i2++) {
                bArr3[length2 + i2] = (byte) ((d3[i2] ^ d2[i2]) ^ d4[i2]);
            }
            return bArr3;
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // c.b.c.a.a
    public byte[] b(byte[] bArr, byte[] bArr2) {
        int length = (bArr.length - this.f5116d) - 16;
        if (length >= 0) {
            Cipher cipher = f5111e.get();
            cipher.init(1, this.f5115c);
            byte[] d2 = d(cipher, 0, bArr, 0, this.f5116d);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] d3 = d(cipher, 1, bArr2, 0, bArr2.length);
            byte[] d4 = d(cipher, 2, bArr, this.f5116d, length);
            int length2 = bArr.length - 16;
            byte b2 = 0;
            for (int i = 0; i < 16; i++) {
                b2 = (byte) (b2 | (((bArr[length2 + i] ^ d3[i]) ^ d2[i]) ^ d4[i]));
            }
            if (b2 == 0) {
                Cipher cipher2 = f5112f.get();
                cipher2.init(1, this.f5115c, new IvParameterSpec(d2));
                return cipher2.doFinal(bArr, this.f5116d, length);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final byte[] d(Cipher cipher, int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(e(bArr3, this.f5113a));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                doFinal[i5] = (byte) (doFinal[i5] ^ bArr[(i2 + i4) + i5]);
            }
            doFinal = cipher.doFinal(doFinal);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = e(copyOfRange, this.f5113a);
        } else {
            byte[] copyOf = Arrays.copyOf(this.f5114b, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(e(doFinal, bArr2));
    }
}
