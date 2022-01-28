package c.b.c.a.e0;

import c.b.c.a.b0.a;
import c.b.c.a.i0.d;
import c.b.c.a.i0.e;
import c.b.c.a.i0.r;
import c.b.c.a.i0.s;
import c.b.c.a.i0.x0;
import c.b.c.a.j0.a.b0;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.q;
import c.b.c.a.m0.p;
import c.b.c.a.y;
import java.security.GeneralSecurityException;

public class f implements p {

    /* renamed from: a  reason: collision with root package name */
    public final String f3451a;

    /* renamed from: b  reason: collision with root package name */
    public int f3452b;

    public f(x0 x0Var) {
        String str = x0Var.typeUrl_;
        this.f3451a = str;
        if (str.equals(a.f3427b)) {
            try {
                i iVar = x0Var.value_;
                q a2 = q.a();
                r rVar = (r) y.f(x0Var);
                int i = ((s) c.b.c.a.j0.a.y.k(s.DEFAULT_INSTANCE, iVar, a2)).keySize_;
            } catch (b0 e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        } else if (this.f3451a.equals(a.f3426a)) {
            try {
                e eVar = (e) c.b.c.a.j0.a.y.k(e.DEFAULT_INSTANCE, x0Var.value_, q.a());
                d dVar = (d) y.f(x0Var);
                this.f3452b = eVar.n().keySize_;
                int i2 = eVar.o().keySize_;
            } catch (b0 e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        } else {
            StringBuilder g = c.a.a.a.a.g("unsupported AEAD DEM key type: ");
            g.append(this.f3451a);
            throw new GeneralSecurityException(g.toString());
        }
    }
}
