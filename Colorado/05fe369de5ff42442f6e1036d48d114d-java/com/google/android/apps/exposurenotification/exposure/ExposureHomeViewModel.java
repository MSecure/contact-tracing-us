package com.google.android.apps.exposurenotification.exposure;

import androidx.lifecycle.LiveData;
import e.p.e0;
import e.t.i;
import e.z.t;
import f.b.a.a.a.b0.o0;
import f.b.a.a.a.b0.p0;
import f.b.a.a.a.b0.q0;
import f.b.a.a.a.b0.r0;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.i.f0.a;
import f.b.a.a.a.i.w;
import java.util.List;
import java.util.Objects;

public class ExposureHomeViewModel extends e0 {
    public final v0 c;

    /* renamed from: d  reason: collision with root package name */
    public final w f330d;

    /* renamed from: e  reason: collision with root package name */
    public final LiveData<List<q0>> f331e;

    /* renamed from: f  reason: collision with root package name */
    public final a f332f;

    /* renamed from: g  reason: collision with root package name */
    public final t f333g;

    public ExposureHomeViewModel(v0 v0Var, r0 r0Var, w wVar, a aVar, t tVar) {
        this.c = v0Var;
        this.f330d = wVar;
        o0 o0Var = (o0) r0Var.a;
        Objects.requireNonNull(o0Var);
        i t = i.t("SELECT * FROM ExposureCheckEntity ORDER BY checkTime DESC LIMIT ?", 1);
        t.x(1, (long) 5);
        this.f331e = o0Var.a.f1702e.b(new String[]{"ExposureCheckEntity"}, false, new p0(o0Var, t));
        this.f332f = aVar;
        this.f333g = tVar;
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
