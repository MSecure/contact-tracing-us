package f.b.a.a.a.d0;

import android.view.View;
import f.b.a.a.a.m0.b;
import gov.ut.covid19.exposurenotifications.R;

public final /* synthetic */ class z implements View.OnClickListener {
    public final /* synthetic */ u5 b;
    public final /* synthetic */ View c;

    public /* synthetic */ z(u5 u5Var, View view) {
        this.b = u5Var;
        this.c = view;
    }

    public final void onClick(View view) {
        u5 u5Var = this.b;
        b.a(this.c, u5Var.E(w5.SELF_REPORT.equals(u5Var.b0.I) ? R.string.en_reporting_info_link : R.string.share_verification_code_learn_more_url));
    }
}
