package org.apache.commons.io.output;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

public class StringBuilderWriter extends Writer implements Serializable {
    public final StringBuilder builder;

    public StringBuilderWriter(int i) {
        this.builder = new StringBuilder(i);
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public Writer append(char c) {
        this.builder.append(c);
        return this;
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.builder.toString();
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.builder.append(str);
        }
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    /* renamed from: append  reason: collision with other method in class */
    public Appendable m11append(char c) throws IOException {
        this.builder.append(c);
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.builder.append(cArr, i, i2);
        }
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public Writer append(CharSequence charSequence) {
        this.builder.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    /* renamed from: append  reason: collision with other method in class */
    public Appendable m12append(CharSequence charSequence) throws IOException {
        this.builder.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public Writer append(CharSequence charSequence, int i, int i2) {
        this.builder.append(charSequence, i, i2);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    /* renamed from: append  reason: collision with other method in class */
    public Appendable m13append(CharSequence charSequence, int i, int i2) throws IOException {
        this.builder.append(charSequence, i, i2);
        return this;
    }
}
