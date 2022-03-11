package f.b.a.a.a.r;

import android.widget.ViewFlipper;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.p.r;

public final /* synthetic */ class d implements r {
    public final /* synthetic */ q3 a;

    public /* synthetic */ d(q3 q3Var) {
        this.a = q3Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        ViewFlipper viewFlipper;
        int i2;
        q3 q3Var = this.a;
        ExposureNotificationViewModel.a aVar = (ExposureNotificationViewModel.a) obj;
        int i3 = q3.d0;
        if (q3Var.F != null) {
            if (aVar == ExposureNotificationViewModel.a.ENABLED) {
                viewFlipper = q3Var.a0.f2115d;
                i2 = 1;
            } else {
                viewFlipper = q3Var.a0.f2115d;
                i2 = 0;
            }
            viewFlipper.setDisplayedChild(i2);
            q3Var.a0.f2116e.setDisplayedChild(i2);
        }
    }
}
