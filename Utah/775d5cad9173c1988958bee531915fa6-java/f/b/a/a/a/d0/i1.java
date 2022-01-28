package f.b.a.a.a.d0;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.a.l;
import java.util.Objects;

public final /* synthetic */ class i1 implements View.OnClickListener {
    public final /* synthetic */ a6 b;
    public final /* synthetic */ l c;

    public /* synthetic */ i1(a6 a6Var, l lVar) {
        this.b = a6Var;
        this.c = lVar;
    }

    public final void onClick(View view) {
        ShareDiagnosisViewModel shareDiagnosisViewModel;
        ShareDiagnosisViewModel.b bVar;
        a6 a6Var = this.b;
        l lVar = this.c;
        Objects.requireNonNull(a6Var);
        if (lVar.b()) {
            shareDiagnosisViewModel = a6Var.b0;
            bVar = ShareDiagnosisViewModel.b.ALREADY_REPORTED;
        } else {
            a6Var.b0.q(w5.SELF_REPORT);
            shareDiagnosisViewModel = a6Var.b0;
            bVar = ShareDiagnosisViewModel.b.GET_CODE;
        }
        shareDiagnosisViewModel.j(bVar);
    }
}
