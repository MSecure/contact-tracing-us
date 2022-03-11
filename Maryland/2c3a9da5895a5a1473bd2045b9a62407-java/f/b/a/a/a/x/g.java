package f.b.a.a.a.x;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;

public final /* synthetic */ class g implements DialogInterface.OnClickListener {
    public final /* synthetic */ ExposureAboutActivity b;

    public /* synthetic */ g(ExposureAboutActivity exposureAboutActivity) {
        this.b = exposureAboutActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.b.u = false;
        dialogInterface.cancel();
    }
}
