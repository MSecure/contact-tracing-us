package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.a.g;
import gov.md.covid19.exposurenotifications.R;

public final /* synthetic */ class u2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ u2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        ShareDiagnosisViewModel.c cVar = (ShareDiagnosisViewModel.c) obj;
        shareDiagnosisViewModel.f392k.j(Boolean.FALSE);
        shareDiagnosisViewModel.w.j(shareDiagnosisViewModel.f387f.getString(R.string.share_error_no_internet));
        shareDiagnosisViewModel.p.j(Boolean.TRUE);
        return null;
    }
}
