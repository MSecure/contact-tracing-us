package f.b.a.a.a.p;

import android.content.IntentSender;
import android.util.Log;
import e.p.r;
import f.b.a.c.b.l.b;
import gov.ca.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class f1 implements r {
    public final /* synthetic */ s3 a;

    public /* synthetic */ f1(s3 s3Var) {
        this.a = s3Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        s3 s3Var = this.a;
        b bVar = (b) obj;
        Objects.requireNonNull(s3Var);
        try {
            bVar.b.g(s3Var.m0(), 2222);
        } catch (IntentSender.SendIntentException unused) {
            Log.w("ShareExposureReviewFrag", "Error calling startResolutionForResult", bVar);
            s3Var.A0(s3Var.z(R.string.generic_error_message));
        }
    }
}
