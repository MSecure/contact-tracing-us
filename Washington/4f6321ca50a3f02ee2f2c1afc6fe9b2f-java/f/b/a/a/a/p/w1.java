package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.a.a.a.a;
import f.b.a.a.a.w.b0;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class w1 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ w1(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        b0 b0Var = (b0) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (b0Var == null) {
            StringBuilder h2 = a.h("No diagnosis id [");
            h2.append(shareDiagnosisViewModel.f375h);
            h2.append("] exists in storage. Returning a fresh empty one.");
            h2.toString();
            return shareDiagnosisViewModel.r.d();
        }
        StringBuilder h3 = a.h("Got saved diagnosis for id ");
        h3.append(shareDiagnosisViewModel.f375h.d());
        h3.toString();
        return b0Var;
    }
}
