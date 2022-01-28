package f.b.a.a.a.w;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.c.i.e;
import java.util.Objects;

public final /* synthetic */ class t implements e {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ t(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.e
    public final void d(Exception exc) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Objects.requireNonNull(exposureNotificationViewModel);
        ExposureNotificationViewModel.y.d("Error calling getStatus", exc);
        exposureNotificationViewModel.c.l(ExposureNotificationViewModel.b.DISABLED);
        exposureNotificationViewModel.f345j.a.edit().putInt("ExposureNotificationSharedPreferences.EN_STATE_CACHE_KEY", 0).apply();
        exposureNotificationViewModel.f339d.l(Boolean.FALSE);
    }
}
