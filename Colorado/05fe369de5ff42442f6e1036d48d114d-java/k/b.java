package k;

import f.a.a.a.a;
import java.io.IOException;

public class b implements s {
    public final /* synthetic */ s b;
    public final /* synthetic */ c c;

    public b(c cVar, s sVar) {
        this.c = cVar;
        this.b = sVar;
    }

    @Override // k.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.b.close();
            this.c.b(true);
        } catch (IOException e2) {
            c cVar = this.c;
            if (!cVar.c()) {
                throw e2;
            }
            throw cVar.d(e2);
        } catch (Throwable th) {
            this.c.b(false);
            throw th;
        }
    }

    @Override // k.s
    public long m(e eVar, long j2) {
        this.c.a();
        try {
            long m = this.b.m(eVar, j2);
            this.c.b(true);
            return m;
        } catch (IOException e2) {
            c cVar = this.c;
            if (!cVar.c()) {
                throw e2;
            }
            throw cVar.d(e2);
        } catch (Throwable th) {
            this.c.b(false);
            throw th;
        }
    }

    public String toString() {
        StringBuilder i2 = a.i("AsyncTimeout.source(");
        i2.append(this.b);
        i2.append(")");
        return i2.toString();
    }
}
