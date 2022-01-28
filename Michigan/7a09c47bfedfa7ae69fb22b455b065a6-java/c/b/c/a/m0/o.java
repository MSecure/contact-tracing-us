package c.b.c.a.m0;

import b.x.t;
import c.b.c.a.u;
import java.security.interfaces.ECPublicKey;

public final class o implements u {
    public o(ECPublicKey eCPublicKey, c0 c0Var, x xVar) {
        t.G(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        n0.d(c0Var);
        String str = c0Var + "withECDSA";
    }
}
