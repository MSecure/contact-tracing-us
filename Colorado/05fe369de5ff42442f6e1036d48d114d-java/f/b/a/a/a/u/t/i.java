package f.b.a.a.a.u.t;

import f.b.a.a.a.b0.v0;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.d;
import l.b.a.e;

public class i implements e0 {
    public static final d b = d.f(14);
    public final v0 a;

    public i(v0 v0Var) {
        this.a = v0Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        int[] iArr = new int[6];
        e j2 = this.a.j();
        if (j2.t(this.a.l())) {
            if (this.a.c().t(j2.w(b))) {
                int b2 = this.a.b() + 1;
                if (b2 >= 0 && b2 < 6) {
                    iArr[b2] = 1;
                }
            } else {
                iArr[1] = 1;
            }
        }
        return b.O0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "KeysUploaded-v1";
    }
}
