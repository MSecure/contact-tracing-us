package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.a.g;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class k4 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ k4(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Objects.requireNonNull(shareDiagnosisViewModel);
        ShareDiagnosisViewModel.O.d("Failed to submit verification code.", (Exception) obj);
        shareDiagnosisViewModel.o.j(Boolean.FALSE);
        shareDiagnosisViewModel.u.j(Boolean.TRUE);
        shareDiagnosisViewModel.D.j(shareDiagnosisViewModel.f402g.getString(R.string.generic_error_message));
        return null;
    }
}
