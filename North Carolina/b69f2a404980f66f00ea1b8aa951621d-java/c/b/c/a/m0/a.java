package c.b.c.a.m0;

import c.b.a.a.c.n.c;
import c.b.c.a.o;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class a implements o {

    /* renamed from: a  reason: collision with root package name */
    public final SecretKey f3700a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3701b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f3702c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f3703d;

    public a(byte[] bArr, int i) {
        n0.a(bArr.length);
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, min is 10 bytes");
        } else if (i <= 16) {
            this.f3700a = new SecretKeySpec(bArr, "AES");
            this.f3701b = i;
            Cipher a2 = a0.f.a("AES/ECB/NoPadding");
            a2.init(1, this.f3700a);
            byte[] H = c.H(a2.doFinal(new byte[16]));
            this.f3702c = H;
            this.f3703d = c.H(H);
        } else {
            throw new InvalidAlgorithmParameterException("tag size too large, max is 16 bytes");
        }
    }

    @Override // c.b.c.a.o
    public void a(byte[] bArr, byte[] bArr2) {
        if (!c.K0(bArr, b(bArr2))) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // c.b.c.a.o
    public byte[] b(byte[] bArr) {
        Cipher a2 = a0.f.a("AES/ECB/NoPadding");
        boolean z = true;
        a2.init(1, this.f3700a);
        int max = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
        if (max * 16 != bArr.length) {
            z = false;
        }
        byte[] C2 = z ? c.C2(bArr, (max - 1) * 16, this.f3702c, 0, 16) : c.D2(c.x(Arrays.copyOfRange(bArr, (max - 1) * 16, bArr.length)), this.f3703d);
        byte[] bArr2 = new byte[16];
        for (int i = 0; i < max - 1; i++) {
            bArr2 = a2.doFinal(c.C2(bArr2, 0, bArr, i * 16, 16));
        }
        byte[] D2 = c.D2(C2, bArr2);
        byte[] bArr3 = new byte[this.f3701b];
        System.arraycopy(a2.doFinal(D2), 0, bArr3, 0, this.f3701b);
        return bArr3;
    }
}
