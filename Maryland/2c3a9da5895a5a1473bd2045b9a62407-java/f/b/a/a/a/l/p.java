package f.b.a.a.a.l;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.p.r;

public final /* synthetic */ class p implements r {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ p(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        exposureNotificationViewModel.o.b = ((Boolean) obj).booleanValue();
        exposureNotificationViewModel.c.l(exposureNotificationViewModel.o);
    }
}
