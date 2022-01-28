package g.a.a.a.c;

import java.io.Serializable;
import java.io.Writer;

public class b extends Writer implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final StringBuilder f6393b;

    public b(int i) {
        this.f6393b = new StringBuilder(i);
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public Writer append(char c2) {
        this.f6393b.append(c2);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public Writer append(CharSequence charSequence) {
        this.f6393b.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public Writer append(CharSequence charSequence, int i, int i2) {
        this.f6393b.append(charSequence, i, i2);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    /* renamed from: append  reason: collision with other method in class */
    public Appendable m350append(char c2) {
        this.f6393b.append(c2);
        return this;
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.f6393b.toString();
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.f6393b.append(str);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.f6393b.append(cArr, i, i2);
        }
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    /* renamed from: append  reason: collision with other method in class */
    public Appendable m351append(CharSequence charSequence) {
        this.f6393b.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    /* renamed from: append  reason: collision with other method in class */
    public Appendable m352append(CharSequence charSequence, int i, int i2) {
        this.f6393b.append(charSequence, i, i2);
        return this;
    }
}
