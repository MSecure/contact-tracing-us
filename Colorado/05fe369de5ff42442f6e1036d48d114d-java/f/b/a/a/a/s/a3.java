package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class a3 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ a3(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Long l2 = (Long) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        ShareDiagnosisViewModel.O.a("Current diagnosis stored, notifying view");
        shareDiagnosisViewModel.l(l2.longValue());
        shareDiagnosisViewModel.o.j(Boolean.FALSE);
        shareDiagnosisViewModel.D.j("");
        return shareDiagnosisViewModel.c.b(l2.longValue());
    }
}
