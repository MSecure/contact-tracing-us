package f.b.a.a.a.t.d0;

import f.b.a.a.a.y.q0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.c;
import l.b.a.d;

public class b implements g {
    public static final c b = c.e(14);
    public final q0 a;

    public b(q0 q0Var) {
        this.a = q0Var;
    }

    @Override // f.b.a.a.a.t.d0.g
    public u<List<Integer>> a() {
        int[] iArr = new int[6];
        d y = d.y(this.a.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_VERIFICATION_CODE_TIME", 0));
        if (y.t(this.a.g())) {
            if (this.a.c().t(y.w(b))) {
                int b2 = this.a.b() + 1;
                if (b2 >= 0 && b2 < 6) {
                    iArr[b2] = 1;
                }
            } else {
                iArr[1] = 1;
            }
        }
        return f.b.a.c.b.o.b.d1(f.b.a.c.b.o.b.h(iArr));
    }

    @Override // f.b.a.a.a.t.d0.g
    public String b() {
        return "CodeVerified-v1";
    }
}
