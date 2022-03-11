package f.b.a.a.a.r;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;

public final /* synthetic */ class n implements DialogInterface.OnCancelListener {
    public final /* synthetic */ ShareDiagnosisViewModel b;

    public /* synthetic */ n(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.b = shareDiagnosisViewModel;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b;
        int i2 = ShareDiagnosisActivity.v;
        shareDiagnosisViewModel.z = false;
    }
}
