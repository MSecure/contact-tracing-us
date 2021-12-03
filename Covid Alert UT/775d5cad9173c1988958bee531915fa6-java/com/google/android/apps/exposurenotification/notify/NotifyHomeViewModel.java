package com.google.android.apps.exposurenotification.notify;

import androidx.lifecycle.LiveData;
import e.q.e0;
import e.u.i;
import f.b.a.a.a.l0.a0;
import f.b.a.a.a.l0.f0;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.l0.i0;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.s.z;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public class NotifyHomeViewModel extends e0 {

    /* renamed from: h  reason: collision with root package name */
    public static final a f394h = a.e("NotifyHomeViewModel");
    public final z<Void> c = new z<>();

    /* renamed from: d  reason: collision with root package name */
    public final LiveData<List<h0>> f395d;

    /* renamed from: e  reason: collision with root package name */
    public final i0 f396e;

    /* renamed from: f  reason: collision with root package name */
    public final ExecutorService f397f;

    /* renamed from: g  reason: collision with root package name */
    public int f398g = -1;

    public NotifyHomeViewModel(i0 i0Var, ExecutorService executorService) {
        this.f396e = i0Var;
        this.f397f = executorService;
        a0 a0Var = (a0) i0Var.a;
        Objects.requireNonNull(a0Var);
        this.f395d = a0Var.a.f1977e.b(new String[]{"DiagnosisEntity"}, false, new f0(a0Var, i.t("SELECT * FROM DiagnosisEntity ORDER BY id DESC", 0)));
    }
}
