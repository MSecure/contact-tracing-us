package f.b.a.a.a.p;

import android.util.Log;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.w.b0;
import f.b.a.c.b.l.b;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class l2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ l2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Objects.requireNonNull(shareDiagnosisViewModel);
        Log.e("ShareDiagnosisViewModel", "Upload fail: ", (b) obj);
        b0.c cVar = b0.c.NOT_SHARED;
        shareDiagnosisViewModel.j(new g2(shareDiagnosisViewModel, cVar));
        return cVar;
    }
}
