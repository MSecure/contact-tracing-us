package f.b.a.a.a.w;

import android.content.Context;
import com.google.android.apps.exposurenotification.home.ExposureNotificationActivity;
import e.a.d.b;

public class b1 implements b {
    public final /* synthetic */ c1 a;

    public b1(c1 c1Var) {
        this.a = c1Var;
    }

    @Override // e.a.d.b
    public void a(Context context) {
        c1 c1Var = this.a;
        if (!c1Var.v) {
            c1Var.v = true;
            ((a1) c1Var.e()).c((ExposureNotificationActivity) c1Var);
        }
    }
}
