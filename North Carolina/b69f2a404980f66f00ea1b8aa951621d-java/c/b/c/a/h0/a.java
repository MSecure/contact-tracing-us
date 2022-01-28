package c.b.c.a.h0;

import c.b.c.a.i;
import c.b.c.a.i0.o0;
import c.b.c.a.i0.p0;
import c.b.c.a.i0.q0;
import c.b.c.a.i0.r0;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.c0;
import c.b.c.a.m0.i0;
import c.b.c.a.m0.n0;
import java.security.GeneralSecurityException;

public class a extends i<p0> {

    /* renamed from: c.b.c.a.h0.a$a  reason: collision with other inner class name */
    public class C0088a extends i.b<c.b.c.a.m0.q0.c, p0> {
        public C0088a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public c.b.c.a.m0.q0.c a(p0 p0Var) {
            p0 p0Var2 = p0Var;
            return new c.b.c.a.m0.q0.a(a.h(p0Var2.p().n()), p0Var2.keyValue_.r(), p0Var2.p().salt_.r());
        }
    }

    public class b extends i.b<e, p0> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public e a(p0 p0Var) {
            p0 p0Var2 = p0Var;
            return new b(this, new c.b.c.a.m0.q0.b(new c.b.c.a.m0.q0.a(a.h(p0Var2.p().n()), p0Var2.keyValue_.r(), p0Var2.p().salt_.r())));
        }
    }

    public class c extends i.a<q0, p0> {
        public c(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public p0 a(q0 q0Var) {
            q0 q0Var2 = q0Var;
            p0.b bVar = (p0.b) p0.DEFAULT_INSTANCE.e();
            byte[] a2 = i0.a(q0Var2.keySize_);
            c.b.c.a.j0.a.i h = c.b.c.a.j0.a.i.h(a2, 0, a2.length);
            bVar.d();
            p0.o((p0) bVar.f3674c, h);
            if (a.this != null) {
                bVar.d();
                ((p0) bVar.f3674c).version_ = 0;
                r0 r0Var = q0Var2.params_;
                if (r0Var == null) {
                    r0Var = r0.DEFAULT_INSTANCE;
                }
                bVar.d();
                p0.n((p0) bVar.f3674c, r0Var);
                return (p0) bVar.b();
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public q0 b(c.b.c.a.j0.a.i iVar) {
            return (q0) y.k(q0.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(q0 q0Var) {
            q0 q0Var2 = q0Var;
            if (q0Var2.keySize_ >= 32) {
                r0 r0Var = q0Var2.params_;
                if (r0Var == null) {
                    r0Var = r0.DEFAULT_INSTANCE;
                }
                a.i(r0Var);
                return;
            }
            throw new GeneralSecurityException("Invalid HkdfPrfKey/HkdfPrfKeyFormat: Key size too short");
        }
    }

    public a() {
        super(p0.class, new C0088a(c.b.c.a.m0.q0.c.class), new b(e.class));
    }

    public static c0 h(o0 o0Var) {
        int ordinal = o0Var.ordinal();
        if (ordinal == 1) {
            return c0.SHA1;
        }
        if (ordinal == 2) {
            return c0.SHA384;
        }
        if (ordinal == 3) {
            return c0.SHA256;
        }
        if (ordinal == 4) {
            return c0.SHA512;
        }
        StringBuilder g = c.a.a.a.a.g("HashType ");
        g.append(o0Var.name());
        g.append(" not known in");
        throw new GeneralSecurityException(g.toString());
    }

    public static void i(r0 r0Var) {
        if (r0Var.n() != o0.SHA256 && r0Var.n() != o0.SHA512) {
            throw new GeneralSecurityException("Invalid HkdfPrfKey/HkdfPrfKeyFormat: Unsupported hash");
        }
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.HkdfPrfKey";
    }

    /* Return type fixed from 'c.b.c.a.i$a<c.b.c.a.i0.q0, c.b.c.a.i0.p0>' to match base method */
    @Override // c.b.c.a.i
    public i.a<?, p0> c() {
        return new c(q0.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.SYMMETRIC;
    }

    /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
    @Override // c.b.c.a.i
    public p0 e(c.b.c.a.j0.a.i iVar) {
        return (p0) y.k(p0.DEFAULT_INSTANCE, iVar, q.a());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
    @Override // c.b.c.a.i
    public void g(p0 p0Var) {
        p0 p0Var2 = p0Var;
        n0.e(p0Var2.version_, 0);
        if (p0Var2.keyValue_.size() >= 32) {
            i(p0Var2.p());
            return;
        }
        throw new GeneralSecurityException("Invalid HkdfPrfKey/HkdfPrfKeyFormat: Key size too short");
    }
}
