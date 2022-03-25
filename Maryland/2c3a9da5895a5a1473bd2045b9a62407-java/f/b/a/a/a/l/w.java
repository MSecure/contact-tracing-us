package f.b.a.a.a.l;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.p.q;
import f.b.a.c.f.b.d;
import f.b.a.c.i.f;
import java.util.Set;

public final /* synthetic */ class w implements f {
    public final /* synthetic */ ExposureNotificationViewModel a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ w(ExposureNotificationViewModel exposureNotificationViewModel, boolean z) {
        this.a = exposureNotificationViewModel;
        this.b = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        if (r8.contains(r6) != false) goto L_0x0057;
     */
    @Override // f.b.a.c.i.f
    public final void b(Object obj) {
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        boolean z = this.b;
        Set set = (Set) obj;
        q<ExposureNotificationViewModel.a> qVar = exposureNotificationViewModel.f340d;
        d dVar = d.LOCATION_DISABLED;
        ExposureNotificationViewModel.a aVar = ExposureNotificationViewModel.a.STORAGE_LOW;
        ExposureNotificationViewModel.a aVar2 = ExposureNotificationViewModel.a.DISABLED;
        d dVar2 = d.LOW_STORAGE;
        if (z) {
            if (set.contains(d.ACTIVATED)) {
                aVar = ExposureNotificationViewModel.a.ENABLED;
            } else if (set.contains(d.INACTIVATED)) {
                if (!set.contains(dVar2)) {
                    d dVar3 = d.BLUETOOTH_DISABLED;
                    if (set.contains(dVar3) && set.contains(dVar)) {
                        aVar = ExposureNotificationViewModel.a.PAUSED_LOCATION_BLE;
                    } else if (set.contains(dVar3)) {
                        aVar = ExposureNotificationViewModel.a.PAUSED_BLE;
                    } else if (set.contains(dVar)) {
                        aVar = ExposureNotificationViewModel.a.PAUSED_LOCATION;
                    }
                }
            }
            qVar.l(aVar);
            exposureNotificationViewModel.f341e.l(Boolean.FALSE);
        }
        aVar = aVar2;
        qVar.l(aVar);
        exposureNotificationViewModel.f341e.l(Boolean.FALSE);
    }
}
