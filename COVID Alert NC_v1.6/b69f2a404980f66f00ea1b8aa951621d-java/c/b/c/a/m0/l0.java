package c.b.c.a.m0;

import c.b.a.a.c.n.c;
import c.b.c.a.t;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

public final class l0 implements t {

    /* renamed from: a  reason: collision with root package name */
    public final RSAPrivateCrtKey f3760a;

    /* renamed from: b  reason: collision with root package name */
    public final RSAPublicKey f3761b;

    /* renamed from: c  reason: collision with root package name */
    public final c0 f3762c;

    /* renamed from: d  reason: collision with root package name */
    public final c0 f3763d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3764e;

    public l0(RSAPrivateCrtKey rSAPrivateCrtKey, c0 c0Var, c0 c0Var2, int i) {
        n0.d(c0Var);
        n0.c(rSAPrivateCrtKey.getModulus().bitLength());
        this.f3760a = rSAPrivateCrtKey;
        this.f3761b = (RSAPublicKey) a0.k.a("RSA").generatePublic(new RSAPublicKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent()));
        this.f3762c = c0Var;
        this.f3763d = c0Var2;
        this.f3764e = i;
    }

    public byte[] a(byte[] bArr) {
        int bitLength = this.f3761b.getModulus().bitLength() - 1;
        n0.d(this.f3762c);
        MessageDigest a2 = a0.i.a(c.m2(this.f3762c));
        byte[] digest = a2.digest(bArr);
        int digestLength = a2.getDigestLength();
        int i = ((bitLength - 1) / 8) + 1;
        int i2 = this.f3764e;
        if (i >= digestLength + i2 + 2) {
            byte[] a3 = i0.a(i2);
            int i3 = digestLength + 8;
            byte[] bArr2 = new byte[(this.f3764e + i3)];
            System.arraycopy(digest, 0, bArr2, 8, digestLength);
            System.arraycopy(a3, 0, bArr2, i3, a3.length);
            byte[] digest2 = a2.digest(bArr2);
            int i4 = (i - digestLength) - 1;
            byte[] bArr3 = new byte[i4];
            int i5 = (i - this.f3764e) - digestLength;
            bArr3[i5 - 2] = 1;
            System.arraycopy(a3, 0, bArr3, i5 - 1, a3.length);
            byte[] E1 = c.E1(digest2, i4, this.f3763d);
            byte[] bArr4 = new byte[i4];
            for (int i6 = 0; i6 < i4; i6++) {
                bArr4[i6] = (byte) (bArr3[i6] ^ E1[i6]);
            }
            int i7 = 0;
            while (((long) i7) < (((long) i) * 8) - ((long) bitLength)) {
                int i8 = i7 / 8;
                bArr4[i8] = (byte) ((~(1 << (7 - (i7 % 8)))) & bArr4[i8]);
                i7++;
                digest2 = digest2;
            }
            int i9 = digestLength + i4;
            byte[] bArr5 = new byte[(i9 + 1)];
            System.arraycopy(bArr4, 0, bArr5, 0, i4);
            System.arraycopy(digest2, 0, bArr5, i4, digest2.length);
            bArr5[i9] = -68;
            Cipher a4 = a0.f.a("RSA/ECB/NOPADDING");
            a4.init(2, this.f3760a);
            byte[] doFinal = a4.doFinal(bArr5);
            Cipher a5 = a0.f.a("RSA/ECB/NOPADDING");
            a5.init(1, this.f3761b);
            if (new BigInteger(1, bArr5).equals(new BigInteger(1, a5.doFinal(doFinal)))) {
                return doFinal;
            }
            throw new RuntimeException("Security bug: RSA signature computation error");
        }
        throw new GeneralSecurityException("encoding error");
    }
}
