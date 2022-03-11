package e.o.a;

import java.io.Writer;
/* loaded from: classes.dex */
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

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
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
            char c = cArr[i2 + i4];
            if (c == '\n') {
                c();
            } else {
                this.c.append(c);
            }
        }
    }
}
