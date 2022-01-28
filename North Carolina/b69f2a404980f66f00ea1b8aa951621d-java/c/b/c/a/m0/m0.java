package c.b.c.a.m0;

import c.b.a.a.c.n.c;
import c.b.c.a.u;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

public final class m0 implements u {

    /* renamed from: a  reason: collision with root package name */
    public final RSAPublicKey f3765a;

    /* renamed from: b  reason: collision with root package name */
    public final c0 f3766b;

    /* renamed from: c  reason: collision with root package name */
    public final c0 f3767c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3768d;

    public m0(RSAPublicKey rSAPublicKey, c0 c0Var, c0 c0Var2, int i) {
        n0.d(c0Var);
        n0.c(rSAPublicKey.getModulus().bitLength());
        this.f3765a = rSAPublicKey;
        this.f3766b = c0Var;
        this.f3767c = c0Var2;
        this.f3768d = i;
    }

    public void a(byte[] bArr, byte[] bArr2) {
        BigInteger publicExponent = this.f3765a.getPublicExponent();
        BigInteger modulus = this.f3765a.getModulus();
        int bitLength = (modulus.bitLength() + 7) / 8;
        int bitLength2 = ((modulus.bitLength() - 1) + 7) / 8;
        if (bitLength == bArr.length) {
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.compareTo(modulus) < 0) {
                byte[] l1 = c.l1(bigInteger.modPow(publicExponent, modulus), bitLength2);
                int bitLength3 = modulus.bitLength() - 1;
                n0.d(this.f3766b);
                MessageDigest a2 = a0.i.a(c.m2(this.f3766b));
                byte[] digest = a2.digest(bArr2);
                int digestLength = a2.getDigestLength();
                int length = l1.length;
                if (length < this.f3768d + digestLength + 2) {
                    throw new GeneralSecurityException("inconsistent");
                } else if (l1[l1.length - 1] == -68) {
                    int i = length - digestLength;
                    int i2 = i - 1;
                    byte[] copyOf = Arrays.copyOf(l1, i2);
                    byte[] copyOfRange = Arrays.copyOfRange(l1, copyOf.length, copyOf.length + digestLength);
                    int i3 = 0;
                    while (true) {
                        long j = (((long) length) * 8) - ((long) bitLength3);
                        if (((long) i3) < j) {
                            if (((copyOf[i3 / 8] >> (7 - (i3 % 8))) & 1) == 0) {
                                i3++;
                                length = length;
                            } else {
                                throw new GeneralSecurityException("inconsistent");
                            }
                        } else {
                            byte[] E1 = c.E1(copyOfRange, i2, this.f3767c);
                            int length2 = E1.length;
                            byte[] bArr3 = new byte[length2];
                            for (int i4 = 0; i4 < length2; i4++) {
                                bArr3[i4] = (byte) (E1[i4] ^ copyOf[i4]);
                            }
                            for (int i5 = 0; ((long) i5) <= j; i5++) {
                                int i6 = i5 / 8;
                                bArr3[i6] = (byte) ((~(1 << (7 - (i5 % 8)))) & bArr3[i6]);
                            }
                            int i7 = 0;
                            while (true) {
                                int i8 = this.f3768d;
                                int i9 = (i - i8) - 2;
                                if (i7 < i9) {
                                    if (bArr3[i7] == 0) {
                                        i7++;
                                    } else {
                                        throw new GeneralSecurityException("inconsistent");
                                    }
                                } else if (bArr3[i9] == 1) {
                                    byte[] copyOfRange2 = Arrays.copyOfRange(bArr3, length2 - i8, length2);
                                    int i10 = digestLength + 8;
                                    byte[] bArr4 = new byte[(this.f3768d + i10)];
                                    System.arraycopy(digest, 0, bArr4, 8, digest.length);
                                    System.arraycopy(copyOfRange2, 0, bArr4, i10, copyOfRange2.length);
                                    if (!c.K0(a2.digest(bArr4), copyOfRange)) {
                                        throw new GeneralSecurityException("inconsistent");
                                    }
                                    return;
                                } else {
                                    throw new GeneralSecurityException("inconsistent");
                                }
                            }
                        }
                    }
                } else {
                    throw new GeneralSecurityException("inconsistent");
                }
            } else {
                throw new GeneralSecurityException("signature out of range");
            }
        } else {
            throw new GeneralSecurityException("invalid signature's length");
        }
    }
}
