package f.b.a.a.a.r;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.r;

public final /* synthetic */ class d0 implements r {
    public final /* synthetic */ x3 a;
    public final /* synthetic */ View b;

    public /* synthetic */ d0(x3 x3Var, View view) {
        this.a = x3Var;
        this.b = view;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        x3 x3Var = this.a;
        x3Var.a0.f2138f.setOnClickListener(new y(x3Var, this.b, (ShareDiagnosisViewModel.d) obj));
    }
}
