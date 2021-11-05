package c.b.c.a.b0;

import c.b.c.a.i;
import c.b.c.a.i0.i;
import c.b.c.a.i0.j;
import c.b.c.a.i0.k;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.c;
import c.b.c.a.m0.e0;
import c.b.c.a.m0.i0;
import c.b.c.a.m0.n0;
import java.security.GeneralSecurityException;

public class d extends i<c.b.c.a.i0.i> {

    public class a extends i.b<e0, c.b.c.a.i0.i> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public e0 a(c.b.c.a.i0.i iVar) {
            c.b.c.a.i0.i iVar2 = iVar;
            byte[] r = iVar2.keyValue_.r();
            k kVar = iVar2.params_;
            if (kVar == null) {
                kVar = k.DEFAULT_INSTANCE;
            }
            return new c(r, kVar.ivSize_);
        }
    }

    public class b extends i.a<j, c.b.c.a.i0.i> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public c.b.c.a.i0.i a(j jVar) {
            j jVar2 = jVar;
            i.b bVar = (i.b) c.b.c.a.i0.i.DEFAULT_INSTANCE.e();
            k kVar = jVar2.params_;
            if (kVar == null) {
                kVar = k.DEFAULT_INSTANCE;
            }
            bVar.d();
            c.b.c.a.i0.i.n((c.b.c.a.i0.i) bVar.f3674c, kVar);
            byte[] a2 = i0.a(jVar2.keySize_);
            c.b.c.a.j0.a.i h = c.b.c.a.j0.a.i.h(a2, 0, a2.length);
            bVar.d();
            c.b.c.a.i0.i.o((c.b.c.a.i0.i) bVar.f3674c, h);
            if (d.this != null) {
                bVar.d();
                ((c.b.c.a.i0.i) bVar.f3674c).version_ = 0;
                return (c.b.c.a.i0.i) bVar.b();
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public j b(c.b.c.a.j0.a.i iVar) {
            return (j) y.k(j.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(j jVar) {
            j jVar2 = jVar;
            n0.a(jVar2.keySize_);
            d dVar = d.this;
            k kVar = jVar2.params_;
            if (kVar == null) {
                kVar = k.DEFAULT_INSTANCE;
            }
            if (dVar != null) {
                int i = kVar.ivSize_;
                if (i < 12 || i > 16) {
                    throw new GeneralSecurityException("invalid IV size");
                }
                return;
            }
            throw null;
        }
    }

    public d() {
        super(c.b.c.a.i0.i.class, new a(e0.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.j, c.b.c.a.i0.i>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, c.b.c.a.i0.i> c() {
        return new b(j.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.SYMMETRIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public c.b.c.a.i0.i e(c.b.c.a.j0.a.i iVar) {
        return (c.b.c.a.i0.i) y.k(c.b.c.a.i0.i.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* renamed from: h */
    public void g(c.b.c.a.i0.i iVar) {
        n0.e(iVar.version_, 0);
        n0.a(iVar.keyValue_.size());
        k kVar = iVar.params_;
        if (kVar == null) {
            kVar = k.DEFAULT_INSTANCE;
        }
        int i = kVar.ivSize_;
        if (i < 12 || i > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }
}
