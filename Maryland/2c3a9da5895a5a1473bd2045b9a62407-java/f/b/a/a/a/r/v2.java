package f.b.a.a.a.r;

import android.util.Log;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.c.b.l.b;
import f.b.b.a.g;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class v2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ v2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        b bVar = (b) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (bVar.b.c == 6) {
            shareDiagnosisViewModel.n.j(bVar);
            return null;
        }
        Log.w("ShareDiagnosisViewModel", "No RESOLUTION_REQUIRED in result", bVar);
        shareDiagnosisViewModel.m.j(shareDiagnosisViewModel.f387f.getString(R.string.generic_error_message));
        shareDiagnosisViewModel.f392k.j(Boolean.FALSE);
        return null;
    }
}
