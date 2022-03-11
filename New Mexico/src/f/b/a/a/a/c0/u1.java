package f.b.a.a.a.c0;

import android.os.Bundle;
import f.b.a.a.a.n0.a1;
import f.b.a.c.f.b.f;
import f.b.b.a.a;
import f.b.b.a.l;
/* loaded from: classes.dex */
public class u1 {
    public final a1 a;

    public u1(a1 a1Var) {
        this.a = a1Var;
    }

    public void a(f fVar) {
        if (fVar != null) {
            Bundle bundle = fVar.b;
            boolean z = false;
            if (bundle != null) {
                z = bundle.getBoolean("METRICS_OPT_IN", false);
            }
            if (z && !this.a.a.contains("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY")) {
                this.a.t(true);
            }
            Bundle bundle2 = fVar.b;
            l c = (bundle2 != null && bundle2.containsKey("APPA_OPT_IN")) ? l.c(Boolean.valueOf(bundle2.getBoolean("APPA_OPT_IN"))) : a.b;
            if (c.b() && !this.a.a.contains("ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY")) {
                this.a.y(((Boolean) c.a()).booleanValue());
            }
        }
    }

    public void b(f fVar) {
        Bundle bundle;
        a1 a1Var = this.a;
        boolean z = false;
        if (!(fVar == null || (bundle = fVar.b) == null)) {
            z = bundle.getBoolean("SMS_NOTICE", false);
        }
        a1Var.a.edit().putBoolean("ExposureNotificationSharedPreferences.IS_PLAY_SMS_NOTICE_SEEN", z).commit();
    }
}
