package f.b.a.a.a.r;

import android.view.View;
import gov.md.covid19.exposurenotifications.R;

public final /* synthetic */ class e1 implements View.OnClickListener {
    public final /* synthetic */ e4 b;

    public /* synthetic */ e1(e4 e4Var) {
        this.b = e4Var;
    }

    public final void onClick(View view) {
        e4 e4Var = this.b;
        if (e4Var.c0.a()) {
            e4Var.b0.l();
        } else {
            e4Var.A0(e4Var.n0().getString(R.string.share_error_no_internet));
        }
    }
}
