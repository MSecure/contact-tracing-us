package f.b.a.a.a.m;

import android.os.Bundle;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.c.i.f;
import f.b.b.a.l;

public final /* synthetic */ class s implements f {
    public final /* synthetic */ ExposureNotificationViewModel a;

    public /* synthetic */ s(ExposureNotificationViewModel exposureNotificationViewModel) {
        this.a = exposureNotificationViewModel;
    }

    @Override // f.b.a.c.i.f
    public final void b(Object obj) {
        Bundle bundle;
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        f.b.a.c.f.b.f fVar = (f.b.a.c.f.b.f) obj;
        exposureNotificationViewModel.t.a(fVar);
        e.p.s<l<Boolean>> sVar = exposureNotificationViewModel.f339i;
        boolean z = false;
        if (!(fVar == null || (bundle = fVar.b) == null)) {
            z = bundle.getBoolean("SMS_NOTICE", false);
        }
        sVar.j(l.c(Boolean.valueOf(z)));
    }
}
