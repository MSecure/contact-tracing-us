package f.b.a.a.a.j;

import android.content.IntentSender;
import android.util.Log;
import com.google.android.apps.exposurenotification.home.ExposureNotificationActivity;
import e.p.r;
import java.util.Objects;

public final /* synthetic */ class b implements r {
    public final /* synthetic */ ExposureNotificationActivity a;

    public /* synthetic */ b(ExposureNotificationActivity exposureNotificationActivity) {
        this.a = exposureNotificationActivity;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        ExposureNotificationActivity exposureNotificationActivity = this.a;
        f.b.a.c.b.l.b bVar = (f.b.a.c.b.l.b) obj;
        Objects.requireNonNull(exposureNotificationActivity);
        try {
            bVar.b.g(exposureNotificationActivity, 1111);
        } catch (IntentSender.SendIntentException unused) {
            Log.w("ExposureNotifnActivity", "Error calling startResolutionForResult", bVar);
        }
    }
}
