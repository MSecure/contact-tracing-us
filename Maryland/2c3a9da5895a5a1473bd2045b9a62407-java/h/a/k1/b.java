package h.a.k1;

import h.a.k1.h;
import h.a.k1.p.m.c;
import h.a.k1.p.m.d;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import k.e;

public final class b implements c {

    /* renamed from: e  reason: collision with root package name */
    public static final Logger f3911e = Logger.getLogger(g.class.getName());
    public final a b;
    public final c c;

    /* renamed from: d  reason: collision with root package name */
    public final h f3912d;

    public interface a {
        void b(Throwable th);
    }

    public b(a aVar, c cVar, h hVar) {
        f.b.a.c.b.o.b.A(aVar, "transportExceptionHandler");
        this.b = aVar;
        f.b.a.c.b.o.b.A(cVar, "frameWriter");
        this.c = cVar;
        f.b.a.c.b.o.b.A(hVar, "frameLogger");
        this.f3912d = hVar;
    }

    @Override // h.a.k1.p.m.c
    public void C(boolean z, int i2, int i3) {
        h.a aVar = h.a.OUTBOUND;
        h hVar = this.f3912d;
        long j2 = (4294967295L & ((long) i3)) | (((long) i2) << 32);
        if (!z) {
            hVar.d(aVar, j2);
        } else if (hVar.a()) {
            Logger logger = hVar.a;
            Level level = hVar.b;
            logger.log(level, aVar + " PING: ack=true bytes=" + j2);
        }
        try {
            this.c.C(z, i2, i3);
        } catch (IOException e2) {
            this.b.b(e2);
        }
    }

    @Override // h.a.k1.p.m.c
    public int D() {
        return this.c.D();
    }

    @Override // h.a.k1.p.m.c
    public void F(boolean z, boolean z2, int i2, int i3, List<d> list) {
        try {
            this.c.F(z, z2, i2, i3, list);
        } catch (IOException e2) {
            this.b.b(e2);
        }
    }

    @Override // h.a.k1.p.m.c
    public void L() {
        try {
            this.c.L();
        } catch (IOException e2) {
            this.b.b(e2);
        }
    }

    @Override // h.a.k1.p.m.c
    public void R(int i2, h.a.k1.p.m.a aVar, byte[] bArr) {
        this.f3912d.c(h.a.OUTBOUND, i2, aVar, k.h.f(bArr));
        try {
            this.c.R(i2, aVar, bArr);
            this.c.flush();
        } catch (IOException e2) {
            this.b.b(e2);
        }
    }

    @Override // h.a.k1.p.m.c
    public void T(int i2, h.a.k1.p.m.a aVar) {
        this.f3912d.e(h.a.OUTBOUND, i2, aVar);
        try {
            this.c.T(i2, aVar);
        } catch (IOException e2) {
            this.b.b(e2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.c.close();
        } catch (IOException e2) {
            f3911e.log(e2.getClass().equals(IOException.class) ? Level.FINE : Level.INFO, "Failed closing connection", (Throwable) e2);
        }
    }

    @Override // h.a.k1.p.m.c
    public void e(h.a.k1.p.m.h hVar) {
        h hVar2 = this.f3912d;
        h.a aVar = h.a.OUTBOUND;
        if (hVar2.a()) {
            Logger logger = hVar2.a;
            Level level = hVar2.b;
            logger.log(level, aVar + " SETTINGS: ack=true");
        }
        try {
            this.c.e(hVar);
        } catch (IOException e2) {
            this.b.b(e2);
        }
    }

    @Override // h.a.k1.p.m.c
    public void flush() {
        try {
            this.c.flush();
        } catch (IOException e2) {
            this.b.b(e2);
        }
    }

    @Override // h.a.k1.p.m.c
    public void i(boolean z, int i2, e eVar, int i3) {
        this.f3912d.b(h.a.OUTBOUND, i2, eVar, i3, z);
        try {
            this.c.i(z, i2, eVar, i3);
        } catch (IOException e2) {
            this.b.b(e2);
        }
    }

    @Override // h.a.k1.p.m.c
    public void o(h.a.k1.p.m.h hVar) {
        this.f3912d.f(h.a.OUTBOUND, hVar);
        try {
            this.c.o(hVar);
        } catch (IOException e2) {
            this.b.b(e2);
        }
    }

    @Override // h.a.k1.p.m.c
    public void u(int i2, long j2) {
        this.f3912d.g(h.a.OUTBOUND, i2, j2);
        try {
            this.c.u(i2, j2);
        } catch (IOException e2) {
            this.b.b(e2);
        }
    }
}
