package f.b.a.a.a.m;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.c.i.c;
import java.util.Objects;

public final /* synthetic */ class b implements c {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ b(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.c
    public final void c() {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Objects.requireNonNull(exposureNotificationViewModel);
        ExposureNotificationViewModel.y.f("Call isEnabled is canceled");
        exposureNotificationViewModel.x = false;
    }
}
