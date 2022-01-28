package c.a.b.x;

import androidx.recyclerview.widget.RecyclerView;
import java.io.ByteArrayOutputStream;

public class j extends ByteArrayOutputStream {

    /* renamed from: b  reason: collision with root package name */
    public final c f2273b;

    public j(c cVar, int i) {
        this.f2273b = cVar;
        ((ByteArrayOutputStream) this).buf = cVar.a(Math.max(i, (int) RecyclerView.d0.FLAG_TMP_DETACHED));
    }

    public final void a(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i > ((ByteArrayOutputStream) this).buf.length) {
            byte[] a2 = this.f2273b.a((i2 + i) * 2);
            System.arraycopy(((ByteArrayOutputStream) this).buf, 0, a2, 0, ((ByteArrayOutputStream) this).count);
            this.f2273b.b(((ByteArrayOutputStream) this).buf);
            ((ByteArrayOutputStream) this).buf = a2;
        }
    }

    @Override // java.io.OutputStream, java.io.ByteArrayOutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2273b.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    @Override // java.lang.Object
    public void finalize() {
        this.f2273b.b(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.OutputStream, java.io.ByteArrayOutputStream
    public synchronized void write(int i) {
        a(1);
        super.write(i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }
}
