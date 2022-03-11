package f.b.a.a.a.j;

import android.content.Intent;
import android.view.View;
import java.util.Objects;

public final /* synthetic */ class a implements View.OnClickListener {
    public final /* synthetic */ j b;

    public /* synthetic */ a(j jVar) {
        this.b = jVar;
    }

    public final void onClick(View view) {
        j jVar = this.b;
        Objects.requireNonNull(jVar);
        jVar.w0(new Intent("com.google.android.gms.settings.EXPOSURE_NOTIFICATION_SETTINGS"));
    }
}
