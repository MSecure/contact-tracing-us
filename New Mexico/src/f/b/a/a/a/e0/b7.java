package f.b.a.a.a.e0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.f.a.p;
/* loaded from: classes.dex */
public class b7 implements p<Void> {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public b7(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.p
    public void a(Void r3) {
        this.a.n.j(-1L);
        this.a.p.j(null);
    }

    @Override // f.b.b.f.a.p
    public void b(Throwable th) {
        ShareDiagnosisViewModel.R.h("Failed to delete", th);
    }
}
