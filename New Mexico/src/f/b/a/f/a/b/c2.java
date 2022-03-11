package f.b.a.f.a.b;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Objects;
/* loaded from: classes.dex */
public final class c2 extends InputStream {
    public final Enumeration<File> b;
    public InputStream c;

    public c2(Enumeration<File> enumeration) {
        this.b = enumeration;
        c();
    }

    public final void c() {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            inputStream.close();
        }
        this.c = this.b.hasMoreElements() ? new FileInputStream(this.b.nextElement()) : null;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        InputStream inputStream = this.c;
        if (inputStream != null) {
            inputStream.close();
            this.c = null;
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        while (true) {
            InputStream inputStream = this.c;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            c();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        if (this.c == null) {
            return -1;
        }
        Objects.requireNonNull(bArr);
        if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
            throw new IndexOutOfBoundsException();
        } else if (i3 == 0) {
            return 0;
        } else {
            do {
                int read = this.c.read(bArr, i2, i3);
                if (read > 0) {
                    return read;
                }
                c();
            } while (this.c != null);
            return -1;
        }
    }
}
