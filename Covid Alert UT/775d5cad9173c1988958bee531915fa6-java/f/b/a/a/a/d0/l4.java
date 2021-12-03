package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import gov.ut.covid19.exposurenotifications.R;
import l.b.a.e;

public final /* synthetic */ class l4 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ l4(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        if (((e) obj) == null) {
            return shareDiagnosisViewModel.d(ShareDiagnosisViewModel.Q);
        }
        String string = shareDiagnosisViewModel.f402g.getString(R.string.health_authority_name);
        return new s.a(new ShareDiagnosisViewModel.c(shareDiagnosisViewModel.f402g.getString(R.string.self_report_code_requested_too_many_times, string)));
    }
}
