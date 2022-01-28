package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.o.f0;
import f.b.b.a.g;

public final /* synthetic */ class a4 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ f0.d b;

    public /* synthetic */ a4(ShareDiagnosisViewModel shareDiagnosisViewModel, f0.d dVar) {
        this.a = shareDiagnosisViewModel;
        this.b = dVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        f0.d dVar = this.b;
        Long l2 = (Long) obj;
        shareDiagnosisViewModel.o.j(Boolean.FALSE);
        shareDiagnosisViewModel.E.j(dVar.b.a(shareDiagnosisViewModel.f406g, x5.SELF_REPORT.equals(shareDiagnosisViewModel.I)));
        return null;
    }
}
