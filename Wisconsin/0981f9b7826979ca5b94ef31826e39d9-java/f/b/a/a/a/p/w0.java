package f.b.a.a.a.p;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.w.b0;

public final /* synthetic */ class w0 implements View.OnClickListener {
    public final /* synthetic */ s3 b;
    public final /* synthetic */ b0 c;

    public /* synthetic */ w0(s3 s3Var, b0 b0Var) {
        this.b = s3Var;
        this.c = b0Var;
    }

    public final void onClick(View view) {
        s3 s3Var = this.b;
        s3Var.Z.i(n3.b(ShareDiagnosisViewModel.e.REVIEW, this.c, s3Var.W));
    }
}
