package f.b.a.a.a.l;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.a.e.a;
import java.util.Objects;

public final /* synthetic */ class b implements e.a.e.b {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ b(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // e.a.e.b
    public final void a(Object obj) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Objects.requireNonNull(exposureNotificationViewModel);
        Boolean bool = Boolean.FALSE;
        if (((a) obj).b == -1) {
            exposureNotificationViewModel.f342f.l(bool);
            exposureNotificationViewModel.f347k.c().f(new q(exposureNotificationViewModel)).d(new n(exposureNotificationViewModel)).a(new k(exposureNotificationViewModel));
            return;
        }
        exposureNotificationViewModel.f342f.l(bool);
        exposureNotificationViewModel.f341e.l(bool);
    }
}
