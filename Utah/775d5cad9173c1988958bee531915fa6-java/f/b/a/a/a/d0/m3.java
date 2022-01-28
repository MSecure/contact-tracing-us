package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.l0.h0;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class m3 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ m3(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        h0 h0Var = (h0) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (m.e.K0(h0Var)) {
            shareDiagnosisViewModel.s(h0Var);
            return null;
        }
        shareDiagnosisViewModel.u.j(Boolean.TRUE);
        shareDiagnosisViewModel.j(m.e.u0(ShareDiagnosisViewModel.b.CODE, h0Var, shareDiagnosisViewModel.I, shareDiagnosisViewModel.r(shareDiagnosisViewModel.f402g), shareDiagnosisViewModel.G));
        return null;
    }
}
