package f.b.a.a.a.f0.s;

import f.b.a.a.a.l0.v0;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.e;

public class d implements e0 {
    public static final l.b.a.d b = l.b.a.d.f(14);
    public final v0 a;

    public d(v0 v0Var) {
        this.a = v0Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        int[] iArr = new int[6];
        e i2 = this.a.i();
        if (i2.t(this.a.l())) {
            if (this.a.c().t(i2.w(b))) {
                int b2 = this.a.b() + 1;
                if (b2 >= 0 && b2 < 6) {
                    iArr[b2] = 1;
                }
            } else {
                iArr[1] = 1;
            }
        }
        return b.Q0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "CodeVerified-v1";
    }
}
