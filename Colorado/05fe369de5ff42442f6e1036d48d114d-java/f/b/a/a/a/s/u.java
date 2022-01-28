package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.i.x;
import java.util.Objects;

public final /* synthetic */ class u implements x.a {
    public final /* synthetic */ t5 a;

    public /* synthetic */ u(t5 t5Var) {
        this.a = t5Var;
    }

    @Override // f.b.a.a.a.i.x.a
    public final void a(Object obj, Object obj2) {
        t5 t5Var = this.a;
        ShareDiagnosisViewModel.b bVar = (ShareDiagnosisViewModel.b) obj;
        Objects.requireNonNull(t5Var);
        if (((Boolean) obj2).booleanValue()) {
            t5Var.g0.f2153e.setOnClickListener(new t(t5Var));
        } else {
            t5Var.g0.f2153e.setOnClickListener(new s(t5Var, bVar));
        }
    }
}
