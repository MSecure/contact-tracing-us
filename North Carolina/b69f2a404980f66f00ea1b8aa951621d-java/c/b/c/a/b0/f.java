package c.b.c.a.b0;

import c.b.c.a.i;
import c.b.c.a.i0.r;
import c.b.c.a.i0.s;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.i0;
import c.b.c.a.m0.n0;

public final class f extends i<r> {

    public class a extends i.b<c.b.c.a.a, r> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public c.b.c.a.a a(r rVar) {
            return new c.b.c.a.m0.f(rVar.keyValue_.r());
        }
    }

    public class b extends i.a<s, r> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public r a(s sVar) {
            r.b bVar = (r.b) r.DEFAULT_INSTANCE.e();
            byte[] a2 = i0.a(sVar.keySize_);
            c.b.c.a.j0.a.i h = c.b.c.a.j0.a.i.h(a2, 0, a2.length);
            bVar.d();
            r.n((r) bVar.f3674c, h);
            if (f.this != null) {
                bVar.d();
                ((r) bVar.f3674c).version_ = 0;
                return (r) bVar.b();
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public s b(c.b.c.a.j0.a.i iVar) {
            return (s) y.k(s.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(s sVar) {
            n0.a(sVar.keySize_);
        }
    }

    public f() {
        super(r.class, new a(c.b.c.a.a.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.s, c.b.c.a.i0.r>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, r> c() {
        return new b(s.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.SYMMETRIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public r e(c.b.c.a.j0.a.i iVar) {
        return (r) y.k(r.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(r rVar) {
        r rVar2 = rVar;
        n0.e(rVar2.version_, 0);
        n0.a(rVar2.keyValue_.size());
    }
}
