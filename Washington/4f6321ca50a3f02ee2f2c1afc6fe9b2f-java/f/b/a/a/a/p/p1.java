package f.b.a.a.a.p;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.w.b0;

public final /* synthetic */ class p1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ y3 b;
    public final /* synthetic */ b0 c;

    public /* synthetic */ p1(y3 y3Var, b0 b0Var) {
        this.b = y3Var;
        this.c = b0Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        y3 y3Var = this.b;
        b0 b0Var = this.c;
        ShareDiagnosisViewModel shareDiagnosisViewModel = y3Var.a0;
        shareDiagnosisViewModel.w = false;
        shareDiagnosisViewModel.c(b0Var);
    }
}
