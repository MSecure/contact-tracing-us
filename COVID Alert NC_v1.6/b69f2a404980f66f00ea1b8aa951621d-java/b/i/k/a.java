package b.i.k;

import androidx.recyclerview.widget.RecyclerView;
import java.io.Writer;

@Deprecated
public class a extends Writer {

    /* renamed from: b  reason: collision with root package name */
    public final String f1131b;

    /* renamed from: c  reason: collision with root package name */
    public StringBuilder f1132c = new StringBuilder((int) RecyclerView.d0.FLAG_IGNORE);

    public a(String str) {
        this.f1131b = str;
    }

    public final void a() {
        if (this.f1132c.length() > 0) {
            this.f1132c.toString();
            StringBuilder sb = this.f1132c;
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
                this.f1132c.append(c2);
            }
        }
    }
}
