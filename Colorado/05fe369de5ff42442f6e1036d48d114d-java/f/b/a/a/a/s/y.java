package f.b.a.a.a.s;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;

public final /* synthetic */ class y implements View.OnClickListener {
    public final /* synthetic */ v5 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisViewModel.b f2399d;

    public /* synthetic */ y(v5 v5Var, View view, ShareDiagnosisViewModel.b bVar) {
        this.b = v5Var;
        this.c = view;
        this.f2399d = bVar;
    }

    public final void onClick(View view) {
        v5 v5Var = this.b;
        View view2 = this.c;
        ShareDiagnosisViewModel.b bVar = this.f2399d;
        m.h.H0(v5Var.p0(), view2);
        ShareDiagnosisViewModel shareDiagnosisViewModel = v5Var.a0;
        shareDiagnosisViewModel.M = false;
        shareDiagnosisViewModel.j(bVar);
    }
}
