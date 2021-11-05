package e.b.g;

import c.b.a.a.c.n.c;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.SocketTimeoutException;

public final class a extends BufferedInputStream {

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4818b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4819c;

    /* renamed from: d  reason: collision with root package name */
    public long f4820d;

    /* renamed from: e  reason: collision with root package name */
    public long f4821e = 0;
    public int f;
    public boolean g;

    public a(InputStream inputStream, int i, int i2) {
        super(inputStream, i);
        boolean z = true;
        c.t1(i2 >= 0);
        this.f4819c = i2;
        this.f = i2;
        this.f4818b = i2 == 0 ? false : z;
        this.f4820d = System.nanoTime();
    }

    public static a a(InputStream inputStream, int i, int i2) {
        return inputStream instanceof a ? (a) inputStream : new a(inputStream, i, i2);
    }

    @Override // java.io.FilterInputStream, java.io.BufferedInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3;
        if (this.g || (this.f4818b && this.f <= 0)) {
            return -1;
        }
        boolean z = true;
        if (Thread.interrupted()) {
            this.g = true;
            return -1;
        }
        if (this.f4821e == 0 || System.nanoTime() - this.f4820d <= this.f4821e) {
            z = false;
        }
        if (!z) {
            if (this.f4818b && i2 > (i3 = this.f)) {
                i2 = i3;
            }
            try {
                int read = super.read(bArr, i, i2);
                this.f -= read;
                return read;
            } catch (SocketTimeoutException unused) {
                return 0;
            }
        } else {
            throw new SocketTimeoutException("Read timeout");
        }
    }

    @Override // java.io.FilterInputStream, java.io.BufferedInputStream, java.io.InputStream
    public void reset() {
        super.reset();
        this.f = this.f4819c - ((BufferedInputStream) this).markpos;
    }
}
