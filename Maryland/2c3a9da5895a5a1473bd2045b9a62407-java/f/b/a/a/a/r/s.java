package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.r;

public final /* synthetic */ class s implements r {
    public final /* synthetic */ v3 a;
    public final /* synthetic */ ShareDiagnosisViewModel b;

    public /* synthetic */ s(v3 v3Var, ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = v3Var;
        this.b = shareDiagnosisViewModel;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        this.a.a0.c.setOnClickListener(new t(this.b, (ShareDiagnosisViewModel.d) obj));
    }
}
