package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.q.t;
import f.b.a.a.a.l0.h0;
import java.util.Objects;

public final /* synthetic */ class n0 implements t {
    public final /* synthetic */ x5 a;

    public /* synthetic */ n0(x5 x5Var) {
        this.a = x5Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel;
        ShareDiagnosisViewModel.b bVar;
        x5 x5Var = this.a;
        h0 h0Var = (h0) obj;
        Objects.requireNonNull(x5Var);
        if (h0Var == null || ShareDiagnosisViewModel.U.equals(h0Var)) {
            x5Var.b0.p(-1);
            shareDiagnosisViewModel = x5Var.b0;
            bVar = ShareDiagnosisViewModel.b.BEGIN;
        } else {
            ShareDiagnosisViewModel shareDiagnosisViewModel2 = x5Var.b0;
            shareDiagnosisViewModel2.M = true;
            shareDiagnosisViewModel2.p(h0Var.e());
            ShareDiagnosisViewModel shareDiagnosisViewModel3 = x5Var.b0;
            shareDiagnosisViewModel3.H.b("ShareDiagnosisViewModel.SAVED_STATE_VERIFIED_CODE", h0Var.p());
            shareDiagnosisViewModel = x5Var.b0;
            bVar = ShareDiagnosisViewModel.b.CODE;
        }
        shareDiagnosisViewModel.k(bVar);
    }
}
