package f.b.a.a.a.f0.s;

import f.b.a.a.a.l0.v0;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.b.a;
import f.b.b.b.c;
import f.b.b.f.a.u;
import java.util.List;
import java.util.Objects;
import l.b.a.d;
import l.b.a.e;

public class f implements e0 {
    public static final c<Integer> b;
    public static final int c;
    public final v0 a;

    static {
        c<Integer> x = c.x(0, 4, 7, 11);
        b = x;
        c = x.size() * 4;
    }

    public f(v0 v0Var) {
        this.a = v0Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        int b2;
        int[] iArr = new int[c];
        e c2 = this.a.c();
        if (c2.t(this.a.l()) && (b2 = this.a.b()) >= 1 && b2 <= 4) {
            c<Integer> cVar = b;
            int size = cVar.size() * (b2 - 1);
            v0 v0Var = this.a;
            Objects.requireNonNull(v0Var);
            e eVar = (e) d.f(v0Var.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_EXPOSURE_TIME", 0)).b(e.f4356d);
            a<Integer> t = cVar.listIterator();
            int i2 = -1;
            while (t.hasNext()) {
                if (eVar.u(c2.w(d.f((long) t.next().intValue())))) {
                    i2++;
                }
            }
            if (i2 != -1 && i2 < b.size()) {
                iArr[size + i2] = 1;
            }
        }
        return b.Q0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "DateExposure-v1";
    }
}
