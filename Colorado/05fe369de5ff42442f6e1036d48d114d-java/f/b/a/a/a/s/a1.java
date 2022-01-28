package f.b.a.a.a.s;

import android.view.View;
import f.b.a.e.k.q;

public final /* synthetic */ class a1 implements View.OnClickListener {
    public final /* synthetic */ a6 b;

    public /* synthetic */ a1(a6 a6Var) {
        this.b = a6Var;
    }

    public final void onClick(View view) {
        a6 a6Var = this.b;
        if (a6Var.E0("ShareDiagnosisGetCodeFragment.DATE_PICKER_TAG") == null) {
            q<Long> D0 = a6Var.D0(a6Var.c0.c());
            D0.m0.add(new z0(a6Var));
            D0.D0(a6Var.u(), "ShareDiagnosisGetCodeFragment.DATE_PICKER_TAG");
        }
    }
}
