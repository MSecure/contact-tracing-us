package h.a.j1;

import h.a.g0;
import java.io.InputStream;

public final class k2 {
    public static final /* synthetic */ int a = 0;

    public static final class a extends InputStream implements g0 {
        public final j2 b;

        public a(j2 j2Var) {
            f.b.a.c.b.o.b.A(j2Var, "buffer");
            this.b = j2Var;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.b.b();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() {
            this.b.close();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.b.b() == 0) {
                return -1;
            }
            return this.b.E();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            if (this.b.b() == 0) {
                return -1;
            }
            int min = Math.min(this.b.b(), i3);
            this.b.O(bArr, i2, min);
            return min;
        }
    }

    public static class b extends c {
        public int b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f3743d;

        public b(byte[] bArr, int i2, int i3) {
            boolean z = true;
            f.b.a.c.b.o.b.o(i2 >= 0, "offset must be >= 0");
            f.b.a.c.b.o.b.o(i3 >= 0, "length must be >= 0");
            int i4 = i3 + i2;
            f.b.a.c.b.o.b.o(i4 > bArr.length ? false : z, "offset + length exceeds array boundary");
            f.b.a.c.b.o.b.A(bArr, "bytes");
            this.f3743d = bArr;
            this.b = i2;
            this.c = i4;
        }

        @Override // h.a.j1.j2
        public int E() {
            c(1);
            byte[] bArr = this.f3743d;
            int i2 = this.b;
            this.b = i2 + 1;
            return bArr[i2] & 255;
        }

        @Override // h.a.j1.j2
        public void O(byte[] bArr, int i2, int i3) {
            System.arraycopy(this.f3743d, this.b, bArr, i2, i3);
            this.b += i3;
        }

        @Override // h.a.j1.j2
        public int b() {
            return this.c - this.b;
        }

        @Override // h.a.j1.j2
        public j2 y(int i2) {
            if (b() >= i2) {
                int i3 = this.b;
                this.b = i3 + i2;
                return new b(this.f3743d, i3, i2);
            }
            throw new IndexOutOfBoundsException();
        }
    }

    static {
        boolean z = false;
        byte[] bArr = new byte[0];
        f.b.a.c.b.o.b.o(true, "offset must be >= 0");
        f.b.a.c.b.o.b.o(true, "length must be >= 0");
        if (0 + 0 <= bArr.length) {
            z = true;
        }
        f.b.a.c.b.o.b.o(z, "offset + length exceeds array boundary");
        f.b.a.c.b.o.b.A(bArr, "bytes");
    }
}
