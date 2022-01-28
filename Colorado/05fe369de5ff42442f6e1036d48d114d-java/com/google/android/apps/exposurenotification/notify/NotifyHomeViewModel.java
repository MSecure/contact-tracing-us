package com.google.android.apps.exposurenotification.notify;

import androidx.lifecycle.LiveData;
import e.p.e0;
import e.t.i;
import f.b.a.a.a.b0.f0;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.b0.i0;
import f.b.a.a.a.i.a0;
import f.b.a.a.a.i.e0.a;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public class NotifyHomeViewModel extends e0 {

    /* renamed from: h  reason: collision with root package name */
    public static final a f398h = a.e("NotifyHomeViewModel");
    public final a0<Void> c = new a0<>();

    /* renamed from: d  reason: collision with root package name */
    public final LiveData<List<h0>> f399d;

    /* renamed from: e  reason: collision with root package name */
    public final i0 f400e;

    /* renamed from: f  reason: collision with root package name */
    public final ExecutorService f401f;

    /* renamed from: g  reason: collision with root package name */
    public int f402g = -1;

    public NotifyHomeViewModel(i0 i0Var, ExecutorService executorService) {
        this.f400e = i0Var;
        this.f401f = executorService;
        f.b.a.a.a.b0.a0 a0Var = (f.b.a.a.a.b0.a0) i0Var.a;
        Objects.requireNonNull(a0Var);
        this.f399d = a0Var.a.f1702e.b(new String[]{"DiagnosisEntity"}, false, new f0(a0Var, i.t("SELECT * FROM DiagnosisEntity ORDER BY id DESC", 0)));
    }
}
