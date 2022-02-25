package f.b.a.a.a.r.c0;

import android.content.SharedPreferences;
import f.b.a.a.a.w.n0;
import f.b.a.c.b.o.b;
import f.b.b.f.a.u;
import java.util.Arrays;
import java.util.List;
import l.b.a.d;

public class c implements f {
    public final n0 a;

    public c(n0 n0Var) {
        this.a = n0Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    @Override // f.b.a.a.a.r.c0.f
    public u<List<Integer>> a() {
        int i2;
        int i3;
        d x = d.x(this.a.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY", 0));
        d x2 = d.x(this.a.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY", 0));
        if (!x.equals(d.f4032d)) {
            if (!(x2.compareTo(x) < 0)) {
                int i4 = this.a.a.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY", 0);
                SharedPreferences sharedPreferences = this.a.a;
                n0.c cVar = n0.c.UNKNOWN;
                int i5 = sharedPreferences.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY", 0);
                if (i5 == 1) {
                    cVar = n0.c.CLICKED;
                } else if (i5 == 2) {
                    cVar = n0.c.DISMISSED;
                }
                int i6 = i4 * 2;
                int ordinal = cVar.ordinal();
                if (ordinal == 1) {
                    i3 = 0;
                } else if (ordinal == 2) {
                    i3 = 1;
                } else {
                    throw new IllegalStateException("NotificationInteraction.UNKNOWN not accepted");
                }
                i2 = (i6 + i3) - 1;
                if (i2 >= 9) {
                    i2 = 0;
                }
                int[] iArr = new int[9];
                Arrays.fill(iArr, 0);
                iArr[i2] = 1;
                return b.c1(b.h(iArr));
            }
        }
        i2 = 0;
        if (i2 >= 9) {
        }
        int[] iArr2 = new int[9];
        Arrays.fill(iArr2, 0);
        iArr2[i2] = 1;
        return b.c1(b.h(iArr2));
    }

    @Override // f.b.a.a.a.r.c0.f
    public void b() {
        this.a.a.edit().remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY").apply();
    }

    @Override // f.b.a.a.a.r.c0.f
    public String c() {
        return "PeriodicExposureNotificationInteraction-v1";
    }
}
