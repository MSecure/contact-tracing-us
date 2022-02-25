package f.b.a.a.a.r.e0;

import f.b.a.a.a.r.s;
import f.b.a.a.a.w.k0;
import f.b.a.c.b.o.b;
import f.b.b.f.a.u;
import java.util.Arrays;
import java.util.List;
import l.b.a.c;

public class d implements f {
    public final k0 a;

    static {
        c.e(1);
    }

    public d(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // f.b.a.a.a.r.e0.f
    public void a() {
        this.a.a();
    }

    @Override // f.b.a.a.a.r.e0.f
    public u<List<Integer>> b(s sVar) {
        int c = sVar.c();
        if (sVar.d().equals(l.b.a.d.f4040d) || c >= 5 || c < 0) {
            c = 0;
        }
        int[] iArr = new int[5];
        Arrays.fill(iArr, 0);
        iArr[c] = 1;
        return b.c1(b.h(iArr));
    }

    @Override // f.b.a.a.a.r.e0.f
    public String c() {
        return "PeriodicExposureNotification-v1";
    }
}
