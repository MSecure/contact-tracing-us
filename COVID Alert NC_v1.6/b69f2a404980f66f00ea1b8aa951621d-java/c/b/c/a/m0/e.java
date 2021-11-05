package c.b.c.a.m0;

import c.a.a.a.a;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

public final class e extends f0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3726a;

    public e(byte[] bArr, String str, int i, int i2, int i3) {
        if (bArr.length < 16 || bArr.length < i) {
            StringBuilder g = a.g("ikm too short, must be >= ");
            g.append(Math.max(16, i));
            throw new InvalidAlgorithmParameterException(g.toString());
        }
        n0.a(i);
        if (i2 > this.f3726a + 1 + 7 + i3 + 16) {
            Arrays.copyOf(bArr, bArr.length);
            this.f3726a = i;
            return;
        }
        throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
    }
}
