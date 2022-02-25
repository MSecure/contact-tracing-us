package com.google.android.apps.exposurenotification.notify;

import androidx.lifecycle.LiveData;
import e.p.a0;
import e.t.i;
import f.b.a.a.a.w.b0;
import f.b.a.a.a.w.c0;
import f.b.a.a.a.w.u;
import f.b.a.a.a.w.z;
import java.util.List;
import java.util.Objects;

public class NotifyHomeViewModel extends a0 {
    public final LiveData<List<b0>> c;

    public NotifyHomeViewModel(c0 c0Var) {
        u uVar = (u) c0Var.a;
        Objects.requireNonNull(uVar);
        this.c = uVar.a.f1854e.b(new String[]{"DiagnosisEntity"}, false, new z(uVar, i.v("SELECT * FROM DiagnosisEntity ORDER BY id DESC", 0)));
    }
}
