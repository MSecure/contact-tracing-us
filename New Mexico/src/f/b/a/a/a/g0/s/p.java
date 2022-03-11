package f.b.a.a.a.g0.s;

import f.b.a.a.a.n0.a1;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.e;
/* loaded from: classes.dex */
public class p implements e0 {
    public final a1 a;

    public p(a1 a1Var) {
        this.a = a1Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        e d2 = this.a.d();
        e o = this.a.o();
        int c = this.a.c();
        if (d2.equals(e.f4611d) || d2.u(o) || c >= 5 || c < 0) {
            c = 0;
        }
        int[] iArr = new int[5];
        iArr[c] = 1;
        return b.R0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "PeriodicExposureNotification14d-v2";
    }
}
