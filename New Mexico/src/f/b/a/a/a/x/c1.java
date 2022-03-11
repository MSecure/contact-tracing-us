package f.b.a.a.a.x;

import android.content.Context;
import com.google.android.apps.exposurenotification.home.ExposureNotificationActivity;
import e.a.d.b;
/* loaded from: classes.dex */
public class c1 implements b {
    public final /* synthetic */ d1 a;

    public c1(d1 d1Var) {
        this.a = d1Var;
    }

    @Override // e.a.d.b
    public void a(Context context) {
        d1 d1Var = this.a;
        if (!d1Var.v) {
            d1Var.v = true;
            ((b1) d1Var.e()).c((ExposureNotificationActivity) d1Var);
        }
    }
}
