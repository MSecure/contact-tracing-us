package f.b.a.a.a.d0;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.q.t;

public final /* synthetic */ class d1 implements t {
    public final /* synthetic */ z5 a;
    public final /* synthetic */ View b;

    public /* synthetic */ d1(z5 z5Var, View view) {
        this.a = z5Var;
        this.b = view;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        z5 z5Var = this.a;
        z5Var.h0.b.setOnClickListener(new s0(z5Var, this.b, (ShareDiagnosisViewModel.b) obj));
    }
}
