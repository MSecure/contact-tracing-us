package f.b.a.a.a.m;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.p.s;
import f.b.a.a.a.b0.v0;
import f.b.a.c.f.b.d;
import f.b.a.c.i.f;
import java.util.Objects;
import java.util.Set;

public final /* synthetic */ class w implements f {
    public final /* synthetic */ ExposureNotificationViewModel a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ w(ExposureNotificationViewModel exposureNotificationViewModel, boolean z) {
        this.a = exposureNotificationViewModel;
        this.b = z;
    }

    @Override // f.b.a.c.i.f
    public final void b(Object obj) {
        Boolean bool;
        s<Boolean> sVar;
        ExposureNotificationViewModel exposureNotificationViewModel = this.a;
        boolean z = this.b;
        Set set = (Set) obj;
        Objects.requireNonNull(exposureNotificationViewModel);
        d dVar = d.LOCATION_DISABLED;
        if (set != null) {
            if (set.contains(dVar)) {
                sVar = exposureNotificationViewModel.f338h;
                bool = Boolean.TRUE;
            } else {
                sVar = exposureNotificationViewModel.f338h;
                bool = Boolean.FALSE;
            }
            sVar.l(bool);
        }
        d dVar2 = d.BLUETOOTH_SUPPORT_UNKNOWN;
        d dVar3 = d.BLUETOOTH_DISABLED;
        ExposureNotificationViewModel.b bVar = ExposureNotificationViewModel.b.STORAGE_LOW;
        d dVar4 = d.LOW_STORAGE;
        ExposureNotificationViewModel.b bVar2 = ExposureNotificationViewModel.b.DISABLED;
        if (!z) {
            if (set.contains(d.EN_NOT_SUPPORT)) {
                bVar = ExposureNotificationViewModel.b.PAUSED_EN_NOT_SUPPORT;
            } else if (set.contains(d.HW_NOT_SUPPORT)) {
                bVar = ExposureNotificationViewModel.b.PAUSED_HW_NOT_SUPPORT;
            } else if (set.contains(d.USER_PROFILE_NOT_SUPPORT)) {
                bVar = ExposureNotificationViewModel.b.PAUSED_USER_PROFILE_NOT_SUPPORT;
            } else if (set.contains(d.NOT_IN_ALLOWLIST)) {
                bVar = ExposureNotificationViewModel.b.PAUSED_NOT_IN_ALLOWLIST;
            } else if (!set.contains(dVar4)) {
                if (!set.contains(d.NO_CONSENT) && set.contains(d.FOCUS_LOST)) {
                    bVar = ExposureNotificationViewModel.b.FOCUS_LOST;
                }
            }
            exposureNotificationViewModel.c.l(bVar);
            v0 v0Var = exposureNotificationViewModel.f340j;
            v0Var.a.edit().putInt("ExposureNotificationSharedPreferences.EN_STATE_CACHE_KEY", bVar.ordinal()).apply();
            exposureNotificationViewModel.f334d.l(Boolean.FALSE);
        }
        if (set.contains(d.ACTIVATED)) {
            bVar = ExposureNotificationViewModel.b.ENABLED;
        } else if (set.contains(d.INACTIVATED)) {
            if (!set.contains(dVar4)) {
                if (set.contains(dVar) && (set.contains(dVar3) || set.contains(dVar2))) {
                    bVar = ExposureNotificationViewModel.b.PAUSED_LOCATION_BLE;
                } else if (set.contains(dVar3) || set.contains(dVar2)) {
                    bVar = ExposureNotificationViewModel.b.PAUSED_BLE;
                } else if (set.contains(dVar)) {
                    bVar = ExposureNotificationViewModel.b.PAUSED_LOCATION;
                }
            }
        }
        exposureNotificationViewModel.c.l(bVar);
        v0 v0Var2 = exposureNotificationViewModel.f340j;
        v0Var2.a.edit().putInt("ExposureNotificationSharedPreferences.EN_STATE_CACHE_KEY", bVar.ordinal()).apply();
        exposureNotificationViewModel.f334d.l(Boolean.FALSE);
        bVar = bVar2;
        exposureNotificationViewModel.c.l(bVar);
        v0 v0Var22 = exposureNotificationViewModel.f340j;
        v0Var22.a.edit().putInt("ExposureNotificationSharedPreferences.EN_STATE_CACHE_KEY", bVar.ordinal()).apply();
        exposureNotificationViewModel.f334d.l(Boolean.FALSE);
    }
}
