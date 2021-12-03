package f.b.a.a.a.s;

import android.view.View;
import e.b.a.m;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class x1 implements View.OnClickListener {
    public final /* synthetic */ j6 b;

    public /* synthetic */ x1(j6 j6Var) {
        this.b = j6Var;
    }

    public final void onClick(View view) {
        j6 j6Var = this.b;
        if (j6Var.a0.m.a()) {
            j6.h0.a("Submitting diagnosis keys...");
            j6Var.a0.v();
            return;
        }
        m.h.I0(j6Var.F, j6Var.A(R.string.share_error_no_internet));
    }
}
