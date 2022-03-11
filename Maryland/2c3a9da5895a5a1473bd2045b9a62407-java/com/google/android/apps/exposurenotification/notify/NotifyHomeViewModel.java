package com.google.android.apps.exposurenotification.notify;

import androidx.lifecycle.LiveData;
import e.p.a0;
import e.t.i;
import f.b.a.a.a.h.q;
import f.b.a.a.a.y.c0;
import f.b.a.a.a.y.d0;
import f.b.a.a.a.y.v;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public class NotifyHomeViewModel extends a0 {
    public final q<Void> c = new q<>();

    /* renamed from: d  reason: collision with root package name */
    public final LiveData<List<c0>> f381d;

    /* renamed from: e  reason: collision with root package name */
    public final d0 f382e;

    /* renamed from: f  reason: collision with root package name */
    public final ExecutorService f383f;

    /* renamed from: g  reason: collision with root package name */
    public int f384g = -1;

    public NotifyHomeViewModel(d0 d0Var, ExecutorService executorService) {
        this.f382e = d0Var;
        this.f383f = executorService;
        v vVar = (v) d0Var.a;
        Objects.requireNonNull(vVar);
        this.f381d = vVar.a.f1886e.b(new String[]{"DiagnosisEntity"}, false, new f.b.a.a.a.y.a0(vVar, i.v("SELECT * FROM DiagnosisEntity ORDER BY id DESC", 0)));
    }
}
