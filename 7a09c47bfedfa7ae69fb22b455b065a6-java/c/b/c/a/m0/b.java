package c.b.c.a.m0;

import c.a.a.a.a;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

public final class b extends f0 {
    public b(byte[] bArr, String str, int i, String str2, int i2, int i3, int i4) {
        int length = bArr.length;
        if (length < 16 || length < i) {
            StringBuilder h = a.h("ikm too short, must be >= ");
            h.append(Math.max(16, i));
            throw new InvalidAlgorithmParameterException(h.toString());
        }
        n0.a(i);
        if (i2 < 10) {
            throw new InvalidAlgorithmParameterException(a.n("tag size too small ", i2));
        } else if ((str2.equals("HmacSha1") && i2 > 20) || ((str2.equals("HmacSha256") && i2 > 32) || (str2.equals("HmacSha512") && i2 > 64))) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        } else if (((((i3 - i4) - i2) - i) - 7) - 1 > 0) {
            Arrays.copyOf(bArr, bArr.length);
        } else {
            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
        }
    }
}
