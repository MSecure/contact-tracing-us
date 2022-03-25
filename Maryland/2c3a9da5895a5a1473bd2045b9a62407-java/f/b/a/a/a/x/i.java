package f.b.a.a.a.x;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;

public final /* synthetic */ class i implements DialogInterface.OnCancelListener {
    public final /* synthetic */ ExposureAboutActivity b;

    public /* synthetic */ i(ExposureAboutActivity exposureAboutActivity) {
        this.b = exposureAboutActivity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.b.u = false;
    }
}
