package f.b.a.a.a.z;

import android.widget.LinearLayout;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.p.t;

public final /* synthetic */ class i implements t {
    public final /* synthetic */ p0 a;

    public /* synthetic */ i(p0 p0Var) {
        this.a = p0Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        p0 p0Var = this.a;
        ExposureNotificationViewModel.b bVar = (ExposureNotificationViewModel.b) obj;
        p0Var.b0 = bVar;
        LinearLayout linearLayout = p0Var.a0.c;
        if (bVar == ExposureNotificationViewModel.b.ENABLED || bVar == ExposureNotificationViewModel.b.DISABLED || bVar == ExposureNotificationViewModel.b.FOCUS_LOST) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
            if ((bVar == ExposureNotificationViewModel.b.PAUSED_NOT_IN_ALLOWLIST || bVar == ExposureNotificationViewModel.b.PAUSED_EN_NOT_SUPPORT || bVar == ExposureNotificationViewModel.b.PAUSED_USER_PROFILE_NOT_SUPPORT || bVar == ExposureNotificationViewModel.b.PAUSED_HW_NOT_SUPPORT) && !p0Var.a0.f2209e.isChecked()) {
                p0Var.a0.f2209e.setEnabled(false);
                return;
            }
        }
        p0Var.a0.f2209e.setEnabled(true);
    }
}
