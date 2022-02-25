package f.b.a.a.a.v;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;

public final /* synthetic */ class g implements DialogInterface.OnCancelListener {
    public final /* synthetic */ ExposureAboutActivity b;

    public /* synthetic */ g(ExposureAboutActivity exposureAboutActivity) {
        this.b = exposureAboutActivity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.b.s = false;
    }
}
