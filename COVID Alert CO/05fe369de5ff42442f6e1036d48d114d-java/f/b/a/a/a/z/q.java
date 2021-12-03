package f.b.a.a.a.z;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.m.d;
import f.b.a.a.a.m.k;
import f.b.a.a.a.m.o;

public final /* synthetic */ class q implements DialogInterface.OnClickListener {
    public final /* synthetic */ p0 b;

    public /* synthetic */ q(p0 p0Var) {
        this.b = p0Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        p0 p0Var = this.b;
        p0Var.c0 = false;
        ExposureNotificationViewModel exposureNotificationViewModel = p0Var.W;
        exposureNotificationViewModel.f334d.l(Boolean.TRUE);
        exposureNotificationViewModel.q.b().i(new o(exposureNotificationViewModel)).f(new d(exposureNotificationViewModel)).d(new k(exposureNotificationViewModel)).a(new f.b.a.a.a.m.q(exposureNotificationViewModel));
    }
}
