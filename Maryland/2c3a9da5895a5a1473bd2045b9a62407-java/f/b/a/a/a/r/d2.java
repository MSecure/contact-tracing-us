package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class d2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ d2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Long l2 = (Long) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        shareDiagnosisViewModel.h(l2.longValue());
        return l2;
    }
}
