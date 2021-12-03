package f.b.a.a.a.s;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.t;

public final /* synthetic */ class d1 implements t {
    public final /* synthetic */ a6 a;
    public final /* synthetic */ View b;

    public /* synthetic */ d1(a6 a6Var, View view) {
        this.a = a6Var;
        this.b = view;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        a6 a6Var = this.a;
        a6Var.g0.b.setOnClickListener(new s0(a6Var, this.b, (ShareDiagnosisViewModel.b) obj));
    }
}
