package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.a.g;
import gov.md.covid19.exposurenotifications.R;

public final /* synthetic */ class r2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ r2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Exception exc = (Exception) obj;
        shareDiagnosisViewModel.m.j(shareDiagnosisViewModel.f387f.getString(R.string.generic_error_message));
        shareDiagnosisViewModel.f392k.j(Boolean.FALSE);
        return null;
    }
}
