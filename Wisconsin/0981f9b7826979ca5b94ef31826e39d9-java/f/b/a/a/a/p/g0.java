package f.b.a.a.a.p;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.w.b0;

public final /* synthetic */ class g0 implements View.OnClickListener {
    public final /* synthetic */ l3 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b0 f2177d;

    public /* synthetic */ g0(l3 l3Var, View view, b0 b0Var) {
        this.b = l3Var;
        this.c = view;
        this.f2177d = b0Var;
    }

    public final void onClick(View view) {
        l3 l3Var = this.b;
        View view2 = this.c;
        b0 b0Var = this.f2177d;
        m.h.B0(l3Var.n0(), view2);
        l3Var.Z.i(n3.b(ShareDiagnosisViewModel.e.CODE, b0Var, l3Var.W));
    }
}
