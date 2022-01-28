package c.b.c.a.k0;

import c.b.c.a.i;
import c.b.c.a.i0.j0;
import c.b.c.a.i0.k0;
import c.b.c.a.i0.l0;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.r0;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.i0;
import c.b.c.a.m0.n0;
import c.b.c.a.m0.u;
import c.b.c.a.s;
import c.b.c.a.t;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class c extends s<k0, l0> {

    public class a extends i.b<t, k0> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public t a(k0 k0Var) {
            return new u(k0Var.keyValue_.q());
        }
    }

    public class b extends i.a<j0, k0> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public k0 a(j0 j0Var) {
            byte[] a2 = i0.a(32);
            byte[] e2 = c.b.c.a.m0.s.e(c.b.c.a.m0.s.d(a2));
            l0.b bVar = (l0.b) l0.DEFAULT_INSTANCE.e();
            if (c.this != null) {
                bVar.d();
                ((l0) bVar.f5063c).version_ = 0;
                c.b.c.a.j0.a.i e3 = c.b.c.a.j0.a.i.e(Arrays.copyOf(e2, e2.length));
                bVar.d();
                l0.n((l0) bVar.f5063c, e3);
                l0 l0Var = (l0) bVar.b();
                k0.b bVar2 = (k0.b) k0.DEFAULT_INSTANCE.e();
                if (c.this != null) {
                    bVar2.d();
                    ((k0) bVar2.f5063c).version_ = 0;
                    c.b.c.a.j0.a.i e4 = c.b.c.a.j0.a.i.e(Arrays.copyOf(a2, a2.length));
                    bVar2.d();
                    k0.n((k0) bVar2.f5063c, e4);
                    bVar2.d();
                    k0.o((k0) bVar2.f5063c, l0Var);
                    return (k0) bVar2.b();
                }
                throw null;
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public j0 b(c.b.c.a.j0.a.i iVar) {
            return (j0) y.k(j0.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(j0 j0Var) {
        }
    }

    public c() {
        super(k0.class, l0.class, new a(t.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey";
    }

    @Override // c.b.c.a.i
    public i.a<j0, k0> c() {
        return new b(j0.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.ASYMMETRIC_PRIVATE;
    }

    @Override // c.b.c.a.i
    public r0 e(c.b.c.a.j0.a.i iVar) {
        return (k0) y.k(k0.DEFAULT_INSTANCE, iVar, q.a());
    }

    @Override // c.b.c.a.i
    public void g(r0 r0Var) {
        k0 k0Var = (k0) r0Var;
        n0.e(k0Var.version_, 0);
        d dVar = new d();
        l0 l0Var = k0Var.publicKey_;
        if (l0Var == null) {
            l0Var = l0.DEFAULT_INSTANCE;
        }
        dVar.g(l0Var);
        if (k0Var.keyValue_.size() != 32) {
            throw new GeneralSecurityException("invalid Ed25519 private key: incorrect key length");
        }
    }
}
