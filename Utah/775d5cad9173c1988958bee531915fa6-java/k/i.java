package k;

import f.a.a.a.a;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.Objects;

public final class i implements r {
    public final /* synthetic */ t b;
    public final /* synthetic */ OutputStream c;

    public i(t tVar, OutputStream outputStream) {
        this.b = tVar;
        this.c = outputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, k.r
    public void close() {
        this.c.close();
    }

    @Override // k.r, java.io.Flushable
    public void flush() {
        this.c.flush();
    }

    @Override // k.r
    public void h(e eVar, long j2) {
        u.b(eVar.c, 0, j2);
        while (j2 > 0) {
            Objects.requireNonNull(this.b);
            if (!Thread.interrupted()) {
                o oVar = eVar.b;
                int min = (int) Math.min(j2, (long) (oVar.c - oVar.b));
                this.c.write(oVar.a, oVar.b, min);
                int i2 = oVar.b + min;
                oVar.b = i2;
                long j3 = (long) min;
                j2 -= j3;
                eVar.c -= j3;
                if (i2 == oVar.c) {
                    eVar.b = oVar.a();
                    p.a(oVar);
                }
            } else {
                throw new InterruptedIOException("thread interrupted");
            }
        }
    }

    public String toString() {
        StringBuilder h2 = a.h("sink(");
        h2.append(this.c);
        h2.append(")");
        return h2.toString();
    }
}
