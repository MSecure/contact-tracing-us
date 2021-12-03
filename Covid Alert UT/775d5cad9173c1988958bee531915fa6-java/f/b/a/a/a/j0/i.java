package f.b.a.a.a.j0;

import android.widget.LinearLayout;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.q.t;

public final /* synthetic */ class i implements t {
    public final /* synthetic */ o0 a;

    public /* synthetic */ i(o0 o0Var) {
        this.a = o0Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        o0 o0Var = this.a;
        ExposureNotificationViewModel.b bVar = (ExposureNotificationViewModel.b) obj;
        o0Var.c0 = bVar;
        LinearLayout linearLayout = o0Var.b0.c;
        if (bVar == ExposureNotificationViewModel.b.ENABLED || bVar == ExposureNotificationViewModel.b.DISABLED || bVar == ExposureNotificationViewModel.b.FOCUS_LOST) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
            if ((bVar == ExposureNotificationViewModel.b.PAUSED_NOT_IN_ALLOWLIST || bVar == ExposureNotificationViewModel.b.PAUSED_EN_NOT_SUPPORT || bVar == ExposureNotificationViewModel.b.PAUSED_USER_PROFILE_NOT_SUPPORT || bVar == ExposureNotificationViewModel.b.PAUSED_HW_NOT_SUPPORT) && !o0Var.b0.f2404e.isChecked()) {
                o0Var.b0.f2404e.setEnabled(false);
                return;
            }
        }
        o0Var.b0.f2404e.setEnabled(true);
    }
}
