package f.b.a.a.a.v;

import android.content.Intent;
import android.view.View;
import com.google.android.apps.exposurenotification.settings.AgencyActivity;
import java.util.Objects;

public final /* synthetic */ class e0 implements View.OnClickListener {
    public final /* synthetic */ t0 b;

    public /* synthetic */ e0(t0 t0Var) {
        this.b = t0Var;
    }

    public final void onClick(View view) {
        t0 t0Var = this.b;
        Objects.requireNonNull(t0Var);
        t0Var.w0(new Intent(t0Var.W, AgencyActivity.class));
    }
}
