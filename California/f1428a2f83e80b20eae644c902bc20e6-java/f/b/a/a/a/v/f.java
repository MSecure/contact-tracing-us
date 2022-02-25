package f.b.a.a.a.v;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;

public final /* synthetic */ class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ ExposureAboutActivity b;

    public /* synthetic */ f(ExposureAboutActivity exposureAboutActivity) {
        this.b = exposureAboutActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.b.s = false;
        dialogInterface.cancel();
    }
}
