package f.b.a.a.a.r;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;

public final /* synthetic */ class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ ShareDiagnosisViewModel b;

    public /* synthetic */ l(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.b = shareDiagnosisViewModel;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b;
        int i3 = ShareDiagnosisActivity.v;
        shareDiagnosisViewModel.z = false;
        dialogInterface.dismiss();
    }
}
