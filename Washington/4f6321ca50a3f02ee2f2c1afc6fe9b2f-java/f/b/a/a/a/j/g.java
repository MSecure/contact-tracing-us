package f.b.a.a.a.j;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.c.i.e;

public final /* synthetic */ class g implements e {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ g(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.e
    public final void d(Exception exc) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        exposureNotificationViewModel.p = false;
        exposureNotificationViewModel.c.l(exposureNotificationViewModel.c(false));
        exposureNotificationViewModel.f334g.a.edit().putBoolean("ExposureNotificationSharedPreferences.IS_ENABLED_CACHE_KEY", false).apply();
    }
}
