package h.a.k1;

import f.a.a.a.a;
import h.a.j1.c;
import h.a.j1.j2;
import k.e;
/* loaded from: classes.dex */
public class j extends c {
    public final e b;

    public j(e eVar) {
        this.b = eVar;
    }

    @Override // h.a.j1.j2
    public void K(byte[] bArr, int i2, int i3) {
        while (i3 > 0) {
            int read = this.b.read(bArr, i2, i3);
            if (read != -1) {
                i3 -= read;
                i2 += read;
            } else {
                throw new IndexOutOfBoundsException(a.v("EOF trying to read ", i3, " bytes"));
            }
        }
    }

    @Override // h.a.j1.j2
    public int b() {
        return (int) this.b.c;
    }

    @Override // h.a.j1.c, h.a.j1.j2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.c();
    }

    @Override // h.a.j1.j2
    public int readUnsignedByte() {
        return this.b.readByte() & 255;
    }

    @Override // h.a.j1.j2
    public j2 v(int i2) {
        e eVar = new e();
        eVar.h(this.b, (long) i2);
        return new j(eVar);
    }
}
