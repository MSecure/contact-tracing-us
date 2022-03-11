package f.b.a.a.a.p;

import android.os.Bundle;
import f.b.a.a.a.y.q0;
import f.b.a.c.f.b.f;
import f.b.b.a.a;
import f.b.b.a.l;

public class i0 {
    public final q0 a;

    public i0(q0 q0Var) {
        this.a = q0Var;
    }

    public void a(f fVar) {
        if (fVar != null) {
            Bundle bundle = fVar.b;
            boolean z = false;
            if (bundle != null) {
                z = bundle.getBoolean("METRICS_OPT_IN", false);
            }
            if (z && !this.a.a.contains("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY")) {
                this.a.k(true);
            }
            l lVar = a.b;
            Bundle bundle2 = fVar.b;
            if (bundle2 != null && bundle2.containsKey("APPA_OPT_IN")) {
                lVar = l.c(Boolean.valueOf(bundle2.getBoolean("APPA_OPT_IN")));
            }
            if (lVar.b() && !this.a.a.contains("ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY")) {
                this.a.m(((Boolean) lVar.a()).booleanValue());
            }
        }
    }
}
