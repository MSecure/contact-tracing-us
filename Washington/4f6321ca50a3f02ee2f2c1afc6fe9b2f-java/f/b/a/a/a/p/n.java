package f.b.a.a.a.p;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;

public final /* synthetic */ class n implements DialogInterface.OnClickListener {
    public final /* synthetic */ ShareDiagnosisViewModel b;

    public /* synthetic */ n(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.b = shareDiagnosisViewModel;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b;
        int i3 = ShareDiagnosisActivity.t;
        shareDiagnosisViewModel.x = false;
        dialogInterface.dismiss();
    }
}
