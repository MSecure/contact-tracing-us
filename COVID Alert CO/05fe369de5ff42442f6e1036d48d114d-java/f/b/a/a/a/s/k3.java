package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.o.e0;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class k3 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ k3(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        h0.d dVar;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        e0 e0Var = (e0) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        a aVar = ShareDiagnosisViewModel.O;
        aVar.a("Upload success: " + e0Var);
        shareDiagnosisViewModel.o(new y3(e0Var));
        shareDiagnosisViewModel.t.j(Boolean.TRUE);
        shareDiagnosisViewModel.f407h.t(shareDiagnosisViewModel.f409j.c());
        try {
            dVar = h0.d.a(e0Var.p());
        } catch (IllegalArgumentException | NullPointerException unused) {
            dVar = null;
        }
        shareDiagnosisViewModel.f407h.r(dVar);
        return h0.c.SHARED;
    }
}
