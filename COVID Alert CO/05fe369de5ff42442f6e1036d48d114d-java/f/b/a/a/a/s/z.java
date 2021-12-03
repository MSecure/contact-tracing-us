package f.b.a.a.a.s;

import android.view.View;
import f.b.a.a.a.c0.b;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class z implements View.OnClickListener {
    public final /* synthetic */ v5 b;
    public final /* synthetic */ View c;

    public /* synthetic */ z(v5 v5Var, View view) {
        this.b = v5Var;
        this.c = view;
    }

    public final void onClick(View view) {
        v5 v5Var = this.b;
        b.a(this.c, v5Var.A(x5.SELF_REPORT.equals(v5Var.a0.I) ? R.string.en_reporting_info_link : R.string.share_verification_code_learn_more_url));
    }
}
