package f.b.a.a.a.g0.s;

import f.b.a.a.a.n0.a1;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.d;
import l.b.a.e;
/* loaded from: classes.dex */
public class f implements e0 {
    public final a1 a;

    public f(a1 a1Var) {
        this.a = a1Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        int c;
        int[] iArr = new int[48];
        e d2 = this.a.d();
        e o = this.a.o();
        e k2 = this.a.k();
        if (d2.t(o) && d2.t(k2) && (c = this.a.c()) >= 1 && c <= 4) {
            int i2 = (c - 1) * 12;
            for (int min = (int) Math.min(d.c(k2, d2).s(), 11L); min < 12; min++) {
                iArr[i2 + min] = 1;
            }
        }
        return b.R0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "DateExposure-v2";
    }
}
