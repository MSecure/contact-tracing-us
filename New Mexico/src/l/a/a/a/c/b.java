package l.a.a.a.c;

import java.io.Serializable;
import java.io.Writer;
/* loaded from: classes.dex */
public class b extends Writer implements Serializable {
    public final StringBuilder b;

    public b(int i2) {
        this.b = new StringBuilder(i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) {
        this.b.append(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        this.b.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i2, int i3) {
        this.b.append(charSequence, i2, i3);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: append  reason: collision with other method in class */
    public Appendable mo19append(char c) {
        this.b.append(c);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.lang.Object
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

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: append  reason: collision with other method in class */
    public Appendable mo20append(CharSequence charSequence) {
        this.b.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: append  reason: collision with other method in class */
    public Appendable mo21append(CharSequence charSequence, int i2, int i3) {
        this.b.append(charSequence, i2, i3);
        return this;
    }
}
