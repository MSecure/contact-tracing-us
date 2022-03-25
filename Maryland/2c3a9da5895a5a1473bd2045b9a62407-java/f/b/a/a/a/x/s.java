package f.b.a.a.a.x;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class s implements View.OnClickListener {
    public final /* synthetic */ r0 b;

    public /* synthetic */ s(r0 r0Var) {
        this.b = r0Var;
    }

    public final void onClick(View view) {
        r0 r0Var = this.b;
        Objects.requireNonNull(r0Var);
        r0Var.w0(new Intent("android.intent.action.VIEW", Uri.parse(r0Var.z(R.string.help_and_support_link))));
    }
}
