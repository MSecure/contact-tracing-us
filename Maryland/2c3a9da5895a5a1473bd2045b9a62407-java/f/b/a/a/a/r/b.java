package f.b.a.a.a.r;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.r.f3;
import f.b.a.a.a.y.c0;

public final /* synthetic */ class b implements View.OnClickListener {
    public final /* synthetic */ f3.b b;
    public final /* synthetic */ c0 c;

    public /* synthetic */ b(f3.b bVar, c0 c0Var) {
        this.b = bVar;
        this.c = c0Var;
    }

    public final void onClick(View view) {
        f3.b bVar = this.b;
        c0 c0Var = this.c;
        q3 q3Var = ((h) f3.this.f2250f).a;
        Context n0 = q3Var.n0();
        int i2 = ShareDiagnosisActivity.v;
        Intent intent = new Intent(n0, ShareDiagnosisActivity.class);
        intent.putExtra("ShareDiagnosisActivity.EXTRA_DIAGNOSIS_ID", c0Var.e());
        intent.putExtra("ShareDiagnosisActivity.EXTRA_STEP", (c0.c.SHARED.equals(c0Var.k()) ? ShareDiagnosisViewModel.d.VIEW : (c0.b.UNSET.equals(c0Var.d()) || (c0.b.YES.equals(c0Var.d()) && c0Var.i() == null)) ? ShareDiagnosisViewModel.d.ONSET : (z3.c(n0) || !c0.e.NOT_ATTEMPTED.equals(c0Var.m())) ? ShareDiagnosisViewModel.d.REVIEW : ShareDiagnosisViewModel.d.TRAVEL_STATUS).name());
        q3Var.w0(intent);
    }
}
