package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.l.t;
import f.b.a.a.a.w.b0;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class s2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ s2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        t tVar = (t) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        String str = "Upload success: " + tVar;
        shareDiagnosisViewModel.j(new y1(tVar));
        shareDiagnosisViewModel.m.j(Boolean.TRUE);
        return b0.c.SHARED;
    }
}
