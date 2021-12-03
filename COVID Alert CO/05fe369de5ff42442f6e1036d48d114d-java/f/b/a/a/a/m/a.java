package f.b.a.a.a.m;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.a.e.b;
import e.p.s;
import java.util.Objects;

public final /* synthetic */ class a implements b {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ a(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // e.a.e.b
    public final void a(Object obj) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Objects.requireNonNull(exposureNotificationViewModel);
        ExposureNotificationViewModel.y.a("onResolutionComplete");
        if (((e.a.e.a) obj).b == -1) {
            exposureNotificationViewModel.f335e.l(Boolean.FALSE);
            exposureNotificationViewModel.q.c().f(new r(exposureNotificationViewModel)).d(new f(exposureNotificationViewModel)).a(new l(exposureNotificationViewModel));
            return;
        }
        s<Boolean> sVar = exposureNotificationViewModel.f335e;
        Boolean bool = Boolean.FALSE;
        sVar.l(bool);
        exposureNotificationViewModel.f334d.l(bool);
    }
}
