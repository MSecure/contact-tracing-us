package c.b.c.a.m0;

import c.b.c.a.t;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

public final class j0 implements t {

    /* renamed from: a  reason: collision with root package name */
    public final RSAPrivateCrtKey f3753a;

    /* renamed from: b  reason: collision with root package name */
    public final RSAPublicKey f3754b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3755c;

    public j0(RSAPrivateCrtKey rSAPrivateCrtKey, c0 c0Var) {
        n0.d(c0Var);
        n0.c(rSAPrivateCrtKey.getModulus().bitLength());
        this.f3753a = rSAPrivateCrtKey;
        n0.d(c0Var);
        this.f3755c = c0Var + "withRSA";
        this.f3754b = (RSAPublicKey) a0.k.a("RSA").generatePublic(new RSAPublicKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent()));
    }

    public byte[] a(byte[] bArr) {
        Signature a2 = a0.h.a(this.f3755c);
        a2.initSign(this.f3753a);
        a2.update(bArr);
        byte[] sign = a2.sign();
        Signature a3 = a0.h.a(this.f3755c);
        a3.initVerify(this.f3754b);
        a3.update(bArr);
        if (a3.verify(sign)) {
            return sign;
        }
        throw new RuntimeException("Security bug: RSA signature computation error");
    }
}
