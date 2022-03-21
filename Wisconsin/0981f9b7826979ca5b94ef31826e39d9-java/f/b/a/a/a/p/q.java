package f.b.a.a.a.p;

import android.content.IntentSender;
import android.util.Log;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import e.p.r;
import f.b.a.c.b.l.b;
import java.util.Objects;

public final /* synthetic */ class q implements r {
    public final /* synthetic */ ShareDiagnosisActivity a;

    public /* synthetic */ q(ShareDiagnosisActivity shareDiagnosisActivity) {
        this.a = shareDiagnosisActivity;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        ShareDiagnosisActivity shareDiagnosisActivity = this.a;
        b bVar = (b) obj;
        Objects.requireNonNull(shareDiagnosisActivity);
        try {
            bVar.b.g(shareDiagnosisActivity, 1111);
        } catch (IntentSender.SendIntentException unused) {
            Log.w("ShareDiagnosisActivity", "Error calling startResolutionForResult", bVar);
        }
    }
}
