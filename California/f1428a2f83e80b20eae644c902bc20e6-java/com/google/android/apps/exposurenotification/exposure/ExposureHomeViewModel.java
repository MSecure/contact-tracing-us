package com.google.android.apps.exposurenotification.exposure;

import e.p.a0;
import f.b.a.a.a.w.n0;

public class ExposureHomeViewModel extends a0 {
    public final n0 c;

    public ExposureHomeViewModel(n0 n0Var) {
        this.c = n0Var;
    }

    public void c(n0.b bVar, n0.b bVar2) {
        if (this.c.b() == bVar) {
            this.c.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY", bVar2.b).apply();
        }
    }

    public void d(n0.b bVar, n0.b bVar2) {
        if (this.c.c() == bVar) {
            this.c.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY", bVar2.b).apply();
        }
    }
}
