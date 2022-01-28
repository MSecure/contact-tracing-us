package f.b.a.a.a.f0.s;

import f.b.a.a.a.l0.v0;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.e;

public class p implements e0 {
    public final v0 a;

    public p(v0 v0Var) {
        this.a = v0Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        e c = this.a.c();
        e l2 = this.a.l();
        int b = this.a.b();
        if (c.equals(e.f4356d) || c.u(l2) || b >= 5 || b < 0) {
            b = 0;
        }
        int[] iArr = new int[5];
        iArr[b] = 1;
        return b.Q0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "PeriodicExposureNotification-v1";
    }
}
