package f.b.a.a.a.v;

import android.content.Intent;
import android.view.View;
import com.google.android.apps.exposurenotification.settings.LegalTermsActivity;
import java.util.Objects;

public final /* synthetic */ class u implements View.OnClickListener {
    public final /* synthetic */ t0 b;

    public /* synthetic */ u(t0 t0Var) {
        this.b = t0Var;
    }

    public final void onClick(View view) {
        t0 t0Var = this.b;
        Objects.requireNonNull(t0Var);
        t0Var.w0(new Intent(t0Var.W, LegalTermsActivity.class));
    }
}
