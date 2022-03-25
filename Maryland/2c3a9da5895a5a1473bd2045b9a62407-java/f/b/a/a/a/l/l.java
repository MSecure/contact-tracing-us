package f.b.a.a.a.l;

import android.util.Log;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.c.b.l.b;
import f.b.a.c.i.e;
import java.util.Objects;

public final /* synthetic */ class l implements e {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ l(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.e
    public final void d(Exception exc) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Objects.requireNonNull(exposureNotificationViewModel);
        Boolean bool = Boolean.FALSE;
        if (!(exc instanceof b)) {
            exposureNotificationViewModel.f341e.l(bool);
            exposureNotificationViewModel.f345i.l(null);
            return;
        }
        b bVar = (b) exc;
        if (bVar.b.c != 6) {
            Log.w("ExposureNotificationVM", "No RESOLUTION_REQUIRED in result", bVar);
            exposureNotificationViewModel.f345i.l(null);
            exposureNotificationViewModel.f341e.l(bool);
        } else if (exposureNotificationViewModel.f342f.d().booleanValue()) {
            Log.e("ExposureNotificationVM", "Error, has in flight resolution", exc);
        } else {
            exposureNotificationViewModel.f342f.l(Boolean.TRUE);
            exposureNotificationViewModel.f346j.j(bVar);
        }
    }
}
