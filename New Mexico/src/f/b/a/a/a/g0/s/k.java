package f.b.a.a.a.g0.s;

import f.b.a.a.a.j0.a;
import f.b.a.a.a.j0.d;
import f.b.a.a.a.n0.a1;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.e;
/* loaded from: classes.dex */
public class k implements e0 {
    public final a1 a;

    public k(a1 a1Var) {
        this.a = a1Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        int[] iArr = new int[15];
        a1.i h2 = this.a.h();
        e i2 = this.a.i();
        e o = this.a.o();
        d b = this.a.b();
        boolean z = h2 == a1.i.VACCINATED;
        boolean z2 = ((a) b).a != 0;
        if (i2.t(o)) {
            iArr[0] = 1;
            if (z) {
                iArr[1] = 1;
                if (z2) {
                    iArr[7] = 1;
                    iArr[6] = 1;
                    iArr[12] = 1;
                    iArr[13] = 1;
                } else {
                    iArr[3] = 1;
                    iArr[4] = 1;
                }
            } else {
                iArr[2] = 1;
                if (z2) {
                    iArr[6] = 1;
                    iArr[8] = 1;
                    iArr[12] = 1;
                    iArr[14] = 1;
                } else {
                    iArr[3] = 1;
                    iArr[5] = 1;
                }
            }
        }
        return b.R0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "KeysUploadedVaccineStatus-v2";
    }
}
