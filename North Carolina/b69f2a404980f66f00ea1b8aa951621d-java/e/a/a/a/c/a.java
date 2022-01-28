package e.a.a.a.c;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class a extends OutputStream {
    public static final byte[] g = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f4793b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public int f4794c;

    /* renamed from: d  reason: collision with root package name */
    public int f4795d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f4796e;
    public int f;

    public a() {
        synchronized (this) {
            a(1024);
        }
    }

    public final void a(int i) {
        int i2;
        if (this.f4794c < this.f4793b.size() - 1) {
            this.f4795d += this.f4796e.length;
            int i3 = this.f4794c + 1;
            this.f4794c = i3;
            this.f4796e = this.f4793b.get(i3);
            return;
        }
        byte[] bArr = this.f4796e;
        if (bArr == null) {
            i2 = 0;
        } else {
            i = Math.max(bArr.length << 1, i - this.f4795d);
            i2 = this.f4795d + this.f4796e.length;
        }
        this.f4795d = i2;
        this.f4794c++;
        byte[] bArr2 = new byte[i];
        this.f4796e = bArr2;
        this.f4793b.add(bArr2);
    }

    public synchronized byte[] b() {
        int i = this.f;
        if (i == 0) {
            return g;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : this.f4793b) {
            int min = Math.min(bArr2.length, i);
            System.arraycopy(bArr2, 0, bArr, i2, min);
            i2 += min;
            i -= min;
            if (i == 0) {
                break;
            }
        }
        return bArr;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Deprecated
    public String toString() {
        return new String(b(), Charset.defaultCharset());
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        int i2 = this.f - this.f4795d;
        if (i2 == this.f4796e.length) {
            a(this.f + 1);
            i2 = 0;
        }
        this.f4796e[i2] = (byte) i;
        this.f++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            synchronized (this) {
                int i4 = this.f + i2;
                int i5 = this.f - this.f4795d;
                while (i2 > 0) {
                    int min = Math.min(i2, this.f4796e.length - i5);
                    System.arraycopy(bArr, i3 - i2, this.f4796e, i5, min);
                    i2 -= min;
                    if (i2 > 0) {
                        a(i4);
                        i5 = 0;
                    }
                }
                this.f = i4;
            }
        }
    }
}
