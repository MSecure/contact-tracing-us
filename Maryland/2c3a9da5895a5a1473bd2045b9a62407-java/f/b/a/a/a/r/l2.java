package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class l2 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ l2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Long l2 = (Long) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        shareDiagnosisViewModel.h(l2.longValue());
        shareDiagnosisViewModel.f392k.j(Boolean.FALSE);
        shareDiagnosisViewModel.w.j("");
        return shareDiagnosisViewModel.c.b(l2.longValue());
    }
}
