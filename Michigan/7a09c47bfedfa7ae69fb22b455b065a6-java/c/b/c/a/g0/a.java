package c.b.c.a.g0;

import c.b.c.a.i;
import c.b.c.a.i0.a;
import c.b.c.a.i0.c;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.i0;
import c.b.c.a.m0.n0;
import c.b.c.a.o;
import java.security.GeneralSecurityException;

public final class a extends i<c.b.c.a.i0.a> {

    /* renamed from: c.b.c.a.g0.a$a  reason: collision with other inner class name */
    public class C0095a extends i.b<o, c.b.c.a.i0.a> {
        public C0095a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public o a(c.b.c.a.i0.a aVar) {
            c.b.c.a.i0.a aVar2 = aVar;
            byte[] q = aVar2.keyValue_.q();
            c cVar = aVar2.params_;
            if (cVar == null) {
                cVar = c.DEFAULT_INSTANCE;
            }
            return new c.b.c.a.m0.a(q, cVar.tagSize_);
        }
    }

    public class b extends i.a<c.b.c.a.i0.b, c.b.c.a.i0.a> {
        public b(a aVar, Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public c.b.c.a.i0.a a(c.b.c.a.i0.b bVar) {
            c.b.c.a.i0.b bVar2 = bVar;
            a.b bVar3 = (a.b) c.b.c.a.i0.a.DEFAULT_INSTANCE.e();
            bVar3.d();
            ((c.b.c.a.i0.a) bVar3.f5063c).version_ = 0;
            byte[] a2 = i0.a(bVar2.keySize_);
            c.b.c.a.j0.a.i g2 = c.b.c.a.j0.a.i.g(a2, 0, a2.length);
            bVar3.d();
            c.b.c.a.i0.a.n((c.b.c.a.i0.a) bVar3.f5063c, g2);
            c cVar = bVar2.params_;
            if (cVar == null) {
                cVar = c.DEFAULT_INSTANCE;
            }
            bVar3.d();
            c.b.c.a.i0.a.o((c.b.c.a.i0.a) bVar3.f5063c, cVar);
            return (c.b.c.a.i0.a) bVar3.b();
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public c.b.c.a.i0.b b(c.b.c.a.j0.a.i iVar) {
            return (c.b.c.a.i0.b) y.k(c.b.c.a.i0.b.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(c.b.c.a.i0.b bVar) {
            c.b.c.a.i0.b bVar2 = bVar;
            c cVar = bVar2.params_;
            if (cVar == null) {
                cVar = c.DEFAULT_INSTANCE;
            }
            a.h(cVar);
            if (bVar2.keySize_ != 32) {
                throw new GeneralSecurityException("AesCmacKey size wrong, must be 16 bytes");
            }
        }
    }

    public a() {
        super(c.b.c.a.i0.a.class, new C0095a(o.class));
    }

    public static void h(c cVar) {
        int i = cVar.tagSize_;
        if (i < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (i > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.b, c.b.c.a.i0.a>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, c.b.c.a.i0.a> c() {
        return new b(this, c.b.c.a.i0.b.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.SYMMETRIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public c.b.c.a.i0.a e(c.b.c.a.j0.a.i iVar) {
        return (c.b.c.a.i0.a) y.k(c.b.c.a.i0.a.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(c.b.c.a.i0.a aVar) {
        c.b.c.a.i0.a aVar2 = aVar;
        n0.e(aVar2.version_, 0);
        if (aVar2.keyValue_.size() == 32) {
            c cVar = aVar2.params_;
            if (cVar == null) {
                cVar = c.DEFAULT_INSTANCE;
            }
            h(cVar);
            return;
        }
        throw new GeneralSecurityException("AesCmacKey size wrong, must be 16 bytes");
    }
}
