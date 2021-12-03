package f.b.a.a.a.s;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.t;

public final /* synthetic */ class d0 implements t {
    public final /* synthetic */ v5 a;
    public final /* synthetic */ View b;

    public /* synthetic */ d0(v5 v5Var, View view) {
        this.a = v5Var;
        this.b = view;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        v5 v5Var = this.a;
        v5Var.h0.f2165i.setOnClickListener(new b0(v5Var, this.b, (ShareDiagnosisViewModel.b) obj));
    }
}
