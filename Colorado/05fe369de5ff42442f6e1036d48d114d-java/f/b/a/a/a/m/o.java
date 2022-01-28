package f.b.a.a.a.m;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.c.i.a;
import f.b.a.c.i.h;
import java.util.Objects;

public final /* synthetic */ class o implements a {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ o(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.a
    public final Object a(h hVar) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        Objects.requireNonNull(exposureNotificationViewModel);
        return ((Boolean) hVar.l()).booleanValue() ? exposureNotificationViewModel.q.d() : exposureNotificationViewModel.q.d().i(p.a);
    }
}
