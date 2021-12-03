package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.c.b.l.b;
import f.b.b.a.g;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class e4 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ e4(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        b bVar = (b) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (bVar.b.c == 6) {
            shareDiagnosisViewModel.r.j(bVar);
            return null;
        }
        ShareDiagnosisViewModel.O.h("No RESOLUTION_REQUIRED in result", bVar);
        shareDiagnosisViewModel.q.j(shareDiagnosisViewModel.f402g.getString(R.string.generic_error_message));
        shareDiagnosisViewModel.o.j(Boolean.FALSE);
        return null;
    }
}
