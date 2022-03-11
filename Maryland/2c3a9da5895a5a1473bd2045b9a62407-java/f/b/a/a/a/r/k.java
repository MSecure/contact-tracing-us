package f.b.a.a.a.r;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;

public final /* synthetic */ class k implements View.OnClickListener {
    public final /* synthetic */ q3 b;

    public /* synthetic */ k(q3 q3Var) {
        this.b = q3Var;
    }

    public final void onClick(View view) {
        q3 q3Var = this.b;
        Context n0 = q3Var.n0();
        int i2 = ShareDiagnosisActivity.v;
        q3Var.w0(new Intent(n0, ShareDiagnosisActivity.class));
    }
}
