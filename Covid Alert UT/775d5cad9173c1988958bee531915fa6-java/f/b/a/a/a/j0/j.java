package f.b.a.a.a.j0;

import android.content.Intent;
import android.view.View;
import java.util.Objects;

public final /* synthetic */ class j implements View.OnClickListener {
    public final /* synthetic */ o0 b;

    public /* synthetic */ j(o0 o0Var) {
        this.b = o0Var;
    }

    public final void onClick(View view) {
        o0 o0Var = this.b;
        Objects.requireNonNull(o0Var);
        o0Var.D0(new Intent("com.google.android.gms.settings.EXPOSURE_NOTIFICATION_SETTINGS"));
    }
}
