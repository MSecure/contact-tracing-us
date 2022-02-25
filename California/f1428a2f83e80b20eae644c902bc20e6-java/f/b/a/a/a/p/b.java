package f.b.a.a.a.p;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.p.u2;
import f.b.a.a.a.w.b0;

public final /* synthetic */ class b implements View.OnClickListener {
    public final /* synthetic */ u2.b b;
    public final /* synthetic */ b0 c;

    public /* synthetic */ b(u2.b bVar, b0 b0Var) {
        this.b = bVar;
        this.c = b0Var;
    }

    public final void onClick(View view) {
        u2.b bVar = this.b;
        b0 b0Var = this.c;
        f3 f3Var = ((k) u2.this.f2190e).a;
        Context n0 = f3Var.n0();
        int i2 = ShareDiagnosisActivity.t;
        Intent intent = new Intent(n0, ShareDiagnosisActivity.class);
        intent.putExtra("ShareExposureActivity.EXTRA_VIEW_POSITIVE_DIAGNOSIS_ID", b0Var.e());
        intent.putExtra("ShareExposureActivity.EXTRA_STEP", (b0.c.SHARED.equals(b0Var.k()) ? ShareDiagnosisViewModel.e.VIEW : (b0.b.UNSET.equals(b0Var.d()) || (b0.b.YES.equals(b0Var.d()) && b0Var.i() == null)) ? ShareDiagnosisViewModel.e.ONSET : (n3.d(n0) || !b0.e.NOT_ATTEMPTED.equals(b0Var.m())) ? ShareDiagnosisViewModel.e.REVIEW : ShareDiagnosisViewModel.e.TRAVEL_STATUS).name());
        f3Var.w0(intent);
    }
}
