package com.google.android.apps.exposurenotification.exposure;

import e.p.a0;
import f.b.a.a.a.w.k0;

public class ExposureHomeViewModel extends a0 {
    public final k0 c;

    public ExposureHomeViewModel(k0 k0Var) {
        this.c = k0Var;
    }

    public void c(k0.f fVar, k0.f fVar2) {
        if (this.c.d() == fVar) {
            this.c.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY", fVar2.b).apply();
        }
    }

    public void d(k0.f fVar, k0.f fVar2) {
        if (this.c.e() == fVar) {
            this.c.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY", fVar2.b).apply();
        }
    }
}
