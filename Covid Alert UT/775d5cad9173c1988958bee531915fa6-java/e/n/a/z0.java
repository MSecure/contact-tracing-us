package e.n.a;

import java.io.Writer;

public final class z0 extends Writer {
    public final String b;
    public StringBuilder c = new StringBuilder(128);

    public z0(String str) {
        this.b = str;
    }

    public final void c() {
        if (this.c.length() > 0) {
            this.c.toString();
            StringBuilder sb = this.c;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public void close() {
        c();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        c();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == '\n') {
                c();
            } else {
                this.c.append(c2);
            }
        }
    }
}
