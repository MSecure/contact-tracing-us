package c.b.c.a.m0;

import b.x.t;
import c.b.c.a.o;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class a implements o {

    /* renamed from: a  reason: collision with root package name */
    public final SecretKey f5091a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5092b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f5093c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f5094d;

    public a(byte[] bArr, int i) {
        n0.a(bArr.length);
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, min is 10 bytes");
        } else if (i <= 16) {
            this.f5091a = new SecretKeySpec(bArr, "AES");
            this.f5092b = i;
            Cipher a2 = a0.f5097f.a("AES/ECB/NoPadding");
            a2.init(1, this.f5091a);
            byte[] f0 = t.f0(a2.doFinal(new byte[16]));
            this.f5093c = f0;
            this.f5094d = t.f0(f0);
        } else {
            throw new InvalidAlgorithmParameterException("tag size too large, max is 16 bytes");
        }
    }

    @Override // c.b.c.a.o
    public void a(byte[] bArr, byte[] bArr2) {
        if (!t.k1(bArr, b(bArr2))) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // c.b.c.a.o
    public byte[] b(byte[] bArr) {
        Cipher a2 = a0.f5097f.a("AES/ECB/NoPadding");
        boolean z = true;
        a2.init(1, this.f5091a);
        int max = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
        if (max * 16 != bArr.length) {
            z = false;
        }
        byte[] B3 = z ? t.B3(bArr, (max - 1) * 16, this.f5093c, 0, 16) : t.C3(t.J(Arrays.copyOfRange(bArr, (max - 1) * 16, bArr.length)), this.f5094d);
        byte[] bArr2 = new byte[16];
        for (int i = 0; i < max - 1; i++) {
            bArr2 = a2.doFinal(t.B3(bArr2, 0, bArr, i * 16, 16));
        }
        byte[] C3 = t.C3(B3, bArr2);
        byte[] bArr3 = new byte[this.f5092b];
        System.arraycopy(a2.doFinal(C3), 0, bArr3, 0, this.f5092b);
        return bArr3;
    }
}
