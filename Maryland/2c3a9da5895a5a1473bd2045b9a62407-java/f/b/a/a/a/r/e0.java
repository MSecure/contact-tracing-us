package f.b.a.a.a.r;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.r;

public final /* synthetic */ class e0 implements r {
    public final /* synthetic */ x3 a;
    public final /* synthetic */ View b;

    public /* synthetic */ e0(x3 x3Var, View view) {
        this.a = x3Var;
        this.b = view;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        x3 x3Var = this.a;
        x3Var.a0.f2137e.setOnClickListener(new c0(x3Var, this.b, (ShareDiagnosisViewModel.d) obj));
    }
}
