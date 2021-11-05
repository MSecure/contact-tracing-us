package c.b.c.a.e0;

import c.b.a.a.c.n.c;
import c.b.c.a.e;
import c.b.c.a.i;
import c.b.c.a.i0.f0;
import c.b.c.a.i0.h0;
import c.b.c.a.i0.i0;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.n0;
import c.b.c.a.m0.r;

public class b extends i<h0> {

    public class a extends i.b<e, h0> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public e a(h0 h0Var) {
            h0 h0Var2 = h0Var;
            f0 q = h0Var2.q();
            i0 p = q.p();
            return new r(c.f1(c.k2(p.n()), h0Var2.x_.r(), h0Var2.y_.r()), p.hkdfSalt_.r(), c.p2(p.o()), c.r2(q.o()), new f(q.n().n()));
        }
    }

    public b() {
        super(h0.class, new a(e.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.ASYMMETRIC_PUBLIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public h0 e(c.b.c.a.j0.a.i iVar) {
        return (h0) y.k(h0.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(h0 h0Var) {
        h0 h0Var2 = h0Var;
        n0.e(h0Var2.version_, 0);
        c.v2(h0Var2.q());
    }
}
