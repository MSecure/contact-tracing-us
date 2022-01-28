package c.b.c.a.m0;

import c.a.a.a.a;
import c.b.c.a.c;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class g implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final Collection<Integer> f3729c = Arrays.asList(64);

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f3730d = new byte[16];

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f3731e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    /* renamed from: a  reason: collision with root package name */
    public final a f3732a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f3733b;

    public g(byte[] bArr) {
        if (f3729c.contains(Integer.valueOf(bArr.length))) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.f3733b = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.f3732a = new a(copyOfRange, 16);
            return;
        }
        StringBuilder g = a.g("invalid key size: ");
        g.append(bArr.length);
        g.append(" bytes; key must have 64 bytes");
        throw new InvalidKeyException(g.toString());
    }

    @Override // c.b.c.a.c
    public byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= 2147483631) {
            Cipher a2 = a0.f.a("AES/CTR/NoPadding");
            byte[] c2 = c(bArr2, bArr);
            byte[] bArr3 = (byte[]) c2.clone();
            bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
            bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
            a2.init(1, new SecretKeySpec(this.f3733b, "AES"), new IvParameterSpec(bArr3));
            return c.b.a.a.c.n.c.C(c2, a2.doFinal(bArr));
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // c.b.c.a.c
    public byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length >= 16) {
            Cipher a2 = a0.f.a("AES/CTR/NoPadding");
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            byte[] bArr3 = (byte[]) copyOfRange.clone();
            bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
            bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
            a2.init(2, new SecretKeySpec(this.f3733b, "AES"), new IvParameterSpec(bArr3));
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
            byte[] doFinal = a2.doFinal(copyOfRange2);
            if (copyOfRange2.length == 0 && doFinal == null && c.b.a.a.c.n.c.m1()) {
                doFinal = new byte[0];
            }
            if (c.b.a.a.c.n.c.K0(copyOfRange, c(bArr2, doFinal))) {
                return doFinal;
            }
            throw new AEADBadTagException("Integrity check failed.");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }

    public final byte[] c(byte[]... bArr) {
        byte[] bArr2;
        if (bArr.length == 0) {
            return this.f3732a.b(f3731e);
        }
        byte[] b2 = this.f3732a.b(f3730d);
        for (int i = 0; i < bArr.length - 1; i++) {
            b2 = c.b.a.a.c.n.c.D2(c.b.a.a.c.n.c.H(b2), this.f3732a.b(bArr[i] == null ? new byte[0] : bArr[i]));
        }
        byte[] bArr3 = bArr[bArr.length - 1];
        if (bArr3.length < 16) {
            bArr2 = c.b.a.a.c.n.c.D2(c.b.a.a.c.n.c.x(bArr3), c.b.a.a.c.n.c.H(b2));
        } else if (bArr3.length >= b2.length) {
            int length = bArr3.length - b2.length;
            bArr2 = Arrays.copyOf(bArr3, bArr3.length);
            for (int i2 = 0; i2 < b2.length; i2++) {
                int i3 = length + i2;
                bArr2[i3] = (byte) (bArr2[i3] ^ b2[i2]);
            }
        } else {
            throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
        }
        return this.f3732a.b(bArr2);
    }
}
