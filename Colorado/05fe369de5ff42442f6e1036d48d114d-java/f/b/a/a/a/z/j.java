package f.b.a.a.a.z;

import android.content.Intent;
import android.view.View;
import java.util.Objects;

public final /* synthetic */ class j implements View.OnClickListener {
    public final /* synthetic */ p0 b;

    public /* synthetic */ j(p0 p0Var) {
        this.b = p0Var;
    }

    public final void onClick(View view) {
        p0 p0Var = this.b;
        Objects.requireNonNull(p0Var);
        p0Var.y0(new Intent("com.google.android.gms.settings.EXPOSURE_NOTIFICATION_SETTINGS"));
    }
}
