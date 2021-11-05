package c.b.c.a.m0;

import c.b.a.a.c.n.c;
import c.b.c.a.u;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;

public final class k0 implements u {

    /* renamed from: a  reason: collision with root package name */
    public final RSAPublicKey f3756a;

    /* renamed from: b  reason: collision with root package name */
    public final c0 f3757b;

    public k0(RSAPublicKey rSAPublicKey, c0 c0Var) {
        n0.d(c0Var);
        n0.c(rSAPublicKey.getModulus().bitLength());
        this.f3756a = rSAPublicKey;
        this.f3757b = c0Var;
    }

    public void a(byte[] bArr, byte[] bArr2) {
        String str;
        BigInteger publicExponent = this.f3756a.getPublicExponent();
        BigInteger modulus = this.f3756a.getModulus();
        int bitLength = (modulus.bitLength() + 7) / 8;
        if (bitLength == bArr.length) {
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.compareTo(modulus) < 0) {
                byte[] l1 = c.l1(bigInteger.modPow(publicExponent, modulus), bitLength);
                c0 c0Var = this.f3757b;
                n0.d(c0Var);
                MessageDigest a2 = a0.i.a(c.m2(this.f3757b));
                a2.update(bArr2);
                byte[] digest = a2.digest();
                int ordinal = c0Var.ordinal();
                if (ordinal == 1) {
                    str = "3031300d060960864801650304020105000420";
                } else if (ordinal == 3) {
                    str = "3051300d060960864801650304020305000440";
                } else {
                    throw new GeneralSecurityException("Unsupported hash " + c0Var);
                }
                byte[] I = c.I(str);
                int length = I.length + digest.length;
                if (bitLength >= length + 11) {
                    byte[] bArr3 = new byte[bitLength];
                    bArr3[0] = 0;
                    int i = 2;
                    bArr3[1] = 1;
                    int i2 = 0;
                    while (i2 < (bitLength - length) - 3) {
                        bArr3[i] = -1;
                        i2++;
                        i++;
                    }
                    int i3 = i + 1;
                    bArr3[i] = 0;
                    System.arraycopy(I, 0, bArr3, i3, I.length);
                    System.arraycopy(digest, 0, bArr3, i3 + I.length, digest.length);
                    if (!c.K0(l1, bArr3)) {
                        throw new GeneralSecurityException("invalid signature");
                    }
                    return;
                }
                throw new GeneralSecurityException("intended encoded message length too short");
            }
            throw new GeneralSecurityException("signature out of range");
        }
        throw new GeneralSecurityException("invalid signature's length");
    }
}
