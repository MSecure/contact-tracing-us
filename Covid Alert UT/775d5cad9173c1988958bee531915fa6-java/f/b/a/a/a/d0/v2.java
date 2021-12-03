package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.s.d0.a;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class v2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ v2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        h0 h0Var = (h0) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (h0Var == null) {
            a aVar = ShareDiagnosisViewModel.O;
            StringBuilder h2 = f.a.a.a.a.h("No diagnosis id [");
            h2.append(shareDiagnosisViewModel.n);
            h2.append("] exists in storage. Returning a fresh empty one.");
            aVar.a(h2.toString());
            return ShareDiagnosisViewModel.U;
        }
        a aVar2 = ShareDiagnosisViewModel.O;
        StringBuilder h3 = f.a.a.a.a.h("Got saved diagnosis for id ");
        h3.append(shareDiagnosisViewModel.n.d());
        aVar2.a(h3.toString());
        return h0Var;
    }
}
