package f.b.a.a.a.l;

import android.util.Log;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import java.util.Objects;

public final /* synthetic */ class c implements f.b.a.c.i.c {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ c(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.c
    public final void c() {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Objects.requireNonNull(exposureNotificationViewModel);
        Log.i("ExposureNotificationVM", "Call isEnabled is canceled");
        exposureNotificationViewModel.p = false;
    }
}
