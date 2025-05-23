package c.b.c.a.m0.q0;

import c.b.c.a.m0.a0;
import c.b.c.a.m0.c0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public final c0 f3769a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f3770b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f3771c;

    /* renamed from: c.b.c.a.m0.q0.a$a  reason: collision with other inner class name */
    public class C0096a extends InputStream {

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f3772b;

        /* renamed from: c  reason: collision with root package name */
        public Mac f3773c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f3774d;

        /* renamed from: e  reason: collision with root package name */
        public ByteBuffer f3775e;
        public int f = -1;

        public C0096a(byte[] bArr) {
            this.f3772b = Arrays.copyOf(bArr, bArr.length);
        }

        public final void a() {
            SecretKeySpec secretKeySpec;
            try {
                Mac a2 = a0.g.a(a.b(a.this.f3769a));
                this.f3773c = a2;
                byte[] bArr = a.this.f3771c;
                if (bArr == null || bArr.length == 0) {
                    a2 = this.f3773c;
                    secretKeySpec = new SecretKeySpec(new byte[this.f3773c.getMacLength()], a.b(a.this.f3769a));
                } else {
                    a aVar = a.this;
                    secretKeySpec = new SecretKeySpec(aVar.f3771c, a.b(aVar.f3769a));
                }
                a2.init(secretKeySpec);
                this.f3773c.update(a.this.f3770b);
                this.f3774d = this.f3773c.doFinal();
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(0);
                this.f3775e = allocateDirect;
                allocateDirect.mark();
                this.f = 0;
            } catch (GeneralSecurityException e2) {
                throw new IOException("Creating HMac failed", e2);
            }
        }

        public final void b() {
            this.f3773c.init(new SecretKeySpec(this.f3774d, a.b(a.this.f3769a)));
            this.f3775e.reset();
            this.f3773c.update(this.f3775e);
            this.f3773c.update(this.f3772b);
            int i = this.f + 1;
            this.f = i;
            this.f3773c.update((byte) i);
            ByteBuffer wrap = ByteBuffer.wrap(this.f3773c.doFinal());
            this.f3775e = wrap;
            wrap.mark();
        }

        @Override // java.io.InputStream
        public int read() {
            byte[] bArr = new byte[1];
            int read = read(bArr, 0, 1);
            if (read == 1) {
                return bArr[0] & 255;
            }
            if (read == -1) {
                return read;
            }
            throw new IOException("Reading failed");
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            try {
                if (this.f == -1) {
                    a();
                }
                int i3 = 0;
                while (i3 < i2) {
                    if (!this.f3775e.hasRemaining()) {
                        if (this.f == 255) {
                            return i3;
                        }
                        b();
                    }
                    int min = Math.min(i2 - i3, this.f3775e.remaining());
                    this.f3775e.get(bArr, i, min);
                    i += min;
                    i3 += min;
                }
                return i3;
            } catch (GeneralSecurityException e2) {
                this.f3773c = null;
                throw new IOException("HkdfInputStream failed", e2);
            }
        }
    }

    public a(c0 c0Var, byte[] bArr, byte[] bArr2) {
        this.f3769a = c0Var;
        this.f3770b = Arrays.copyOf(bArr, bArr.length);
        this.f3771c = Arrays.copyOf(bArr2, bArr2.length);
    }

    public static String b(c0 c0Var) {
        int ordinal = c0Var.ordinal();
        if (ordinal == 0) {
            return "HmacSha1";
        }
        if (ordinal == 1) {
            return "HmacSha256";
        }
        if (ordinal == 2) {
            return "HmacSha384";
        }
        if (ordinal == 3) {
            return "HmacSha512";
        }
        throw new GeneralSecurityException("No getJavaxHmacName for given hash " + c0Var + " known");
    }

    @Override // c.b.c.a.m0.q0.c
    public InputStream a(byte[] bArr) {
        return new C0096a(bArr);
    }
}
