package c.b.c.a.b0;

import c.b.c.a.i;
import c.b.c.a.i0.p1;
import c.b.c.a.i0.q1;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.i0;
import c.b.c.a.m0.n0;
import c.b.c.a.m0.p0;
import java.security.GeneralSecurityException;

public class k extends i<p1> {

    public class a extends i.b<c.b.c.a.a, p1> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public c.b.c.a.a a(p1 p1Var) {
            return new p0(p1Var.keyValue_.r());
        }
    }

    public class b extends i.a<q1, p1> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public p1 a(q1 q1Var) {
            p1.b bVar = (p1.b) p1.DEFAULT_INSTANCE.e();
            if (k.this != null) {
                bVar.d();
                ((p1) bVar.f3674c).version_ = 0;
                byte[] a2 = i0.a(32);
                c.b.c.a.j0.a.i h = c.b.c.a.j0.a.i.h(a2, 0, a2.length);
                bVar.d();
                p1.n((p1) bVar.f3674c, h);
                return (p1) bVar.b();
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public q1 b(c.b.c.a.j0.a.i iVar) {
            return (q1) y.k(q1.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(q1 q1Var) {
        }
    }

    public k() {
        super(p1.class, new a(c.b.c.a.a.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.q1, c.b.c.a.i0.p1>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, p1> c() {
        return new b(q1.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.SYMMETRIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public p1 e(c.b.c.a.j0.a.i iVar) {
        return (p1) y.k(p1.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(p1 p1Var) {
        p1 p1Var2 = p1Var;
        n0.e(p1Var2.version_, 0);
        if (p1Var2.keyValue_.size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }
}
