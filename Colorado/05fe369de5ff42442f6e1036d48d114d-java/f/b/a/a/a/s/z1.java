package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.i.x;
import f.b.b.a.l;
import java.util.Objects;

public final /* synthetic */ class z1 implements x.a {
    public final /* synthetic */ j6 a;

    public /* synthetic */ z1(j6 j6Var) {
        this.a = j6Var;
    }

    @Override // f.b.a.a.a.i.x.a
    public final void a(Object obj, Object obj2) {
        j6 j6Var = this.a;
        h0 h0Var = (h0) obj;
        Boolean bool = (Boolean) obj2;
        Objects.requireNonNull(j6Var);
        if (bool != null) {
            ShareDiagnosisViewModel.b bVar = ShareDiagnosisViewModel.b.UPLOAD;
            ShareDiagnosisViewModel shareDiagnosisViewModel = j6Var.a0;
            x5 x5Var = shareDiagnosisViewModel.I;
            boolean r = shareDiagnosisViewModel.r(j6Var.w());
            boolean booleanValue = bool.booleanValue();
            j6Var.a0.k(m.h.n0(bVar, h0Var, x5Var, r, l.c(Boolean.valueOf(booleanValue)), j6Var.p0()));
        }
    }
}
