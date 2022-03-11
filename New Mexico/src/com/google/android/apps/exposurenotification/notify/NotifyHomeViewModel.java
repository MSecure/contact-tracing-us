package com.google.android.apps.exposurenotification.notify;

import androidx.lifecycle.LiveData;
import e.r.e0;
import e.v.i;
import f.b.a.a.a.n0.d0;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.n0.k0;
import f.b.a.a.a.n0.y;
import f.b.a.a.a.t.l0;
import f.b.a.a.a.t.p0.a;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public class NotifyHomeViewModel extends e0 {

    /* renamed from: h */
    public static final a f401h = a.e("NotifyHomeViewModel");

    /* renamed from: d */
    public final LiveData<List<j0>> f402d;

    /* renamed from: e */
    public final k0 f403e;

    /* renamed from: f */
    public final ExecutorService f404f;
    public final l0<Void> c = new l0<>();

    /* renamed from: g */
    public int f405g = -1;

    public NotifyHomeViewModel(k0 k0Var, ExecutorService executorService) {
        this.f403e = k0Var;
        this.f404f = executorService;
        d0 d0Var = (d0) k0Var.a;
        Objects.requireNonNull(d0Var);
        this.f402d = d0Var.a.f2062e.b(new String[]{"DiagnosisEntity"}, false, new y(d0Var, i.t("SELECT * FROM DiagnosisEntity ORDER BY id DESC", 0)));
    }
}
