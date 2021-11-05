package c.b.c.a;

import c.a.a.a.a;
import c.b.c.a.f0.a.d;
import c.b.c.a.i0.n0;
import c.b.c.a.i0.z0;
import c.b.c.a.j0.a.b0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import java.security.GeneralSecurityException;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final z0 f3517a;

    public j(z0 z0Var) {
        this.f3517a = z0Var;
    }

    public static final j a(z0 z0Var) {
        if (z0Var != null && z0Var.key_.size() > 0) {
            return new j(z0Var);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public static final j c(d dVar, a aVar) {
        n0 n0Var = (n0) y.l(n0.DEFAULT_INSTANCE, dVar.a(), q.a());
        if (n0Var.encryptedKeyset_.size() != 0) {
            try {
                z0 o = z0.o(aVar.b(n0Var.encryptedKeyset_.r(), new byte[0]), q.a());
                if (o.key_.size() > 0) {
                    return new j(o);
                }
                throw new GeneralSecurityException("empty keyset");
            } catch (b0 unused) {
                throw new GeneralSecurityException("invalid keyset, corrupted key material");
            }
        } else {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public <P> P b(Class<P> cls) {
        p<?> e2 = y.e(this, cls);
        q<?> qVar = y.f3828e.get(e2.f3815c);
        if (qVar != null) {
            return (P) qVar.b(e2);
        }
        StringBuilder g = a.g("No wrapper found for ");
        g.append(e2.f3815c.getName());
        throw new GeneralSecurityException(g.toString());
    }

    public String toString() {
        return a0.a(this.f3517a).toString();
    }
}
