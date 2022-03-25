package f.b.a.a.a.t.d0;

import android.content.SharedPreferences;
import f.b.a.a.a.y.q0;
import f.b.a.c.b.o.b;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.d;

public class e implements g {
    public final q0 a;

    public e(q0 q0Var) {
        this.a = q0Var;
    }

    @Override // f.b.a.a.a.t.d0.g
    public u<List<Integer>> a() {
        int i2;
        d y = d.y(this.a.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY", 0));
        d g2 = this.a.g();
        int i3 = 0;
        if (!y.equals(d.f4136d) && !y.u(g2)) {
            int i4 = this.a.a.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_INTERACTION_CLASSIFICATION_KEY", 0);
            SharedPreferences sharedPreferences = this.a.a;
            q0.g gVar = q0.g.UNKNOWN;
            int i5 = sharedPreferences.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY", 0);
            if (i5 == 1) {
                gVar = q0.g.CLICKED;
            } else if (i5 == 2) {
                gVar = q0.g.DISMISSED;
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
        return b.d1(b.h(iArr));
    }

    @Override // f.b.a.a.a.t.d0.g
    public String b() {
        return "PeriodicExposureNotificationInteraction-v1";
    }
}
