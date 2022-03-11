package f.b.a.a.a.p;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;

public final /* synthetic */ class e implements View.OnClickListener {
    public final /* synthetic */ f3 b;

    public /* synthetic */ e(f3 f3Var) {
        this.b = f3Var;
    }

    public final void onClick(View view) {
        f3 f3Var = this.b;
        Context n0 = f3Var.n0();
        int i2 = ShareDiagnosisActivity.t;
        f3Var.w0(new Intent(n0, ShareDiagnosisActivity.class));
    }
}
