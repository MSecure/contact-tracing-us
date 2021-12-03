package f.b.a.a.a.d0;

import android.text.TextUtils;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.y.b0;
import f.b.a.a.a.y.i0;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class g3 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ i0 b;

    public /* synthetic */ g3(ShareDiagnosisViewModel shareDiagnosisViewModel, i0 i0Var) {
        this.a = shareDiagnosisViewModel;
        this.b = i0Var;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        i0 i0Var = this.b;
        i0 i0Var2 = (i0) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        i0.a h2 = i0Var.h();
        if (!TextUtils.isEmpty(i0Var2.a()) && i0Var2.b() > 0) {
            b0.b bVar = (b0.b) h2;
            bVar.f2484d = i0Var2.a();
            bVar.b(i0Var2.b());
        }
        return shareDiagnosisViewModel.c(h2.a());
    }
}
