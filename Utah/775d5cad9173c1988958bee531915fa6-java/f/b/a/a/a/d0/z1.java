package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.s.w;
import f.b.b.a.l;
import java.util.Objects;

public final /* synthetic */ class z1 implements w.a {
    public final /* synthetic */ i6 a;

    public /* synthetic */ z1(i6 i6Var) {
        this.a = i6Var;
    }

    @Override // f.b.a.a.a.s.w.a
    public final void a(Object obj, Object obj2) {
        i6 i6Var = this.a;
        h0 h0Var = (h0) obj;
        Boolean bool = (Boolean) obj2;
        Objects.requireNonNull(i6Var);
        if (bool != null) {
            ShareDiagnosisViewModel.b bVar = ShareDiagnosisViewModel.b.UPLOAD;
            ShareDiagnosisViewModel shareDiagnosisViewModel = i6Var.b0;
            w5 w5Var = shareDiagnosisViewModel.I;
            boolean r = shareDiagnosisViewModel.r(i6Var.A());
            boolean booleanValue = bool.booleanValue();
            i6Var.b0.k(m.e.v0(bVar, h0Var, w5Var, r, l.c(Boolean.valueOf(booleanValue)), i6Var.t0()));
        }
    }
}
