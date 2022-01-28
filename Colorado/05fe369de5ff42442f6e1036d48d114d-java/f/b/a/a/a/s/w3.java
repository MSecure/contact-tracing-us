package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.i.y;
import f.b.a.a.a.o.a0;
import f.b.a.a.a.o.e0;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class w3 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ String b;

    public /* synthetic */ w3(ShareDiagnosisViewModel shareDiagnosisViewModel, String str) {
        this.a = shareDiagnosisViewModel;
        this.b = str;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        String str = this.b;
        List list = (List) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        ShareDiagnosisViewModel.O.a("Submitting verification code...");
        e0.a i2 = e0.i(str, y.a(shareDiagnosisViewModel.f411l));
        if (!list.isEmpty()) {
            ((a0.b) i2).f2286l = (String) list.get(0);
        }
        return shareDiagnosisViewModel.f404e.b(i2.a());
    }
}
