package f.b.a.a.a.g0.s;

import f.b.a.a.a.n0.a1;
import f.b.a.a.a.n0.j0;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.d;
/* loaded from: classes.dex */
public class e implements e0 {
    public final a1 a;

    static {
        d.f(14);
    }

    public e(a1 a1Var) {
        this.a = a1Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        int[] iArr = new int[6];
        if (this.a.m().t(this.a.o())) {
            j0.d l2 = this.a.l();
            if (l2 == null) {
                iArr[0] = 1;
            } else {
                int ordinal = l2.ordinal();
                if (ordinal == 0) {
                    iArr[1] = 1;
                } else if (ordinal == 1) {
                    iArr[2] = 1;
                } else if (ordinal == 2) {
                    iArr[5] = 1;
                } else if (ordinal != 3) {
                    iArr[0] = 1;
                } else {
                    iArr[3] = 1;
                }
            }
        }
        return b.R0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "CodeVerifiedWithReportType14d-v2";
    }
}
