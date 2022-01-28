package com.bugsnag.android;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import org.pathcheck.covidsafepaths.BuildConfig;

public class JsonWriter implements Closeable, Flushable {
    public static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    public static final String[] REPLACEMENT_CHARS = new String[128];
    public String deferredName;
    public final Writer out;
    public String separator;
    public boolean serializeNulls;
    public int[] stack = new int[32];
    public int stackSize = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            REPLACEMENT_CHARS[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        HTML_SAFE_REPLACEMENT_CHARS = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        push(6);
        this.separator = ColorPropConverter.PACKAGE_DELIMITER;
        this.serializeNulls = true;
        if (writer != null) {
            this.out = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    public void beforeValue() throws IOException {
        int peek = peek();
        if (peek == 1) {
            replaceTop(2);
        } else if (peek == 2) {
            this.out.append(',');
        } else if (peek == 4) {
            this.out.append((CharSequence) this.separator);
            replaceTop(5);
        } else if (peek == 6) {
            replaceTop(7);
        } else if (peek == 7) {
            throw new IllegalStateException("JSON must have only one top-level value.");
        } else {
            throw new IllegalStateException("Nesting problem.");
        }
    }

    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        beforeValue();
        push(1);
        this.out.write("[");
        return this;
    }

    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        beforeValue();
        push(3);
        this.out.write("{");
        return this;
    }

    public final JsonWriter close(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.deferredName == null) {
            this.stackSize--;
            this.out.write(str);
            return this;
        } else {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Dangling name: ");
            outline15.append(this.deferredName);
            throw new IllegalStateException(outline15.toString());
        }
    }

    public JsonWriter endArray() throws IOException {
        close(1, 2, "]");
        return this;
    }

    public JsonWriter endObject() throws IOException {
        close(3, 5, "}");
        return this;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.stackSize != 0) {
            this.out.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public JsonWriter name(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.deferredName != null) {
            throw new IllegalStateException();
        } else if (this.stackSize != 0) {
            this.deferredName = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (this.serializeNulls) {
                writeDeferredName();
            } else {
                this.deferredName = null;
                return this;
            }
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    public final int peek() {
        int i = this.stackSize;
        if (i != 0) {
            return this.stack[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void push(int i) {
        int i2 = this.stackSize;
        int[] iArr = this.stack;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(i2 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.stack = iArr2;
        }
        int[] iArr3 = this.stack;
        int i3 = this.stackSize;
        this.stackSize = i3 + 1;
        iArr3[i3] = i;
    }

    public final void replaceTop(int i) {
        this.stack[this.stackSize - 1] = i;
    }

    public final void string(String str) throws IOException {
        String str2;
        String[] strArr = REPLACEMENT_CHARS;
        this.out.write("\"");
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i < i2) {
                this.out.write(str, i, i2 - i);
            }
            this.out.write(str2);
            i = i2 + 1;
        }
        if (i < length) {
            this.out.write(str, i, length - i);
        }
        this.out.write("\"");
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            nullValue();
            return this;
        }
        writeDeferredName();
        beforeValue();
        string(str);
        return this;
    }

    public final void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            int peek = peek();
            if (peek == 5) {
                this.out.write(44);
            } else if (peek != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            replaceTop(4);
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public JsonWriter value(boolean z) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(z ? BuildConfig.DISPLAY_CALL_EMERGENCY_SERVICES : "false");
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.stackSize;
        if (i > 1 || (i == 1 && this.stack[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            nullValue();
            return this;
        }
        writeDeferredName();
        beforeValue();
        this.out.write(bool.booleanValue() ? BuildConfig.DISPLAY_CALL_EMERGENCY_SERVICES : "false");
        return this;
    }

    public JsonWriter value(long j) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(j));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            nullValue();
            return this;
        }
        writeDeferredName();
        String obj = number.toString();
        if (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN")) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.out.append((CharSequence) obj);
        return this;
    }
}
