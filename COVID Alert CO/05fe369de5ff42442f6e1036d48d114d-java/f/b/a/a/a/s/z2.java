package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.b0.h0;
import f.b.b.a.g;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class z2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ z2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        ShareDiagnosisViewModel.d dVar = (ShareDiagnosisViewModel.d) obj;
        shareDiagnosisViewModel.o.j(Boolean.FALSE);
        shareDiagnosisViewModel.l(dVar.b.e());
        if (h0.c.SHARED.equals(dVar.b.m())) {
            shareDiagnosisViewModel.D.j(shareDiagnosisViewModel.f406g.getString(R.string.code_error_already_submitted));
        }
        if (m.h.z0(dVar.b)) {
            shareDiagnosisViewModel.s(dVar.b);
            return null;
        }
        shareDiagnosisViewModel.u.j(Boolean.TRUE);
        return null;
    }
}
