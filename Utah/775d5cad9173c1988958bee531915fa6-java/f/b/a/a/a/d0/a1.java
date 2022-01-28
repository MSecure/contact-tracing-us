package f.b.a.a.a.d0;

import android.view.View;
import f.b.a.e.l.q;

public final /* synthetic */ class a1 implements View.OnClickListener {
    public final /* synthetic */ z5 b;

    public /* synthetic */ a1(z5 z5Var) {
        this.b = z5Var;
    }

    public final void onClick(View view) {
        z5 z5Var = this.b;
        if (z5Var.K0("ShareDiagnosisGetCodeFragment.DATE_PICKER_TAG") == null) {
            q<Long> J0 = z5Var.J0(z5Var.d0.c());
            J0.m0.add(new z0(z5Var));
            J0.I0(z5Var.v(), "ShareDiagnosisGetCodeFragment.DATE_PICKER_TAG");
        }
    }
}
