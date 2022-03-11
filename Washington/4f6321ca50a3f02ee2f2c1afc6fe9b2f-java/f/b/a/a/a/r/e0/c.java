package f.b.a.a.a.r.e0;

import f.b.a.a.a.r.s;
import f.b.a.a.a.w.k0;
import f.b.a.c.b.o.b;
import f.b.b.f.a.u;
import java.util.Arrays;
import java.util.List;
import l.b.a.d;

public class c implements f {
    public final k0 a;

    public c(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // f.b.a.a.a.r.e0.f
    public void a() {
        this.a.b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r0 < 9) goto L_0x0045;
     */
    @Override // f.b.a.a.a.r.e0.f
    public u<List<Integer>> b(s sVar) {
        int i2;
        int i3;
        d d2 = sVar.d();
        d a2 = sVar.a();
        if (!d2.equals(d.f4040d)) {
            if (!(a2.compareTo(d2) < 0)) {
                int c = sVar.c() * 2;
                int ordinal = sVar.b().ordinal();
                if (ordinal == 1) {
                    i3 = 0;
                } else if (ordinal == 2) {
                    i3 = 1;
                } else {
                    throw new IllegalStateException("NotificationInteraction.UNKNOWN not accepted");
                }
                i2 = (c + i3) - 1;
                if (i2 >= 0) {
                }
            }
        }
        i2 = 0;
        if (i2 >= 9) {
            i2 = 0;
        }
        int[] iArr = new int[9];
        Arrays.fill(iArr, 0);
        iArr[i2] = 1;
        return b.c1(b.h(iArr));
    }

    @Override // f.b.a.a.a.r.e0.f
    public String c() {
        return "PeriodicExposureNotificationInteraction-v1";
    }
}
