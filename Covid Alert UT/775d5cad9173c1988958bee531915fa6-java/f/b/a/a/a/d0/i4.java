package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.l0.h0;
import f.b.a.c.b.l.b;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class i4 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ i4(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Objects.requireNonNull(shareDiagnosisViewModel);
        ShareDiagnosisViewModel.O.d("Upload fail: ", (b) obj);
        h0.c cVar = h0.c.NOT_SHARED;
        shareDiagnosisViewModel.o(new o4(shareDiagnosisViewModel, cVar));
        return cVar;
    }
}
