package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.o.e0;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class z3 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ z3(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Objects.requireNonNull(shareDiagnosisViewModel);
        ShareDiagnosisViewModel.O.a("Uploading keys and cert to keyserver...");
        return shareDiagnosisViewModel.f404e.d((e0) obj);
    }
}
