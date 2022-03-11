package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.y.c0;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class y2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ y2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        c0 c0Var = (c0) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (z3.b(c0Var)) {
            shareDiagnosisViewModel.v.pop();
            shareDiagnosisViewModel.f(z3.a(ShareDiagnosisViewModel.d.CODE, c0Var, shareDiagnosisViewModel.x));
            return null;
        }
        shareDiagnosisViewModel.p.j(Boolean.TRUE);
        return null;
    }
}
