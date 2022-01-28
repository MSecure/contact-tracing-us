package f.b.a.a.a.d0;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.q.t;

public final /* synthetic */ class d0 implements t {
    public final /* synthetic */ u5 a;
    public final /* synthetic */ View b;

    public /* synthetic */ d0(u5 u5Var, View view) {
        this.a = u5Var;
        this.b = view;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        u5 u5Var = this.a;
        u5Var.i0.f2360i.setOnClickListener(new b0(u5Var, this.b, (ShareDiagnosisViewModel.b) obj));
    }
}
