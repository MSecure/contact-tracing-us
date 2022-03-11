package f.b.a.a.a.g0.s;

import f.b.a.a.a.n0.a1;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.b.a;
import f.b.b.b.c;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.d;
import l.b.a.e;
/* loaded from: classes.dex */
public class g implements e0 {
    public static final c<Integer> b;
    public static final int c;
    public final a1 a;

    static {
        c<Integer> x = c.x(0, 4, 7, 11);
        b = x;
        c = x.size() * 4;
    }

    public g(a1 a1Var) {
        this.a = a1Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        int c2;
        int[] iArr = new int[c];
        e d2 = this.a.d();
        if (d2.t(this.a.p()) && (c2 = this.a.c()) >= 1 && c2 <= 4) {
            c<Integer> cVar = b;
            int size = cVar.size() * (c2 - 1);
            e k2 = this.a.k();
            a<Integer> t = cVar.listIterator();
            int i2 = -1;
            while (t.hasNext()) {
                if (k2.u(d2.w(d.f((long) t.next().intValue())))) {
                    i2++;
                }
            }
            if (i2 != -1 && i2 < b.size()) {
                iArr[size + i2] = 1;
            }
        }
        return b.R0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "DateExposure-v1";
    }
}
