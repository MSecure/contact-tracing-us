package c.b.c.a.k0;

import c.b.a.a.c.n.c;
import c.b.c.a.i;
import c.b.c.a.i0.a0;
import c.b.c.a.i0.b0;
import c.b.c.a.i0.v0;
import c.b.c.a.i0.y;
import c.b.c.a.i0.z;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.r0;
import c.b.c.a.m0.n;
import c.b.c.a.m0.n0;
import c.b.c.a.s;
import c.b.c.a.t;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

public final class a extends s<a0, b0> {

    /* renamed from: c.b.c.a.k0.a$a  reason: collision with other inner class name */
    public class C0093a extends i.b<t, a0> {
        public C0093a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public t a(a0 a0Var) {
            a0 a0Var2 = a0Var;
            return new n(c.e1(c.l2(a0Var2.p().q().n()), a0Var2.keyValue_.r()), c.o2(a0Var2.p().q().p()), c.n2(a0Var2.p().q().o()));
        }
    }

    public class b extends i.a<y, a0> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public a0 a(y yVar) {
            z zVar = yVar.params_;
            if (zVar == null) {
                zVar = z.DEFAULT_INSTANCE;
            }
            KeyPair W0 = c.W0(c.l2(zVar.n()));
            ECPrivateKey eCPrivateKey = (ECPrivateKey) W0.getPrivate();
            ECPoint w = ((ECPublicKey) W0.getPublic()).getW();
            b0.b bVar = (b0.b) b0.DEFAULT_INSTANCE.e();
            if (a.this != null) {
                bVar.d();
                ((b0) bVar.f3674c).version_ = 0;
                bVar.d();
                b0.n((b0) bVar.f3674c, zVar);
                c.b.c.a.j0.a.i e2 = c.b.c.a.j0.a.i.e(w.getAffineX().toByteArray());
                bVar.d();
                b0.o((b0) bVar.f3674c, e2);
                c.b.c.a.j0.a.i e3 = c.b.c.a.j0.a.i.e(w.getAffineY().toByteArray());
                bVar.d();
                b0.p((b0) bVar.f3674c, e3);
                b0 b0Var = (b0) bVar.b();
                a0.b bVar2 = (a0.b) a0.DEFAULT_INSTANCE.e();
                if (a.this != null) {
                    bVar2.d();
                    ((a0) bVar2.f3674c).version_ = 0;
                    bVar2.d();
                    a0.n((a0) bVar2.f3674c, b0Var);
                    c.b.c.a.j0.a.i e4 = c.b.c.a.j0.a.i.e(eCPrivateKey.getS().toByteArray());
                    bVar2.d();
                    a0.o((a0) bVar2.f3674c, e4);
                    return (a0) bVar2.b();
                }
                throw null;
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public y b(c.b.c.a.j0.a.i iVar) {
            return (y) c.b.c.a.j0.a.y.k(y.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(y yVar) {
            z zVar = yVar.params_;
            if (zVar == null) {
                zVar = z.DEFAULT_INSTANCE;
            }
            c.w2(zVar);
        }
    }

    public a() {
        super(a0.class, b0.class, new C0093a(t.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
    }

    @Override // c.b.c.a.i
    public i.a<y, a0> c() {
        return new b(y.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.ASYMMETRIC_PRIVATE;
    }

    @Override // c.b.c.a.i
    public r0 e(c.b.c.a.j0.a.i iVar) {
        return (a0) c.b.c.a.j0.a.y.k(a0.DEFAULT_INSTANCE, iVar, q.a());
    }

    @Override // c.b.c.a.i
    public void g(r0 r0Var) {
        a0 a0Var = (a0) r0Var;
        n0.e(a0Var.version_, 0);
        c.w2(a0Var.p().q());
    }
}
