package c.b.c.a.m0;

import c.b.c.a.t;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

public final class j0 implements t {

    /* renamed from: a  reason: collision with root package name */
    public final RSAPrivateCrtKey f5150a;

    /* renamed from: b  reason: collision with root package name */
    public final RSAPublicKey f5151b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5152c;

    public j0(RSAPrivateCrtKey rSAPrivateCrtKey, c0 c0Var) {
        n0.d(c0Var);
        n0.c(rSAPrivateCrtKey.getModulus().bitLength());
        this.f5150a = rSAPrivateCrtKey;
        n0.d(c0Var);
        this.f5152c = c0Var + "withRSA";
        this.f5151b = (RSAPublicKey) a0.k.a("RSA").generatePublic(new RSAPublicKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent()));
    }

    public byte[] a(byte[] bArr) {
        Signature a2 = a0.h.a(this.f5152c);
        a2.initSign(this.f5150a);
        a2.update(bArr);
        byte[] sign = a2.sign();
        Signature a3 = a0.h.a(this.f5152c);
        a3.initVerify(this.f5151b);
        a3.update(bArr);
        if (a3.verify(sign)) {
            return sign;
        }
        throw new RuntimeException("Security bug: RSA signature computation error");
    }
}
