package k;

import f.a.a.a.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Objects;

public final class j implements s {
    public final /* synthetic */ t b;
    public final /* synthetic */ InputStream c;

    public j(t tVar, InputStream inputStream) {
        this.b = tVar;
        this.c = inputStream;
    }

    @Override // k.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.close();
    }

    @Override // k.s
    public long m(e eVar, long j2) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (i2 == 0) {
            return 0;
        } else {
            try {
                Objects.requireNonNull(this.b);
                if (!Thread.interrupted()) {
                    o S = eVar.S(1);
                    int read = this.c.read(S.a, S.c, (int) Math.min(j2, (long) (8192 - S.c)));
                    if (read == -1) {
                        return -1;
                    }
                    S.c += read;
                    long j3 = (long) read;
                    eVar.c += j3;
                    return j3;
                }
                throw new InterruptedIOException("thread interrupted");
            } catch (AssertionError e2) {
                if (l.a(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }
    }

    public String toString() {
        StringBuilder h2 = a.h("source(");
        h2.append(this.c);
        h2.append(")");
        return h2.toString();
    }
}
