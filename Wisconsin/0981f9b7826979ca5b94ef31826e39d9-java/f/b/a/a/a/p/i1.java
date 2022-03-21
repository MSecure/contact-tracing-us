package f.b.a.a.a.p;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.w.b0;

public final /* synthetic */ class i1 implements View.OnClickListener {
    public final /* synthetic */ w3 b;
    public final /* synthetic */ b0 c;

    public /* synthetic */ i1(w3 w3Var, b0 b0Var) {
        this.b = w3Var;
        this.c = b0Var;
    }

    public final void onClick(View view) {
        w3 w3Var = this.b;
        w3Var.Z.f(n3.a(ShareDiagnosisViewModel.e.TRAVEL_STATUS, this.c, w3Var.W));
    }
}
