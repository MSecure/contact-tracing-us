package h.a.k1;

import h.a.j1.d3;
import k.e;

public class l implements d3 {
    public final e a;
    public int b;
    public int c;

    public l(e eVar, int i2) {
        this.a = eVar;
        this.b = i2;
    }

    @Override // h.a.j1.d3
    public void a() {
    }

    @Override // h.a.j1.d3
    public int b() {
        return this.c;
    }

    @Override // h.a.j1.d3
    public void c(byte[] bArr, int i2, int i3) {
        this.a.U(bArr, i2, i3);
        this.b -= i3;
        this.c += i3;
    }

    @Override // h.a.j1.d3
    public int d() {
        return this.b;
    }

    @Override // h.a.j1.d3
    public void e(byte b2) {
        this.a.V(b2);
        this.b--;
        this.c++;
    }
}
