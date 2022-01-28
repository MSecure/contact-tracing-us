package c.b.c.a.k0;

import c.a.b.o;
import c.b.a.a.c.n.c;
import c.b.c.a.i;
import c.b.c.a.i0.l1;
import c.b.c.a.i0.m1;
import c.b.c.a.i0.n1;
import c.b.c.a.i0.o1;
import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.r0;
import c.b.c.a.j0.a.y;
import c.b.c.a.m0.a0;
import c.b.c.a.m0.l0;
import c.b.c.a.m0.m0;
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

public final class i extends s<n1, o1> {

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f3691d = "Tink and Wycheproof.".getBytes(Charset.forName(o.DEFAULT_PARAMS_ENCODING));

    public class a extends i.b<t, n1> {
        public a(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.c.a.i.b
        public t a(n1 n1Var) {
            n1 n1Var2 = n1Var;
            KeyFactory a2 = a0.k.a("RSA");
            m1 q = n1Var2.u().q();
            l0 l0Var = new l0((RSAPrivateCrtKey) a2.generatePrivate(new RSAPrivateCrtKeySpec(new BigInteger(1, n1Var2.u().n_.r()), new BigInteger(1, n1Var2.u().e_.r()), new BigInteger(1, n1Var2.d_.r()), new BigInteger(1, n1Var2.p_.r()), new BigInteger(1, n1Var2.q_.r()), new BigInteger(1, n1Var2.dp_.r()), new BigInteger(1, n1Var2.dq_.r()), new BigInteger(1, n1Var2.crt_.r()))), c.o2(q.o()), c.o2(q.n()), q.saltLength_);
            try {
                new m0((RSAPublicKey) a2.generatePublic(new RSAPublicKeySpec(new BigInteger(1, n1Var2.u().n_.r()), new BigInteger(1, n1Var2.u().e_.r()))), c.o2(q.o()), c.o2(q.n()), q.saltLength_).a(l0Var.a(i.f3691d), i.f3691d);
                return l0Var;
            } catch (GeneralSecurityException e2) {
                throw new RuntimeException("Security bug: signing with private key followed by verifying with public key failed" + e2);
            }
        }
    }

    public class b extends i.a<l1, n1> {
        public b(Class cls) {
            super(cls);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public n1 a(l1 l1Var) {
            l1 l1Var2 = l1Var;
            m1 m1Var = l1Var2.params_;
            if (m1Var == null) {
                m1Var = m1.DEFAULT_INSTANCE;
            }
            n0.c(l1Var2.modulusSizeInBits_);
            n0.d(c.o2(m1Var.o()));
            KeyPairGenerator a2 = a0.j.a("RSA");
            a2.initialize(new RSAKeyGenParameterSpec(l1Var2.modulusSizeInBits_, new BigInteger(1, l1Var2.publicExponent_.r())));
            KeyPair generateKeyPair = a2.generateKeyPair();
            RSAPublicKey rSAPublicKey = (RSAPublicKey) generateKeyPair.getPublic();
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) generateKeyPair.getPrivate();
            o1.b bVar = (o1.b) o1.DEFAULT_INSTANCE.e();
            if (i.this != null) {
                bVar.d();
                ((o1) bVar.f3674c).version_ = 0;
                bVar.d();
                o1.n((o1) bVar.f3674c, m1Var);
                c.b.c.a.j0.a.i e2 = c.b.c.a.j0.a.i.e(rSAPublicKey.getPublicExponent().toByteArray());
                bVar.d();
                o1.p((o1) bVar.f3674c, e2);
                c.b.c.a.j0.a.i e3 = c.b.c.a.j0.a.i.e(rSAPublicKey.getModulus().toByteArray());
                bVar.d();
                o1.o((o1) bVar.f3674c, e3);
                o1 o1Var = (o1) bVar.b();
                n1.b bVar2 = (n1.b) n1.DEFAULT_INSTANCE.e();
                if (i.this != null) {
                    bVar2.d();
                    ((n1) bVar2.f3674c).version_ = 0;
                    bVar2.d();
                    n1.r((n1) bVar2.f3674c, o1Var);
                    c.b.c.a.j0.a.i e4 = c.b.c.a.j0.a.i.e(rSAPrivateCrtKey.getPrivateExponent().toByteArray());
                    bVar2.d();
                    n1.s((n1) bVar2.f3674c, e4);
                    c.b.c.a.j0.a.i e5 = c.b.c.a.j0.a.i.e(rSAPrivateCrtKey.getPrimeP().toByteArray());
                    bVar2.d();
                    n1.t((n1) bVar2.f3674c, e5);
                    c.b.c.a.j0.a.i e6 = c.b.c.a.j0.a.i.e(rSAPrivateCrtKey.getPrimeQ().toByteArray());
                    bVar2.d();
                    n1.n((n1) bVar2.f3674c, e6);
                    c.b.c.a.j0.a.i e7 = c.b.c.a.j0.a.i.e(rSAPrivateCrtKey.getPrimeExponentP().toByteArray());
                    bVar2.d();
                    n1.o((n1) bVar2.f3674c, e7);
                    c.b.c.a.j0.a.i e8 = c.b.c.a.j0.a.i.e(rSAPrivateCrtKey.getPrimeExponentQ().toByteArray());
                    bVar2.d();
                    n1.p((n1) bVar2.f3674c, e8);
                    c.b.c.a.j0.a.i e9 = c.b.c.a.j0.a.i.e(rSAPrivateCrtKey.getCrtCoefficient().toByteArray());
                    bVar2.d();
                    n1.q((n1) bVar2.f3674c, e9);
                    return (n1) bVar2.b();
                }
                throw null;
            }
            throw null;
        }

        /* Return type fixed from 'c.b.c.a.j0.a.r0' to match base method */
        @Override // c.b.c.a.i.a
        public l1 b(c.b.c.a.j0.a.i iVar) {
            return (l1) y.k(l1.DEFAULT_INSTANCE, iVar, q.a());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.j0.a.r0] */
        @Override // c.b.c.a.i.a
        public void c(l1 l1Var) {
            l1 l1Var2 = l1Var;
            m1 m1Var = l1Var2.params_;
            if (m1Var == null) {
                m1Var = m1.DEFAULT_INSTANCE;
            }
            c.y2(m1Var);
            n0.c(l1Var2.modulusSizeInBits_);
        }
    }

    public i() {
        super(n1.class, o1.class, new a(t.class));
    }

    @Override // c.b.c.a.i
    public String a() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey";
    }

    @Override // c.b.c.a.i
    public i.a<l1, n1> c() {
        return new b(l1.class);
    }

    @Override // c.b.c.a.i
    public v0.c d() {
        return v0.c.ASYMMETRIC_PRIVATE;
    }

    @Override // c.b.c.a.i
    public r0 e(c.b.c.a.j0.a.i iVar) {
        return (n1) y.k(n1.DEFAULT_INSTANCE, iVar, q.a());
    }

    @Override // c.b.c.a.i
    public void g(r0 r0Var) {
        n1 n1Var = (n1) r0Var;
        n0.e(n1Var.version_, 0);
        n0.c(new BigInteger(1, n1Var.u().n_.r()).bitLength());
        c.y2(n1Var.u().q());
    }
}
