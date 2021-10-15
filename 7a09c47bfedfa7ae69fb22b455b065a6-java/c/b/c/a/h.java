package c.b.c.a;

import c.b.c.a.i0.f1;
import c.b.c.a.i0.x0;
import c.b.c.a.j0.a.i;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final x0 f4827a;

    public enum a {
        TINK,
        LEGACY,
        RAW,
        CRUNCHY
    }

    public h(x0 x0Var) {
        this.f4827a = x0Var;
    }

    public static h a(String str, byte[] bArr, a aVar) {
        f1 f1Var;
        x0.b bVar = (x0.b) x0.DEFAULT_INSTANCE.e();
        bVar.d();
        x0 x0Var = (x0) bVar.f5063c;
        if (x0Var != null) {
            str.getClass();
            x0Var.typeUrl_ = str;
            i g2 = i.g(bArr, 0, bArr.length);
            bVar.d();
            x0 x0Var2 = (x0) bVar.f5063c;
            if (x0Var2 != null) {
                g2.getClass();
                x0Var2.value_ = g2;
                int ordinal = aVar.ordinal();
                if (ordinal == 0) {
                    f1Var = f1.TINK;
                } else if (ordinal == 1) {
                    f1Var = f1.LEGACY;
                } else if (ordinal == 2) {
                    f1Var = f1.RAW;
                } else if (ordinal == 3) {
                    f1Var = f1.CRUNCHY;
                } else {
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
                bVar.d();
                x0 x0Var3 = (x0) bVar.f5063c;
                if (x0Var3 != null) {
                    x0Var3.outputPrefixType_ = f1Var.a();
                    return new h((x0) bVar.b());
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }
}
