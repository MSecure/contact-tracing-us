package f.b.a.a.a.v;

import android.content.IntentSender;
import android.util.Log;
import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;
import e.p.r;
import f.b.a.c.b.l.b;
import java.util.Objects;

public final /* synthetic */ class m implements r {
    public final /* synthetic */ ExposureAboutActivity a;

    public /* synthetic */ m(ExposureAboutActivity exposureAboutActivity) {
        this.a = exposureAboutActivity;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        ExposureAboutActivity exposureAboutActivity = this.a;
        b bVar = (b) obj;
        Objects.requireNonNull(exposureAboutActivity);
        try {
            bVar.b.g(exposureAboutActivity, 1111);
        } catch (IntentSender.SendIntentException unused) {
            Log.w("ExposureAboutActivity", "Error calling startResolutionForResult", bVar);
        }
    }
}
