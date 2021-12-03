package f.b.a.a.a.d0;

import android.os.Bundle;
import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.n.a.r;
import f.b.a.a.a.d0.z4;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.w.y0;
import f.b.a.c.b.o.b;

public final /* synthetic */ class c implements View.OnClickListener {
    public final /* synthetic */ z4.b b;
    public final /* synthetic */ h0 c;

    public /* synthetic */ c(z4.b bVar, h0 h0Var) {
        this.b = bVar;
        this.c = h0Var;
    }

    public final void onClick(View view) {
        z4.b bVar = this.b;
        h0 h0Var = this.c;
        o6 o6Var = ((r4) z4.this.f2196d).a;
        o6Var.t0();
        Bundle bundle = new Bundle();
        bundle.putLong("ShareDiagnosisFragment.EXTRA_DIAGNOSIS_ID", h0Var.e());
        bundle.putString("ShareDiagnosisFragment.EXTRA_STEP", (h0.c.SHARED.equals(h0Var.m()) ? ShareDiagnosisViewModel.b.VIEW : ShareDiagnosisViewModel.b.UPLOAD).name());
        x5 x5Var = new x5();
        x5Var.y0(bundle);
        r s0 = o6Var.s0();
        b.n(s0 instanceof y0);
        ((y0) s0).B(x5Var);
    }
}
