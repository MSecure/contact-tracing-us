package f.b.a.a.a.p;

import android.os.Bundle;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.m.a.a;
import e.m.a.l;
import e.p.r;
import gov.ca.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class m implements r {
    public final /* synthetic */ ShareDiagnosisActivity a;

    public /* synthetic */ m(ShareDiagnosisActivity shareDiagnosisActivity) {
        this.a = shareDiagnosisActivity;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        l lVar;
        ShareDiagnosisActivity shareDiagnosisActivity = this.a;
        Objects.requireNonNull(shareDiagnosisActivity);
        Bundle bundle = new Bundle();
        bundle.putParcelable("ShareDiagnosisActivity.ACTIVITY_START_INTENT", shareDiagnosisActivity.getIntent());
        switch (((ShareDiagnosisViewModel.e) obj).ordinal()) {
            case 1:
                lVar = new l3();
                break;
            case 2:
                lVar = new q3();
                break;
            case 3:
                lVar = new s3();
                break;
            case 4:
                lVar = new u3();
                break;
            case 5:
                lVar = new o3();
                break;
            case 6:
                lVar = new w3();
                break;
            case 7:
                lVar = new y3();
                break;
            default:
                lVar = new j3();
                break;
        }
        lVar.s0(bundle);
        a aVar = new a(shareDiagnosisActivity.n());
        aVar.f(R.id.share_exposure_fragment, lVar, "ShareExposureActivity.POSITIVE_TEST_FRAGMENT_TAG");
        aVar.f1638f = 4097;
        aVar.c();
    }
}
