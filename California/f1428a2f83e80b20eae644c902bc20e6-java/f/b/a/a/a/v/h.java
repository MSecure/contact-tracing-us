package f.b.a.a.a.v;

import android.view.View;
import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;
import com.google.android.material.snackbar.Snackbar;
import e.p.r;
import gov.ca.covid19.exposurenotifications.R;

public final /* synthetic */ class h implements r {
    public final /* synthetic */ ExposureAboutActivity a;

    public /* synthetic */ h(ExposureAboutActivity exposureAboutActivity) {
        this.a = exposureAboutActivity;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        ExposureAboutActivity exposureAboutActivity = this.a;
        Void r3 = (Void) obj;
        String string = exposureAboutActivity.getString(R.string.generic_error_message);
        View findViewById = exposureAboutActivity.findViewById(16908290);
        if (findViewById != null) {
            Snackbar.j(findViewById, string, 0).k();
        }
    }
}
