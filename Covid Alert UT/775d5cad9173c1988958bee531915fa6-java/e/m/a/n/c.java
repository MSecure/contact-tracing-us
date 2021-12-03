package e.m.a.n;

import java.nio.ByteBuffer;

public class c {
    public int a;
    public ByteBuffer b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f1655d;

    public c() {
        if (d.a == null) {
            d.a = new d();
        }
    }

    public int a(int i2) {
        if (i2 < this.f1655d) {
            return this.b.getShort(this.c + i2);
        }
        return 0;
    }

    public void b(int i2, ByteBuffer byteBuffer) {
        short s;
        this.b = byteBuffer;
        if (byteBuffer != null) {
            this.a = i2;
            int i3 = i2 - byteBuffer.getInt(i2);
            this.c = i3;
            s = this.b.getShort(i3);
        } else {
            s = 0;
            this.a = 0;
            this.c = 0;
        }
        this.f1655d = s;
    }
}
