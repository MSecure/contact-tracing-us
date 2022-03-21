package f.b.a.a.a.j;

import android.util.Log;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.c.b.l.b;
import java.util.Objects;

public final /* synthetic */ class e implements f.b.a.c.i.e {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ e(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.e
    public final void d(Exception exc) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Objects.requireNonNull(exposureNotificationViewModel);
        Boolean bool = Boolean.FALSE;
        if (!(exc instanceof b)) {
            exposureNotificationViewModel.f331d.l(bool);
            exposureNotificationViewModel.f335h.l(null);
            return;
        }
        b bVar = (b) exc;
        if (bVar.b.c != 6) {
            Log.w("ExposureNotificationVM", "No RESOLUTION_REQUIRED in result", bVar);
            exposureNotificationViewModel.f335h.l(null);
            exposureNotificationViewModel.f331d.l(bool);
        } else if (exposureNotificationViewModel.f332e.d().booleanValue()) {
            Log.e("ExposureNotificationVM", "Error, has in flight resolution", exc);
        } else {
            exposureNotificationViewModel.f332e.l(Boolean.TRUE);
            exposureNotificationViewModel.f336i.j(bVar);
        }
    }
}
