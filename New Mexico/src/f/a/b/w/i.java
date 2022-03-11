package f.a.b.w;

import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class i extends ByteArrayOutputStream {
    public final c b;

    public i(c cVar, int i2) {
        this.b = cVar;
        ((ByteArrayOutputStream) this).buf = cVar.a(Math.max(i2, 256));
    }

    public final void c(int i2) {
        int i3 = ((ByteArrayOutputStream) this).count;
        if (i3 + i2 > ((ByteArrayOutputStream) this).buf.length) {
            byte[] a = this.b.a((i3 + i2) * 2);
            System.arraycopy(((ByteArrayOutputStream) this).buf, 0, a, 0, ((ByteArrayOutputStream) this).count);
            this.b.b(((ByteArrayOutputStream) this).buf);
            ((ByteArrayOutputStream) this).buf = a;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    @Override // java.lang.Object
    public void finalize() {
        this.b.b(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i2) {
        c(1);
        super.write(i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) {
        c(i3);
        super.write(bArr, i2, i3);
    }
}
