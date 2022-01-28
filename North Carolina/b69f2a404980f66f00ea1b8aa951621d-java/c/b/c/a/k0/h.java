package c.b.c.a.k0;

import c.b.a.a.c.n.c;
import c.b.c.a.i;
import c.b.c.a.i0.k1;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.a0;
import c.b.c.a.m0.k0;
import c.b.c.a.m0.n0;
import c.b.c.a.u;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

public class h extends i<k1> {

    public class a extends i.b<u, k1> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public u a(k1 k1Var) {
            k1 k1Var2 = k1Var;
            return new k0((RSAPublicKey) a0.k.a("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, k1Var2.n_.r()), new BigInteger(1, k1Var2.e_.r()))), c.o2(k1Var2.q().n()));
        }
    }

    public h() {
        super(k1.class, new a(u.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PublicKey";
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.ASYMMETRIC_PUBLIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public k1 e(c.b.c.a.j0.a.i iVar) {
        return (k1) y.k(k1.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(k1 k1Var) {
        k1 k1Var2 = k1Var;
        n0.e(k1Var2.version_, 0);
        n0.c(new BigInteger(1, k1Var2.n_.r()).bitLength());
        c.x2(k1Var2.q());
    }
}
