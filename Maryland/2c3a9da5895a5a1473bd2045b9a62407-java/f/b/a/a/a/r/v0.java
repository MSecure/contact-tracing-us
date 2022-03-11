package f.b.a.a.a.r;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.y.c0;

public final /* synthetic */ class v0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ e4 b;
    public final /* synthetic */ c0 c;

    public /* synthetic */ v0(e4 e4Var, c0 c0Var) {
        this.b = e4Var;
        this.c = c0Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        e4 e4Var = this.b;
        c0 c0Var = this.c;
        ShareDiagnosisViewModel shareDiagnosisViewModel = e4Var.b0;
        shareDiagnosisViewModel.y = false;
        shareDiagnosisViewModel.c(c0Var);
    }
}
