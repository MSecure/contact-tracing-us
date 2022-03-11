package f.b.a.a.a.x;

import android.content.Intent;
import android.view.View;
import com.google.android.apps.exposurenotification.settings.LegalTermsActivity;
import java.util.Objects;

public final /* synthetic */ class v implements View.OnClickListener {
    public final /* synthetic */ r0 b;

    public /* synthetic */ v(r0 r0Var) {
        this.b = r0Var;
    }

    public final void onClick(View view) {
        r0 r0Var = this.b;
        Objects.requireNonNull(r0Var);
        r0Var.w0(new Intent(r0Var.X, LegalTermsActivity.class));
    }
}
