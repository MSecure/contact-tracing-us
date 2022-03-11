package f.b.a.a.a.r;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.y.c0;

public final /* synthetic */ class t1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ k4 b;
    public final /* synthetic */ c0 c;

    public /* synthetic */ t1(k4 k4Var, c0 c0Var) {
        this.b = k4Var;
        this.c = c0Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        k4 k4Var = this.b;
        c0 c0Var = this.c;
        ShareDiagnosisViewModel shareDiagnosisViewModel = k4Var.c0;
        shareDiagnosisViewModel.y = false;
        shareDiagnosisViewModel.c(c0Var);
    }
}
