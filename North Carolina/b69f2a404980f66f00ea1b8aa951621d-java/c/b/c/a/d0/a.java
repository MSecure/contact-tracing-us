package c.b.c.a.d0;

import c.b.c.a.c;
import c.b.c.a.i;
import c.b.c.a.i0.t;
import c.b.c.a.i0.u;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.g;
import c.b.c.a.m0.i0;
import c.b.c.a.m0.n0;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

public final class a extends i<t> {

    /* renamed from: c.b.c.a.d0.a$a  reason: collision with other inner class name */
    public class C0083a extends i.b<c, t> {
        public C0083a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public c a(t tVar) {
            return new g(tVar.keyValue_.r());
        }
    }

    public class b extends i.a<u, t> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public t a(u uVar) {
            t.b bVar = (t.b) t.DEFAULT_INSTANCE.e();
            byte[] a2 = i0.a(uVar.keySize_);
            c.b.c.a.j0.a.i h = c.b.c.a.j0.a.i.h(a2, 0, a2.length);
            bVar.d();
            t.n((t) bVar.f3674c, h);
            if (a.this != null) {
                bVar.d();
                ((t) bVar.f3674c).version_ = 0;
                return (t) bVar.b();
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public u b(c.b.c.a.j0.a.i iVar) {
            return (u) y.k(u.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(u uVar) {
            u uVar2 = uVar;
            if (uVar2.keySize_ != 64) {
                StringBuilder g = c.a.a.a.a.g("invalid key size: ");
                g.append(uVar2.keySize_);
                g.append(". Valid keys must have 64 bytes.");
                throw new InvalidAlgorithmParameterException(g.toString());
            }
        }
    }

    public a() {
        super(t.class, new C0083a(c.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.u, c.b.c.a.i0.t>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, t> c() {
        return new b(u.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.SYMMETRIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public t e(c.b.c.a.j0.a.i iVar) {
        return (t) y.k(t.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(t tVar) {
        t tVar2 = tVar;
        n0.e(tVar2.version_, 0);
        if (tVar2.keyValue_.size() != 64) {
            StringBuilder g = c.a.a.a.a.g("invalid key size: ");
            g.append(tVar2.keyValue_.size());
            g.append(". Valid keys must have 64 bytes.");
            throw new InvalidKeyException(g.toString());
        }
    }
}
