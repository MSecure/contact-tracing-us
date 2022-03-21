package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.a.g;
import gov.wi.covid19.exposurenotifications.R;

public final /* synthetic */ class r2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ r2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        ShareDiagnosisViewModel.d dVar = (ShareDiagnosisViewModel.d) obj;
        shareDiagnosisViewModel.f376i.j(Boolean.FALSE);
        shareDiagnosisViewModel.u.j(shareDiagnosisViewModel.f373f.getString(R.string.share_error_no_internet));
        shareDiagnosisViewModel.n.j(Boolean.TRUE);
        return null;
    }
}
