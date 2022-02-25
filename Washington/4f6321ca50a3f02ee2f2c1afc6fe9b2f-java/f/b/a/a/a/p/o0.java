package f.b.a.a.a.p;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.w.b0;

public final /* synthetic */ class o0 implements View.OnClickListener {
    public final /* synthetic */ q3 b;
    public final /* synthetic */ b0 c;

    public /* synthetic */ o0(q3 q3Var, b0 b0Var) {
        this.b = q3Var;
        this.c = b0Var;
    }

    public final void onClick(View view) {
        q3 q3Var = this.b;
        q3Var.a0.f(n3.a(ShareDiagnosisViewModel.e.ONSET, this.c, q3Var.W));
    }
}
