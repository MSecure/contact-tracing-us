package f.b.a.a.a.x;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;
import e.p.r;

public final /* synthetic */ class j implements r {
    public final /* synthetic */ ExposureAboutActivity a;

    public /* synthetic */ j(ExposureAboutActivity exposureAboutActivity) {
        this.a = exposureAboutActivity;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        ExposureNotificationViewModel.a aVar = (ExposureNotificationViewModel.a) obj;
        this.a.s.c.setVisibility((aVar == ExposureNotificationViewModel.a.ENABLED || aVar == ExposureNotificationViewModel.a.DISABLED) ? 0 : 8);
    }
}
