package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.o.f0;
import f.b.b.a.g;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class f3 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ f3(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        f0.c cVar = (f0.c) obj;
        shareDiagnosisViewModel.q.j(shareDiagnosisViewModel.f406g.getString(R.string.share_error_no_internet));
        shareDiagnosisViewModel.o.j(Boolean.FALSE);
        return null;
    }
}
