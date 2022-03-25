package f.b.a.a.a.r;

import android.os.Bundle;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.m.a.a;
import e.m.a.l;
import e.p.r;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class o implements r {
    public final /* synthetic */ ShareDiagnosisActivity a;

    public /* synthetic */ o(ShareDiagnosisActivity shareDiagnosisActivity) {
        this.a = shareDiagnosisActivity;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        l lVar;
        ShareDiagnosisActivity shareDiagnosisActivity = this.a;
        Objects.requireNonNull(shareDiagnosisActivity);
        Bundle bundle = new Bundle();
        bundle.putParcelable("ShareDiagnosisActivity.ACTIVITY_START_INTENT", shareDiagnosisActivity.getIntent());
        switch (((ShareDiagnosisViewModel.d) obj).ordinal()) {
            case 1:
                lVar = new x3();
                break;
            case 2:
                lVar = new c4();
                break;
            case 3:
                lVar = new e4();
                break;
            case 4:
                lVar = new g4();
                break;
            case 5:
                lVar = new a4();
                break;
            case 6:
                lVar = new i4();
                break;
            case 7:
                lVar = new k4();
                break;
            default:
                lVar = new v3();
                break;
        }
        lVar.s0(bundle);
        a aVar = new a(shareDiagnosisActivity.o());
        aVar.f(R.id.share_exposure_fragment, lVar, "ShareDiagnosisActivity.POSITIVE_TEST_FRAGMENT_TAG");
        aVar.f1665f = 4097;
        aVar.c();
    }
}
