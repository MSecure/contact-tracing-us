package com.google.android.apps.exposurenotification.exposure;

import androidx.lifecycle.LiveData;
import e.p.a0;
import e.t.i;
import f.b.a.a.a.y.j0;
import f.b.a.a.a.y.k0;
import f.b.a.a.a.y.l0;
import f.b.a.a.a.y.m0;
import f.b.a.a.a.y.q0;
import java.util.List;
import java.util.Objects;

public class ExposureHomeViewModel extends a0 {
    public final q0 c;

    /* renamed from: d  reason: collision with root package name */
    public final LiveData<List<l0>> f339d;

    public ExposureHomeViewModel(q0 q0Var, m0 m0Var) {
        this.c = q0Var;
        j0 j0Var = (j0) m0Var.a;
        Objects.requireNonNull(j0Var);
        i v = i.v("SELECT * FROM ExposureCheckEntity ORDER BY checkTime DESC LIMIT ?", 1);
        v.A(1, (long) 5);
        this.f339d = j0Var.a.f1886e.b(new String[]{"ExposureCheckEntity"}, false, new k0(j0Var, v));
    }

    public void c(q0.f fVar, q0.f fVar2) {
        if (this.c.d() == fVar) {
            this.c.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY", fVar2.b).apply();
        }
    }

    public void d(q0.f fVar, q0.f fVar2) {
        if (this.c.e() == fVar) {
            this.c.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY", fVar2.b).apply();
        }
    }
}
