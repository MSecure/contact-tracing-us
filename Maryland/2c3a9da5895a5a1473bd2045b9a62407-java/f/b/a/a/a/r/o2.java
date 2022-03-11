package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.y.c0;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class o2 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ String b;

    public /* synthetic */ o2(ShareDiagnosisViewModel shareDiagnosisViewModel, String str) {
        this.a = shareDiagnosisViewModel;
        this.b = str;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        String str = this.b;
        List list = (List) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (!list.isEmpty()) {
            return new s.a(new ShareDiagnosisViewModel.e((c0) list.get(0)));
        }
        if (!shareDiagnosisViewModel.f388g.a()) {
            return new s.a(new ShareDiagnosisViewModel.c(null));
        }
        return shareDiagnosisViewModel.f385d.a(f.b.a.a.a.n.u.i(str).a());
    }
}
