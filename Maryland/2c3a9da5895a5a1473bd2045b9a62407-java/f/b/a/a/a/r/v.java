package f.b.a.a.a.r;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import e.b.a.m;
import f.b.a.a.a.y.c0;

public final /* synthetic */ class v implements View.OnClickListener {
    public final /* synthetic */ x3 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c0 f2268d;

    public /* synthetic */ v(x3 x3Var, View view, c0 c0Var) {
        this.b = x3Var;
        this.c = view;
        this.f2268d = c0Var;
    }

    public final void onClick(View view) {
        x3 x3Var = this.b;
        View view2 = this.c;
        c0 c0Var = this.f2268d;
        m.h.B0(x3Var.n0(), view2);
        if (m.h.r0(c0Var)) {
            ShareDiagnosisActivity.x(x3Var.m0(), x3Var.b0);
        } else {
            x3Var.m0().finish();
        }
    }
}
