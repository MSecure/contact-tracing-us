package f.b.a.a.a.r;

import android.widget.ViewFlipper;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import e.p.r;
import java.util.Objects;

public final /* synthetic */ class m implements r {
    public final /* synthetic */ ShareDiagnosisActivity a;

    public /* synthetic */ m(ShareDiagnosisActivity shareDiagnosisActivity) {
        this.a = shareDiagnosisActivity;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        ViewFlipper viewFlipper;
        int i2;
        ShareDiagnosisActivity shareDiagnosisActivity = this.a;
        Objects.requireNonNull(shareDiagnosisActivity);
        if (((Boolean) obj).booleanValue()) {
            viewFlipper = shareDiagnosisActivity.s.b;
            i2 = 0;
        } else {
            viewFlipper = shareDiagnosisActivity.s.b;
            i2 = 1;
        }
        viewFlipper.setDisplayedChild(i2);
    }
}
