package f.b.a.a.a.p;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.w.b0;

public final /* synthetic */ class j1 implements View.OnClickListener {
    public final /* synthetic */ w3 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b0 f2179d;

    public /* synthetic */ j1(w3 w3Var, View view, b0 b0Var) {
        this.b = w3Var;
        this.c = view;
        this.f2179d = b0Var;
    }

    public final void onClick(View view) {
        w3 w3Var = this.b;
        View view2 = this.c;
        b0 b0Var = this.f2179d;
        m.h.B0(w3Var.n0(), view2);
        w3Var.Z.i(n3.b(ShareDiagnosisViewModel.e.TRAVEL_STATUS, b0Var, w3Var.W));
    }
}
