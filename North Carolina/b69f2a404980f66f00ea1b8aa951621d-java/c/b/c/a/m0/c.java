package c.b.c.a.m0;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class c implements e0 {

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal<Cipher> f3709d = new a();

    /* renamed from: a  reason: collision with root package name */
    public final SecretKeySpec f3710a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3711b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3712c;

    public class a extends ThreadLocal<Cipher> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return a0.f.a("AES/CTR/NoPadding");
            } catch (GeneralSecurityException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public c(byte[] bArr, int i) {
        n0.a(bArr.length);
        this.f3710a = new SecretKeySpec(bArr, "AES");
        int blockSize = f3709d.get().getBlockSize();
        this.f3712c = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f3711b = i;
    }

    @Override // c.b.c.a.m0.e0
    public byte[] a(byte[] bArr) {
        int length = bArr.length;
        int i = this.f3711b;
        if (length <= Integer.MAX_VALUE - i) {
            byte[] bArr2 = new byte[(bArr.length + i)];
            byte[] a2 = i0.a(i);
            System.arraycopy(a2, 0, bArr2, 0, this.f3711b);
            c(bArr, 0, bArr.length, bArr2, this.f3711b, a2, true);
            return bArr2;
        }
        StringBuilder g = c.a.a.a.a.g("plaintext length can not exceed ");
        g.append(Integer.MAX_VALUE - this.f3711b);
        throw new GeneralSecurityException(g.toString());
    }

    @Override // c.b.c.a.m0.e0
    public byte[] b(byte[] bArr) {
        int length = bArr.length;
        int i = this.f3711b;
        if (length >= i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            int length2 = bArr.length;
            int i2 = this.f3711b;
            byte[] bArr3 = new byte[(length2 - i2)];
            c(bArr, i2, bArr.length - i2, bArr3, 0, bArr2, false);
            return bArr3;
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final void c(byte[] bArr, int i, int i2, byte[] bArr2, int i3, byte[] bArr3, boolean z) {
        Cipher cipher = f3709d.get();
        byte[] bArr4 = new byte[this.f3712c];
        System.arraycopy(bArr3, 0, bArr4, 0, this.f3711b);
        cipher.init(z ? 1 : 2, this.f3710a, new IvParameterSpec(bArr4));
        if (cipher.doFinal(bArr, i, i2, bArr2, i3) != i2) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }
}
