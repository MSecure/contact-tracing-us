package f.b.a.a.a.p;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import e.b.a.m;
import f.b.a.a.a.w.b0;

public final /* synthetic */ class d0 implements View.OnClickListener {
    public final /* synthetic */ l3 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b0 f2176d;

    public /* synthetic */ d0(l3 l3Var, View view, b0 b0Var) {
        this.b = l3Var;
        this.c = view;
        this.f2176d = b0Var;
    }

    public final void onClick(View view) {
        l3 l3Var = this.b;
        View view2 = this.c;
        b0 b0Var = this.f2176d;
        m.h.B0(l3Var.n0(), view2);
        if (m.h.q0(b0Var)) {
            ShareDiagnosisActivity.w(l3Var.m0(), l3Var.Z);
        } else {
            l3Var.m0().finish();
        }
    }
}
