package f.b.a.a.a.r.c0;

import f.b.a.a.a.w.n0;
import f.b.a.c.b.o.b;
import f.b.b.f.a.u;
import java.util.Arrays;
import java.util.List;
import l.b.a.c;

public class d implements f {
    public final n0 a;

    static {
        c.e(1);
    }

    public d(n0 n0Var) {
        this.a = n0Var;
    }

    @Override // f.b.a.a.a.r.c0.f
    public u<List<Integer>> a() {
        int i2 = this.a.a.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY", 0);
        if (l.b.a.d.x(this.a.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY", 0)).equals(l.b.a.d.f4032d) || i2 >= 5) {
            i2 = 0;
        }
        int[] iArr = new int[5];
        Arrays.fill(iArr, 0);
        iArr[i2] = 1;
        return b.c1(b.h(iArr));
    }

    @Override // f.b.a.a.a.r.c0.f
    public void b() {
        this.a.a.edit().remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY").apply();
    }

    @Override // f.b.a.a.a.r.c0.f
    public String c() {
        return "PeriodicExposureNotification-v1";
    }
}
