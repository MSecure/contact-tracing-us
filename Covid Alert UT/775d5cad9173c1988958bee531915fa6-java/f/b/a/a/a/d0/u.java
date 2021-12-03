package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.s.w;
import java.util.Objects;

public final /* synthetic */ class u implements w.a {
    public final /* synthetic */ s5 a;

    public /* synthetic */ u(s5 s5Var) {
        this.a = s5Var;
    }

    @Override // f.b.a.a.a.s.w.a
    public final void a(Object obj, Object obj2) {
        s5 s5Var = this.a;
        ShareDiagnosisViewModel.b bVar = (ShareDiagnosisViewModel.b) obj;
        Objects.requireNonNull(s5Var);
        if (((Boolean) obj2).booleanValue()) {
            s5Var.h0.f2348e.setOnClickListener(new t(s5Var));
        } else {
            s5Var.h0.f2348e.setOnClickListener(new s(s5Var, bVar));
        }
    }
}
