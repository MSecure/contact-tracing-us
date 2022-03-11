package f.b.a.a.a.x;

import android.content.Intent;
import android.view.View;
import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;
import java.util.Objects;

public final /* synthetic */ class l implements View.OnClickListener {
    public final /* synthetic */ ExposureAboutActivity b;

    public /* synthetic */ l(ExposureAboutActivity exposureAboutActivity) {
        this.b = exposureAboutActivity;
    }

    public final void onClick(View view) {
        ExposureAboutActivity exposureAboutActivity = this.b;
        Objects.requireNonNull(exposureAboutActivity);
        exposureAboutActivity.startActivity(new Intent("com.google.android.gms.settings.EXPOSURE_NOTIFICATION_SETTINGS"));
    }
}
