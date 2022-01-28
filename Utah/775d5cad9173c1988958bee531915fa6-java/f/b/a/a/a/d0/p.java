package f.b.a.a.a.d0;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.f.a.a;
import e.u.n.d;
import f.b.a.a.a.l0.a0;
import f.b.a.a.a.l0.b0;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.l0.i0;
import f.b.b.f.a.q;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class p implements DialogInterface.OnClickListener {
    public final /* synthetic */ q5 b;
    public final /* synthetic */ h0 c;

    public /* synthetic */ p(q5 q5Var, h0 h0Var) {
        this.b = q5Var;
        this.c = h0Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        q5 q5Var = this.b;
        h0 h0Var = this.c;
        ShareDiagnosisViewModel shareDiagnosisViewModel = q5Var.b0;
        shareDiagnosisViewModel.J = false;
        i0 i0Var = shareDiagnosisViewModel.c;
        long e2 = h0Var.e();
        a0 a0Var = (a0) i0Var.a;
        u a = d.a(a0Var.a, true, new b0(a0Var, e2));
        n6 n6Var = new n6(shareDiagnosisViewModel);
        ExecutorService executorService = shareDiagnosisViewModel.y;
        ((a) a).a(new q(a, n6Var), executorService);
    }
}
