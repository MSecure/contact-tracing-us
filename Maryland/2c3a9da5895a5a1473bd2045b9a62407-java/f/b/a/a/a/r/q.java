package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.r;
import f.b.a.a.a.y.c0;

public final /* synthetic */ class q implements r {
    public final /* synthetic */ v3 a;
    public final /* synthetic */ ShareDiagnosisViewModel b;

    public /* synthetic */ q(v3 v3Var, ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = v3Var;
        this.b = shareDiagnosisViewModel;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        v3 v3Var = this.a;
        v3Var.a0.b.setOnClickListener(new r(v3Var, (c0) obj, this.b));
    }
}
