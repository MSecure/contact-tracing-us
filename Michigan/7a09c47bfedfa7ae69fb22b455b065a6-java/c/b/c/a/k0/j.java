package c.b.c.a.k0;

import b.x.t;
import c.b.c.a.i;
import c.b.c.a.i0.m1;
import c.b.c.a.i0.o1;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.a0;
import c.b.c.a.m0.m0;
import c.b.c.a.m0.n0;
import c.b.c.a.u;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

public class j extends i<o1> {

    public class a extends i.b<u, o1> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public u a(o1 o1Var) {
            o1 o1Var2 = o1Var;
            m1 q = o1Var2.q();
            return new m0((RSAPublicKey) a0.k.a("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, o1Var2.n_.q()), new BigInteger(1, o1Var2.e_.q()))), t.W2(q.o()), t.W2(q.n()), q.saltLength_);
        }
    }

    public j() {
        super(o1.class, new a(u.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPssPublicKey";
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.ASYMMETRIC_PUBLIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public o1 e(c.b.c.a.j0.a.i iVar) {
        return (o1) y.k(o1.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(o1 o1Var) {
        o1 o1Var2 = o1Var;
        n0.e(o1Var2.version_, 0);
        n0.c(new BigInteger(1, o1Var2.n_.q()).bitLength());
        t.h3(o1Var2.q());
    }
}
