package c.b.c.a.k0;

import c.b.a.a.c.n.c;
import c.b.c.a.i;
import c.b.c.a.i0.b0;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.n0;
import c.b.c.a.m0.o;
import c.b.c.a.u;

public class b extends i<b0> {

    public class a extends i.b<u, b0> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public u a(b0 b0Var) {
            b0 b0Var2 = b0Var;
            return new o(c.f1(c.l2(b0Var2.q().n()), b0Var2.x_.r(), b0Var2.y_.r()), c.o2(b0Var2.q().p()), c.n2(b0Var2.q().o()));
        }
    }

    public b() {
        super(b0.class, new a(u.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPublicKey";
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.ASYMMETRIC_PUBLIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public b0 e(c.b.c.a.j0.a.i iVar) {
        return (b0) y.k(b0.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(b0 b0Var) {
        b0 b0Var2 = b0Var;
        n0.e(b0Var2.version_, 0);
        c.w2(b0Var2.q());
    }
}
