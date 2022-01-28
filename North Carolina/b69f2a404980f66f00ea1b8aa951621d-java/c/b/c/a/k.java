package c.b.c.a;

import c.b.c.a.i0.f1;
import c.b.c.a.i0.v0;
import c.b.c.a.i0.w0;
import c.b.c.a.i0.x0;
import c.b.c.a.i0.z0;
import c.b.c.a.j0.a.y;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Iterator;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final z0.b f3686a;

    public k(z0.b bVar) {
        this.f3686a = bVar;
    }

    public static int e() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i = 0;
        while (i == 0) {
            secureRandom.nextBytes(bArr);
            i = ((bArr[0] & Byte.MAX_VALUE) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return i;
    }

    public static k f(j jVar) {
        z0 z0Var = jVar.f3517a;
        y.a aVar = (y.a) z0Var.f(y.f.NEW_BUILDER, null, null);
        aVar.d();
        aVar.f(aVar.f3674c, z0Var);
        return new k((z0.b) aVar);
    }

    @Deprecated
    public synchronized int a(x0 x0Var, boolean z) {
        z0.c c2;
        c2 = c(x0Var);
        z0.b bVar = this.f3686a;
        bVar.d();
        z0.n((z0) bVar.f3674c, c2);
        if (z) {
            z0.b bVar2 = this.f3686a;
            int i = c2.keyId_;
            bVar2.d();
            ((z0) bVar2.f3674c).primaryKeyId_ = i;
        }
        return c2.keyId_;
    }

    public synchronized j b() {
        return j.a((z0) this.f3686a.b());
    }

    public final synchronized z0.c c(x0 x0Var) {
        z0.c.a aVar;
        v0 g = y.g(x0Var);
        int d2 = d();
        f1 b2 = f1.b(x0Var.outputPrefixType_);
        if (b2 == null) {
            b2 = f1.UNRECOGNIZED;
        }
        if (b2 == f1.UNKNOWN_PREFIX) {
            b2 = f1.TINK;
        }
        aVar = (z0.c.a) z0.c.DEFAULT_INSTANCE.e();
        aVar.d();
        z0.c.n((z0.c) aVar.f3674c, g);
        aVar.d();
        ((z0.c) aVar.f3674c).keyId_ = d2;
        w0 w0Var = w0.ENABLED;
        aVar.d();
        z0.c.p((z0.c) aVar.f3674c, w0Var);
        aVar.d();
        z0.c.o((z0.c) aVar.f3674c, b2);
        return (z0.c) aVar.b();
    }

    public final synchronized int d() {
        boolean z;
        do {
            int e2 = e();
            synchronized (this) {
                Iterator it = Collections.unmodifiableList(((z0) this.f3686a.f3674c).key_).iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((z0.c) it.next()).keyId_ == e2) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
            return e2;
        } while (!z);
        return e2;
        if (!z) {
            return e2;
        }
    }
}
