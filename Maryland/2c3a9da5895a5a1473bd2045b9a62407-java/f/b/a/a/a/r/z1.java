package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.a.a.a.a;
import f.b.a.a.a.y.c0;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class z1 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ z1(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        c0 c0Var = (c0) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (c0Var == null) {
            StringBuilder h2 = a.h("No diagnosis id [");
            h2.append(shareDiagnosisViewModel.f391j);
            h2.append("] exists in storage. Returning a fresh empty one.");
            h2.toString();
            return shareDiagnosisViewModel.t.d();
        }
        StringBuilder h3 = a.h("Got saved diagnosis for id ");
        h3.append(shareDiagnosisViewModel.f391j.d());
        h3.toString();
        return c0Var;
    }
}
