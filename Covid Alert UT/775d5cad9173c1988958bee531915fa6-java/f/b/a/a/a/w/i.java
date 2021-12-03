package f.b.a.a.a.w;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.gms.common.api.Status;
import f.b.a.c.b.a;
import f.b.a.c.b.l.b;
import f.b.a.c.i.e;
import java.util.Objects;

public final /* synthetic */ class i implements e {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ i(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.e
    public final void d(Exception exc) {
        a aVar;
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Objects.requireNonNull(exposureNotificationViewModel);
        if (!(exc instanceof b)) {
            exposureNotificationViewModel.f339d.l(Boolean.FALSE);
            exposureNotificationViewModel.f347l.l(null);
            return;
        }
        b bVar = (b) exc;
        if (bVar.b.c != 6) {
            ExposureNotificationViewModel.y.h("No RESOLUTION_REQUIRED in result", bVar);
            int i2 = -1;
            Status status = bVar.b;
            if (!(status == null || (aVar = status.f453f) == null)) {
                i2 = aVar.c;
            }
            ((i2 == 1 || i2 == 2 || i2 == 3 || i2 == 9) ? exposureNotificationViewModel.m : exposureNotificationViewModel.f347l).l(null);
            exposureNotificationViewModel.f339d.l(Boolean.FALSE);
        } else if (exposureNotificationViewModel.f340e.d().booleanValue()) {
            ExposureNotificationViewModel.y.d("Error, has in flight resolution", exc);
        } else {
            exposureNotificationViewModel.f340e.l(Boolean.TRUE);
            exposureNotificationViewModel.o.j(bVar);
        }
    }
}
