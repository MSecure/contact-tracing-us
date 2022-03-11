package f.b.a.a.a.l;

import android.util.Log;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.c.i.e;
import java.util.Objects;

public final /* synthetic */ class r implements e {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ r(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.e
    public final void d(Exception exc) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Objects.requireNonNull(exposureNotificationViewModel);
        Log.e("ExposureNotificationVM", "Error calling getStatus", exc);
        exposureNotificationViewModel.f341e.l(Boolean.FALSE);
    }
}
