package f.b.a.a.a.w;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.q.s;
import f.b.a.c.i.e;

public final /* synthetic */ class j implements e {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ j(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.e
    public final void d(Exception exc) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        exposureNotificationViewModel.d(false);
        s<Boolean> sVar = exposureNotificationViewModel.f341f;
        Boolean bool = Boolean.FALSE;
        sVar.l(bool);
        exposureNotificationViewModel.f342g.l(bool);
        exposureNotificationViewModel.f345j.a.edit().putBoolean("ExposureNotificationSharedPreferences.IS_ENABLED_CACHE_KEY", false).apply();
        exposureNotificationViewModel.x = false;
    }
}
