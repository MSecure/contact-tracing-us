package f.b.a.a.a.r;

import android.view.View;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.r;

public final /* synthetic */ class p1 implements r {
    public final /* synthetic */ i4 a;
    public final /* synthetic */ View b;

    public /* synthetic */ p1(i4 i4Var, View view) {
        this.a = i4Var;
        this.b = view;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        i4 i4Var = this.a;
        i4Var.a0.f2155e.setOnClickListener(new j1(i4Var, this.b, (ShareDiagnosisViewModel.d) obj));
    }
}
