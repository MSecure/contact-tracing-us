package f.b.a.a.a.l;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.y.q0;
import f.b.a.c.i.f;
import java.util.Objects;

public final /* synthetic */ class g implements f {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ g(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.f
    public final void b(Object obj) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Boolean bool = (Boolean) obj;
        Objects.requireNonNull(exposureNotificationViewModel);
        exposureNotificationViewModel.c(bool.booleanValue());
        exposureNotificationViewModel.f343g.l(bool);
        q0 q0Var = exposureNotificationViewModel.f344h;
        q0Var.a.edit().putBoolean("ExposureNotificationSharedPreferences.IS_ENABLED_CACHE_KEY", bool.booleanValue()).apply();
        exposureNotificationViewModel.p = false;
    }
}
