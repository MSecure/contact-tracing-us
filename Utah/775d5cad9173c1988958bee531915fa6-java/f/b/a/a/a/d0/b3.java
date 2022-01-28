package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.a.g;
import gov.ut.covid19.exposurenotifications.R;

public final /* synthetic */ class b3 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ b3(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Exception exc = (Exception) obj;
        shareDiagnosisViewModel.q.j(shareDiagnosisViewModel.f402g.getString(R.string.generic_error_message));
        shareDiagnosisViewModel.o.j(Boolean.FALSE);
        return null;
    }
}
