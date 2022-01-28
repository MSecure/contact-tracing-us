package c.b.c.a.k0;

import c.a.b.o;
import c.b.a.a.c.n.c;
import c.b.c.a.i;
import c.b.c.a.i0.h1;
import c.b.c.a.i0.i1;
import c.b.c.a.i0.j1;
import c.b.c.a.i0.k1;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.r0;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.a0;
import c.b.c.a.m0.j0;
import c.b.c.a.m0.k0;
import c.b.c.a.m0.n0;
import c.b.c.a.s;
import c.b.c.a.t;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;

public final class g extends s<j1, k1> {

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f3689d = "Tink and Wycheproof.".getBytes(Charset.forName(o.DEFAULT_PARAMS_ENCODING));

    public class a extends i.b<t, j1> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public t a(j1 j1Var) {
            j1 j1Var2 = j1Var;
            KeyFactory a2 = a0.k.a("RSA");
            j0 j0Var = new j0((RSAPrivateCrtKey) a2.generatePrivate(new RSAPrivateCrtKeySpec(new BigInteger(1, j1Var2.u().n_.r()), new BigInteger(1, j1Var2.u().e_.r()), new BigInteger(1, j1Var2.d_.r()), new BigInteger(1, j1Var2.p_.r()), new BigInteger(1, j1Var2.q_.r()), new BigInteger(1, j1Var2.dp_.r()), new BigInteger(1, j1Var2.dq_.r()), new BigInteger(1, j1Var2.crt_.r()))), c.o2(j1Var2.u().q().n()));
            try {
                new k0((RSAPublicKey) a2.generatePublic(new RSAPublicKeySpec(new BigInteger(1, j1Var2.u().n_.r()), new BigInteger(1, j1Var2.u().e_.r()))), c.o2(j1Var2.u().q().n())).a(j0Var.a(g.f3689d), g.f3689d);
                return j0Var;
            } catch (GeneralSecurityException e2) {
                throw new RuntimeException("Security bug: signing with private key followed by verifying with public key failed" + e2);
            }
        }
    }

    public class b extends i.a<h1, j1> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public j1 a(h1 h1Var) {
            h1 h1Var2 = h1Var;
            i1 i1Var = h1Var2.params_;
            if (i1Var == null) {
                i1Var = i1.DEFAULT_INSTANCE;
            }
            KeyPairGenerator a2 = a0.j.a("RSA");
            a2.initialize(new RSAKeyGenParameterSpec(h1Var2.modulusSizeInBits_, new BigInteger(1, h1Var2.publicExponent_.r())));
            KeyPair generateKeyPair = a2.generateKeyPair();
            RSAPublicKey rSAPublicKey = (RSAPublicKey) generateKeyPair.getPublic();
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) generateKeyPair.getPrivate();
            k1.b bVar = (k1.b) k1.DEFAULT_INSTANCE.e();
            if (g.this != null) {
                bVar.d();
                ((k1) bVar.f3674c).version_ = 0;
                bVar.d();
                k1.n((k1) bVar.f3674c, i1Var);
                c.b.c.a.j0.a.i e2 = c.b.c.a.j0.a.i.e(rSAPublicKey.getPublicExponent().toByteArray());
                bVar.d();
                k1.p((k1) bVar.f3674c, e2);
                c.b.c.a.j0.a.i e3 = c.b.c.a.j0.a.i.e(rSAPublicKey.getModulus().toByteArray());
                bVar.d();
                k1.o((k1) bVar.f3674c, e3);
                k1 k1Var = (k1) bVar.b();
                j1.b bVar2 = (j1.b) j1.DEFAULT_INSTANCE.e();
                if (g.this != null) {
                    bVar2.d();
                    ((j1) bVar2.f3674c).version_ = 0;
                    bVar2.d();
                    j1.r((j1) bVar2.f3674c, k1Var);
                    c.b.c.a.j0.a.i e4 = c.b.c.a.j0.a.i.e(rSAPrivateCrtKey.getPrivateExponent().toByteArray());
                    bVar2.d();
                    j1.s((j1) bVar2.f3674c, e4);
                    c.b.c.a.j0.a.i e5 = c.b.c.a.j0.a.i.e(rSAPrivateCrtKey.getPrimeP().toByteArray());
                    bVar2.d();
                    j1.t((j1) bVar2.f3674c, e5);
                    c.b.c.a.j0.a.i e6 = c.b.c.a.j0.a.i.e(rSAPrivateCrtKey.getPrimeQ().toByteArray());
                    bVar2.d();
                    j1.n((j1) bVar2.f3674c, e6);
                    c.b.c.a.j0.a.i e7 = c.b.c.a.j0.a.i.e(rSAPrivateCrtKey.getPrimeExponentP().toByteArray());
                    bVar2.d();
                    j1.o((j1) bVar2.f3674c, e7);
                    c.b.c.a.j0.a.i e8 = c.b.c.a.j0.a.i.e(rSAPrivateCrtKey.getPrimeExponentQ().toByteArray());
                    bVar2.d();
                    j1.p((j1) bVar2.f3674c, e8);
                    c.b.c.a.j0.a.i e9 = c.b.c.a.j0.a.i.e(rSAPrivateCrtKey.getCrtCoefficient().toByteArray());
                    bVar2.d();
                    j1.q((j1) bVar2.f3674c, e9);
                    return (j1) bVar2.b();
                }
                throw null;
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public h1 b(c.b.c.a.j0.a.i iVar) {
            return (h1) y.k(h1.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(h1 h1Var) {
            h1 h1Var2 = h1Var;
            i1 i1Var = h1Var2.params_;
            if (i1Var == null) {
                i1Var = i1.DEFAULT_INSTANCE;
            }
            c.x2(i1Var);
            n0.c(h1Var2.modulusSizeInBits_);
        }
    }

    public g() {
        super(j1.class, k1.class, new a(t.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey";
    }

    @Override // c.b.c.a.i
    public i.a<h1, j1> c() {
        return new b(h1.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.ASYMMETRIC_PRIVATE;
    }

    @Override // c.b.c.a.i
    public r0 e(c.b.c.a.j0.a.i iVar) {
        return (j1) y.k(j1.DEFAULT_INSTANCE, iVar, q.a());
    }

    @Override // c.b.c.a.i
    public void g(r0 r0Var) {
        j1 j1Var = (j1) r0Var;
        n0.e(j1Var.version_, 0);
        n0.c(new BigInteger(1, j1Var.u().n_.r()).bitLength());
        c.x2(j1Var.u().q());
    }
}
