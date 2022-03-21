package f.b.a.a.a.p;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import gov.wi.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class f0 implements View.OnClickListener {
    public final /* synthetic */ l3 b;

    public /* synthetic */ f0(l3 l3Var) {
        this.b = l3Var;
    }

    public final void onClick(View view) {
        l3 l3Var = this.b;
        Objects.requireNonNull(l3Var);
        l3Var.w0(new Intent("android.intent.action.VIEW", Uri.parse(l3Var.z(R.string.share_verification_code_learn_more_url))));
    }
}
