package k;

import java.io.IOException;
/* loaded from: classes.dex */
public class a implements r {
    public final /* synthetic */ r b;
    public final /* synthetic */ c c;

    public a(c cVar, r rVar) {
        this.c = cVar;
        this.b = rVar;
    }

    @Override // k.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.c.a();
            try {
                this.b.close();
                this.c.b(true);
            } catch (IOException e2) {
                c cVar = this.c;
                if (cVar.c()) {
                    throw cVar.d(e2);
                }
            }
        } catch (Throwable th) {
            this.c.b(false);
            throw th;
        }
    }

    @Override // k.r, java.io.Flushable
    public void flush() {
        try {
            this.c.a();
            try {
                this.b.flush();
                this.c.b(true);
            } catch (IOException e2) {
                c cVar = this.c;
                if (cVar.c()) {
                    throw cVar.d(e2);
                }
            }
        } catch (Throwable th) {
            this.c.b(false);
            throw th;
        }
    }

    @Override // k.r
    public void h(e eVar, long j2) {
        u.b(eVar.c, 0, j2);
        while (true) {
            long j3 = 0;
            if (j2 > 0) {
                o oVar = eVar.b;
                while (true) {
                    if (j3 >= 65536) {
                        break;
                    }
                    o oVar2 = eVar.b;
                    j3 += (long) (oVar2.c - oVar2.b);
                    if (j3 >= j2) {
                        j3 = j2;
                        break;
                    }
                    oVar = oVar.f4592f;
                }
                boolean z = false;
                this.c.a();
                try {
                    try {
                        this.b.h(eVar, j3);
                        j2 -= j3;
                        z = true;
                    } catch (IOException e2) {
                        c cVar = this.c;
                        if (cVar.c()) {
                            throw cVar.d(e2);
                        }
                        throw e2;
                    }
                } finally {
                    this.c.b(z);
                }
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("AsyncTimeout.sink(");
        h2.append(this.b);
        h2.append(")");
        return h2.toString();
    }
}
