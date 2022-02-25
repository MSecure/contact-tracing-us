package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class x1 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ x1(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Long l2 = (Long) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        shareDiagnosisViewModel.h(l2.longValue());
        shareDiagnosisViewModel.f376i.j(Boolean.FALSE);
        shareDiagnosisViewModel.u.j("");
        return shareDiagnosisViewModel.c.a(l2.longValue());
    }
}
