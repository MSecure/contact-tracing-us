package f.b.a.a.a.p;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;

public final /* synthetic */ class o implements DialogInterface.OnCancelListener {
    public final /* synthetic */ ShareDiagnosisViewModel b;

    public /* synthetic */ o(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.b = shareDiagnosisViewModel;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b;
        int i2 = ShareDiagnosisActivity.t;
        shareDiagnosisViewModel.x = false;
    }
}
