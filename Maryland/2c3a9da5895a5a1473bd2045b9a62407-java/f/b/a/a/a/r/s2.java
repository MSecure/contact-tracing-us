package f.b.a.a.a.r;

import android.util.Log;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.a.g;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class s2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ s2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Objects.requireNonNull(shareDiagnosisViewModel);
        Log.e("ShareDiagnosisViewModel", "Failed to submit verification code.", (Exception) obj);
        shareDiagnosisViewModel.f392k.j(Boolean.FALSE);
        shareDiagnosisViewModel.p.j(Boolean.TRUE);
        shareDiagnosisViewModel.w.j(shareDiagnosisViewModel.f387f.getString(R.string.generic_error_message));
        return null;
    }
}
