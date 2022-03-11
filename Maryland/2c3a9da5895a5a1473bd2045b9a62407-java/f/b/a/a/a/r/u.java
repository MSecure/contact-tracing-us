package f.b.a.a.a.r;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class u implements View.OnClickListener {
    public final /* synthetic */ x3 b;

    public /* synthetic */ u(x3 x3Var) {
        this.b = x3Var;
    }

    public final void onClick(View view) {
        x3 x3Var = this.b;
        Objects.requireNonNull(x3Var);
        x3Var.w0(new Intent("android.intent.action.VIEW", Uri.parse(x3Var.z(R.string.share_verification_code_learn_more_url))));
    }
}
