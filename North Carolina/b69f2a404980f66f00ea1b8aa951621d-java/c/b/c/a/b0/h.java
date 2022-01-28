package c.b.c.a.b0;

import c.b.c.a.i;
import c.b.c.a.i0.b1;
import c.b.c.a.i0.c1;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.n0;
import c.b.c.a.n;

public class h extends i<b1> {

    public class a extends i.b<c.b.c.a.a, b1> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public c.b.c.a.a a(b1 b1Var) {
            c1 c1Var = b1Var.params_;
            if (c1Var == null) {
                c1Var = c1.DEFAULT_INSTANCE;
            }
            String str = c1Var.keyUri_;
            return n.a(str).a(str);
        }
    }

    public class b extends i.a<c1, b1> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public b1 a(c1 c1Var) {
            b1.b bVar = (b1.b) b1.DEFAULT_INSTANCE.e();
            bVar.d();
            b1.n((b1) bVar.f3674c, c1Var);
            if (h.this != null) {
                bVar.d();
                ((b1) bVar.f3674c).version_ = 0;
                return (b1) bVar.b();
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public c1 b(c.b.c.a.j0.a.i iVar) {
            return (c1) y.k(c1.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(c1 c1Var) {
        }
    }

    public h() {
        super(b1.class, new a(c.b.c.a.a.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.c1, c.b.c.a.i0.b1>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, b1> c() {
        return new b(c1.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.REMOTE;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public b1 e(c.b.c.a.j0.a.i iVar) {
        return (b1) y.k(b1.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(b1 b1Var) {
        n0.e(b1Var.version_, 0);
    }
}
