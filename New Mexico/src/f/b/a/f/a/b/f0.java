package f.b.a.f.a.b;

import java.io.InputStream;
/* loaded from: classes.dex */
public final class f0 extends InputStream {
    public final InputStream b;
    public long c;

    public f0(InputStream inputStream, long j2) {
        this.b = inputStream;
        this.c = j2;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        this.b.close();
        this.c = 0;
    }

    @Override // java.io.InputStream
    public final int read() {
        long j2 = this.c;
        if (j2 <= 0) {
            return -1;
        }
        this.c = j2 - 1;
        return this.b.read();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        long j2 = this.c;
        if (j2 <= 0) {
            return -1;
        }
        int read = this.b.read(bArr, i2, (int) Math.min((long) i3, j2));
        if (read != -1) {
            this.c -= (long) read;
        }
        return read;
    }
}
