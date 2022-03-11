package f.b.a.f.a.b;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class n0 extends FilterInputStream {

    /* renamed from: d  reason: collision with root package name */
    public long f3267d;
    public final d2 b = new d2();
    public byte[] c = new byte[4096];

    /* renamed from: e  reason: collision with root package name */
    public boolean f3268e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3269f = false;

    public n0(InputStream inputStream) {
        super(inputStream);
    }

    public final e3 c() {
        byte[] bArr;
        if (this.f3267d > 0) {
            do {
                bArr = this.c;
            } while (read(bArr, 0, bArr.length) != -1);
            if (!this.f3268e || this.f3269f) {
                return new k0(null, -1, -1, false, false, null);
            }
            if (!t(30)) {
                this.f3268e = true;
                return this.b.b();
            }
            e3 b = this.b.b();
            k0 k0Var = (k0) b;
            if (k0Var.f3255e) {
                this.f3269f = true;
                return b;
            } else if (k0Var.b != 4294967295L) {
                int i2 = this.b.f3209f - 30;
                long j2 = (long) i2;
                int length = this.c.length;
                if (j2 > ((long) length)) {
                    do {
                        length += length;
                    } while (((long) length) < j2);
                    this.c = Arrays.copyOf(this.c, length);
                }
                if (!t(i2)) {
                    this.f3268e = true;
                    return this.b.b();
                }
                e3 b2 = this.b.b();
                this.f3267d = ((k0) b2).b;
                return b2;
            } else {
                throw new z0("Files bigger than 4GiB are not supported.");
            }
        } else {
            if (!this.f3268e) {
            }
            return new k0(null, -1, -1, false, false, null);
        }
    }

    public final int d(byte[] bArr, int i2, int i3) {
        return Math.max(0, super.read(bArr, i2, i3));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        long j2 = this.f3267d;
        if (j2 <= 0 || this.f3268e) {
            return -1;
        }
        int max = Math.max(0, super.read(bArr, i2, (int) Math.min(j2, (long) i3)));
        this.f3267d -= (long) max;
        if (max != 0) {
            return max;
        }
        this.f3268e = true;
        return 0;
    }

    public final boolean t(int i2) {
        int d2 = d(this.c, 0, i2);
        if (d2 != i2) {
            int i3 = i2 - d2;
            if (d(this.c, d2, i3) != i3) {
                this.b.a(this.c, 0, d2);
                return false;
            }
        }
        this.b.a(this.c, 0, i2);
        return true;
    }
}
