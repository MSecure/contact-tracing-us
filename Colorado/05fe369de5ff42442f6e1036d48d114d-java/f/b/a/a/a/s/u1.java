package f.b.a.a.a.s;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.t;

public final /* synthetic */ class u1 implements t {
    public final /* synthetic */ j6 a;
    public final /* synthetic */ View b;

    public /* synthetic */ u1(j6 j6Var, View view) {
        this.a = j6Var;
        this.b = view;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        j6 j6Var = this.a;
        j6Var.g0.f2194j.setOnClickListener(new h2(j6Var, this.b, (ShareDiagnosisViewModel.b) obj));
    }
}
