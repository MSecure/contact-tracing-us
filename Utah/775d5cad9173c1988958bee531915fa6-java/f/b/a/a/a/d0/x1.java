package f.b.a.a.a.d0;

import android.view.View;
import e.b.a.m;
import gov.ut.covid19.exposurenotifications.R;

public final /* synthetic */ class x1 implements View.OnClickListener {
    public final /* synthetic */ i6 b;

    public /* synthetic */ x1(i6 i6Var) {
        this.b = i6Var;
    }

    public final void onClick(View view) {
        i6 i6Var = this.b;
        if (i6Var.b0.m.a()) {
            i6.i0.a("Submitting diagnosis keys...");
            i6Var.b0.v();
            return;
        }
        m.e.T0(i6Var.F, i6Var.E(R.string.share_error_no_internet));
    }
}
