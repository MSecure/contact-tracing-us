package c.b.c.a.k0;

import c.b.c.a.i;
import c.b.c.a.i0.l0;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.n0;
import c.b.c.a.m0.v;
import c.b.c.a.u;
import java.security.GeneralSecurityException;

public class d extends i<l0> {

    public class a extends i.b<u, l0> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public u a(l0 l0Var) {
            return new v(l0Var.keyValue_.q());
        }
    }

    public d() {
        super(l0.class, new a(u.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PublicKey";
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.ASYMMETRIC_PUBLIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public l0 e(c.b.c.a.j0.a.i iVar) {
        return (l0) y.k(l0.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* renamed from: h */
    public void g(l0 l0Var) {
        n0.e(l0Var.version_, 0);
        if (l0Var.keyValue_.size() != 32) {
            throw new GeneralSecurityException("invalid Ed25519 public key: incorrect key length");
        }
    }
}
