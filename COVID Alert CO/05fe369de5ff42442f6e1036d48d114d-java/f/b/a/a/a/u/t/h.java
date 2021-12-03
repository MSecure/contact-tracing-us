package f.b.a.a.a.u.t;

import f.b.a.a.a.b0.h0;
import f.b.a.a.a.b0.v0;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.d;
import l.b.a.e;

public class h implements e0 {
    public static final d b = d.f(14);
    public final v0 a;

    public h(v0 v0Var) {
        this.a = v0Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        int[] iArr = new int[20];
        e c = this.a.c();
        e j2 = this.a.j();
        e k2 = this.a.k();
        if (j2.t(c) && c.t(k2) && c.t(j2.w(b))) {
            int b2 = this.a.b();
            h0.d h2 = this.a.h();
            int i2 = 0;
            if (h2 != null) {
                int ordinal = h2.ordinal();
                if (ordinal == 0) {
                    i2 = 1;
                } else if (ordinal == 1) {
                    i2 = 2;
                } else if (ordinal == 2) {
                    i2 = 5;
                } else if (ordinal == 3) {
                    i2 = 3;
                }
            }
            if (i2 != 0 && b2 > 0) {
                iArr[(b2 - 1) + ((i2 - 1) * 4)] = 1;
            }
        }
        return b.O0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "SecondaryAttack14d-v1";
    }
}
