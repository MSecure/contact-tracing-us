package f.b.a.a.a.x;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;
import f.b.a.a.a.l.j;
import f.b.a.a.a.l.o;
import f.b.a.a.a.l.v;
import f.b.a.a.a.p.f0;
import f.b.a.a.a.p.l;
import f.b.a.a.a.p.n;

public final /* synthetic */ class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ ExposureAboutActivity b;

    public /* synthetic */ f(ExposureAboutActivity exposureAboutActivity) {
        this.b = exposureAboutActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        ExposureAboutActivity exposureAboutActivity = this.b;
        exposureAboutActivity.u = false;
        ExposureNotificationViewModel exposureNotificationViewModel = exposureAboutActivity.t;
        exposureNotificationViewModel.f341e.l(Boolean.TRUE);
        f0 f0Var = exposureNotificationViewModel.f347k;
        f0Var.a.stop().d(new n(f0Var)).f(new l(f0Var)).f(new v(exposureNotificationViewModel)).d(new o(exposureNotificationViewModel)).a(new j(exposureNotificationViewModel));
    }
}
