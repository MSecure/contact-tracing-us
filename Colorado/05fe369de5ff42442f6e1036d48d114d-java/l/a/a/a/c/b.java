package l.a.a.a.c;

import java.io.Serializable;
import java.io.Writer;

public class b extends Writer implements Serializable {
    public final StringBuilder b;

    public b(int i2) {
        this.b = new StringBuilder(i2);
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public Writer append(char c) {
        this.b.append(c);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public Writer append(CharSequence charSequence) {
        this.b.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public Writer append(CharSequence charSequence, int i2, int i3) {
        this.b.append(charSequence, i2, i3);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    /* renamed from: append  reason: collision with other method in class */
    public Appendable m8append(char c) {
        this.b.append(c);
        return this;
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.b.toString();
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.b.append(str);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        if (cArr != null) {
            this.b.append(cArr, i2, i3);
        }
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    /* renamed from: append  reason: collision with other method in class */
    public Appendable m9append(CharSequence charSequence) {
        this.b.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    /* renamed from: append  reason: collision with other method in class */
    public Appendable m10append(CharSequence charSequence, int i2, int i3) {
        this.b.append(charSequence, i2, i3);
        return this;
    }
}
