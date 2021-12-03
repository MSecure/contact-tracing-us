package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.s.x;
import f.b.a.a.a.y.a0;
import f.b.a.a.a.y.e0;
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
        e0.a i2 = e0.i(str, x.a(shareDiagnosisViewModel.f407l));
        if (!list.isEmpty()) {
            ((a0.b) i2).f2478l = (String) list.get(0);
        }
        return shareDiagnosisViewModel.f400e.b(i2.a());
    }
}
