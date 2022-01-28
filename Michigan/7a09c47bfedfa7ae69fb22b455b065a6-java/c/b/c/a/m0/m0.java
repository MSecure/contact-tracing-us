package c.b.c.a.m0;

import b.x.t;
import c.b.c.a.u;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

public final class m0 implements u {

    /* renamed from: a  reason: collision with root package name */
    public final RSAPublicKey f5162a;

    /* renamed from: b  reason: collision with root package name */
    public final c0 f5163b;

    /* renamed from: c  reason: collision with root package name */
    public final c0 f5164c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5165d;

    public m0(RSAPublicKey rSAPublicKey, c0 c0Var, c0 c0Var2, int i) {
        n0.d(c0Var);
        n0.c(rSAPublicKey.getModulus().bitLength());
        this.f5162a = rSAPublicKey;
        this.f5163b = c0Var;
        this.f5164c = c0Var2;
        this.f5165d = i;
    }

    public void a(byte[] bArr, byte[] bArr2) {
        BigInteger publicExponent = this.f5162a.getPublicExponent();
        BigInteger modulus = this.f5162a.getModulus();
        int bitLength = (modulus.bitLength() + 7) / 8;
        int bitLength2 = ((modulus.bitLength() - 1) + 7) / 8;
        if (bitLength == bArr.length) {
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.compareTo(modulus) < 0) {
                byte[] R1 = t.R1(bigInteger.modPow(publicExponent, modulus), bitLength2);
                int bitLength3 = modulus.bitLength() - 1;
                n0.d(this.f5163b);
                MessageDigest a2 = a0.i.a(t.U2(this.f5163b));
                byte[] digest = a2.digest(bArr2);
                int digestLength = a2.getDigestLength();
                int length = R1.length;
                if (length < this.f5165d + digestLength + 2) {
                    throw new GeneralSecurityException("inconsistent");
                } else if (R1[R1.length - 1] == -68) {
                    int i = length - digestLength;
                    int i2 = i - 1;
                    byte[] copyOf = Arrays.copyOf(R1, i2);
                    byte[] copyOfRange = Arrays.copyOfRange(R1, copyOf.length, copyOf.length + digestLength);
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
                            byte[] h2 = t.h2(copyOfRange, i2, this.f5164c);
                            int length2 = h2.length;
                            byte[] bArr3 = new byte[length2];
                            for (int i4 = 0; i4 < length2; i4++) {
                                bArr3[i4] = (byte) (h2[i4] ^ copyOf[i4]);
                            }
                            for (int i5 = 0; ((long) i5) <= j; i5++) {
                                int i6 = i5 / 8;
                                bArr3[i6] = (byte) ((~(1 << (7 - (i5 % 8)))) & bArr3[i6]);
                            }
                            int i7 = 0;
                            while (true) {
                                int i8 = this.f5165d;
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
                                    byte[] bArr4 = new byte[(this.f5165d + i10)];
                                    System.arraycopy(digest, 0, bArr4, 8, digest.length);
                                    System.arraycopy(copyOfRange2, 0, bArr4, i10, copyOfRange2.length);
                                    if (!t.k1(a2.digest(bArr4), copyOfRange)) {
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
