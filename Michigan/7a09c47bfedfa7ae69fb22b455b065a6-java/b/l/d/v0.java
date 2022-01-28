package b.l.d;

import androidx.recyclerview.widget.RecyclerView;
import java.io.Writer;

public final class v0 extends Writer {

    /* renamed from: b  reason: collision with root package name */
    public final String f2140b;

    /* renamed from: c  reason: collision with root package name */
    public StringBuilder f2141c = new StringBuilder((int) RecyclerView.a0.FLAG_IGNORE);

    public v0(String str) {
        this.f2140b = str;
    }

    public final void a() {
        if (this.f2141c.length() > 0) {
            this.f2141c.toString();
            StringBuilder sb = this.f2141c;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == '\n') {
                a();
            } else {
                this.f2141c.append(c2);
            }
        }
    }
}
