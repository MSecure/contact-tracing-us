package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.b0.h0;
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
        if (m.h.z0(h0Var)) {
            shareDiagnosisViewModel.s(h0Var);
            return null;
        }
        shareDiagnosisViewModel.u.j(Boolean.TRUE);
        shareDiagnosisViewModel.j(m.h.m0(ShareDiagnosisViewModel.b.CODE, h0Var, shareDiagnosisViewModel.I, shareDiagnosisViewModel.r(shareDiagnosisViewModel.f406g), shareDiagnosisViewModel.G));
        return null;
    }
}
