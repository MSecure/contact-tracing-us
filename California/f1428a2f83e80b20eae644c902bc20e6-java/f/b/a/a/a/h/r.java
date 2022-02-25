package f.b.a.a.a.h;

import f.b.b.c.a;
import java.security.SecureRandom;
import l.b.a.p;
import l.b.a.u.c;
import l.b.a.u.d;

public final class r {
    public static final SecureRandom a = new SecureRandom();
    public static final a b = a.a;

    static {
        c cVar = c.f4112h;
        d dVar = new d();
        dVar.h("yyyy-MM-dd, HH:mm:ss z");
        dVar.q().h(p.t("UTC"));
    }

    public static String a(int i2) {
        byte[] bArr = new byte[i2];
        a.nextBytes(bArr);
        return b.c(bArr);
    }
}
