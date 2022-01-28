package f.b.a.a.a.b0;

import android.os.Bundle;
import f.b.a.a.a.l0.v0;
import f.b.a.c.f.b.f;
import f.b.b.a.a;
import f.b.b.a.l;

public class m1 {
    public final v0 a;

    public m1(v0 v0Var) {
        this.a = v0Var;
    }

    public void a(f fVar) {
        if (fVar != null) {
            Bundle bundle = fVar.b;
            boolean z = false;
            if (bundle != null) {
                z = bundle.getBoolean("METRICS_OPT_IN", false);
            }
            if (z && !this.a.a.contains("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY")) {
                this.a.p(true);
            }
            Bundle bundle2 = fVar.b;
            l c = (bundle2 != null && bundle2.containsKey("APPA_OPT_IN")) ? l.c(Boolean.valueOf(bundle2.getBoolean("APPA_OPT_IN"))) : a.b;
            if (c.b() && !this.a.a.contains("ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY")) {
                this.a.u(((Boolean) c.a()).booleanValue());
            }
        }
    }

    public void b(f fVar) {
        Bundle bundle;
        v0 v0Var = this.a;
        boolean z = false;
        if (!(fVar == null || (bundle = fVar.b) == null)) {
            z = bundle.getBoolean("SMS_NOTICE", false);
        }
        v0Var.a.edit().putBoolean("ExposureNotificationSharedPreferences.IS_PLAY_SMS_NOTICE_SEEN", z).commit();
    }
}
