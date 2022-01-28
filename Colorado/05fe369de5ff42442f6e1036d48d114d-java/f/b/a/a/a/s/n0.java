package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.t;
import f.b.a.a.a.b0.h0;
import java.util.Objects;

public final /* synthetic */ class n0 implements t {
    public final /* synthetic */ y5 a;

    public /* synthetic */ n0(y5 y5Var) {
        this.a = y5Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel;
        ShareDiagnosisViewModel.b bVar;
        y5 y5Var = this.a;
        h0 h0Var = (h0) obj;
        Objects.requireNonNull(y5Var);
        if (h0Var == null || ShareDiagnosisViewModel.U.equals(h0Var)) {
            y5Var.a0.p(-1);
            shareDiagnosisViewModel = y5Var.a0;
            bVar = ShareDiagnosisViewModel.b.BEGIN;
        } else {
            ShareDiagnosisViewModel shareDiagnosisViewModel2 = y5Var.a0;
            shareDiagnosisViewModel2.M = true;
            shareDiagnosisViewModel2.p(h0Var.e());
            ShareDiagnosisViewModel shareDiagnosisViewModel3 = y5Var.a0;
            shareDiagnosisViewModel3.H.b("ShareDiagnosisViewModel.SAVED_STATE_VERIFIED_CODE", h0Var.p());
            shareDiagnosisViewModel = y5Var.a0;
            bVar = ShareDiagnosisViewModel.b.CODE;
        }
        shareDiagnosisViewModel.k(bVar);
    }
}
