package l.a.a.a.c;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends OutputStream {

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f4599g = new byte[0];
    public final List<byte[]> b = new ArrayList();
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f4600d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f4601e;

    /* renamed from: f  reason: collision with root package name */
    public int f4602f;

    public a() {
        synchronized (this) {
            c(1024);
        }
    }

    public final void c(int i2) {
        int i3;
        if (this.c < this.b.size() - 1) {
            this.f4600d += this.f4601e.length;
            int i4 = this.c + 1;
            this.c = i4;
            this.f4601e = this.b.get(i4);
            return;
        }
        byte[] bArr = this.f4601e;
        if (bArr == null) {
            i3 = 0;
        } else {
            i2 = Math.max(bArr.length << 1, i2 - this.f4600d);
            i3 = this.f4600d + this.f4601e.length;
        }
        this.f4600d = i3;
        this.c++;
        byte[] bArr2 = new byte[i2];
        this.f4601e = bArr2;
        this.b.add(bArr2);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public synchronized byte[] d() {
        int i2 = this.f4602f;
        if (i2 == 0) {
            return f4599g;
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (byte[] bArr2 : this.b) {
            int min = Math.min(bArr2.length, i2);
            System.arraycopy(bArr2, 0, bArr, i3, min);
            i3 += min;
            i2 -= min;
            if (i2 == 0) {
                break;
            }
        }
        return bArr;
    }

    @Override // java.lang.Object
    @Deprecated
    public String toString() {
        return new String(d(), Charset.defaultCharset());
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i2) {
        int i3 = this.f4602f;
        int i4 = i3 - this.f4600d;
        if (i4 == this.f4601e.length) {
            c(i3 + 1);
            i4 = 0;
        }
        this.f4601e[i4] = (byte) i2;
        this.f4602f++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        int i4;
        if (i2 < 0 || i2 > bArr.length || i3 < 0 || (i4 = i2 + i3) > bArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i3 != 0) {
            synchronized (this) {
                int i5 = this.f4602f;
                int i6 = i5 + i3;
                int i7 = i5 - this.f4600d;
                while (i3 > 0) {
                    int min = Math.min(i3, this.f4601e.length - i7);
                    System.arraycopy(bArr, i4 - i3, this.f4601e, i7, min);
                    i3 -= min;
                    if (i3 > 0) {
                        c(i6);
                        i7 = 0;
                    }
                }
                this.f4602f = i6;
            }
        }
    }
}
