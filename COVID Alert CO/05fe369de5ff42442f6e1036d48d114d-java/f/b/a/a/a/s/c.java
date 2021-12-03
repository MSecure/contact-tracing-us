package f.b.a.a.a.s;

import android.os.Bundle;
import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.m.a.r;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.m.y0;
import f.b.a.a.a.s.z4;
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
        q6 q6Var = ((r4) z4.this.f2400d).a;
        q6Var.p0();
        Bundle bundle = new Bundle();
        bundle.putLong("ShareDiagnosisFragment.EXTRA_DIAGNOSIS_ID", h0Var.e());
        bundle.putString("ShareDiagnosisFragment.EXTRA_STEP", (h0.c.SHARED.equals(h0Var.m()) ? ShareDiagnosisViewModel.b.VIEW : ShareDiagnosisViewModel.b.UPLOAD).name());
        y5 y5Var = new y5();
        y5Var.t0(bundle);
        r o0 = q6Var.o0();
        b.n(o0 instanceof y0);
        ((y0) o0).A(y5Var);
    }
}
