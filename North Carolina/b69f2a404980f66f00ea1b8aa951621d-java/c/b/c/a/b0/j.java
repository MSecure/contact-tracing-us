package c.b.c.a.b0;

import c.b.c.a.i;
import c.b.c.a.i0.d1;
import c.b.c.a.i0.e1;
import c.b.c.a.i0.v0;
import c.b.c.a.i0.x0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.n0;
import c.b.c.a.n;

public class j extends i<d1> {

    public class a extends i.b<c.b.c.a.a, d1> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public c.b.c.a.a a(d1 d1Var) {
            d1 d1Var2 = d1Var;
            e1 e1Var = d1Var2.params_;
            if (e1Var == null) {
                e1Var = e1.DEFAULT_INSTANCE;
            }
            String str = e1Var.kekUri_;
            c.b.c.a.a a2 = n.a(str).a(str);
            e1 e1Var2 = d1Var2.params_;
            if (e1Var2 == null) {
                e1Var2 = e1.DEFAULT_INSTANCE;
            }
            x0 x0Var = e1Var2.dekTemplate_;
            if (x0Var == null) {
                x0Var = x0.DEFAULT_INSTANCE;
            }
            return new i(x0Var, a2);
        }
    }

    public class b extends i.a<e1, d1> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public d1 a(e1 e1Var) {
            d1.b bVar = (d1.b) d1.DEFAULT_INSTANCE.e();
            bVar.d();
            d1.n((d1) bVar.f3674c, e1Var);
            if (j.this != null) {
                bVar.d();
                ((d1) bVar.f3674c).version_ = 0;
                return (d1) bVar.b();
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public e1 b(c.b.c.a.j0.a.i iVar) {
            return (e1) y.k(e1.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(e1 e1Var) {
        }
    }

    public j() {
        super(d1.class, new a(c.b.c.a.a.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.e1, c.b.c.a.i0.d1>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, d1> c() {
        return new b(e1.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.REMOTE;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public d1 e(c.b.c.a.j0.a.i iVar) {
        return (d1) y.k(d1.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(d1 d1Var) {
        n0.e(d1Var.version_, 0);
    }
}
