package f.b.a.a.a.s;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.f.a.a;
import e.t.n.d;
import f.b.a.a.a.b0.a0;
import f.b.a.a.a.b0.b0;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.b0.i0;
import f.b.b.f.a.q;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class p implements DialogInterface.OnClickListener {
    public final /* synthetic */ r5 b;
    public final /* synthetic */ h0 c;

    public /* synthetic */ p(r5 r5Var, h0 h0Var) {
        this.b = r5Var;
        this.c = h0Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        r5 r5Var = this.b;
        h0 h0Var = this.c;
        ShareDiagnosisViewModel shareDiagnosisViewModel = r5Var.a0;
        shareDiagnosisViewModel.J = false;
        i0 i0Var = shareDiagnosisViewModel.c;
        long e2 = h0Var.e();
        a0 a0Var = (a0) i0Var.a;
        u a = d.a(a0Var.a, true, new b0(a0Var, e2));
        o6 o6Var = new o6(shareDiagnosisViewModel);
        ExecutorService executorService = shareDiagnosisViewModel.y;
        ((a) a).a(new q(a, o6Var), executorService);
    }
}
