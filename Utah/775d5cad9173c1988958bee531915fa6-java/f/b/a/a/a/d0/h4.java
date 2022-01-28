package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.y.e0;
import f.b.a.c.b.o.b;
import f.b.b.a.t;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class h4 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ h4(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        e0 e0Var = (e0) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        ShareDiagnosisViewModel.O.a("Submitting keys to verification server for certificate...");
        return t.a(e0Var.a()) ? shareDiagnosisViewModel.f400e.c(e0Var) : b.Q0(e0Var);
    }
}
