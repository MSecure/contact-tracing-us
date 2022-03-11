package f.b.a.a.a.r;

import android.app.PendingIntent;
import android.content.IntentSender;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import e.p.r;
import f.b.a.c.b.l.b;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class h1 implements r {
    public final /* synthetic */ e4 a;

    public /* synthetic */ h1(e4 e4Var) {
        this.a = e4Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        e4 e4Var = this.a;
        b bVar = (b) obj;
        Objects.requireNonNull(e4Var);
        try {
            Status status = bVar.b;
            e.m.a.r m0 = e4Var.m0();
            PendingIntent pendingIntent = status.f428e;
            if (pendingIntent != null) {
                Objects.requireNonNull(pendingIntent, "null reference");
                m0.startIntentSenderForResult(pendingIntent.getIntentSender(), 2222, null, 0, 0, 0);
            }
        } catch (IntentSender.SendIntentException unused) {
            Log.w("ShareExposureReviewFrag", "Error calling startResolutionForResult", bVar);
            e4Var.A0(e4Var.z(R.string.generic_error_message));
        }
    }
}
