package f.b.a.a.a.s;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.a.l;
import java.util.Objects;

public final /* synthetic */ class i1 implements View.OnClickListener {
    public final /* synthetic */ b6 b;
    public final /* synthetic */ l c;

    public /* synthetic */ i1(b6 b6Var, l lVar) {
        this.b = b6Var;
        this.c = lVar;
    }

    public final void onClick(View view) {
        ShareDiagnosisViewModel shareDiagnosisViewModel;
        ShareDiagnosisViewModel.b bVar;
        b6 b6Var = this.b;
        l lVar = this.c;
        Objects.requireNonNull(b6Var);
        if (lVar.b()) {
            shareDiagnosisViewModel = b6Var.a0;
            bVar = ShareDiagnosisViewModel.b.ALREADY_REPORTED;
        } else {
            b6Var.a0.q(x5.SELF_REPORT);
            shareDiagnosisViewModel = b6Var.a0;
            bVar = ShareDiagnosisViewModel.b.GET_CODE;
        }
        shareDiagnosisViewModel.j(bVar);
    }
}
