package f.b.a.a.a.n;

import android.os.Bundle;
import f.b.a.a.a.w.k0;
import f.b.a.c.f.b.e;
import f.b.b.a.a;
import f.b.b.a.l;

public class i0 {
    public final k0 a;

    public i0(k0 k0Var) {
        this.a = k0Var;
    }

    public void a(e eVar) {
        if (eVar != null) {
            Bundle bundle = eVar.b;
            boolean z = false;
            if (bundle != null) {
                z = bundle.getBoolean("METRICS_OPT_IN", false);
            }
            if (z && !this.a.a.contains("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY")) {
                this.a.j(true);
            }
            l lVar = a.b;
            Bundle bundle2 = eVar.b;
            if (bundle2 != null && bundle2.containsKey("APPA_OPT_IN")) {
                lVar = l.c(Boolean.valueOf(bundle2.getBoolean("APPA_OPT_IN")));
            }
            if (lVar.b() && !this.a.a.contains("ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY")) {
                this.a.l(((Boolean) lVar.a()).booleanValue());
            }
        }
    }
}
