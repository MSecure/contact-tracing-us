package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.b.f.a.p;

public class o6 implements p<Void> {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public o6(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.p
    public void a(Throwable th) {
        ShareDiagnosisViewModel.O.h("Failed to delete", th);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.b.f.a.p
    public void b(Void r3) {
        this.a.n.j(-1L);
        this.a.p.j(null);
    }
}
