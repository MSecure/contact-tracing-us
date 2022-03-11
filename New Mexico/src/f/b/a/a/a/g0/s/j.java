package f.b.a.a.a.g0.s;

import f.b.a.a.a.n0.a1;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.d;
import l.b.a.e;
/* loaded from: classes.dex */
public class j implements e0 {
    public static final d b = d.f(14);
    public final a1 a;

    public j(a1 a1Var) {
        this.a = a1Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        int[] iArr = new int[6];
        e n = this.a.n();
        if (n.t(this.a.p())) {
            if (this.a.d().t(n.w(b))) {
                int c = this.a.c() + 1;
                if (c >= 0 && c < 6) {
                    iArr[c] = 1;
                }
            } else {
                iArr[1] = 1;
            }
        }
        return b.R0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "KeysUploaded-v1";
    }
}
