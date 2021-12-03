package f.b.a.a.a.m;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.b0.v0;
import f.b.a.c.i.f;
import java.util.Objects;

public final /* synthetic */ class h implements f {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ h(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.f
    public final void b(Object obj) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Boolean bool = (Boolean) obj;
        Objects.requireNonNull(exposureNotificationViewModel);
        exposureNotificationViewModel.d(bool.booleanValue());
        exposureNotificationViewModel.f336f.l(bool);
        exposureNotificationViewModel.f337g.l(bool);
        v0 v0Var = exposureNotificationViewModel.f340j;
        v0Var.a.edit().putBoolean("ExposureNotificationSharedPreferences.IS_ENABLED_CACHE_KEY", bool.booleanValue()).apply();
        exposureNotificationViewModel.x = false;
    }
}
