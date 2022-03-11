package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.w.b0;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class p2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ p2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        b0 b0Var = (b0) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (n3.c(b0Var)) {
            shareDiagnosisViewModel.t.pop();
            shareDiagnosisViewModel.f(n3.a(ShareDiagnosisViewModel.e.CODE, b0Var, shareDiagnosisViewModel.v));
            return null;
        }
        shareDiagnosisViewModel.n.j(Boolean.TRUE);
        return null;
    }
}
