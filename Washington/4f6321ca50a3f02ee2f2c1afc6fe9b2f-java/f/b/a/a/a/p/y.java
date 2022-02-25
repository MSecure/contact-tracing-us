package f.b.a.a.a.p;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.w.b0;

public final /* synthetic */ class y implements View.OnClickListener {
    public final /* synthetic */ l3 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b0 f2196d;

    public /* synthetic */ y(l3 l3Var, View view, b0 b0Var) {
        this.b = l3Var;
        this.c = view;
        this.f2196d = b0Var;
    }

    public final void onClick(View view) {
        l3 l3Var = this.b;
        View view2 = this.c;
        b0 b0Var = this.f2196d;
        m.h.C0(l3Var.n0(), view2);
        l3Var.Z.f(n3.a(ShareDiagnosisViewModel.e.CODE, b0Var, l3Var.W));
    }
}
