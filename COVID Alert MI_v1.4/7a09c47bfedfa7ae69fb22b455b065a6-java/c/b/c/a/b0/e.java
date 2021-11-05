package c.b.c.a.b0;

import c.b.c.a.i;
import c.b.c.a.i0.l;
import c.b.c.a.i0.m;
import c.b.c.a.i0.n;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.d;
import c.b.c.a.m0.i0;
import c.b.c.a.m0.n0;
import java.security.GeneralSecurityException;

public final class e extends i<l> {

    public class a extends i.b<c.b.c.a.a, l> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public c.b.c.a.a a(l lVar) {
            l lVar2 = lVar;
            return new d(lVar2.keyValue_.q(), lVar2.p().ivSize_);
        }
    }

    public class b extends i.a<m, l> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public l a(m mVar) {
            m mVar2 = mVar;
            l.b bVar = (l.b) l.DEFAULT_INSTANCE.e();
            byte[] a2 = i0.a(mVar2.keySize_);
            c.b.c.a.j0.a.i g2 = c.b.c.a.j0.a.i.g(a2, 0, a2.length);
            bVar.d();
            l.o((l) bVar.f5063c, g2);
            n n = mVar2.n();
            bVar.d();
            l.n((l) bVar.f5063c, n);
            if (e.this != null) {
                bVar.d();
                ((l) bVar.f5063c).version_ = 0;
                return (l) bVar.b();
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public m b(c.b.c.a.j0.a.i iVar) {
            return (m) y.k(m.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(m mVar) {
            m mVar2 = mVar;
            n0.a(mVar2.keySize_);
            if (mVar2.n().ivSize_ != 12 && mVar2.n().ivSize_ != 16) {
                throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
            }
        }
    }

    public e() {
        super(l.class, new a(c.b.c.a.a.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.m, c.b.c.a.i0.l>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, l> c() {
        return new b(m.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.SYMMETRIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public l e(c.b.c.a.j0.a.i iVar) {
        return (l) y.k(l.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(l lVar) {
        l lVar2 = lVar;
        n0.e(lVar2.version_, 0);
        n0.a(lVar2.keyValue_.size());
        if (lVar2.p().ivSize_ != 12 && lVar2.p().ivSize_ != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
