package com.google.android.apps.exposurenotification.exposure;

import androidx.lifecycle.LiveData;
import e.b0.w;
import e.q.e0;
import e.u.i;
import f.b.a.a.a.l0.o0;
import f.b.a.a.a.l0.p0;
import f.b.a.a.a.l0.q0;
import f.b.a.a.a.l0.r0;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.s.e0.a;
import f.b.a.a.a.s.v;
import java.util.List;
import java.util.Objects;

public class ExposureHomeViewModel extends e0 {
    public final v0 c;

    /* renamed from: d  reason: collision with root package name */
    public final v f335d;

    /* renamed from: e  reason: collision with root package name */
    public final LiveData<List<q0>> f336e;

    /* renamed from: f  reason: collision with root package name */
    public final a f337f;

    /* renamed from: g  reason: collision with root package name */
    public final w f338g;

    public ExposureHomeViewModel(v0 v0Var, r0 r0Var, v vVar, a aVar, w wVar) {
        this.c = v0Var;
        this.f335d = vVar;
        o0 o0Var = (o0) r0Var.a;
        Objects.requireNonNull(o0Var);
        i t = i.t("SELECT * FROM ExposureCheckEntity ORDER BY checkTime DESC LIMIT ?", 1);
        t.x(1, (long) 5);
        this.f336e = o0Var.a.f1977e.b(new String[]{"ExposureCheckEntity"}, false, new p0(o0Var, t));
        this.f337f = aVar;
        this.f338g = wVar;
    }

    public void c(v0.f fVar, v0.f fVar2) {
        if (this.c.d() == fVar) {
            this.c.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY", fVar2.b).apply();
        }
    }

    public void d(v0.f fVar, v0.f fVar2) {
        if (this.c.e() == fVar) {
            this.c.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY", fVar2.b).apply();
        }
    }
}
