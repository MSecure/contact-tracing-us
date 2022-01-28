package g.a.a.a.c;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class a extends OutputStream {

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f6387g = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f6388b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public int f6389c;

    /* renamed from: d  reason: collision with root package name */
    public int f6390d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f6391e;

    /* renamed from: f  reason: collision with root package name */
    public int f6392f;

    public a() {
        synchronized (this) {
            a(1024);
        }
    }

    public final void a(int i) {
        int i2;
        if (this.f6389c < this.f6388b.size() - 1) {
            this.f6390d += this.f6391e.length;
            int i3 = this.f6389c + 1;
            this.f6389c = i3;
            this.f6391e = this.f6388b.get(i3);
            return;
        }
        byte[] bArr = this.f6391e;
        if (bArr == null) {
            i2 = 0;
        } else {
            i = Math.max(bArr.length << 1, i - this.f6390d);
            i2 = this.f6390d + this.f6391e.length;
        }
        this.f6390d = i2;
        this.f6389c++;
        byte[] bArr2 = new byte[i];
        this.f6391e = bArr2;
        this.f6388b.add(bArr2);
    }

    public synchronized byte[] b() {
        int i = this.f6392f;
        if (i == 0) {
            return f6387g;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : this.f6388b) {
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
        int i2 = this.f6392f - this.f6390d;
        if (i2 == this.f6391e.length) {
            a(this.f6392f + 1);
            i2 = 0;
        }
        this.f6391e[i2] = (byte) i;
        this.f6392f++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            synchronized (this) {
                int i4 = this.f6392f + i2;
                int i5 = this.f6392f - this.f6390d;
                while (i2 > 0) {
                    int min = Math.min(i2, this.f6391e.length - i5);
                    System.arraycopy(bArr, i3 - i2, this.f6391e, i5, min);
                    i2 -= min;
                    if (i2 > 0) {
                        a(i4);
                        i5 = 0;
                    }
                }
                this.f6392f = i4;
            }
        }
    }
}
