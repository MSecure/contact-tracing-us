package f.b.a.a.a.g0.s;

import android.content.SharedPreferences;
import f.b.a.a.a.n0.a1;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.e;
/* loaded from: classes.dex */
public class q implements e0 {
    public final a1 a;

    public q(a1 a1Var) {
        this.a = a1Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        int i2;
        e z = e.z(this.a.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY", 0));
        e p = this.a.p();
        int i3 = 0;
        if (!z.equals(e.f4611d) && !z.u(p)) {
            int i4 = this.a.a.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_INTERACTION_CLASSIFICATION_KEY", 0);
            SharedPreferences sharedPreferences = this.a.a;
            a1.g gVar = a1.g.UNKNOWN;
            int i5 = sharedPreferences.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY", 0);
            if (i5 == 1) {
                gVar = a1.g.CLICKED;
            } else if (i5 == 2) {
                gVar = a1.g.DISMISSED;
            }
            int i6 = i4 * 2;
            int ordinal = gVar.ordinal();
            if (ordinal == 1) {
                i2 = 0;
            } else if (ordinal == 2) {
                i2 = 1;
            } else {
                throw new IllegalStateException("NotificationInteraction.UNKNOWN not accepted");
            }
            int i7 = (i6 + i2) - 1;
            if (i7 >= 0 && i7 < 9) {
                i3 = i7;
            }
        }
        int[] iArr = new int[9];
        iArr[i3] = 1;
        return b.R0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "PeriodicExposureNotificationInteraction-v1";
    }
}
