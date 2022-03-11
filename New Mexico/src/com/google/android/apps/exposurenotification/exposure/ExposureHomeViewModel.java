package com.google.android.apps.exposurenotification.exposure;

import androidx.lifecycle.LiveData;
import e.c0.w;
import e.r.e0;
import e.v.i;
import f.b.a.a.a.c0.o1;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.n0.r0;
import f.b.a.a.a.n0.t0;
import f.b.a.a.a.n0.u0;
import f.b.a.a.a.n0.v0;
import f.b.a.a.a.t.h0;
import f.b.a.a.a.t.q0.a;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public class ExposureHomeViewModel extends e0 {
    public final a1 c;

    /* renamed from: d */
    public final o1 f335d;

    /* renamed from: e */
    public final h0 f336e;

    /* renamed from: f */
    public final LiveData<List<u0>> f337f;

    /* renamed from: g */
    public final a f338g;

    /* renamed from: h */
    public final w f339h;

    /* renamed from: i */
    public final ExecutorService f340i;

    public ExposureHomeViewModel(a1 a1Var, o1 o1Var, v0 v0Var, h0 h0Var, a aVar, w wVar, ExecutorService executorService) {
        this.c = a1Var;
        this.f335d = o1Var;
        this.f336e = h0Var;
        r0 r0Var = (r0) v0Var.a;
        Objects.requireNonNull(r0Var);
        i t = i.t("SELECT * FROM ExposureCheckEntity ORDER BY checkTime DESC LIMIT ?", 1);
        t.x(1, (long) 5);
        this.f337f = r0Var.a.f2062e.b(new String[]{"ExposureCheckEntity"}, false, new t0(r0Var, t));
        this.f338g = aVar;
        this.f339h = wVar;
        this.f340i = executorService;
    }

    public void c(a1.f fVar, a1.f fVar2) {
        if (this.c.e() == fVar) {
            this.c.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY", fVar2.b).apply();
        }
    }

    public void d(a1.f fVar, a1.f fVar2) {
        if (this.c.f() == fVar) {
            this.c.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY", fVar2.b).apply();
        }
    }
}
