package f.b.a.a.a.j;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.w.k0;
import f.b.a.c.i.f;

public final /* synthetic */ class d implements f {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ d(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.f
    public final void b(Object obj) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Boolean bool = (Boolean) obj;
        exposureNotificationViewModel.c.l(exposureNotificationViewModel.c(bool.booleanValue()));
        k0 k0Var = exposureNotificationViewModel.f334g;
        k0Var.a.edit().putBoolean("ExposureNotificationSharedPreferences.IS_ENABLED_CACHE_KEY", bool.booleanValue()).apply();
        exposureNotificationViewModel.p = false;
    }
}
