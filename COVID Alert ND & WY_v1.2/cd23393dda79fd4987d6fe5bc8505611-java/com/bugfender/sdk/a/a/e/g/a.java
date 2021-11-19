package com.bugfender.sdk.a.a.e.g;

import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;

public class a implements Closeable {
    private final int a;
    private final Charset b;
    private final RandomAccessFile c;
    private final byte[][] d;
    private final int e;
    private final int f;
    private b g;
    private boolean h;

    /* access modifiers changed from: private */
    public class b {
        private final long a;
        private final byte[] b;
        private byte[] c;
        private int d;

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private b c() {
            if (this.d <= -1) {
                long j = this.a;
                if (j > 1) {
                    a aVar = a.this;
                    return new b(j - 1, aVar.a, this.c);
                } else if (this.c == null) {
                    return null;
                } else {
                    throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.c, a.this.b));
                }
            } else {
                throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.d);
            }
        }

        private b(long j, int i, byte[] bArr) {
            this.a = j;
            byte[] bArr2 = new byte[((bArr != null ? bArr.length : 0) + i)];
            this.b = bArr2;
            long j2 = (j - 1) * ((long) a.this.a);
            if (j > 0) {
                a.this.c.seek(j2);
                if (a.this.c.read(bArr2, 0, i) != i) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (bArr != null) {
                System.arraycopy(bArr, 0, bArr2, i, bArr.length);
            }
            this.d = bArr2.length - 1;
            this.c = null;
        }

        private void a() {
            int i = this.d + 1;
            if (i > 0) {
                byte[] bArr = new byte[i];
                this.c = bArr;
                System.arraycopy(this.b, 0, bArr, 0, i);
            } else {
                this.c = null;
            }
            this.d = -1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private String b() {
            String str;
            boolean z = this.a == 1;
            int i = this.d;
            while (true) {
                if (i > -1) {
                    if (!z && i < a.this.e) {
                        a();
                        break;
                    }
                    int a2 = a(this.b, i);
                    if (a2 <= 0) {
                        i -= a.this.f;
                        if (i < 0) {
                            a();
                            break;
                        }
                    } else {
                        int i2 = i + 1;
                        int i3 = (this.d - i2) + 1;
                        if (i3 >= 0) {
                            byte[] bArr = new byte[i3];
                            System.arraycopy(this.b, i2, bArr, 0, i3);
                            str = new String(bArr, a.this.b);
                            this.d = i - a2;
                        } else {
                            throw new IllegalStateException("Unexpected negative line length=" + i3);
                        }
                    }
                } else {
                    break;
                }
            }
            str = null;
            if (!z || this.c == null) {
                return str;
            }
            String str2 = new String(this.c, a.this.b);
            this.c = null;
            return str2;
        }

        private int a(byte[] bArr, int i) {
            byte[][] bArr2 = a.this.d;
            for (byte[] bArr3 : bArr2) {
                boolean z = true;
                for (int length = bArr3.length - 1; length >= 0; length--) {
                    int length2 = (i + length) - (bArr3.length - 1);
                    z &= length2 >= 0 && bArr[length2] == bArr3[length];
                }
                if (z) {
                    return bArr3.length;
                }
            }
            return 0;
        }
    }

    public a(File file, Charset charset) {
        this(file, 4096, charset);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.close();
    }

    private a(File file, int i, Charset charset) {
        int i2;
        long j;
        this.h = false;
        this.a = i;
        this.b = charset;
        if (charset.newEncoder().maxBytesPerChar() == 1.0f) {
            this.f = 1;
        } else if (charset == b.a) {
            this.f = 1;
        } else {
            throw new UnsupportedEncodingException("Encoding " + charset + " is not supported yet (feel free to submit a patch)");
        }
        byte[][] bArr = {IOUtils.LINE_SEPARATOR_WINDOWS.getBytes(charset), IOUtils.LINE_SEPARATOR_UNIX.getBytes(charset), "\r".getBytes(charset)};
        this.d = bArr;
        this.e = bArr[0].length;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        this.c = randomAccessFile;
        long length = randomAccessFile.length();
        long j2 = (long) i;
        int i3 = (int) (length % j2);
        if (i3 > 0) {
            i2 = i3;
            j = (length / j2) + 1;
        } else {
            long j3 = length / j2;
            i2 = length > 0 ? i : i3;
            j = j3;
        }
        this.g = new b(j, i2, null);
    }

    public long a() {
        return this.c.length();
    }

    public String b() {
        String b2 = this.g.b();
        while (b2 == null) {
            b c2 = this.g.c();
            this.g = c2;
            if (c2 == null) {
                break;
            }
            b2 = c2.b();
        }
        if (!"".equals(b2) || this.h) {
            return b2;
        }
        this.h = true;
        return b();
    }
}
