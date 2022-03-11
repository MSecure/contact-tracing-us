package h.a.l1.a;

import f.b.a.c.b.o.b;
import f.b.f.b1;
import f.b.f.m;
import f.b.f.r;
import f.b.f.t0;
import h.a.g0;
import h.a.u;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

public final class a extends InputStream implements u, g0 {
    public t0 b;
    public final b1<?> c;

    /* renamed from: d  reason: collision with root package name */
    public ByteArrayInputStream f4037d;

    public a(t0 t0Var, b1<?> b1Var) {
        this.b = t0Var;
        this.c = b1Var;
    }

    @Override // java.io.InputStream
    public int available() {
        t0 t0Var = this.b;
        if (t0Var != null) {
            return t0Var.getSerializedSize();
        }
        ByteArrayInputStream byteArrayInputStream = this.f4037d;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // h.a.u
    public int c(OutputStream outputStream) {
        t0 t0Var = this.b;
        if (t0Var != null) {
            int serializedSize = t0Var.getSerializedSize();
            this.b.writeTo(outputStream);
            this.b = null;
            return serializedSize;
        }
        ByteArrayInputStream byteArrayInputStream = this.f4037d;
        if (byteArrayInputStream == null) {
            return 0;
        }
        r rVar = b.a;
        b.A(byteArrayInputStream, "inputStream cannot be null!");
        b.A(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j2 = 0;
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read == -1) {
                int i2 = (int) j2;
                this.f4037d = null;
                return i2;
            }
            outputStream.write(bArr, 0, read);
            j2 += (long) read;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.b != null) {
            this.f4037d = new ByteArrayInputStream(this.b.toByteArray());
            this.b = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f4037d;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        t0 t0Var = this.b;
        if (t0Var != null) {
            int serializedSize = t0Var.getSerializedSize();
            if (serializedSize == 0) {
                this.b = null;
                this.f4037d = null;
                return -1;
            } else if (i3 >= serializedSize) {
                Logger logger = m.b;
                m.c cVar = new m.c(bArr, i2, serializedSize);
                this.b.writeTo(cVar);
                cVar.b();
                this.b = null;
                this.f4037d = null;
                return serializedSize;
            } else {
                this.f4037d = new ByteArrayInputStream(this.b.toByteArray());
                this.b = null;
            }
        }
        ByteArrayInputStream byteArrayInputStream = this.f4037d;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i2, i3);
        }
        return -1;
    }
}
