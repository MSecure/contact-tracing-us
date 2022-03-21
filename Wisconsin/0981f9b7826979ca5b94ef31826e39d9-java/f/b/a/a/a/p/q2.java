package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.w.b0;
import f.b.b.a.g;
import gov.wi.covid19.exposurenotifications.R;

public final /* synthetic */ class q2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ q2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        ShareDiagnosisViewModel.f fVar = (ShareDiagnosisViewModel.f) obj;
        shareDiagnosisViewModel.f376i.j(Boolean.FALSE);
        shareDiagnosisViewModel.h(fVar.b.e());
        if (b0.c.SHARED.equals(fVar.b.k())) {
            shareDiagnosisViewModel.u.j(shareDiagnosisViewModel.f373f.getString(R.string.code_error_already_submitted));
        }
        if (n3.c(fVar.b)) {
            b0 b0Var = fVar.b;
            shareDiagnosisViewModel.t.pop();
            shareDiagnosisViewModel.f(n3.a(ShareDiagnosisViewModel.e.CODE, b0Var, shareDiagnosisViewModel.v));
            return null;
        }
        shareDiagnosisViewModel.n.j(Boolean.TRUE);
        return null;
    }
}
