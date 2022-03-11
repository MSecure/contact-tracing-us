package f.b.a.a.a.v;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;
import f.b.a.a.a.j.h;
import f.b.a.a.a.j.o;
import f.b.a.a.a.n.f0;
import f.b.a.a.a.n.l;
import f.b.a.a.a.n.n;

public final /* synthetic */ class i implements DialogInterface.OnClickListener {
    public final /* synthetic */ ExposureAboutActivity b;

    public /* synthetic */ i(ExposureAboutActivity exposureAboutActivity) {
        this.b = exposureAboutActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        ExposureAboutActivity exposureAboutActivity = this.b;
        exposureAboutActivity.s = false;
        ExposureNotificationViewModel exposureNotificationViewModel = exposureAboutActivity.r;
        exposureNotificationViewModel.f331d.l(Boolean.TRUE);
        f0 f0Var = exposureNotificationViewModel.f337j;
        f0Var.a.stop().d(new n(f0Var)).f(new l(f0Var)).f(new h(exposureNotificationViewModel)).d(new f.b.a.a.a.j.i(exposureNotificationViewModel)).a(new o(exposureNotificationViewModel));
    }
}
