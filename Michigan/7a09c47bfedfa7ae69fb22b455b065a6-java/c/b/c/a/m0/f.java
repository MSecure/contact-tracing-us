package c.b.c.a.m0;

import androidx.recyclerview.widget.RecyclerView;
import b.x.t;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class f implements c.b.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<Cipher> f5122b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final SecretKey f5123a;

    public class a extends ThreadLocal<Cipher> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return a0.f5097f.a("AES/GCM/NoPadding");
            } catch (GeneralSecurityException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public f(byte[] bArr) {
        n0.a(bArr.length);
        this.f5123a = new SecretKeySpec(bArr, "AES");
    }

    public static AlgorithmParameterSpec c(byte[] bArr, int i, int i2) {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(RecyclerView.a0.FLAG_IGNORE, bArr, i, i2);
        } catch (ClassNotFoundException unused) {
            if (t.S1()) {
                return new IvParameterSpec(bArr, i, i2);
            }
            throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
        }
    }

    @Override // c.b.c.a.a
    public byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= 2147483619) {
            byte[] bArr3 = new byte[(bArr.length + 12 + 16)];
            byte[] a2 = i0.a(12);
            System.arraycopy(a2, 0, bArr3, 0, 12);
            f5122b.get().init(1, this.f5123a, c(a2, 0, a2.length));
            if (!(bArr2 == null || bArr2.length == 0)) {
                f5122b.get().updateAAD(bArr2);
            }
            int doFinal = f5122b.get().doFinal(bArr, 0, bArr.length, bArr3, 12);
            if (doFinal == bArr.length + 16) {
                return bArr3;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(doFinal - bArr.length)));
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // c.b.c.a.a
    public byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length >= 28) {
            f5122b.get().init(2, this.f5123a, c(bArr, 0, 12));
            if (!(bArr2 == null || bArr2.length == 0)) {
                f5122b.get().updateAAD(bArr2);
            }
            return f5122b.get().doFinal(bArr, 12, bArr.length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
