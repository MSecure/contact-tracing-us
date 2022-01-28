package c.b.c.a.e0;

import c.b.a.a.c.n.c;
import c.b.c.a.d;
import c.b.c.a.i;
import c.b.c.a.i0.e0;
import c.b.c.a.i0.f0;
import c.b.c.a.i0.g0;
import c.b.c.a.i0.h0;
import c.b.c.a.i0.i0;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.r0;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.n0;
import c.b.c.a.m0.q;
import c.b.c.a.s;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

public final class a extends s<g0, h0> {

    /* renamed from: c.b.c.a.e0.a$a  reason: collision with other inner class name */
    public class C0084a extends i.b<d, g0> {
        public C0084a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public d a(g0 g0Var) {
            g0 g0Var2 = g0Var;
            h0 h0Var = g0Var2.publicKey_;
            if (h0Var == null) {
                h0Var = h0.DEFAULT_INSTANCE;
            }
            f0 q = h0Var.q();
            i0 p = q.p();
            return new q(c.e1(c.k2(p.n()), g0Var2.keyValue_.r()), p.hkdfSalt_.r(), c.p2(p.o()), c.r2(q.o()), new f(q.n().n()));
        }
    }

    public class b extends i.a<e0, g0> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public g0 a(e0 e0Var) {
            e0 e0Var2 = e0Var;
            KeyPair W0 = c.W0(c.k2(e0Var2.n().p().n()));
            ECPrivateKey eCPrivateKey = (ECPrivateKey) W0.getPrivate();
            ECPoint w = ((ECPublicKey) W0.getPublic()).getW();
            h0.b bVar = (h0.b) h0.DEFAULT_INSTANCE.e();
            if (a.this != null) {
                bVar.d();
                ((h0) bVar.f3674c).version_ = 0;
                f0 n = e0Var2.n();
                bVar.d();
                h0.n((h0) bVar.f3674c, n);
                c.b.c.a.j0.a.i e2 = c.b.c.a.j0.a.i.e(w.getAffineX().toByteArray());
                bVar.d();
                h0.o((h0) bVar.f3674c, e2);
                c.b.c.a.j0.a.i e3 = c.b.c.a.j0.a.i.e(w.getAffineY().toByteArray());
                bVar.d();
                h0.p((h0) bVar.f3674c, e3);
                h0 h0Var = (h0) bVar.b();
                g0.b bVar2 = (g0.b) g0.DEFAULT_INSTANCE.e();
                if (a.this != null) {
                    bVar2.d();
                    ((g0) bVar2.f3674c).version_ = 0;
                    bVar2.d();
                    g0.n((g0) bVar2.f3674c, h0Var);
                    c.b.c.a.j0.a.i e4 = c.b.c.a.j0.a.i.e(eCPrivateKey.getS().toByteArray());
                    bVar2.d();
                    g0.o((g0) bVar2.f3674c, e4);
                    return (g0) bVar2.b();
                }
                throw null;
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public e0 b(c.b.c.a.j0.a.i iVar) {
            return (e0) y.k(e0.DEFAULT_INSTANCE, iVar, c.b.c.a.j0.a.q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(e0 e0Var) {
            c.v2(e0Var.n());
        }
    }

    public a() {
        super(g0.class, h0.class, new C0084a(d.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // c.b.c.a.i
    public i.a<e0, g0> c() {
        return new b(e0.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.ASYMMETRIC_PRIVATE;
    }

    @Override // c.b.c.a.i
    public r0 e(c.b.c.a.j0.a.i iVar) {
        return (g0) y.k(g0.DEFAULT_INSTANCE, iVar, c.b.c.a.j0.a.q.a());
    }

    @Override // c.b.c.a.i
    public void g(r0 r0Var) {
        g0 g0Var = (g0) r0Var;
        if (!(g0Var.keyValue_.size() == 0)) {
            n0.e(g0Var.version_, 0);
            h0 h0Var = g0Var.publicKey_;
            if (h0Var == null) {
                h0Var = h0.DEFAULT_INSTANCE;
            }
            c.v2(h0Var.q());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }
}
