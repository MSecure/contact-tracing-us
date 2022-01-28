package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.a.g;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class g4 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ g4(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Exception exc = (Exception) obj;
        shareDiagnosisViewModel.q.j(shareDiagnosisViewModel.f406g.getString(R.string.generic_error_message));
        shareDiagnosisViewModel.o.j(Boolean.FALSE);
        return null;
    }
}
