package f.b.a.a.a.d0;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;

public final /* synthetic */ class y implements View.OnClickListener {
    public final /* synthetic */ u5 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ShareDiagnosisViewModel.b f2195d;

    public /* synthetic */ y(u5 u5Var, View view, ShareDiagnosisViewModel.b bVar) {
        this.b = u5Var;
        this.c = view;
        this.f2195d = bVar;
    }

    public final void onClick(View view) {
        u5 u5Var = this.b;
        View view2 = this.c;
        ShareDiagnosisViewModel.b bVar = this.f2195d;
        m.e.S0(u5Var.t0(), view2);
        ShareDiagnosisViewModel shareDiagnosisViewModel = u5Var.b0;
        shareDiagnosisViewModel.M = false;
        shareDiagnosisViewModel.j(bVar);
    }
}
