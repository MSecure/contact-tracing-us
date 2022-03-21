package f.b.a.a.a.p;

import android.view.View;
import gov.wi.covid19.exposurenotifications.R;

public final /* synthetic */ class z0 implements View.OnClickListener {
    public final /* synthetic */ s3 b;

    public /* synthetic */ z0(s3 s3Var) {
        this.b = s3Var;
    }

    public final void onClick(View view) {
        s3 s3Var = this.b;
        if (s3Var.a0.a()) {
            s3Var.Z.l();
        } else {
            s3Var.A0(s3Var.n0().getString(R.string.share_error_no_internet));
        }
    }
}
