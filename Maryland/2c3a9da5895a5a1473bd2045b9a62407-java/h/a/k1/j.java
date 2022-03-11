package h.a.k1;

import f.a.a.a.a;
import h.a.j1.c;
import h.a.j1.j2;
import k.e;

public class j extends c {
    public final e b;

    public j(e eVar) {
        this.b = eVar;
    }

    @Override // h.a.j1.j2
    public int E() {
        return this.b.Q() & 255;
    }

    @Override // h.a.j1.j2
    public void O(byte[] bArr, int i2, int i3) {
        while (i3 > 0) {
            int A = this.b.A(bArr, i2, i3);
            if (A != -1) {
                i3 -= A;
                i2 += A;
            } else {
                throw new IndexOutOfBoundsException(a.r("EOF trying to read ", i3, " bytes"));
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
    public j2 y(int i2) {
        e eVar = new e();
        eVar.h(this.b, (long) i2);
        return new j(eVar);
    }
}
