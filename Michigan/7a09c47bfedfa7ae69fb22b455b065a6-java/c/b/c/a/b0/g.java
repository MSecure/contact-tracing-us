package c.b.c.a.b0;

import c.b.c.a.i;
import c.b.c.a.i0.v;
import c.b.c.a.i0.v0;
import c.b.c.a.i0.w;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.i0;
import c.b.c.a.m0.k;
import c.b.c.a.m0.n0;
import java.security.GeneralSecurityException;

public class g extends i<v> {

    public class a extends i.b<c.b.c.a.a, v> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public c.b.c.a.a a(v vVar) {
            return new k(vVar.keyValue_.q());
        }
    }

    public class b extends i.a<w, v> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public v a(w wVar) {
            v.b bVar = (v.b) v.DEFAULT_INSTANCE.e();
            if (g.this != null) {
                bVar.d();
                ((v) bVar.f5063c).version_ = 0;
                byte[] a2 = i0.a(32);
                c.b.c.a.j0.a.i g2 = c.b.c.a.j0.a.i.g(a2, 0, a2.length);
                bVar.d();
                v.n((v) bVar.f5063c, g2);
                return (v) bVar.b();
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public w b(c.b.c.a.j0.a.i iVar) {
            return (w) y.k(w.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(w wVar) {
        }
    }

    public g() {
        super(v.class, new a(c.b.c.a.a.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.w, c.b.c.a.i0.v>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, v> c() {
        return new b(w.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.SYMMETRIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public v e(c.b.c.a.j0.a.i iVar) {
        return (v) y.k(v.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(v vVar) {
        v vVar2 = vVar;
        n0.e(vVar2.version_, 0);
        if (vVar2.keyValue_.size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
