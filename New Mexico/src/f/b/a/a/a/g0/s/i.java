package f.b.a.a.a.g0.s;

import f.b.a.a.a.n0.a1;
import f.b.a.a.a.n0.j0;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.d;
import l.b.a.e;
/* loaded from: classes.dex */
public class i implements e0 {
    public static final d b = d.f(14);
    public final a1 a;

    public i(a1 a1Var) {
        this.a = a1Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        int[] iArr = new int[20];
        e d2 = this.a.d();
        e n = this.a.n();
        e o = this.a.o();
        if (n.t(d2) && d2.t(o) && d2.t(n.w(b))) {
            int c = this.a.c();
            j0.d l2 = this.a.l();
            int i2 = 0;
            if (l2 != null) {
                int ordinal = l2.ordinal();
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
            if (i2 != 0 && c > 0) {
                iArr[(c - 1) + ((i2 - 1) * 4)] = 1;
            }
        }
        return b.R0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "SecondaryAttack14d-v2";
    }
}
