package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.y.c0;
import f.b.b.a.g;
import gov.md.covid19.exposurenotifications.R;

public final /* synthetic */ class n2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ n2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        ShareDiagnosisViewModel.e eVar = (ShareDiagnosisViewModel.e) obj;
        shareDiagnosisViewModel.f392k.j(Boolean.FALSE);
        shareDiagnosisViewModel.h(eVar.b.e());
        if (c0.c.SHARED.equals(eVar.b.k())) {
            shareDiagnosisViewModel.w.j(shareDiagnosisViewModel.f387f.getString(R.string.code_error_already_submitted));
        }
        if (z3.b(eVar.b)) {
            c0 c0Var = eVar.b;
            shareDiagnosisViewModel.v.pop();
            shareDiagnosisViewModel.f(z3.a(ShareDiagnosisViewModel.d.CODE, c0Var, shareDiagnosisViewModel.x));
            return null;
        }
        shareDiagnosisViewModel.p.j(Boolean.TRUE);
        return null;
    }
}
