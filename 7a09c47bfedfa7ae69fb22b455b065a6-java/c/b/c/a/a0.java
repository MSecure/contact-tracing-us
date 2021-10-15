package c.b.c.a;

import c.a.b.o;
import c.b.c.a.i0.a1;
import c.b.c.a.i0.f1;
import c.b.c.a.i0.v0;
import c.b.c.a.i0.w0;
import c.b.c.a.i0.z0;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

public class a0 {
    static {
        Charset.forName(o.DEFAULT_PARAMS_ENCODING);
    }

    public static a1 a(z0 z0Var) {
        a1.b bVar = (a1.b) a1.DEFAULT_INSTANCE.e();
        int i = z0Var.primaryKeyId_;
        bVar.d();
        ((a1) bVar.f5063c).primaryKeyId_ = i;
        for (z0.c cVar : z0Var.key_) {
            a1.c.a aVar = (a1.c.a) a1.c.DEFAULT_INSTANCE.e();
            String str = cVar.q().typeUrl_;
            aVar.d();
            a1.c.n((a1.c) aVar.f5063c, str);
            w0 s = cVar.s();
            aVar.d();
            a1.c.p((a1.c) aVar.f5063c, s);
            f1 r = cVar.r();
            aVar.d();
            a1.c.o((a1.c) aVar.f5063c, r);
            int i2 = cVar.keyId_;
            aVar.d();
            ((a1.c) aVar.f5063c).keyId_ = i2;
            bVar.d();
            a1.n((a1) bVar.f5063c, (a1.c) aVar.b());
        }
        return (a1) bVar.b();
    }

    public static void b(z0 z0Var) {
        int i = z0Var.primaryKeyId_;
        boolean z = true;
        int i2 = 0;
        boolean z2 = false;
        for (z0.c cVar : z0Var.key_) {
            if (cVar.s() == w0.ENABLED) {
                if (!(cVar.keyData_ != null)) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(cVar.keyId_)));
                } else if (cVar.r() == f1.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(cVar.keyId_)));
                } else if (cVar.s() != w0.UNKNOWN_STATUS) {
                    if (cVar.keyId_ == i) {
                        if (!z2) {
                            z2 = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    v0.c b2 = v0.c.b(cVar.q().keyMaterialType_);
                    if (b2 == null) {
                        b2 = v0.c.UNRECOGNIZED;
                    }
                    if (b2 != v0.c.ASYMMETRIC_PUBLIC) {
                        z = false;
                    }
                    i2++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(cVar.keyId_)));
                }
            }
        }
        if (i2 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z2 && !z) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
