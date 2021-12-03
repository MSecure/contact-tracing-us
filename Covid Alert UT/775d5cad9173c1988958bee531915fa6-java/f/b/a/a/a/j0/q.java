package f.b.a.a.a.j0;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.w.d;
import f.b.a.a.a.w.k;
import f.b.a.a.a.w.o;

public final /* synthetic */ class q implements DialogInterface.OnClickListener {
    public final /* synthetic */ o0 b;

    public /* synthetic */ q(o0 o0Var) {
        this.b = o0Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        o0 o0Var = this.b;
        o0Var.d0 = false;
        ExposureNotificationViewModel exposureNotificationViewModel = o0Var.W;
        exposureNotificationViewModel.f339d.l(Boolean.TRUE);
        exposureNotificationViewModel.q.b().i(new o(exposureNotificationViewModel)).f(new d(exposureNotificationViewModel)).d(new k(exposureNotificationViewModel)).a(new f.b.a.a.a.w.q(exposureNotificationViewModel));
    }
}
