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
    public final c0 f5166a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f5167b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f5168c;

    /* renamed from: c.b.c.a.m0.q0.a$a  reason: collision with other inner class name */
    public class C0105a extends InputStream {

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f5169b;

        /* renamed from: c  reason: collision with root package name */
        public Mac f5170c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f5171d;

        /* renamed from: e  reason: collision with root package name */
        public ByteBuffer f5172e;

        /* renamed from: f  reason: collision with root package name */
        public int f5173f = -1;

        public C0105a(byte[] bArr) {
            this.f5169b = Arrays.copyOf(bArr, bArr.length);
        }

        public final void a() {
            SecretKeySpec secretKeySpec;
            try {
                Mac a2 = a0.f5098g.a(a.b(a.this.f5166a));
                this.f5170c = a2;
                byte[] bArr = a.this.f5168c;
                if (bArr == null || bArr.length == 0) {
                    a2 = this.f5170c;
                    secretKeySpec = new SecretKeySpec(new byte[this.f5170c.getMacLength()], a.b(a.this.f5166a));
                } else {
                    a aVar = a.this;
                    secretKeySpec = new SecretKeySpec(aVar.f5168c, a.b(aVar.f5166a));
                }
                a2.init(secretKeySpec);
                this.f5170c.update(a.this.f5167b);
                this.f5171d = this.f5170c.doFinal();
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(0);
                this.f5172e = allocateDirect;
                allocateDirect.mark();
                this.f5173f = 0;
            } catch (GeneralSecurityException e2) {
                throw new IOException("Creating HMac failed", e2);
            }
        }

        public final void b() {
            this.f5170c.init(new SecretKeySpec(this.f5171d, a.b(a.this.f5166a)));
            this.f5172e.reset();
            this.f5170c.update(this.f5172e);
            this.f5170c.update(this.f5169b);
            int i = this.f5173f + 1;
            this.f5173f = i;
            this.f5170c.update((byte) i);
            ByteBuffer wrap = ByteBuffer.wrap(this.f5170c.doFinal());
            this.f5172e = wrap;
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
                if (this.f5173f == -1) {
                    a();
                }
                int i3 = 0;
                while (i3 < i2) {
                    if (!this.f5172e.hasRemaining()) {
                        if (this.f5173f == 255) {
                            return i3;
                        }
                        b();
                    }
                    int min = Math.min(i2 - i3, this.f5172e.remaining());
                    this.f5172e.get(bArr, i, min);
                    i += min;
                    i3 += min;
                }
                return i3;
            } catch (GeneralSecurityException e2) {
                this.f5170c = null;
                throw new IOException("HkdfInputStream failed", e2);
            }
        }
    }

    public a(c0 c0Var, byte[] bArr, byte[] bArr2) {
        this.f5166a = c0Var;
        this.f5167b = Arrays.copyOf(bArr, bArr.length);
        this.f5168c = Arrays.copyOf(bArr2, bArr2.length);
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
        return new C0105a(bArr);
    }
}
