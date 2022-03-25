package f.b.a.a.a.k;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.p.r;

public final /* synthetic */ class d implements r {
    public final /* synthetic */ n a;

    public /* synthetic */ d(n nVar) {
        this.a = nVar;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        n nVar = this.a;
        ExposureNotificationViewModel.a aVar = (ExposureNotificationViewModel.a) obj;
        int i2 = n.h0;
        if (nVar.F != null) {
            nVar.a0.f2110h.setDisplayedChild(aVar == ExposureNotificationViewModel.a.ENABLED ? 1 : 0);
            nVar.A0(nVar.d0.c.a(), aVar, Boolean.valueOf(nVar.d0.c.a.getBoolean("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY", false)).booleanValue());
        }
    }
}
