package f.b.a.a.a.k;

import android.content.Intent;
import android.view.View;
import java.util.Objects;

public final /* synthetic */ class a implements View.OnClickListener {
    public final /* synthetic */ l b;

    public /* synthetic */ a(l lVar) {
        this.b = lVar;
    }

    public final void onClick(View view) {
        l lVar = this.b;
        Objects.requireNonNull(lVar);
        lVar.y0(new Intent("com.google.android.gms.settings.EXPOSURE_NOTIFICATION_SETTINGS"));
    }
}
