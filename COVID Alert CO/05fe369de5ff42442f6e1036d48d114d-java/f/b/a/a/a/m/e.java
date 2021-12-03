package f.b.a.a.a.m;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.c.i.c;
import java.util.Objects;

public final /* synthetic */ class e implements c {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ e(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.c
    public final void c() {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Objects.requireNonNull(exposureNotificationViewModel);
        ExposureNotificationViewModel.y.f("Call getStatus is canceled");
        exposureNotificationViewModel.f334d.l(Boolean.FALSE);
    }
}
