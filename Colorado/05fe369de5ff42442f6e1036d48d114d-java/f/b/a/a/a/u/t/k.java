package f.b.a.a.a.u.t;

import f.b.a.a.a.b0.h0;
import f.b.a.a.a.b0.v0;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.d;

public class k implements e0 {
    public final v0 a;

    static {
        d.f(14);
    }

    public k(v0 v0Var) {
        this.a = v0Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        int[] iArr = new int[6];
        if (this.a.j().t(this.a.k())) {
            h0.d h2 = this.a.h();
            if (h2 == null) {
                iArr[0] = 1;
            } else {
                int ordinal = h2.ordinal();
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
        return b.O0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "KeysUploadedWithReportType14d-v1";
    }
}
