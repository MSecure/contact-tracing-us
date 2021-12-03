package f.b.a.a.a.s;

import android.text.TextUtils;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.o.b0;
import f.b.a.a.a.o.j0;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class g3 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ j0 b;

    public /* synthetic */ g3(ShareDiagnosisViewModel shareDiagnosisViewModel, j0 j0Var) {
        this.a = shareDiagnosisViewModel;
        this.b = j0Var;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        j0 j0Var = this.b;
        j0 j0Var2 = (j0) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        j0.a h2 = j0Var.h();
        if (!TextUtils.isEmpty(j0Var2.a()) && j0Var2.b() > 0) {
            b0.b bVar = (b0.b) h2;
            bVar.f2292d = j0Var2.a();
            bVar.b(j0Var2.b());
        }
        return shareDiagnosisViewModel.c(h2.a());
    }
}
