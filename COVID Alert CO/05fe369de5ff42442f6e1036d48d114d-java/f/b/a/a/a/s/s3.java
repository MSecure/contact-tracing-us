package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.a.g;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class s3 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ s3(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Exception exc = (Exception) obj;
        shareDiagnosisViewModel.o.j(Boolean.FALSE);
        shareDiagnosisViewModel.E.j(shareDiagnosisViewModel.f406g.getString(R.string.generic_error_message));
        return null;
    }
}
