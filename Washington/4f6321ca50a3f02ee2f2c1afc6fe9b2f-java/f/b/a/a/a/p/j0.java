package f.b.a.a.a.p;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.w.b0;

public final /* synthetic */ class j0 implements View.OnClickListener {
    public final /* synthetic */ q3 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b0 f2178d;

    public /* synthetic */ j0(q3 q3Var, View view, b0 b0Var) {
        this.b = q3Var;
        this.c = view;
        this.f2178d = b0Var;
    }

    public final void onClick(View view) {
        q3 q3Var = this.b;
        View view2 = this.c;
        b0 b0Var = this.f2178d;
        m.h.C0(q3Var.n0(), view2);
        q3Var.a0.i(n3.b(ShareDiagnosisViewModel.e.ONSET, b0Var, q3Var.W));
    }
}
